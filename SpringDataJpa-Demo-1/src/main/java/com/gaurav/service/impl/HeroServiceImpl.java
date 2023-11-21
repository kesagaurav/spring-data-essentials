package com.gaurav.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.dto.HeroDto;
import com.gaurav.model.Hero;
import com.gaurav.repository.HeroRepository;
import com.gaurav.service.HeroService;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {
	@Autowired
	private HeroRepository repo;
	@Override
	public Hero addHero(HeroDto dto) {
		// TODO Auto-generated method stub
		Hero hero=new Hero();
		hero.setName(dto.getName());
		hero.setColor(dto.getColor());
		hero.setWeapon(dto.getWeapon());
		return repo.save(hero);
	}

	@Override
	public void update(HeroDto dto) {
		// TODO Auto-generated method stub
		Hero hero=new Hero();
		hero.setName(dto.getName());
		hero.setColor(dto.getColor());
		hero.setWeapon(dto.getWeapon());
	    repo.save(hero);
		System.out.println("heros are updated");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		System.out.println("deleted the records " + repo.count());
		
	}
	
	@Override
	public List<Hero> findByName(String name){
		return repo.findByName(name);
	}

	@Override
	public List<Hero> findByWeapons(String weapons) {
		// TODO Auto-generated method stub
		return repo.findByWeapons(weapons);
	}

	@Override
	public List<Hero> findByColor(String color) {
		// TODO Auto-generated method stub
		return repo.findByColor(color);
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		repo.deleteByName(name);
		System.out.println("rows affetcted " + repo.count());
		
	}

	@Override
	public void updateByWeapon(String weapons,int id) {
		// TODO Auto-generated method stub
		
		repo.updateByWeapon(weapons,id);
		System.out.println("rows affetcted " + repo.count());

	}

	@Override
	public void updateByColorAndName(String color,String name,int id) {
		// TODO Auto-generated method stub
		repo.updateByColorAndName(color,  name,id);
		System.out.println("rows affetcted " + repo.count());

	}

	@Override
	public void updateByColorAndNameAndWeapon(String color, String name, String weapon, int id) {
		// TODO Auto-generated method stub
		repo.updateByColorAndNameAndWeapon(color, name, weapon, id);
		System.out.println("rows affetcted " + repo.count());

	}

	

}
