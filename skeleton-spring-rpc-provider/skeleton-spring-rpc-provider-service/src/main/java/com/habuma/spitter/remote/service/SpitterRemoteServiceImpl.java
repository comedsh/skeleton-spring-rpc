package com.habuma.spitter.remote.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.remote.dto.SpitterDTO;
import com.habuma.spitter.remote.dto.SpittleDTO;
import com.habuma.spitter.service.ISpitterService;

/**
 * The remove implementation
 * 
 * @author 商洋
 *
 */
@WebService(serviceName="SpitterRemoteService", endpointInterface="com.habuma.spitter.remote.service.ISpitterRemoteService")
@SOAPBinding(style = Style.RPC)
@Service("spitterRemoteService")
public class SpitterRemoteServiceImpl implements ISpitterRemoteService{

	@Autowired
	ISpitterService service;
	
	public List<SpittleDTO> getSpittlesForSpitter(SpitterDTO spitterDto) {

		List<SpittleDTO> list = new ArrayList<SpittleDTO>(5);
		
		for( Spittle spittle : service.getSpittlesForSpitter( SpitterRemoteServiceHelper.convertToSpitter( spitterDto ) ) ){
			
			list.add( SpitterRemoteServiceHelper.convertToSpittleDTO( spittle ) );
			
		}
		
		return list;
	}

	public List<SpittleDTO> getSpittlesForSpitter(String username) {
		
		List<SpittleDTO> list = new ArrayList<SpittleDTO>(5);
		
		for( Spittle spittle : service.getSpittlesForSpitter(username) ){
			
			list.add( SpitterRemoteServiceHelper.convertToSpittleDTO( spittle ) );
			
		}
		
		return list;	
		
	}
	
	public SpitterDTO getSpitter(String username) {

		Spitter spitter = service.getSpitter(username);
		
		if( spitter != null ){
			
			return SpitterRemoteServiceHelper.convertToSpitterDTO(spitter);
			
		}
		
		return null;
	}

	public void saveSpitter(SpitterDTO spitterDto) {
		
		service.saveSpitter( SpitterRemoteServiceHelper.convertToSpitter(spitterDto) );
		
	}

	public void saveSpittle(SpittleDTO spittleDto) {
		
		service.saveSpittle( SpitterRemoteServiceHelper.convertToSpittle( spittleDto ) );
		
	}

	public void clear() {
		
		service.clear();
		
	}
	
}
