package com.nft.collection.param;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.nft.collection.domain.PreSaleQualify;
import com.nft.common.utils.IdUtils;
import com.nft.constants.Constant;

import lombok.Data;

@Data
public class AddPreSaleQualifyParam {

	@NotBlank
	private String memberId;

	@NotBlank
	private String collectionId;

	@NotNull
	@DecimalMin(value = "0", inclusive = false)
	private Integer preMinute;

	public PreSaleQualify convertToPo() {
		PreSaleQualify po = new PreSaleQualify();
		BeanUtils.copyProperties(this, po);
		po.setId(IdUtils.getId());
		po.setBizType(Constant.PRIORITY_PURCHASE_BUSINESS_TYPE_MANUAL_DISTRIBUTION);
		po.setGrantTime(new Date());
		po.setState(Constant.PRIORITY_PURCHASE_QUALIFICATION_STATUS_UNUSED);
		return po;
	}

}
