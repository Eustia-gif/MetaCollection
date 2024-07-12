package com.nft.collection.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.collection.param.CollectionQueryCondParam;
import com.nft.collection.param.ResaleCollectionQueryCondParam;
import com.nft.collection.service.CollectionService;
import com.nft.collection.service.CreatorService;
import com.nft.collection.vo.CreatorVO;
import com.nft.collection.vo.GroupByDateCollectionVO;
import com.nft.collection.vo.IssuedCollectionActionLogVO;
import com.nft.collection.vo.LatestCollectionDetailVO;
import com.nft.collection.vo.LatestCollectionVO;
import com.nft.collection.vo.PublishedBrandDictVO;
import com.nft.collection.vo.ResaleCollectionDetailVO;
import com.nft.collection.vo.ResaleCollectionVO;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;

@Api(tags = "藏品")
@RestController
@RequestMapping("/collection")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private CreatorService creatorService;

	/**
	 * 分页查询会员转卖收藏
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询创作者")
	@GetMapping("/findCreatorById")
	public Result<CreatorVO> findCreatorById(String id) {
		return Result.success(creatorService.findCreatorById(id));
	}

	/**
	 * 分页查询会员转卖收藏
	 * @return
	 */
	@ApiOperation(value = "查询已发布的品牌和系列字典")
	@GetMapping("/findPublishedBrandAndCollectionDict")
	public Result<List<PublishedBrandDictVO>> findPublishedBrandAndCollectionDict() {
		return Result.success(collectionService.findPublishedBrandAndCollectionDict());
	}

	/**
	 * 查询发行藏品操作日志
	 * @param issuedCollectionId
	 * @return
	 */
	@ApiOperation(value = "查询发行藏品操作日志")
	@GetMapping("/findIssuedCollectionActionLog")
	public Result<List<IssuedCollectionActionLogVO>> findIssuedCollectionActionLog(String issuedCollectionId) {
		return Result.success(collectionService.findIssuedCollectionActionLog(issuedCollectionId));
	}

	/**
	 * 查找转卖收藏详情
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查找转卖收藏详情")
	@GetMapping("/findResaleCollectionDetail")
	public Result<ResaleCollectionDetailVO> findResaleCollectionDetail(String id) {
		return Result.success(collectionService.findResaleCollectionDetail(id));
	}

	/**
	 * 分页查询转卖收藏
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询转卖收藏")
	@GetMapping("/findResaleCollectionByPage")
	public Result<PageResult<ResaleCollectionVO>> findResaleCollectionByPage(ResaleCollectionQueryCondParam param) {
		return Result.success(collectionService.findResaleCollectionByPage(param));
	}

	/**
	 * 查找最新收藏详情通过id
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查找最新收藏详情通过id")
	@GetMapping("/findLatestCollectionDetailById")
	public Result<LatestCollectionDetailVO> findLatestCollectionDetailById(String id) {
		return Result.success(collectionService.findLatestCollectionDetailById(id));
	}

	/**
	 * 分页查询最新盲盒
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询最新盲盒")
	@GetMapping("/findLatestMysteryBoxByPage")
	public Result<PageResult<LatestCollectionVO>> findLatestMysteryBoxByPage(CollectionQueryCondParam param) {
		return Result.success(collectionService.findLatestMysteryBoxByPage(param));
	}
	/**
	 * 分页查询最新藏品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询最新藏品")
	@GetMapping("/findLatestCollectionByPage")
	public Result<PageResult<LatestCollectionVO>> findLatestCollectionByPage(CollectionQueryCondParam param) {
		return Result.success(collectionService.findLatestCollectionByPage(param));
	}

	/**
	 * 查询销售收藏
	 * @return
	 */
	@ApiOperation(value = "查询日历销售")
	@GetMapping("/findForSaleCollection")
	public Result<List<GroupByDateCollectionVO>> findForSaleCollection() {
		return Result.success(collectionService.findForSaleCollection());
	}

}
