package com.nft.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.log.param.MemberBalanceChangeLogQueryCondParam;
import com.nft.log.service.MemberBalanceChangeLogService;
import com.nft.log.vo.MemberFinanceDetailVO;
import com.nft.log.vo.MemberFinanceRecordVO;

import cn.dev33.satoken.stp.StpUtil;

@RestController
@RequestMapping("/memberBalanceChangeLog")
@Api(tags = "会员余额变动日志")
public class MemberBalanceChangeLogController {

	@Autowired
	private MemberBalanceChangeLogService memberBalanceChangeLogService;

	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "获取详情")
	@GetMapping("/getDetail")
	public Result<MemberFinanceDetailVO> getDetail(String id) {
		return Result.success(memberBalanceChangeLogService.getDetail(id));
	}

	/**
	 * 分页查询会员记录
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询会员记录")
	@GetMapping("/findByPage")
	public Result<PageResult<MemberFinanceRecordVO>> findByPage(MemberBalanceChangeLogQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(memberBalanceChangeLogService.findMemberFinanceRecordByPage(param));
	}

}
