package com.nft.admin.collection.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.collection.param.CollectionGiveRecordQueryCondParam;
import com.nft.collection.service.CollectionGiveService;
import com.nft.collection.vo.CollectionGiveRecordVO;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;

@Api(tags = "收藏赠送记录")
@Controller
@RequestMapping("/collectionGiveRecord")
public class CollectionGiveRecordController {

	@Autowired
	private CollectionGiveService collectionGiveService;
	/**
	 * 分页查询收藏赠送记录
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询收藏赠送记录")
	@GetMapping("/findCollectionGiveRecordByPage")
	@ResponseBody
	public Result<PageResult<CollectionGiveRecordVO>> findCollectionGiveRecordByPage(
			CollectionGiveRecordQueryCondParam param) {
		return Result.success(collectionGiveService.findCollectionGiveRecordByPage(param));
	}

}
