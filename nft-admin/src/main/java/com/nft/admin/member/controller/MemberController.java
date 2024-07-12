package com.nft.admin.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.chain.service.ChainService;
import com.nft.common.operlog.OperLog;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;
import com.nft.member.param.AddMemberParam;
import com.nft.member.param.MemberQueryCondParam;
import com.nft.member.param.UpdateMemberParam;
import com.nft.member.service.MemberService;
import com.nft.member.vo.MemberFundInfoVO;
import com.nft.member.vo.MemberStatisticDataVO;
import com.nft.member.vo.MemberVO;

import cn.dev33.satoken.stp.StpUtil;

@Controller
@RequestMapping("/member")
@Api(tags = "会员账号")
public class MemberController {

	public static final String module_memberAccount = "会员账号";

	@Autowired
	private MemberService memberService;

	@Autowired
	private ChainService chainService;

	@GetMapping("/createBlockChainAddr")
	@ResponseBody
	@ApiOperation("创建区块链地址")
	public Result<String> createBlockChainAddr(String id) {
		return Result.success(chainService.createBlockChainAddr(id));
	}

	@GetMapping("/getMemberFundInfo")
	@ResponseBody
	@ApiOperation("获取会员资金信息")
	public Result<MemberFundInfoVO> getMemberFundInfo() {
		return Result.success(memberService.getMemberFundInfo());
	}

	@GetMapping("/getMemberStatisticData")
	@ResponseBody
	@ApiOperation("获取会员统计数据")
	public Result<MemberStatisticDataVO> getMemberStatisticData() {
		return Result.success(memberService.getMemberStatisticData());
	}

	@GetMapping("/findMemberById")
	@ResponseBody
	@ApiOperation("根据ID查询会员")
	public Result<MemberVO> findMemberById(String id) {
		return Result.success(memberService.findMemberById(id));
	}

	@GetMapping("/findMemberByPage")
	@ResponseBody
	@ApiOperation("分页查询会员")
	public Result<PageResult<MemberVO>> findMemberByPage(MemberQueryCondParam param) {
		return Result.success(memberService.findMemberByPage(param));
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_memberAccount, operate = "修改支付密码")
	@PostMapping("/modifyPayPwd")
	@ResponseBody
	@ApiOperation("修改支付密码")
	public Result<String> modifyPayPwd(String id, String newPwd) {
		memberService.modifyPayPwd(id, newPwd);
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_memberAccount, operate = "修改会员信息")
	@PostMapping("/updateMember")
	@ResponseBody
	@ApiOperation("修改会员信息")
	public Result<String> updateMember(UpdateMemberParam param) {
		memberService.updateMember(param);
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_memberAccount, operate = "删除")
	@GetMapping("/delMember")
	@ResponseBody
	@ApiOperation("删除会员")
	public Result<String> delMember(String id) {
		memberService.delMember(id);
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_memberAccount, operate = "新增会员")
	@PostMapping("/addMember")
	@ResponseBody
	@ApiOperation("新增会员")
	public Result<String> addMember(AddMemberParam param) {
		memberService.addMember(param);
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_memberAccount, operate = "增加余额")
	@PostMapping("/addBalance")
	@ResponseBody
	@ApiOperation("增加余额")
	public Result<String> addBalance(String id, Double amount) {
		memberService.addBalance(id, amount, StpUtil.getLoginIdAsString());
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_memberAccount, operate = "减少余额")
	@PostMapping("/reduceBalance")
	@ResponseBody
	@ApiOperation("减少余额")
	public Result<String> reduceBalance(String id, Double amount) {
		memberService.reduceBalance(id, amount, StpUtil.getLoginIdAsString());
		return Result.success();
	}

}
