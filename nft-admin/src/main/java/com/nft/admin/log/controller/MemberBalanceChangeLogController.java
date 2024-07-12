package com.nft.admin.log.controller;

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
import com.nft.log.vo.MemberBalanceChangeLogVO;

@RestController
@RequestMapping("/memberBalanceChangeLog")
@Api(tags = "会员余额变动日志")
public class MemberBalanceChangeLogController {

	@Autowired
	private MemberBalanceChangeLogService memberBalanceChangeLogService;
	
	@GetMapping("/findByPage")
	@ApiOperation("分页查询会员余额变动日志")
	public Result<PageResult<MemberBalanceChangeLogVO>> findByPage(MemberBalanceChangeLogQueryCondParam param) {
		return Result.success(memberBalanceChangeLogService.findByPage(param));
	}

}
