package com.demo.gbook.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GbookDTO {
	private Long id;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate, modDate;
}
