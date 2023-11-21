package com.gaurav.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hero {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hid;
	private String name;
	private String color;
	private String weapon;
}
