package com.nft.admin.collection.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nft.constract.ContractInteraction;
import com.nft.ipfs.repo.IpfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.chain.service.ChainService;
import com.nft.collection.param.AddCollectionParam;
import com.nft.collection.param.CollectionQueryCondParam;
import com.nft.collection.param.UpdateCollectionStoryParam;
import com.nft.collection.param.UpdateMysteryBoxCommodityParam;
import com.nft.collection.service.CollectionService;
import com.nft.collection.vo.CollectionStatisticDataVO;
import com.nft.collection.vo.CollectionVO;
import com.nft.collection.vo.IssuedCollectionVO;
import com.nft.collection.vo.MysteryBoxCommodityVO;
import com.nft.common.operlog.OperLog;
import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.constants.Constant;

@Api(tags = "艺术品管理")
@Controller
@RequestMapping("/collection")
public class CollectionController {

	public static final String 模块_艺术品管理 = "艺术品管理";

	@Autowired
	private CollectionService collectionService;

	@Autowired
	private ChainService chainService;

	@Autowired
	private IpfsService ipfsService;

	@Autowired
	private ContractInteraction contractInteraction;

	/**
	 * 查询盲盒商品
	 * @param collectionId
	 * @return
	 */

	@ApiOperation(value = "查询盲盒商品")
	@GetMapping("/findMysteryBoxCommodity")
	@ResponseBody
	public Result<List<MysteryBoxCommodityVO>> findMysteryBoxCommodity(String collectionId) {
		return Result.success(collectionService.findMysteryBoxCommodity(collectionId));
	}

	/**
	 * 编辑盲盒商品
	 * @param param
	 * @return
	 */

	@ApiOperation(value = "编辑盲盒商品")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_艺术品管理, operate = "编辑盲盒商品")
	@PostMapping("/updateMysteryBoxCommodity")
	@ResponseBody
	public Result<String> updateMysteryBoxCommodity(@RequestBody UpdateMysteryBoxCommodityParam param) {
		collectionService.updateMysteryBoxCommodity(param);
		return Result.success();
	}

	/**
	 * 查询已发行的艺术品
	 * @param collectionId
	 * @return
	 */
	@ApiOperation(value = "查询已发行的艺术品")
	@GetMapping("/findIssuedCollection")
	@ResponseBody
	public Result<List<IssuedCollectionVO>> findIssuedCollection(String collectionId) {
		return Result.success(collectionService.findIssuedCollection(collectionId));
	}

	/**
	 * 手动上链
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "手动上链")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_艺术品管理, operate = "手动上链")
	@GetMapping("/syncChain")
	@ResponseBody
	public Result<String> syncChain(String id) {
		return Result.success(chainService.chainAddArtwork(id));
	}

	/**
	 * 获取艺术品统计数据
	 * @return
	 */
	@ApiOperation(value = "获取艺术品统计数据")
	@GetMapping("/getCollectionStatisticData")
	@ResponseBody
	public Result<CollectionStatisticDataVO> getCollectionStatisticData() {
		return Result.success(collectionService.getCollectionStatisticData());
	}

	/**
	 * 编辑作品故事
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "编辑作品故事")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_艺术品管理, operate = "编辑作品故事")
	@PostMapping("/updateCollectionStory")
	@ResponseBody
	public Result<String> updateCollectionStory(@RequestBody UpdateCollectionStoryParam param) {
		collectionService.updateCollectionStory(param);
		return Result.success();
	}

	/**
	 * 删除艺术品
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除艺术品")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_艺术品管理, operate = "删除")
	@GetMapping("/delCollection")
	@ResponseBody
	public Result<String> delCollection(String id) {
		collectionService.delCollection(id);
		return Result.success();
	}

	/**
	 * 查询所有艺术品
	 * @return
	 */
	@ApiOperation(value = "查询所有艺术品")
	@GetMapping("/findAllCollection")
	@ResponseBody
	public Result<List<CollectionVO>> findAllCollection() {
		return Result.success(collectionService.findAllCollection());
	}
	/**
	 * 查询艺术品通过id
	 * @return
	 */
	@ApiOperation(value = "查询艺术品通过id")
	@GetMapping("/findCollectionById")
	@ResponseBody
	public Result<CollectionVO> findCollectionById(String id) {
		return Result.success(collectionService.findCollectionById(id));
	}
	/**
	 * 分页查询艺术品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "分页查询艺术品")
	@GetMapping("/findCollectionByPage")
	@ResponseBody
	public Result<PageResult<CollectionVO>> findCollectionByPage(CollectionQueryCondParam param) {
		return Result.success(collectionService.findCollectionByPage(param));
	}
	/**
	 * 新增艺术品
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "新增艺术品")
	@OperLog(subSystem = Constant.SUBSYSTEM_BACKSTAGE_MANAGEMENT, module = 模块_艺术品管理, operate = "新增")
	@PostMapping("/addCollection")
	@ResponseBody
	public Result<String> addCollection(AddCollectionParam param) throws Exception {
		// 设置ipfsHash
		// TODO 避免卡顿，暂时先注释掉
//		contractInteraction.init();
//		String storeHash = contractInteraction.storeHash("QmPCrp1kxWkCFAFfpQtUkikwHehke8EA2dJPU3VZ8KEkWS");
//		param.setChainHash(storeHash);
		collectionService.addCollection(param);
		return Result.success();
	}

}
