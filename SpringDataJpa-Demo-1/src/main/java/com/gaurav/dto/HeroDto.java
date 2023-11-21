package com.gaurav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroDto {
	private String name;
	private String color;
	private String weapon;
}
