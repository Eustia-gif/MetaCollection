package com.nft.notice.controller;

import com.nft.common.vo.Result;
import com.nft.notice.domain.Carousel;
import com.nft.notice.service.CarouselService;
import com.nft.notice.vo.CarouselVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@Api(tags = "轮播图")
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "获取轮播图")
    @GetMapping("/getCarouselsByCount")
    public Result<List<CarouselVo>> getCarouselsByCount(int count) {
        List<Carousel> carousels = carouselService.getCarouselsByCount(count);
        List<CarouselVo> carouselVos = new ArrayList<>();
        for (Carousel carousel : carousels) {
            CarouselVo carouselVo = new CarouselVo();
            BeanUtils.copyProperties(carousel, carouselVo);
            carouselVos.add(carouselVo);
        }
            return Result.success(carouselVos);
    }
}