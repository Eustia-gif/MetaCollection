package com.nft.notice.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carousel")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Carousel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 32)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date createTime;

    private String imgUrl;

    private Boolean deletedFlag;

    private Date deletedTime;

    public void deleted() {
        this.setDeletedFlag(true);
        this.setDeletedTime(new Date());
    }
}