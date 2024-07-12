package com.nft.admin.collection.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nft.chain.service.ChainService;
import com.nft.collection.param.MemberHoldCollectionQueryCondParam;
import com.nft.collection.service.CollectionService;
import com.nft.collection.vo.IssuedCollectionActionLogVO;
import com.nft.collection.vo.MemberHoldCollectionVO;
import com.nft.common.operlog.OperLog;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;

@Api(tags = "持有艺术品")
@RestController
@RequestMapping("/memberHoldCollection")
public class MemberHoldCollectionController {

	public static final String 模块_持有艺术品 = "持有艺术品 ";

	@Autowired
	private CollectionService collectionService;

	@Autowired
	private ChainService chainService;

	/**
	 * 手动上链(转让)
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "手动上链(转让)")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_持有艺术品, operate = "手动上链(转让)")
	@GetMapping("/chainTransfer")
	@ResponseBody
	public Result<String> chainTransfer(String id) {
		return Result.success(chainService.chainTransfer(id));
	}

	/**
	 * 手动上链(铸造)
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "手动上链(铸造)")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_持有艺术品, operate = "手动上链(铸造)")
	@GetMapping("/mintArtwork")
	@ResponseBody
	public Result<String> mintArtwork(String id) {
		return Result.success(chainService.mintArtwork(id));
	}

	/**
	 * 查询发布艺术品操作日志
	 * @param issuedCollectionId
	 * @return
	 */
	@ApiOperation(value = "查询发布艺术品操作日志")
	@GetMapping("/findIssuedCollectionActionLog")
	public Result<List<IssuedCollectionActionLogVO>> findIssuedCollectionActionLog(String issuedCollectionId) {
		return Result.success(collectionService.findIssuedCollectionActionLog(issuedCollectionId));
	}

	/**
	 * 分页查询持有艺术品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询持有艺术品")
	@GetMapping("/findMemberHoldCollectionByPage")
	public Result<PageResult<MemberHoldCollectionVO>> findMemberHoldCollectionByPage(
			MemberHoldCollectionQueryCondParam param) {
		return Result.success(collectionService.findMemberHoldCollectionByPage(param));
	}

}
