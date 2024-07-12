package com.nft.constants;

public class Constant {
	/**
	 * 优先购业务类型_手动发放 PRIORITY_PURCHASE_BUSINESS_TYPE_MANUAL_DISTRIBUTION
	 */
	public static final String PRIORITY_PURCHASE_BUSINESS_TYPE_MANUAL_DISTRIBUTION = "1";

	/**
	 * 优先购业务类型_优先购任务 PRIORITY_PURCHASE_BUSINESS_TYPE_PRIORITY_PURCHASE_TASK
	 */
	public static final String PRIORITY_PURCHASE_BUSINESS_TYPE_PRIORITY_PURCHASE_TASK = "2";

	/**
	 * 执行优先购任务 EXECUTE_PRESALE_TASK
	 */
	public static final String EXECUTE_PRESALE_TASK = "executePreSaleTask";

	/**
	 * 优先购任务状态_未执行 PRIORITY_PURCHASE_TASK_STATUS_NOT_EXECUTED
	 */
	public static final String PRIORITY_PURCHASE_TASK_STATUS_NOT_EXECUTED = "1";

	/**
	 * 优先购任务状态_已执行 PRIORITY_PURCHASE_TASK_STATUS_EXECUTED
	 */
	public static final String PRIORITY_PURCHASE_TASK_STATUS_EXECUTED = "2";

	/**
	 * 优先购任务状态_已取消 PRIORITY_PURCHASE_TASK_STATUS_CANCELLED
	 */
	public static final String PRIORITY_PURCHASE_TASK_STATUS_CANCELLED = "3";

	/**
	 * 优先购资格状态_未使用 PRIORITY_PURCHASE_QUALIFICATION_STATUS_UNUSED
	 */
	public static final String PRIORITY_PURCHASE_QUALIFICATION_STATUS_UNUSED = "1";

	/**
	 * 优先购资格状态_已使用 PRIORITY_PURCHASE_QUALIFICATION_STATUS_USED
	 */
	public static final String PRIORITY_PURCHASE_QUALIFICATION_STATUS_USED = "2";

	/**
	 * 优先购资格状态_已作废 PRIORITY_PURCHASE_QUALIFICATION_STATUS_INVALID
	 */
	public static final String PRIORITY_PURCHASE_QUALIFICATION_STATUS_INVALID = "3";

	/**
	 * 区块链类型_不上链 BLOCKCHAIN_TYPE_NO_CHAIN
	 */
	public static final String BLOCKCHAIN_TYPE_NO_CHAIN = "noneChain";

	/**
	 * 上链_销毁艺术品 CHAIN_DESTROY_ARTWORK
	 */
	public static final String CHAIN_DESTROY_ARTWORK = "destroyArtwork";

	/**
	 * 上链_转让艺术品 CHAIN_TRANSFER_ARTWORK
	 */
	public static final String CHAIN_TRANSFER_ARTWORK = "transferArtwork";

	/**
	 * 上链_二级市场购买艺术品 CHAIN_SECONDARY_MARKET_BUY_ARTWORK
	 */
	public static final String CHAIN_SECONDARY_MARKET_BUY_ARTWORK = "marketBuyArtwork";

	/**
	 * 上链_同步唯一标识 CHAIN_SYNC_UNIQUE_ID
	 */
	public static final String CHAIN_SYNC_UNIQUE_ID = "syncUniqueId";

	/**
	 * 上链_同步交易HASH CHAIN_SYNC_TRANSACTION_HASH
	 */
	public static final String CHAIN_SYNC_TRANSACTION_HASH = "syncTransactionHash";

	/**
	 * 上链_铸造艺术品 CHAIN_MINT_ARTWORK
	 */
	public static final String CHAIN_MINT_ARTWORK = "mintArtwork";

	/**
	 * 上链_同步艺术品HASH CHAIN_SYNC_ARTWORK_HASH
	 */
	public static final String CHAIN_SYNC_ARTWORK_HASH = "syncArtworkHash";

	/**
	 * 上链_创建艺术品 CHAIN_CREATE_ARTWORK
	 */
	public static final String CHAIN_CREATE_ARTWORK = "chainAddArtwork";

	/**
	 * 创建区块链地址 CREATE_BLOCKCHAIN_ADDRESS
	 */
	public static final String CREATE_BLOCKCHAIN_ADDRESS = "createBlockChainAddr";

	/**
	 * 提现记录状态_审核中 WITHDRAWAL_RECORD_STATUS_UNDER_REVIEW
	 */
	public static final String WITHDRAWAL_RECORD_STATUS_UNDER_REVIEW = "1";

	/**
	 * 提现记录状态_已提现 WITHDRAWAL_RECORD_STATUS_WITHDRAWN
	 */
	public static final String WITHDRAWAL_RECORD_STATUS_WITHDRAWN = "2";

	/**
	 * 提现记录状态_已驳回 WITHDRAWAL_RECORD_STATUS_REJECTED
	 */
	public static final String WITHDRAWAL_RECORD_STATUS_REJECTED = "3";

	/**
	 * 结算账户_银行卡 SETTLEMENT_ACCOUNT_BANK_CARD
	 */
	public static final String SETTLEMENT_ACCOUNT_BANK_CARD = "bankCard";

	/**
	 * 结算账户_支付宝 SETTLEMENT_ACCOUNT_ALIPAY
	 */
	public static final String SETTLEMENT_ACCOUNT_ALIPAY = "alipay";

	/**
	 * 结算账户_微信 SETTLEMENT_ACCOUNT_WECHAT
	 */
	public static final String SETTLEMENT_ACCOUNT_WECHAT = "wechat";

	/**
	 * 兑换码状态_未兑换 EXCHANGE_CODE_STATUS_UNEXCHANGED
	 */
	public static final String EXCHANGE_CODE_STATUS_UNEXCHANGED = "1";

	/**
	 * 兑换码状态_已兑换 EXCHANGE_CODE_STATUS_EXCHANGED
	 */
	public static final String EXCHANGE_CODE_STATUS_EXCHANGED = "2";

	/**
	 * 兑换码状态_已作废 EXCHANGE_CODE_STATUS_INVALID
	 */
	public static final String EXCHANGE_CODE_STATUS_INVALID = "3";

	/**
	 * 商品类型_藏品 PRODUCT_TYPE_COLLECTION
	 */
	public static final String PRODUCT_TYPE_COLLECTION = "1";

	/**
	 * 商品类型_盲盒 PRODUCT_TYPE_BLIND_BOX
	 */
	public static final String PRODUCT_TYPE_BLIND_BOX = "2";

	/**
	 * 支付订单超时取消 PAY_ORDER_TIMEOUT_CANCEL
	 */
	public static final String PAY_ORDER_TIMEOUT_CANCEL = "payOrderTimeoutCancel";

	/**
	 * 支付订单业务模式_平台自营 PAY_ORDER_BUSINESS_MODE_PLATFORM_SELF_OPERATED
	 */
	public static final String PAY_ORDER_BUSINESS_MODE_PLATFORM_SELF_OPERATED = "1";

	/**
	 * 支付订单业务类型_二级市场 PAY_ORDER_BUSINESS_TYPE_SECONDARY_MARKET
	 */
	public static final String PAY_ORDER_BUSINESS_TYPE_SECONDARY_MARKET = "2";

	/**
	 * 支付订单状态_待付款 PAY_ORDER_STATUS_PENDING_PAYMENT
	 */
	public static final String PAY_ORDER_STATUS_PENDING_PAYMENT = "1";

	/**
	 * 支付订单状态_已付款 PAY_ORDER_STATUS_PAID
	 */
	public static final String PAY_ORDER_STATUS_PAID = "2";

	/**
	 * 支付订单状态_已取消 PAY_ORDER_STATUS_CANCELLED
	 */
	public static final String PAY_ORDER_STATUS_CANCELLED = "3";

	/**
	 * 转售的藏品状态_已发布 RESALE_COLLECTION_STATUS_PUBLISHED
	 */
	public static final String RESALE_COLLECTION_STATUS_PUBLISHED = "1";

	/**
	 * 转售的藏品状态_已卖出 RESALE_COLLECTION_STATUS_SOLD
	 */
	public static final String RESALE_COLLECTION_STATUS_SOLD = "2";

	/**
	 * 转售的藏品状态_已取消 RESALE_COLLECTION_STATUS_CANCELLED
	 */
	public static final String RESALE_COLLECTION_STATUS_CANCELLED = "3";

	/**
	 * 持有藏品状态_持有中 HOLDING_COLLECTION_STATUS_HOLDING
	 */
	public static final String HOLDING_COLLECTION_STATUS_HOLDING = "1";

	/**
	 * 持有藏品状态_已转赠 HOLDING_COLLECTION_STATUS_GIFTED
	 */
	public static final String HOLDING_COLLECTION_STATUS_GIFTED = "2";

	/**
	 * 持有藏品状态_转售中 HOLDING_COLLECTION_STATUS_FOR_SALE
	 */
	public static final String HOLDING_COLLECTION_STATUS_FOR_SALE = "3";

	/**
	 * 持有藏品状态_已卖出 HOLDING_COLLECTION_STATUS_SOLD
	 */
	public static final String HOLDING_COLLECTION_STATUS_SOLD = "4";

	/**
	 * 持有藏品状态_开盲盒销毁 HOLDING_COLLECTION_STATUS_BLIND_BOX_DESTROYED
	 */
	public static final String HOLDING_COLLECTION_STATUS_BLIND_BOX_DESTROYED = "5";

	/**
	 * 持有藏品状态_合成销毁 HOLDING_COLLECTION_STATUS_SYNTHESIZED_DESTROYED
	 */
	public static final String HOLDING_COLLECTION_STATUS_SYNTHESIZED_DESTROYED = "6";

	/**
	 * 藏品获取方式_购买 COLLECTION_ACQUISITION_METHOD_PURCHASE
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_PURCHASE = "1";

	/**
	 * 藏品获取方式_赠送 COLLECTION_ACQUISITION_METHOD_GIFT
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_GIFT = "2";

	/**
	 * 藏品获取方式_二级市场 COLLECTION_ACQUISITION_METHOD_SECONDARY_MARKET
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_SECONDARY_MARKET = "3";

	/**
	 * 藏品获取方式_盲盒 COLLECTION_ACQUISITION_METHOD_BLIND_BOX
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_BLIND_BOX = "4";

	/**
	 * 藏品获取方式_合成 COLLECTION_ACQUISITION_METHOD_SYNTHESIS
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_SYNTHESIS = "5";

	/**
	 * 藏品获取方式_空投 COLLECTION_ACQUISITION_METHOD_AIRDROP
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_AIRDROP = "6";

	/**
	 * 藏品获取方式_兑换码 COLLECTION_ACQUISITION_METHOD_EXCHANGE_CODE
	 */
	public static final String COLLECTION_ACQUISITION_METHOD_EXCHANGE_CODE = "7";

	/**
	 * 发送短信 SEND_SMS
	 */
	public static final String SEND_SMS = "sendSms";

	/**
	 * 短信发送状态_未发送 SMS_SEND_STATUS_NOT_SENT
	 */
	public static final String SMS_SEND_STATUS_NOT_SENT = "1";

	/**
	 * 短信发送状态_发送成功 SMS_SEND_STATUS_SENT_SUCCESSFULLY
	 */
	public static final String SMS_SEND_STATUS_SENT_SUCCESSFULLY = "2";

	/**
	 * 短信发送状态_发送失败 SMS_SEND_STATUS_SEND_FAILED
	 */
	public static final String SMS_SEND_STATUS_SEND_FAILED = "3";

	/**
	 * 限制 LIMIT
	 */
	public static final String LIMIT = "limit";

	/**
	 * 短信类型_验证码_修改支付密码 SMS_TYPE_VERIFICATION_CODE_MODIFY_PAYMENT_PASSWORD
	 */
	public static final String SMS_TYPE_VERIFICATION_CODE_MODIFY_PAYMENT_PASSWORD = "modifyPayPwd";

	/**
	 * 短信类型_验证码_登录 SMS_TYPE_VERIFICATION_CODE_LOGIN
	 */
	public static final String SMS_TYPE_VERIFICATION_CODE_LOGIN = "login";

	/**
	 * 会员余额变动日志类型_系统 MEMBER_BALANCE_CHANGE_LOG_TYPE_SYSTEM
	 */
	public static final String MEMBER_BALANCE_CHANGE_LOG_TYPE_SYSTEM = "1";

	/**
	 * 会员余额变动日志类型_购买藏品 MEMBER_BALANCE_CHANGE_LOG_TYPE_PURCHASE_COLLECTION
	 */
	public static final String MEMBER_BALANCE_CHANGE_LOG_TYPE_PURCHASE_COLLECTION = "2";

	/**
	 * 会员余额变动日志类型_购买转售的藏品 MEMBER_BALANCE_CHANGE_LOG_TYPE_PURCHASE_RESOLD_COLLECTION
	 */
	public static final String MEMBER_BALANCE_CHANGE_LOG_TYPE_PURCHASE_RESOLD_COLLECTION = "3";

	/**
	 * 会员余额变动日志类型_出售藏品 MEMBER_BALANCE_CHANGE_LOG_TYPE_SELL_COLLECTION
	 */
	public static final String MEMBER_BALANCE_CHANGE_LOG_TYPE_SELL_COLLECTION = "4";

	/**
	 * 会员余额变动日志类型_提现 MEMBER_BALANCE_CHANGE_LOG_TYPE_WITHDRAWAL
	 */
	public static final String MEMBER_BALANCE_CHANGE_LOG_TYPE_WITHDRAWAL = "5";

	/**
	 * 会员余额变动日志类型_提现驳回 MEMBER_BALANCE_CHANGE_LOG_TYPE_WITHDRAWAL_REJECTION
	 */
	public static final String MEMBER_BALANCE_CHANGE_LOG_TYPE_WITHDRAWAL_REJECTION = "6";

	// 菜单类型_一级菜单 MENU_TYPE_FIRST_LEVEL_MENU
	public static final String MENU_TYPE_FIRST_LEVEL_MENU = "menu_1";

	// 菜单类型_二级菜单 MENU_TYPE_SECOND_LEVEL_MENU
	public static final String MENU_TYPE_SECOND_LEVEL_MENU = "menu_2";

	// 子系统_会员端 SUBSYSTEM_MEMBER_END
	public static final String SUBSYSTEM_MEMBER_END = "member";

	// 子系统_后台管理 SUBSYSTEM_BACKSTAGE_MANAGEMENT
	public static final String SUBSYSTEM_BACKSTAGE_MANAGEMENT = "admin";

	// 登录提示_登录成功 LOGIN_PROMPT_LOGIN_SUCCESS
	public static final String LOGIN_PROMPT_LOGIN_SUCCESS = "登录成功";

	// 登录状态_成功 LOGIN_STATUS_SUCCESS
	public static final String LOGIN_STATUS_SUCCESS = "1";

	// 登录状态_失败 LOGIN_STATUS_FAILURE
	public static final String LOGIN_STATUS_FAILURE = "0";

	// 功能状态_启用 FEATURE_STATUS_ENABLED
	public static final String FEATURE_STATUS_ENABLED = "1";

	// 功能状态_禁用 FEATURE_STATUS_DISABLED
	public static final String FEATURE_STATUS_DISABLED = "0";
}
