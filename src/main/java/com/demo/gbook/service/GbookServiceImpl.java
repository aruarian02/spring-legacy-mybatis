package com.demo.gbook.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.gbook.dto.GbookDTO;
import com.demo.gbook.entity.Gbook;
import com.demo.gbook.mapper.GbookMapper;


@Service
public class GbookServiceImpl implements GbookService {

	
	private final GbookMapper gbookMapper;
	
	@Autowired
	public GbookServiceImpl(GbookMapper gbookMapper) {
		this.gbookMapper = gbookMapper;
	}
	
	@Override
	public void registerGbook(GbookDTO dto) {
		Gbook gbook = dtoToEntity(dto);
		System.out.println(gbook);
		
		try {
			gbookMapper.insertGbook(gbook);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	@Override
	public List<GbookDTO> getAllGbookDTO() {
		return gbookMapper.getAllGbook();
	}
	
	@Override
	public GbookDTO getGbookById(Long id) {
		Optional<GbookDTO> optionalGbook = gbookMapper.getById(id);
		
		return optionalGbook.orElse(null);
	}
	
	@Override
	public void updateById(GbookDTO dto) {
		Optional<GbookDTO> optionalGbook = gbookMapper.getById(dto.getId());
		
		if (optionalGbook.isPresent()) {
			GbookDTO dbGbook = optionalGbook.get();
			
			dbGbook.setTitle(dto.getTitle());
			dbGbook.setContent(dto.getContent());
			dbGbook.setWriter(dto.getWriter());
			dbGbook.setModDate(LocalDateTime.now());
			
			gbookMapper.updateById(dbGbook);
		}
	}
	
	@Override
	public void deleteById(Long id) {
		Optional<GbookDTO> optionalGbook = gbookMapper.getById(id);
		
		if (optionalGbook.isPresent()) {
			gbookMapper.deleteById(id);
		}
	}

}
