package com.nft.chain.controller;

import com.nft.common.vo.Result;
import com.nft.ipfs.repo.IpfsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;

@RestController
@Api(tags = "区块链信息查询")
@RequestMapping("/infoQuery")
public class InfoQueryByIpfsHash {
    @Autowired
    private IpfsService ipfsService;

    /**
     * 根据ipfsHash查询信息
     * @param ipfsHash
     * @return
     */
    @ApiOperation(value = "根据ipfsHash查询信息")
    @GetMapping("/GetIpfsHash")
    public Result<Object> queryInfoByIpfsHash(String ipfsHash) {
        byte[] bytes = new byte[0];
        try {
            bytes = ipfsService.downFromIpfs(ipfsHash);
        } catch (Exception e) {
            throw new RuntimeException("查询失败");
        }
        String jsonString = new String(bytes, StandardCharsets.UTF_8);
        Object jsonObject = JSON.parse(jsonString);
        return Result.success(jsonObject);
    }
}
