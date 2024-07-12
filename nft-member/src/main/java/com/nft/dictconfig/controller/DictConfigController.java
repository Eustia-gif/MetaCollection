package com.nft.dictconfig.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nft.common.vo.Result;
import com.nft.dictconfig.DictHolder;
import com.nft.dictconfig.vo.DictItemVO;

@Controller
@RequestMapping("/dictconfig")
@Api(tags = "字典配置")
public class DictConfigController {
	
	@GetMapping("/findDictItemInCache")
	@ResponseBody
	@ApiOperation(value = "在缓存中查找字典项")
	public Result<List<DictItemVO>> findDictItemInCache(String dictTypeCode) {
		return Result.success(DictHolder.findDictItem(dictTypeCode));
	}
}
