package com.premierleague.standings.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premierleague.standings.dto.TimeDTO;
import com.premierleague.standings.service.TimeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(name = "/times")
public class TimeRestController {

	@Autowired
	private TimeService timeService;
	
	@GetMapping
	public ResponseEntity<List<TimeDTO>> listTimes() {
		return ResponseEntity.ok().body(timeService.listTimes());
	}
	
	@ApiOperation(value = "Retorna um time através de um id informado")
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<TimeDTO>> getTime(@PathVariable Integer id){
		return ResponseEntity.ok().body(timeService.getTime(id));
	}
	
	@PostMapping
	public ResponseEntity<TimeDTO> saveTime(@RequestBody TimeDTO time){
		return ResponseEntity.ok().body(timeService.saveTime(time));
	}
}
