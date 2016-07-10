package com.habuma.spitter.remote.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;

public class SpitterRemoteServiceHelper {
	
	public static Spitter convertToSpitter( SpitterDTO dto ){
	
		Spitter s = new Spitter( dto.getUsername(), dto.getFullName(), dto.getEmail() );
		
		s.setPassword( dto.getPassword() );
		
		return s;
		
	}
	
	public static Spittle convertToSpittle( SpittleDTO dto ){
		
		return new Spittle( convertToSpitter( dto.getSpitterDTO()), dto.getText(), dto.getWhen() );
		
	}
	
	public static SpitterDTO convertToSpitterDTO( Spitter spitter ){
		
		SpitterDTO dto = new SpitterDTO( spitter.getUsername(), spitter.getFullName(), spitter.getEmail() );
		
		dto.setPassword( spitter.getPassword() );
		
		return dto;
		
	}
	
	public static SpittleDTO convertToSpittleDTO( Spittle spittle ){
		
		return new SpittleDTO( convertToSpitterDTO( spittle.getSpitter() ), spittle.getText(), spittle.getWhen() );
		
	}
	
}
