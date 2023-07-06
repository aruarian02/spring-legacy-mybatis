package com.demo.gbook.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.demo.gbook.dto.GbookDTO;
import com.demo.gbook.entity.Gbook;

@Mapper
public interface GbookMapper {
	void insertGbook(@Param("gbook") Gbook gbook);
	List<GbookDTO> getAllGbook();
	Optional<GbookDTO> getById(@Param("id") Long id);
	void updateById(@Param("dto") GbookDTO dto);
	void deleteById(@Param("id") Long id);
}
