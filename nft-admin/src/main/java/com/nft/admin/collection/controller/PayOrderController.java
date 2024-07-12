package com.nft.admin.collection.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.collection.param.PayOrderQueryCondParam;
import com.nft.collection.service.TransactionService;
import com.nft.collection.vo.PayOrderVO;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;

@RestController
@RequestMapping("/payOrder")
@Api(tags = "支付订单")
public class PayOrderController {

	@Autowired
	private TransactionService transactionService;

	/**
	 * 分页查询支付订单
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询支付订单")
	@GetMapping("/findPayOrderByPage")
	public Result<PageResult<PayOrderVO>> findPayOrderByPage(PayOrderQueryCondParam param) {
		return Result.success(transactionService.findPayOrderByPage(param));
	}

}
