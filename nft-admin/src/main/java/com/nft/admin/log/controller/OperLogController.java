package com.nft.admin.log.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.log.param.OperLogQueryCondParam;
import com.nft.log.service.OperLogService;
import com.nft.log.vo.OperLogVO;

@Controller
@RequestMapping("/operLog")
@Api(tags = "操作日志")
public class OperLogController {

	@Autowired
	private OperLogService operLogService;

	@GetMapping("/findOperLogByPage")
	@ResponseBody
	@ApiOperation("分页查询操作日志")
	public Result<PageResult<OperLogVO>> findOperLogByPage(OperLogQueryCondParam param) {
		return Result.success(operLogService.findOperLogByPage(param));
	}

}
