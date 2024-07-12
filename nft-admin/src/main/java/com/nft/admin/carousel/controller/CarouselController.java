package com.nft.admin.carousel.controller;

import com.nft.common.vo.Result;
import com.nft.notice.domain.Carousel;
import com.nft.notice.param.AddOrUpdateCarouselParam;
import com.nft.notice.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "轮播图管理")
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "添加轮播图")
    @PostMapping("/addCarousel")
    public Result addCarousel(@RequestBody AddOrUpdateCarouselParam param) {
        carouselService.addCarousel(param);
        return Result.success();
    }

    @ApiOperation(value = "删除轮播图")
    @DeleteMapping("/deleteCarousel/{id}")
    public Result deleteCarousel(@PathVariable Integer id) {
        carouselService.deleteCarousel(id);
        return Result.success();
    }

    @ApiOperation(value = "更新轮播图")
    @PutMapping("/updateCarousel")
    public Result updateCarousel(@RequestBody AddOrUpdateCarouselParam param) {
        carouselService.updateCarousel(param);
        return Result.success();
    }

    @ApiOperation(value = "获取所有轮播图")
    @GetMapping("/getAllCarousels")
    public Result<List<Carousel>> getAllCarousels() {
        return Result.success(carouselService.getAllCarousels());
    }
}