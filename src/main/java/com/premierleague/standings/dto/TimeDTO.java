package com.premierleague.standings.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeDTO {
	private String nome;
	private String sigla;
	private String estado;
	private String estadio;
}
