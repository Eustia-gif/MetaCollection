package com.nft.member.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.common.vo.Result;
import com.nft.member.param.AddSettlementAccountParam;
import com.nft.member.param.SettlementAccountQueryCondParam;
import com.nft.member.param.UpdateSettlementAccountStateParam;
import com.nft.member.service.SettlementAccountService;
import com.nft.member.vo.SettlementAccountVO;

import cn.dev33.satoken.stp.StpUtil;

@RestController
@RequestMapping("/settlementAccount")
@Api(tags = "结算账户")
public class SettlementAccountController {

	@Autowired
	private SettlementAccountService settlementAccountService;

	/**
	 * 更新激活状态
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "更新激活状态")
	@PostMapping("/updateActivatedFlag")
	public Result<String> updateActivatedFlag(UpdateSettlementAccountStateParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		settlementAccountService.updateActivatedFlag(param);
		return Result.success();
	}

	/**
	 * 查询所有
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查询所有")
	@GetMapping("/findAll")
	public Result<List<SettlementAccountVO>> findAll(SettlementAccountQueryCondParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		return Result.success(settlementAccountService.findAll(param));
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除")
	@PostMapping("/del")
	public Result<String> del(String id) {
		settlementAccountService.del(id, StpUtil.getLoginIdAsString());
		return Result.success();
	}
	/**
	 * 添加
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "添加")
	@PostMapping("/add")
	public Result<String> add(AddSettlementAccountParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		settlementAccountService.add(param);
		return Result.success();
	}

}
