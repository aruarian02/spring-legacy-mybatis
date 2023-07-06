package com.demo.gbook.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.demo.gbook.dto.GbookDTO;
import com.demo.gbook.entity.Gbook;


public interface GbookService {
	void registerGbook(GbookDTO dto);
	List<GbookDTO> getAllGbookDTO();
	GbookDTO getGbookById(Long id);
	void updateById(GbookDTO dto);
	void deleteById(Long id);
	
	
	default Gbook dtoToEntity(GbookDTO dto) {
		Gbook gbook = Gbook.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		gbook.setModDate(LocalDateTime.now());
		
		return gbook;
	}
	
	default GbookDTO entityToDto(Gbook entity) {
		return GbookDTO.builder()
				.id(entity.getGno())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
	}
}
