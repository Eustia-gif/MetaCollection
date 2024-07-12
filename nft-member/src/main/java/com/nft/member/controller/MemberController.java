package com.nft.member.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;
import com.nft.log.param.LoginLogQueryCondParam;
import com.nft.log.service.LoginLogService;
import com.nft.log.vo.LoginLogVO;
import com.nft.member.param.BindRealNameParam;
import com.nft.member.param.ModifyPayPwdParam;
import com.nft.member.service.MemberService;
import com.nft.member.vo.InviteInfoVO;
import com.nft.member.vo.MyInviteRecordVO;
import com.nft.member.vo.MyPersonalInfoVO;

import cn.dev33.satoken.stp.StpUtil;

@RestController
@RequestMapping("/member")
@Api(tags = "会员")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private LoginLogService loginLogService;

	/**
	 * 查询我的邀请记录
	 * @return
	 */
	@ApiOperation(value = "查询我的邀请记录")
	@GetMapping("/findMyInviteRecord")
	public Result<List<MyInviteRecordVO>> findMyInviteRecord() {
		return Result.success(memberService.findMyInviteRecord(StpUtil.getLoginIdAsString()));
	}

	/**
	 * 获取邀请信息
	 * @return
	 */
	@ApiOperation(value = "获取邀请信息")
	@GetMapping("/getInviteInfo")
	public Result<InviteInfoVO> getInviteInfo() {
		return Result.success(memberService.getInviteInfo(StpUtil.getLoginIdAsString()));
	}

	/**
	 * 获取余额
	 * @return
	 */
	@ApiOperation(value = "获取余额")
	@GetMapping("/getBalance")
	public Result<Double> getBalance() {
		return Result.success(memberService.getBalance(StpUtil.getLoginIdAsString()));
	}

	/**
	 * 发送修改支付密码验证码
	 * @return
	 */
	@ApiOperation(value = "发送修改支付密码验证码")
	@GetMapping("/sendModifyPayPwdVerificationCode")
	public Result<String> sendModifyPayPwdVerificationCode() {
		memberService.sendModifyPayPwdVerificationCode(StpUtil.getLoginIdAsString());
		return Result.success();
	}

	/**
	 * 分页查询登录日志
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询登录日志")
	@GetMapping("/findLoginLogByPage")
	public Result<PageResult<LoginLogVO>> findLoginLogByPage(LoginLogQueryCondParam param) {
		param.setUserName(StpUtil.getSession().getString("mobile"));
		param.setSubSystem(Constant.SUBSYSTEM_MEMBER_END);
		return Result.success(loginLogService.findLoginLogByPage(param));
	}

	/**
	 * 更新保持登录时长
	 * @param keepLoginDuration
	 * @return
	 */
	@ApiOperation(value = "更新保持登录时长")
	@PostMapping("/updateKeepLoginDuration")
	public Result<String> updateKeepLoginDuration(Integer keepLoginDuration) {
		memberService.updateKeepLoginDuration(StpUtil.getLoginIdAsString(), keepLoginDuration);
		return Result.success();
	}

	/**
	 * 获取我的个人信息
	 * @return
	 */
	@ApiOperation(value = "获取我的个人信息")
	@GetMapping("/getMyPersonalInfo")
	public Result<MyPersonalInfoVO> getMyPersonalInfo() {
		return Result.success(memberService.getMyPersonalInfo(StpUtil.getLoginIdAsString()));
	}

	/**
	 * 更新昵称
	 * @param nickName
	 * @return
	 */
	@ApiOperation(value = "更新昵称")
	@PostMapping("/updateNickName")
	public Result<String> updateNickName(String nickName) {
		memberService.updateNickName(StpUtil.getLoginIdAsString(), nickName);
		return Result.success();
	}

	/**
	 * 更新头像
	 * @param avatar
	 * @return
	 */
	@ApiOperation(value = "更新头像")
	@PostMapping("/updateAvatar")
	public Result<String> updateAvatar(String avatar) {
		memberService.updateAvatar(StpUtil.getLoginIdAsString(), avatar);
		return Result.success();
	}

	/**
	 * 绑定实名
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "绑定实名")
	@PostMapping("/bindRealName")
	public Result<String> bindRealName(BindRealNameParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		memberService.bindRealName(param);
		return Result.success();
	}

	/**
	 * 修改支付密码
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "修改支付密码")
	@PostMapping("/modifyPayPwd")
	public Result<String> modifyPayPwd(ModifyPayPwdParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		memberService.modifyPayPwd(param);
		return Result.success();
	}

}
