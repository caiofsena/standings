package com.premierleague.standings.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Jogo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer golsCasa;
	
	private Integer golsVisitante;
	
	private Integer publicoPagante;

	@ManyToOne
	@JoinColumn(name = "casa")
	private Time casa;
	
	@ManyToOne
	@JoinColumn(name = "visitante")
	private Time visitante;
}
