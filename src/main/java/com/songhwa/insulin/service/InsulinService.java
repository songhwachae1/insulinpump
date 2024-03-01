package com.songhwa.insulin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.sql.SQLException;

import com.songhwa.insulin.mapper.InsulinMapper;
import com.songhwa.insulin.dto.Record;

@Service
public class InsulinService implements InsulinMapper{
	
	@Autowired
	InsulinMapper insulinMapper;

	private int bound = 200;

	/*
	 * read current glucose level and return
	 * for now, generate random number between 0 - 200 and return
	 * @param
	 * @return int
	 */
	private int read() {
		Random rand = new Random();
		int num = rand.nextInt(bound);
		return num;
	}

	@Override
	public void writeRecord(Record record) throws SQLException {
		insulinMapper.writeRecord(record);
	}

	@Override
	public List<Record> getRecord(Long userId, String startDate, String endDate) throws SQLException {
		return insulinMapper.getRecord(userId, startDate, endDate);
	}

	@Override
	public Record selectRecord(Long id) throws SQLException {
		return insulinMapper.selectRecord(id);
	}

	@Override
	public Record getLatestRecord(Long userId) throws SQLException {
		return insulinMapper.getLatestRecord(userId);
	}

	@Transactional
	public Record readGlucoseLvl(Long userId) throws SQLException {
		Record record = new Record();
		record.setUserId(userId);
		record.setGlucoseLevel(read());
		writeRecord(record);
		return selectRecord(record.getId());
	}
}
