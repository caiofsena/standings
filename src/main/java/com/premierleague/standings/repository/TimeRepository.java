package com.premierleague.standings.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.premierleague.standings.dto.TimeDTO;
import com.premierleague.standings.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Integer>{
	
	public default List<TimeDTO> listTimes(){
		return findAll().stream()
				.map(time -> TimeDTO.builder()
						.nome(time.getNome())
						.sigla(time.getSigla())
						.estado(time.getEstado())
						.estadio(time.getEstadio())
						.build())
				.collect(Collectors.toList());
	}
	
	public default Optional<TimeDTO> getTime(Integer id) {
		Optional<Time> timeEntity = findById(id);
		return Optional.of(TimeDTO.builder()
				.nome(timeEntity.get().getNome())
				.sigla(timeEntity.get().getSigla())
				.estado(timeEntity.get().getEstado())
				.estadio(timeEntity.get().getEstadio())
				.build());
	}
	
	public default TimeDTO saveTime(TimeDTO time) {
		Time timeEntity = Time.builder()
				.nome(time.getNome())
				.sigla(time.getSigla())
				.estado(time.getEstado())
				.estadio(time.getEstadio())
				.build();
		return TimeDTO.builder()
				.nome(timeEntity.getNome())
				.sigla(timeEntity.getSigla())
				.estado(timeEntity.getEstado())
				.estadio(timeEntity.getEstadio())
				.build();
	}

}
