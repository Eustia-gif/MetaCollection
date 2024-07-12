package com.nft.setting.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.common.vo.Result;
import com.nft.setting.service.SettingService;

@Controller
@RequestMapping("/setting")
@Api(tags = "设置")
public class SettingController {

	@Autowired
	private SettingService service;

	/**
	 * 获取客服地址
	 * @return
	 */
	@ApiOperation("获取客服地址")
	@GetMapping("/getCustomerServiceUrl")
	@ResponseBody
	public Result<String> getCustomerServiceUrl() {
		return Result.success(service.getSystemSetting().getCustomerServiceUrl());
	}

}
