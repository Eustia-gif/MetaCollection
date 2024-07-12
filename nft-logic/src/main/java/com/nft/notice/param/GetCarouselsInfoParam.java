package com.nft.notice.param;

import com.nft.notice.domain.Carousel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

@Data
public class GetCarouselsInfoParam {
    private String id;
    @NotBlank
    private String imgUrl;

    public Carousel toCarousel() {
        Carousel carousel = new Carousel();
        BeanUtils.copyProperties(this, carousel);
        return carousel;
    }
}
