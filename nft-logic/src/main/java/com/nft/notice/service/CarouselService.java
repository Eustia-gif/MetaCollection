// CarouselService.java
package com.nft.notice.service;

import com.nft.notice.domain.Carousel;
import com.nft.notice.param.AddOrUpdateCarouselParam;
import com.nft.notice.repo.CarouselRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.List;

@Validated
@Service
public class CarouselService {
    @Autowired
    private CarouselRepo carouselRepo;
    @Transactional
    public List<Carousel> getCarouselsByCount(int count) {
        Page<Carousel> page = carouselRepo.findAll(PageRequest.of(0, count));
        return page.getContent();
    }
        public void addCarousel(AddOrUpdateCarouselParam param) {
            Carousel carousel = param.toCarousel();
            carouselRepo.save(carousel);
        }

        public void deleteCarousel(Integer id) {
            carouselRepo.deleteById(id);
        }

    // CarouselService.java
    public void updateCarousel(AddOrUpdateCarouselParam param) {
        Carousel carousel = carouselRepo.findById(param.getId()).orElseThrow(() -> new RuntimeException("Carousel not found"));
        carousel.setImgUrl(param.getImageUrl());
        carouselRepo.save(carousel);
    }
        public List<Carousel> getAllCarousels() {
            return carouselRepo.findAll();
        }
    }