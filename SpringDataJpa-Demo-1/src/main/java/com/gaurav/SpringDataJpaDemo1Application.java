package com.gaurav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.gaurav.dto.HeroDto;
import com.gaurav.model.Hero;
import com.gaurav.repository.HeroRepository;
import com.gaurav.service.HeroService;

@SpringBootApplication
public class SpringDataJpaDemo1Application implements CommandLineRunner {
	@Autowired
	private HeroService service;
	@Autowired
	private HeroRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		HeroDto dto = new HeroDto("ironman", "red", "lazer-beems");
		HeroDto dto1 = new HeroDto("captain-america", "blue", "sheild");
		HeroDto dto2 = new HeroDto("natasha", "black", "guns");
		HeroDto dto3 = new HeroDto("arrow-man", "black", "arrow/bow");
		HeroDto dto4 = new HeroDto("thor", "light-blue", "niomir");
		HeroDto dto5 = new HeroDto("fury", "dark-black", "guns");
		HeroDto dto6 = new HeroDto("hulk", "green", "smash");

//		service.addHero(dto);
//		service.addHero(dto1);
//		service.addHero(dto2);
//		service.addHero(dto3);
//		service.addHero(dto4);
//		service.addHero(dto5);
//		service.addHero(dto6);
		System.out.println("hero added successfully");
//		service.delete(7);
//		service.delete(8);
//		service.delete(9);

//		dto3.setColor("white");
//		dto3.setName("angelia");
//		service.update(dto3);

		// service.findByName("ironman");
//		System.out.println(service.findByName("ironman"));
//		System.out.println(service.findByName("fury"));

//		System.out.println(service.findByWeapons("guns"));

//		System.out.println(service.findByColor("green"));

		//service.deleteByName("angelia");
//		service.deleteByName("arrow-man");
		
		//service.deleteByName("thor");
		
//		service.updateByWeapon("MP40",12);

//		service.updateByWeapon("Glock 26s",4);
		
	//	service.updateByWeapon("Hydra-pistol",3);
		
		//service.updateByColorAndName("red", "hydra",3);
		
		//service.updateByColorAndNameAndWeapon("black", "nick-fury", "stG44", 12);

		//pageable
		
		long count=repo.count();
		for(int i=0;i<=count;i++) {
			Pageable page=PageRequest.of(i, 2);
			System.out.println("-------------");
			Page<Hero> p=service.findAll(page);
			for(Hero h:p) {
				System.out.println(h);
			}
		}

		System.out.println("sorted counts");
		Iterable<Hero> hero=service.findAll(Sort.by(Sort.Direction.DESC, "name"));
		hero.forEach(e->System.out.println(e));

	}

}
