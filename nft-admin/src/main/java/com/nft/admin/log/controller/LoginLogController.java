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
import com.nft.log.param.LoginLogQueryCondParam;
import com.nft.log.service.LoginLogService;
import com.nft.log.vo.LoginLogVO;

@Controller
@RequestMapping("/loginLog")
@Api(tags = "登录日志")
public class LoginLogController {

	@Autowired
	private LoginLogService loginLogService;

	@GetMapping("/findLoginLogByPage")
	@ResponseBody
	@ApiOperation("分页查询登录日志")
	public Result<PageResult<LoginLogVO>> findLoginLogByPage(LoginLogQueryCondParam param) {
		return Result.success(loginLogService.findLoginLogByPage(param));
	}

}
