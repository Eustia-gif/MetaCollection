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
import org.springframework.beans.BeanUtils;

import com.nft.common.utils.IdUtils;
import com.nft.constants.Constant;
import com.nft.member.domain.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "member_hold_collection")
@DynamicInsert(true)
@DynamicUpdate(true)
public class MemberHoldCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 32)
	private String id;
	
	private String preId;

	private Double price;

	private String gainWay;

	private String state;

	private Date holdTime;

	private Date loseTime;

	private String transactionHash;
	
	private Date syncChainTime;

	private String modelPath;

	@Version
	private Long version;

	@Column(name = "member_id", length = 32)
	private String memberId;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", updatable = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Member member;

	@Column(name = "collection_id", length = 32)
	private String collectionId;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collection_id", updatable = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Collection collection;

	@Column(name = "issued_collection_id", length = 32)
	private String issuedCollectionId;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "issued_collection_id", updatable = false, insertable = false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private IssuedCollection issuedCollection;
	
	public void syncChain(String transactionHash) {
		this.setTransactionHash(transactionHash);
		this.setSyncChainTime(new Date());
	}
	
	public void composeDestroy() {
		this.setLoseTime(new Date());
		this.setState(Constant.HOLDING_COLLECTION_STATUS_SYNTHESIZED_DESTROYED);
	}
	
	public void openMysteryBoxDestroy() {
		this.setLoseTime(new Date());
		this.setState(Constant.HOLDING_COLLECTION_STATUS_BLIND_BOX_DESTROYED);
	}

	public void sold() {
		this.setLoseTime(new Date());
		this.setState(Constant.HOLDING_COLLECTION_STATUS_SOLD);
	}

	public MemberResaleCollection buildResaleCollectionReocrd(Double resalePrice) {
		MemberResaleCollection po = new MemberResaleCollection();
		po.setId(IdUtils.getId());
		po.setState(Constant.RESALE_COLLECTION_STATUS_PUBLISHED);
		po.setResaleTime(new Date());
		po.setResalePrice(resalePrice);
		po.setMemberId(this.getMemberId());
		po.setCollectionId(this.getCollectionId());
		po.setMemberHoldCollectionId(this.getId());
		po.setIssuedCollectionId(this.getIssuedCollectionId());
		return po;
	}

	public MemberHoldCollection buildWithGive(String giveToId) {
		MemberHoldCollection po = new MemberHoldCollection();
		BeanUtils.copyProperties(this, po);
		po.setId(IdUtils.getId());
		po.setHoldTime(new Date());
		po.setMemberId(giveToId);
		po.setGainWay(Constant.COLLECTION_ACQUISITION_METHOD_GIFT);
		po.setTransactionHash(null);
		po.setSyncChainTime(null);
		return po;
	}

	public MemberHoldCollection buildWithBuyerHold(String buyerId, Double price) {
		MemberHoldCollection po = new MemberHoldCollection();
		BeanUtils.copyProperties(this, po);
		po.setId(IdUtils.getId());
		po.setHoldTime(new Date());
		po.setLoseTime(null);
		po.setGainWay(Constant.COLLECTION_ACQUISITION_METHOD_SECONDARY_MARKET);
		po.setMemberId(buyerId);
		po.setPrice(price);
		po.setState(Constant.HOLDING_COLLECTION_STATUS_HOLDING);
		po.setTransactionHash(null);
		po.setSyncChainTime(null);
		return po;
	}

}
