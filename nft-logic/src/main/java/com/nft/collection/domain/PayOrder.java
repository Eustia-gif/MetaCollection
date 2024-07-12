package com.nft.collection.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.nft.common.utils.IdUtils;
import com.nft.constants.Constant;
import com.nft.member.domain.Member;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pay_order")
@DynamicInsert(true)
@DynamicUpdate(true)
public class PayOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 32)
	private String id;

	private String orderNo;

	private Date createTime;

	private Date paidTime;

	private Date cancelTime;

	private Date orderDeadline;

	private String state;

	private Double amount;

	private String bizMode;

	private String bizOrderNo;

	@Column(name = "ipfs_hash", length = 256)
	private String ipfsHash;

	@Column(name = "chain_hash",length = 256)
	private String chainHash;

	@Version
	private Long version;

	@Column(name = "collection_id", length = 32)
	private String collectionId;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collection_id", updatable = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Collection collection;

	@Column(name = "member_id", length = 32)
	private String memberId;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", updatable = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Member member;

	public void cancelOrder() {
		this.setState(Constant.PAY_ORDER_STATUS_CANCELLED);
		this.setCancelTime(new Date());
	}

	public void paid() {
		this.setState(Constant.PAY_ORDER_STATUS_PAID);
		this.setPaidTime(new Date());
	}

	public static PayOrder buildWithResaleCollection(MemberResaleCollection memberResaleCollection, Member member) {
		PayOrder po = new PayOrder();
		po.setId(IdUtils.getId());
		po.setOrderNo(po.getId());
		po.setCreateTime(new Date());
		po.setOrderDeadline(DateUtil.offset(po.getCreateTime(), DateField.MINUTE, 15));
		po.setState(Constant.PAY_ORDER_STATUS_PENDING_PAYMENT);
		po.setAmount(memberResaleCollection.getResalePrice());
		po.setBizMode(Constant.PAY_ORDER_BUSINESS_TYPE_SECONDARY_MARKET);
		po.setBizOrderNo(memberResaleCollection.getId());
		po.setCollectionId(memberResaleCollection.getCollectionId());
		po.setMemberId(member.getId());
		return po;
	}

	public static PayOrder buildWithLatestCollection(Collection collection, Member member) {
		PayOrder po = new PayOrder();
		po.setId(IdUtils.getId());
		po.setOrderNo(po.getId());
		po.setCreateTime(new Date());
		po.setOrderDeadline(DateUtil.offset(po.getCreateTime(), DateField.MINUTE, 15));
		po.setState(Constant.PAY_ORDER_STATUS_PENDING_PAYMENT);
		po.setAmount(collection.getPrice());
		po.setBizMode(Constant.PAY_ORDER_BUSINESS_MODE_PLATFORM_SELF_OPERATED);
		po.setCollectionId(collection.getId());
		po.setMemberId(member.getId());
		return po;
	}

}
