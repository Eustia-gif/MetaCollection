package com.nft.notice.vo;

import com.nft.notice.domain.Carousel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class CarouselVo implements Serializable {
    private Integer id;

    private Date createTime;

    private String imgUrl;

    private Boolean deletedFlag;

    private Date deletedTime;
    public static CarouselVo convertFor(Carousel carousel) {
        if (carousel == null) {
            return null;
        }
        CarouselVo vo = new CarouselVo();
        BeanUtils.copyProperties(carousel, vo);
        return vo;
    }
}
