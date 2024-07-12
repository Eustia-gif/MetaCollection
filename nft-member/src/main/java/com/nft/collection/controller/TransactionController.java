package com.nft.collection.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nft.ipfs.repo.IpfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.collection.param.CancelPayParam;
import com.nft.collection.param.CollectionCancelResaleParam;
import com.nft.collection.param.CollectionGiveParam;
import com.nft.collection.param.CollectionGiveRecordQueryCondParam;
import com.nft.collection.param.CollectionResaleParam;
import com.nft.collection.param.ConfirmPayParam;
import com.nft.collection.param.LatestCollectionCreateOrderParam;
import com.nft.collection.param.OpenMysteryBoxParam;
import com.nft.collection.param.PayOrderQueryCondParam;
import com.nft.collection.param.ResaleCollectionCreateOrderParam;
import com.nft.collection.service.CollectionGiveService;
import com.nft.collection.service.TransactionService;
import com.nft.collection.vo.CollectionReceiverInfoVO;
import com.nft.collection.vo.MyGiveRecordVO;
import com.nft.collection.vo.MyPayOrderDetailVO;
import com.nft.collection.vo.MyPayOrderVO;
import com.nft.collection.vo.OpenMysteryBoxResultVO;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;

import cn.dev33.satoken.stp.StpUtil;

import java.io.IOException;

@RestController
@RequestMapping("/transaction")
@Api(tags = "交易")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private CollectionGiveService collectionGiveService;

	@Autowired
	private IpfsService ipfsService;

	/**
	 * 分页查询我的赠送记录
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询我的赠送记录")
	@GetMapping("/findMyGiveRecordByPage")
	public Result<PageResult<MyGiveRecordVO>> findMyGiveRecordByPage(CollectionGiveRecordQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(collectionGiveService.findMyGiveRecordByPage(param));
	}

	/**
	 * 获取接收者信息
	 * @param giveToAccount
	 * @return
	 */
	@ApiOperation(value = "获取接收者信息")
	@GetMapping("/getCollectionReceiverInfo")
	public Result<CollectionReceiverInfoVO> getCollectionReceiverInfo(String giveToAccount) {
		return Result
				.success(collectionGiveService.getCollectionReceiverInfo(giveToAccount, StpUtil.getLoginIdAsString()));
	}

	/**
	 * 赠送
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "赠送")
	@PostMapping("/collectionGive")
	public Result<String> collectionGive(CollectionGiveParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		collectionGiveService.collectionGive(param);
		return Result.success();
	}

	/**
	 * 开启盲盒
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "开启盲盒")
	@PostMapping("/openMysteryBox")
	public Result<OpenMysteryBoxResultVO> openMysteryBox(OpenMysteryBoxParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(transactionService.openMysteryBox(param));
	}

	/**
	 * 查找我的支付订单详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查找我的支付订单详情")
	@GetMapping("/findMyPayOrderDetail")
	public Result<MyPayOrderDetailVO> findMyPayOrderDetail(String id) {
		return Result.success(transactionService.findMyPayOrderDetail(id));
	}

	/**
	 * 分页查询我的支付订单
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询我的支付订单")
	@GetMapping("/findMyPayOrderByPage")
	public Result<PageResult<MyPayOrderVO>> findMyPayOrderByPage(PayOrderQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(transactionService.findMyPayOrderByPage(param));
	}

	/**
	 * 取消支付
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "取消支付")
	@PostMapping("/cancelPay")
	public Result<String> cancelPay(CancelPayParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		transactionService.cancelPay(param);
		return Result.success();
	}

	/**
	 * 确认支付
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "确认支付")
	@PostMapping("/confirmPay")
	public Result<String> confirmPay(ConfirmPayParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		transactionService.confirmPay(param);
		return Result.success();
	}

	/**
	 * 转卖收藏创建订单
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "创建订单(转卖收藏)")
	@PostMapping("/resaleCollectionCreateOrder")
	public Result<String> resaleCollectionCreateOrder(ResaleCollectionCreateOrderParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		String orderId = transactionService.resaleCollectionCreateOrder(param);
		return Result.success().setData(orderId);
	}
	/**
	 * 最新藏品创建订单
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "创建订单(最新藏品)")
	@PostMapping("/latestCollectionCreateOrder")
	public Result<String> latestCollectionCreateOrder(LatestCollectionCreateOrderParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		String orderId = transactionService.latestCollectionCreateOrder(param);
		return Result.success().setData(orderId);
	}

	/**
	 * 取消转卖
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "取消转卖")
	@PostMapping("/cancelResale")
	public Result<String> cancelResale(CollectionCancelResaleParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		transactionService.cancelResale(param);
		return Result.success();
	}

	/**
	 * 转卖收藏
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "转卖收藏")
	@PostMapping("/collectionResale")
	public Result<String> collectionResale(CollectionResaleParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		transactionService.collectionResale(param);
		return Result.success();
	}

}
