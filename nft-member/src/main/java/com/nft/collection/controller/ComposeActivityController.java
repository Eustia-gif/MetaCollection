package com.nft.collection.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.collection.param.ComposeParam;
import com.nft.collection.service.ComposeActivityService;
import com.nft.collection.vo.ActiveComposeActivityDetailVO;
import com.nft.collection.vo.ActiveComposeActivityVO;
import com.nft.common.vo.Result;

import cn.dev33.satoken.stp.StpUtil;

@Api(tags = "合成活动")
@RestController
@RequestMapping("/composeActivity")
public class ComposeActivityController {

	@Autowired
	private ComposeActivityService composeActivityService;

	/**
	 * 合成
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "合成")
	@PostMapping("/compose")
	public Result<String> compose(ComposeParam param) {
		param.setMemberId(StpUtil.getLoginIdAsString());
		composeActivityService.compose(param);
		return Result.success();
	}

	/**
	 * 查询合成活动详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询合成活动详情")
	@GetMapping("/findActiveComposeActivityDetail")
	public Result<ActiveComposeActivityDetailVO> findActiveComposeActivityDetail(String id) {
		return Result.success(composeActivityService.findActiveComposeActivityDetail(id));
	}

	/**
	 * 查询活动合成列表
	 * @return
	 */
	@ApiOperation(value = "查询活动合成列表")
	@GetMapping("/findActiveComposeActivity")
	public Result<List<ActiveComposeActivityVO>> findActiveComposeActivity() {
		return Result.success(composeActivityService.findActiveComposeActivity());
	}

}
