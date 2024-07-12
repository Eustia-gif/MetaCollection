package com.nft.admin.collection.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nft.ipfs.repo.IpfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.collection.param.AddOrUpdateCreatorParam;
import com.nft.collection.param.CreatorQueryCondParam;
import com.nft.collection.service.CreatorService;
import com.nft.collection.vo.CreatorVO;
import com.nft.common.operlog.OperLog;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;

@Api(tags = "创作者管理")
@Controller
@RequestMapping("/creator")
public class CreatorController {

	public static final String 模块_创作者列表 = "创作者列表";

	@Autowired
	private CreatorService creatorService;
	@Autowired
	private IpfsService ipfsService;

	/**
	 * 删除创作者
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除创作者")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_创作者列表, operate = "删除创作者")
	@GetMapping("/delCreator")
	@ResponseBody
	public Result<String> delCreator(String id) {
		creatorService.delCreator(id);
		return Result.success();
	}

	/**
	 * 查询创作者
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询创作者")
	@GetMapping("/findCreatorById")
	@ResponseBody
	public Result<CreatorVO> findCreatorById(String id) {
		return Result.success(creatorService.findCreatorById(id));
	}

	/**
	 * 查询所有创作者
	 * @return
	 */
	@ApiOperation(value = "查询所有创作者")
	@GetMapping("/findAllCreator")
	@ResponseBody
	public Result<List<CreatorVO>> findAllCreator() {
		return Result.success(creatorService.findAllCreator());
	}
	/**
	 * 分页查询创作者
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询创作者")
	@GetMapping("/findCreatorByPage")
	@ResponseBody
	public Result<PageResult<CreatorVO>> findCreatorByPage(CreatorQueryCondParam param) {
		return Result.success(creatorService.findCreatorByPage(param));
	}

	/**
	 * 新增或编辑创作者
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "新增或编辑创作者")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_创作者列表, operate = "新增或编辑创作者")
	@PostMapping("/addOrUpdateCreator")
	@ResponseBody
	public Result<String> addOrUpdateCreator(AddOrUpdateCreatorParam param) {
		// 去除null的字段
		String jsonString = JSON.toJSONString(param, SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.BrowserCompatible);
		String hash = ipfsService.uploadToIpfsToJson(jsonString);
		// 设置ipfsHash
		param.setIpfsHashCreator(hash);
		creatorService.addOrUpdateCreator(param);
		return Result.success();
	}

}
