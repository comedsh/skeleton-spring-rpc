package com.habuma.spitter.service;

import static java.lang.Math.min;
import static java.util.Collections.reverse;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

@Component("spitterService")
public class SpitterServiceImpl implements ISpitterService {
	
	List<Spittle> spittles = new LinkedList<Spittle>();
	  
	Set<Spitter> spitters = new LinkedHashSet<Spitter>();
	  
	static long MAX_SPITTER_ID = 0;
	
	public void saveSpittle( Spittle spittle ) {    
	    
		spittles.add(spittle);
	    
	}

	public List<Spittle> getRecentSpittles(int count) {
		  
		reverse( spittles );
		    
		return spittles.subList(0, min(49, spittles.size()));
	    
	}
  
	public void saveSpitter(Spitter spitter) {
		  
	    if(spitter.getId() == null) {
	    	
	    	spitter.setId( ++MAX_SPITTER_ID ); // synchronized needed
	    	
	    	spitters.add(spitter);
	    	
	    } else {
	      
	    	spitters.add(spitter);
	    	
	    }
	}
  
	public Spitter getSpitter(long id) {
		
		
		for( Spitter s : spitters ){
			
			if(s.getId() == id ){
				return s;
			}
			
		}
		
		return null;
	
	}

	public void startFollowing(Spitter follower, Spitter followee) {
	    // TODO Auto-generated method stub
	    
	}
  
	public Spitter getSpitter(String username) {
		  
		for( Spitter s : spitters ){
			  
			if( StringUtils.equals( username, s.getUsername() ) ){
				  
				return s;
				  
			}
			  
		}
		  
		return null;
	}

	public List<Spittle> getSpittlesForSpitter( Spitter spitter ) {
	
		List<Spittle> spittles = new LinkedList<Spittle>();
		  
		for( Spittle s : this.spittles ){
			  
			if( s.getSpitter().equals(spitter) ){
				spittles.add(s);
			}
			  
		}
		  
	    return spittles;
	    
	}

	public List<Spittle> getSpittlesForSpitter(String username) {
	    
		return this.getSpittlesForSpitter( this.getSpitter(username) );
		  
	}
  
	public List<Spitter> getAllSpitters() {
		  
		List<Spitter> spitters = new ArrayList<Spitter>( this.spitters );
		  
		return spitters;
	  
	}

	public void deleteSpittle(long id) {
		
		for(Spittle s : spittles){
			
			if( s.getId() == id ){
				
				spittles.remove(s);
				
				break;
				
			}
			
		}
	
	}

	public Spittle getSpittleById(long id) {
		
		for(Spittle s : spittles){
			
			if( s.getId() == id ){
				
				return s;
				
			}
			
		}		
		
		return null;
		
	}
}
