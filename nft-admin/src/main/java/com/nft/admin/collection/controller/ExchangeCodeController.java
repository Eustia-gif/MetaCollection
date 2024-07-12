package com.nft.admin.collection.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.collection.param.GenerateExchangeCodeParam;
import com.nft.collection.service.ExchangeCodeService;
import com.nft.collection.vo.ExchangeCodeVO;
import com.nft.common.operlog.OperLog;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;

@Api(tags = "兑换码")
@Controller
@RequestMapping("/exchangeCode")
public class ExchangeCodeController {

	public static final String 模块_兑换码 = "兑换码";

	@Autowired
	private ExchangeCodeService exchangeCodeService;

	/**
	 * 查询兑换码
	 * @param collectionId
	 * @return
	 */
	@ApiOperation(value = "查询兑换码")
	@GetMapping("/findExchangeCode")
	@ResponseBody
	public Result<List<ExchangeCodeVO>> findExchangeCode(String collectionId) {
		return Result.success(exchangeCodeService.findExchangeCode(collectionId));
	}

	/**
	 * 生成兑换码
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "生成兑换码")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_兑换码, operate = "生成兑换码")
	@PostMapping("/generateExchangeCode")
	@ResponseBody
	public Result<String> generateExchangeCode(GenerateExchangeCodeParam param) {
		exchangeCodeService.generateExchangeCode(param);
		return Result.success();
	}

}
