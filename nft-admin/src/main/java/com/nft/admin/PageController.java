package com.nft.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
@Api(tags = "页面")
public class PageController {
	
	@GetMapping("/statistic-data")
	@ApiOperation("统计数据")
	public String statisticData() {
		return "statistic-data";
	}
	
	@GetMapping("/withdraw-record")
	@ApiOperation("提现记录")
	public String withdrawRecord() {
		return "withdraw-record";
	}
	
	@GetMapping("/compose-activity")
	@ApiOperation("合成活动")
	public String composeActivity() {
		return "compose-activity";
	}
	
	@GetMapping("/pay-order")
	@ApiOperation("支付订单")
	public String payOrder() {
		return "pay-order";
	}

	@GetMapping("/collection-give-record")
	@ApiOperation("赠送记录")
	public String collectionGiveRecord() {
		return "collection-give-record";
	}

	@GetMapping("/member-resale-collection")
	@ApiOperation("会员转售集合")
	public String memberResaleCollection() {
		return "member-resale-collection";
	}

	@GetMapping("/member-hold-collection")
	@ApiOperation("会员持有集合")
	public String memberHoldCollection() {
		return "member-hold-collection";
	}

	@GetMapping("/creator")
	@ApiOperation("创作者")
	public String creator() {
		return "creator";
	}
	
	@GetMapping("/mystery-box")
	@ApiOperation("神秘盒")
	public String mysteryBox() {
		return "mystery-box";
	}

	@GetMapping("/collection")
	public String collection() {
		return "collection";
	}

	@GetMapping("/member-data")
	@ApiOperation("会员数据")
	public String memberData() {
		return "member-data";
	}

	@GetMapping("/sms-send-record")
	@ApiOperation("短信发送记录")
	public String smsSendRecord() {
		return "sms-send-record";
	}

	@GetMapping("/notice")
	@ApiOperation("站内公告")
	public String notice() {
		return "notice";
	}

	@GetMapping("/member-balance-change-log")
	@ApiOperation("会员余额变动日志")
	public String memberBalanceChangeLog() {
		return "member-balance-change-log";
	}

	@GetMapping("/data-clean")
	@ApiOperation("数据清理")
	public String dataClean() {
		return "data-clean";
	}

	@GetMapping("/statistical")
	@ApiOperation("统计")
	public String statistical() {
		return "statistical";
	}

	@GetMapping("/setting")
	@ApiOperation("设置")
	public String setting() {
		return "setting";
	}

	@GetMapping("/super-admin")
	@ApiOperation("超级管理员")
	public String superAdmin() {
		return "super-admin";
	}

	@GetMapping("/google-auth")
	@ApiOperation("谷歌认证")
	public String googleAuth() {
		return "google-auth";
	}

	@GetMapping("/permission-fail")
	@ApiOperation("权限不足")
	public String permissionFail() {
		return "permission-fail";
	}

	@GetMapping("/role-manage")
	@ApiOperation("角色管理")
	public String roleManage() {
		return "role-manage";
	}

	@GetMapping("/menu-manage")
	@ApiOperation("菜单管理")
	public String menuManage() {
		return "menu-manage";
	}

	@GetMapping("/member")
	@ApiOperation("会员")
	public String member() {
		return "member";
	}

	@GetMapping("/background-account")
	@ApiOperation("后台账号")
	public String backgroundAccount() {
		return "background-account";
	}

	@GetMapping("/login")
	@ApiOperation("登录")
	public String login() {
		return "login";
	}

	@GetMapping("/dict-manage")
	@ApiOperation("字典管理")
	public String dictManage() {
		return "dict-manage";
	}

	@GetMapping("/login-log")
	@ApiOperation("登录日志")
	public String loginLog() {
		return "login-log";
	}

	@GetMapping("/oper-log")
	@ApiOperation("操作日志")
	public String operLog() {
		return "oper-log";
	}
// TODO 后期加上首页轮播图管理
	@GetMapping("/carousel")
	@ApiOperation("轮播图")
	public String carouselManager() {
		return "carousel";
	}

}
