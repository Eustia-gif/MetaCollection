package com.nft.notice.param;

import com.nft.notice.domain.Carousel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
public class AddOrUpdateCarouselParam {
    private Integer id;
    @NotBlank
    private String imageUrl;
    public Carousel toCarousel() {
        Carousel carousel = new Carousel();
        carousel.setImgUrl(this.imageUrl);
        carousel.setCreateTime(new Date());
        carousel.setDeletedFlag(false);
        carousel.setCreateTime(new Date());
        return carousel;
    }
}