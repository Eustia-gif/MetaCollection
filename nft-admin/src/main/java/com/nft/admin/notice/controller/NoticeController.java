package com.nft.admin.notice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.common.operlog.OperLog;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;
import com.nft.notice.param.AddOrUpdateNoticeParam;
import com.nft.notice.param.NoticeQueryCondParam;
import com.nft.notice.service.NoticeService;
import com.nft.notice.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
@Api(tags = "站内公告")
public class NoticeController {

	public static final String module_notice = "站内公告";

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/findById")
	@ResponseBody
	@ApiOperation("根据ID查询")
	public Result<NoticeVO> findById(String id) {
		return Result.success(noticeService.findById(id));
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_notice, operate = "删除")
	@GetMapping("/delById")
	@ResponseBody
	@ApiOperation("根据ID删除")
	public Result<String> delById(String id) {
		noticeService.delById(id);
		return Result.success();
	}

	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = module_notice, operate = "添加或编辑")
	@PostMapping("/addOrUpdateNotice")
	@ResponseBody
	@ApiOperation("添加或编辑")
	public Result<String> addOrUpdateNotice(AddOrUpdateNoticeParam param) {
		noticeService.addOrUpdateNotice(param);
		return Result.success();
	}

	@GetMapping("/findByPage")
	@ResponseBody
	@ApiOperation("分页查询")
	public Result<PageResult<NoticeVO>> findByPage(NoticeQueryCondParam param) {
		return Result.success(noticeService.findByPage(param));
	}

}
