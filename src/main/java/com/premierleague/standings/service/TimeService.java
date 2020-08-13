package com.premierleague.standings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premierleague.standings.dto.TimeDTO;
import com.premierleague.standings.repository.TimeRepository;

@Service
public class TimeService {
	@Autowired
	private TimeRepository timeRepository;

	public List<TimeDTO> listTimes(){
		return timeRepository.listTimes();
	}
	
	public Optional<TimeDTO> getTime(Integer id) {
		return timeRepository.getTime(id);
	}
	
	public TimeDTO saveTime(TimeDTO time) {
		return timeRepository.saveTime(time);
	}
	
	public TimeDTO updateTime(TimeDTO time) {
		return timeRepository.updateTime(time);
	}
	
	public void deleteTime(TimeDTO time) {
		timeRepository.deleteTime(time);
	}
}