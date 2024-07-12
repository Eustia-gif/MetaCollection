package com.nft.admin.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.common.operlog.OperLog;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;
import com.nft.member.param.WithdrawRecordQueryCondParam;
import com.nft.member.service.WithdrawService;
import com.nft.member.vo.WithdrawRecordVO;

@Controller
@RequestMapping("/withdraw")
@Api(tags = "提现")
public class WithdrawController {

	public static final String module_withdraw = "提现";

	@Autowired
	private WithdrawService withdrawService;

	@GetMapping("/findByPage")
	@ResponseBody
	@ApiOperation("分页查询提现记录")
	public Result<PageResult<WithdrawRecordVO>> findByPage(WithdrawRecordQueryCondParam param) {
		return Result.success(withdrawService.findByPage(param));
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_withdraw, operate = "确定已提现")
	@GetMapping("/confirmCredited")
	@ResponseBody
	@ApiOperation("确定已提现")
	public Result<String> confirmCredited(String id) {
		withdrawService.confirmCredited(id);
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_withdraw, operate = "驳回")
	@GetMapping("/reject")
	@ResponseBody
	@ApiOperation("驳回")
	public Result<String> reject(String id) {
		withdrawService.reject(id);
		return Result.success();
	}

}
