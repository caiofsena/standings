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
						.id(time.getId())
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
				.id(timeEntity.get().getId())
				.nome(timeEntity.get().getNome())
				.sigla(timeEntity.get().getSigla())
				.estado(timeEntity.get().getEstado())
				.estadio(timeEntity.get().getEstadio())
				.build());
	}
	
	public default TimeDTO saveTime(TimeDTO timeDTO) {
		Time timeEntity = Time.builder()
				.nome(timeDTO.getNome())
				.sigla(timeDTO.getSigla())
				.estado(timeDTO.getEstado())
				.estadio(timeDTO.getEstadio())
				.build();
		timeEntity = save(timeEntity);
		return TimeDTO.builder()
				.id(timeEntity.getId())
				.nome(timeEntity.getNome())
				.sigla(timeEntity.getSigla())
				.estado(timeEntity.getEstado())
				.estadio(timeEntity.getEstadio())
				.build();
	}
	
	public default TimeDTO updateTime(TimeDTO timeDTO) {
		Time time = findById(timeDTO.getId()).get();
		time.setNome(timeDTO.getNome());
		time.setSigla(timeDTO.getSigla());
		time.setEstado(timeDTO.getEstado());
		time.setEstadio(timeDTO.getEstadio());
		save(time);
		return TimeDTO.builder()
				.id(time.getId())
				.nome(time.getNome())
				.sigla(time.getSigla())
				.estado(time.getEstado())
				.estadio(time.getEstadio())
				.build();
	}
	
	public default void deleteTime(TimeDTO timeDTO) {
		Time time = Time.builder()
				.id(timeDTO.getId())
				.build();
		delete(time);
	}

}
