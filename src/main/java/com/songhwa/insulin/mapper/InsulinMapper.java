package com.songhwa.insulin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

import com.songhwa.insulin.dto.Record;

public interface InsulinMapper {
	
	void writeRecord(Record record) throws SQLException;

	List<Record> getRecord(@Param("userId") Long userId, @Param("startDate") String startDate, @Param("endDate") String endDate) throws SQLException;

	Record selectRecord(@Param("id") Long id) throws SQLException;

	Record getLatestRecord(@Param("userId") Long userId) throws SQLException;
}
