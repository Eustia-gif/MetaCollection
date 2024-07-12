package com.nft.admin.collection.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.collection.param.statistic.TradeDataQueryCondParam;
import com.nft.collection.service.TradeStatisticService;
import com.nft.collection.vo.statistic.EverydayTradeDataVO;
import com.nft.collection.vo.statistic.TradeStatisticDataVO;
import com.nft.common.vo.Result;

@Api(tags = "交易统计")
@RestController
@RequestMapping("/tradeStatistic")
public class TradeStatisticController {

	@Autowired
	private TradeStatisticService tradeStatisticService;

	/**
	 * 获取交易统计数据
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "获取交易统计数据")
	@GetMapping("/getTradeStatisticData")
	public Result<TradeStatisticDataVO> getTradeStatisticData(TradeDataQueryCondParam param) {
		return Result.success(tradeStatisticService.getTradeStatisticData(param));
	}

	/**
	 * 获取每日交易数据
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "获取每日交易数据")
	@GetMapping("/findEverydayTradeData")
	public Result<List<EverydayTradeDataVO>> findEverydayTradeData(TradeDataQueryCondParam param) {
		return Result.success(tradeStatisticService.findEverydayTradeData(param));
	}

}
