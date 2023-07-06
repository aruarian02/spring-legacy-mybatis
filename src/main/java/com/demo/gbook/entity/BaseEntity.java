package com.demo.gbook.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class BaseEntity {
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
}
