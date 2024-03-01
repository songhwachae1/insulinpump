package com.songhwa.insulin.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.songhwa.insulin.common.ResponseObject;
import com.songhwa.insulin.common.StatusCode;
import com.songhwa.insulin.dto.Record;
import com.songhwa.insulin.service.InsulinService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class InsulinRestController {
	
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

		//TODO session check, get user id from the session

		try {
			String startDate = param.get("startDate").toString();
			String endDate = param.get("endDate").toString();
			List<Record> list = insulinService.getRecord(Long.valueOf(1), startDate, endDate);
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

		//TODO session check, get user id from the session
		try {
			Record record = insulinService.readGlucoseLvl(Long.valueOf(1));
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

		//TODO session check, get user id from the session
		try {
			Record record = insulinService.getLatestRecord(Long.valueOf(1));
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
