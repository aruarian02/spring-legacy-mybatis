package com.demo.gbook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gbook extends BaseEntity {
	private Long gno;
	private String title;
	private String content;
	private String writer;
}
