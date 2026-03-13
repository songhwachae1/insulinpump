package com.songhwa.insulin.controller.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.songhwa.insulin.common.ResponseObject;
import com.songhwa.insulin.common.StatusCode;
import com.songhwa.insulin.dto.Record;
import com.songhwa.insulin.service.InsulinService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class InsulinController {
	
	@Autowired
	InsulinService insulinService;

	@RequestMapping("/insulin/getRecord")
	public ResponseObject<Object> getRecord(@RequestParam HashMap<String, Object> param) {
		ResponseObject<Object> rsp = new ResponseObject<>();

		if (param.get("startDate") == null) {
			rsp.setReturnCode(StatusCode.ERROR_PARAMETER);
			return rsp;
		}

		if (param.get("endDate") == null) {
			rsp.setReturnCode(StatusCode.ERROR_PARAMETER);
			return rsp;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if ("anonymousUser".equals(authentication.getName())) {
			rsp.setReturnCode(StatusCode.ERROR_UNAUTHORIZED);
			return rsp;
		}
		
		String[] userArray = authentication.getName().split("\\|");
		String userId = userArray[0];

		try {
			String startDate = param.get("startDate").toString() + " 00:00:00";
			String endDate = param.get("endDate").toString() + " 23:59:59";
			List<Record> list = insulinService.getRecord(userId, startDate, endDate);
			rsp.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setReturnCode(StatusCode.ERROR_SERVICE);
			return rsp;
		}

		rsp.setReturnCode(StatusCode.OK);
		return rsp;
	}
	
	@RequestMapping("/insulin/read")
	public ResponseObject<Object> read() {
		ResponseObject<Object> rsp = new ResponseObject<>();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if ("anonymousUser".equals(authentication.getName())) {
			rsp.setReturnCode(StatusCode.ERROR_UNAUTHORIZED);
			return rsp;
		}
		
		String[] userArray = authentication.getName().split("\\|");
		String userId = userArray[0];

		try {
			Record record = insulinService.readGlucoseLvl(userId);
			rsp.setData(record);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setReturnCode(StatusCode.ERROR_SERVICE);
			return rsp;
		}

		rsp.setReturnCode(StatusCode.OK);
		return rsp;
	}

	@RequestMapping("/insulin/latest")
	public ResponseObject<Object> getLatestRecord() {
		ResponseObject<Object> rsp = new ResponseObject<>();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if ("anonymousUser".equals(authentication.getName())) {
			rsp.setReturnCode(StatusCode.ERROR_UNAUTHORIZED);
			return rsp;
		}
		
		String[] userArray = authentication.getName().split("\\|");
		String userId = userArray[0];

		try {
			Record record = insulinService.getLatestRecord(userId);
			rsp.setData(record);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setReturnCode(StatusCode.ERROR_SERVICE);
			return rsp;
		}

		rsp.setReturnCode(StatusCode.OK);
		return rsp;
	}
	
}
