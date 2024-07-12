package com.nft.admin.sms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nft.common.vo.PageResult;
import com.nft.common.vo.Result;
import com.nft.sms.param.SmsSendRecordQueryCondParam;
import com.nft.sms.service.SmsService;
import com.nft.sms.vo.SmsSendRecordVO;

@RestController
@RequestMapping("/sms")
@Api(tags = "短信")
public class SmsController {

	@Autowired
	private SmsService smsService;

	@GetMapping("/findSendRecordByPage")
	@ApiOperation("分页查询短信发送记录")
	public Result<PageResult<SmsSendRecordVO>> findSendRecordByPage(SmsSendRecordQueryCondParam param) {
		return Result.success(smsService.findSendRecordByPage(param));
	}

}
