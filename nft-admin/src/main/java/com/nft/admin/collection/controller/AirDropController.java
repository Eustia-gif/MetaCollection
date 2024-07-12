package com.nft.admin.collection.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.collection.param.AirDropParam;
import com.nft.collection.service.AirDropService;
import com.nft.common.operlog.OperLog;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;

@Api(tags = "空投")
@Controller
@RequestMapping("/airDrop")
public class AirDropController {

	public static final String 模块_空投 = "空投";

	@Autowired
	private AirDropService airDropService;

	/**
	 * 发放空投
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "发放空投")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_空投, operate = "发放空投")
	@PostMapping("/airDrop")
	@ResponseBody
	public Result<String> airDrop(AirDropParam param) {
		airDropService.airDrop(param);
		return Result.success();
	}

}
