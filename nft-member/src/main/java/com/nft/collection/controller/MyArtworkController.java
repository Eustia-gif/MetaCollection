package com.nft.collection.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.collection.param.MemberHoldCollectionQueryCondParam;
import com.nft.collection.param.ResaleCollectionQueryCondParam;
import com.nft.collection.service.CollectionService;
import com.nft.collection.vo.MyHoldCollectionDetailVO;
import com.nft.collection.vo.MyHoldCollectionVO;
import com.nft.collection.vo.MyHoldVO;
import com.nft.collection.vo.MyResaleCollectionDetailVO;
import com.nft.collection.vo.MyResaleCollectionVO;
import com.nft.collection.vo.MySoldCollectionVO;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;

import cn.dev33.satoken.stp.StpUtil;

@RestController
@RequestMapping("/myArtwork")
@Api(tags = "我的藏品")
public class MyArtworkController {

	@Autowired
	private CollectionService collectionService;

	/**
	 * 查询我的转卖藏品详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询我的转卖藏品详情")
	@GetMapping("/findMyResaleCollectionDetail")
	public Result<MyResaleCollectionDetailVO> findMyResaleCollectionDetail(String id) {
		return Result.success(collectionService.findMyResaleCollectionDetail(id, StpUtil.getLoginIdAsString()));
	}

	/**
	 * 查询我的持有藏品详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询我的持有藏品详情")
	@GetMapping("/findMyHoldCollectionDetail")
	public Result<MyHoldCollectionDetailVO> findMyHoldCollectionDetail(String id) {
		return Result.success(collectionService.findMyHoldCollectionDetail(id, StpUtil.getLoginIdAsString()));
	}

	/**
	 * 分页查询我的转卖藏品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询我的转卖藏品")
	@GetMapping("/findMySoldCollectionByPage")
	public Result<PageResult<MySoldCollectionVO>> findMySoldCollectionByPage(ResaleCollectionQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(collectionService.findMySoldCollectionByPage(param));
	}

	/**
	 * 查询我所有的持有
	 * @return
	 */
	@ApiOperation(value = "查询我所有的持有")
	@GetMapping("/findAllMyHold")
	public Result<List<MyHoldVO>> findAllMyHold() {
		return Result.success(collectionService.findAllMyHold(StpUtil.getLoginIdAsString()));
	}

	/**
	 * 分页查询我的持有的盲盒
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询我的持有的盲盒")
	@GetMapping("/findMyHoldMysteryBoxByPage")
	public Result<PageResult<MyHoldCollectionVO>> findMyHoldMysteryBoxByPage(MemberHoldCollectionQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(collectionService.findMyHoldMysteryBoxByPage(param));
	}

	/**
	 * 分页查询我的持有的藏品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询我的持有的藏品")
	@GetMapping("/findMyHoldCollectionByPage")
	public Result<PageResult<MyHoldCollectionVO>> findMyHoldCollectionByPage(MemberHoldCollectionQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(collectionService.findMyHoldCollectionByPage(param));
	}

	/**
	 * 分页查询我的转卖藏品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询我的转卖藏品")
	@GetMapping("/findMyResaleCollectionByPage")
	public Result<PageResult<MyResaleCollectionVO>> findMyResaleCollectionByPage(ResaleCollectionQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(collectionService.findMyResaleCollectionByPage(param));
	}

}
