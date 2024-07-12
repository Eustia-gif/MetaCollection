package com.nft.notice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.notice.param.NoticeQueryCondParam;
import com.nft.notice.service.NoticeService;
import com.nft.notice.vo.NoticeAbstractVO;
import com.nft.notice.vo.NoticeVO;

@RestController
@RequestMapping("/notice")
@Api(tags = "公告")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	/**
	 * 分页查询公告
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "分页查询公告")
	@GetMapping("/getNoticeDetail")
	public Result<NoticeVO> getNoticeDetail(String id) {
		return Result.success(noticeService.findById(id));
	}

	/**
	 * 分页查询公告摘要
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询公告摘要")
	@GetMapping("/findNoticeAbstractByPage")
	public Result<PageResult<NoticeAbstractVO>> findNoticeAbstractByPage(NoticeQueryCondParam param) {
		return Result.success(noticeService.findPublishedNoticeByPage(param));
	}

}
