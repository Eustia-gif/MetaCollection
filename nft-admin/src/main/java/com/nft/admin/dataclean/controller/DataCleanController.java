package com.nft.admin.dataclean.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.common.operlog.OperLog;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;
import com.nft.dataclean.param.DataCleanParam;
import com.nft.dataclean.service.DataCleanService;

@Controller
@RequestMapping("/dataClean")
@Api(tags = "缓存清理")
public class DataCleanController {

	@Autowired
	private DataCleanService dataCleanService;

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = "数据清理", operate = "数据清理")
	@PostMapping("/clean")
	@ResponseBody
	@ApiOperation(value = "清空缓存")
	public Result<String> clean(@RequestBody DataCleanParam param) {
		dataCleanService.clean(param);
		return Result.success();
	}

}
