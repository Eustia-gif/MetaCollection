package com.nft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nft.chain.service.ChainService;
import com.nft.collection.service.TransactionService;
import com.nft.constants.Constant;
import com.nft.sms.service.SmsService;
import com.zengtengpeng.annotation.MQListener;

@Component
public class RedisMqListener {

	@Autowired
	private SmsService smsService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private ChainService chainService;

	@MQListener(name = Constant.CHAIN_SYNC_TRANSACTION_HASH)
	public void syncTransactionHash(String topicName, String value) {
		chainService.syncTransactionHash(value);
	}

	@MQListener(name = Constant.CHAIN_SYNC_UNIQUE_ID)
	public void syncUniqueId(String topicName, String value) {
		chainService.syncUniqueId(value);
	}

	@MQListener(name = Constant.CHAIN_DESTROY_ARTWORK)
	public void destroyArtwork(String topicName, String value) {
		chainService.destroyArtwork(value);
	}

	@MQListener(name = Constant.CHAIN_TRANSFER_ARTWORK)
	public void transferArtwork(String topicName, String value) {
		chainService.transferArtwork(value);
	}

	@MQListener(name = Constant.CHAIN_SECONDARY_MARKET_BUY_ARTWORK)
	public void marketBuyArtwork(String topicName, String value) {
		chainService.marketBuyArtwork(value);
	}

	@MQListener(name = Constant.CHAIN_MINT_ARTWORK)
	public void mintArtwork(String topicName, String value) {
		chainService.mintArtwork(value);
	}

	@MQListener(name = Constant.CHAIN_SYNC_ARTWORK_HASH)
	public void syncArtworkHash(String topicName, String value) {
		chainService.syncArtworkHash(value);
	}

	@MQListener(name = Constant.CHAIN_CREATE_ARTWORK)
	public void chainAddArtwork(String topicName, String value) {
		chainService.chainAddArtwork(value);
	}

	@MQListener(name = Constant.CREATE_BLOCKCHAIN_ADDRESS)
	public void createBlockChainAddr(String topicName, String value) {
		chainService.createBlockChainAddr(value);
	}

	@MQListener(name = Constant.PAY_ORDER_TIMEOUT_CANCEL)
	public void buyerPaidConfirm(String topicName, String value) {
		transactionService.cancelPay(value);
	}

	@MQListener(name = Constant.SEND_SMS)
	public void sendSms(String topicName, String value) {
		smsService.sendSms(value);
	}

}
