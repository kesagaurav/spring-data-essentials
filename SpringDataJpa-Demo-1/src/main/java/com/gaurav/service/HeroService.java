package com.gaurav.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.gaurav.dto.HeroDto;
import com.gaurav.model.Hero;

public interface HeroService {

	public Hero addHero(HeroDto dto);
	public void update(HeroDto dto);
	public void delete(int id);
	public List<Hero> findByName(String name);
	public List<Hero> findByWeapons(String weapons);
	public List<Hero> findByColor(String color);
	public void deleteByName(String name);
	public void updateByWeapon(String weapons,int id);
	public void updateByColorAndName(String color,String name,int id);
	public void updateByColorAndNameAndWeapon(String color, String name, String weapon, int id);
	public Page<Hero> findAll(Pageable page);
	public Iterable<Hero> findAll(Sort sort);



}
