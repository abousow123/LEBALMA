package org.sid.restful;

import java.util.List;
import java.util.Optional;

import org.sid.bo.Client;
import org.sid.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*")
@RestController
public class ClientRest {
	
	@Autowired
	public ClientRepository clientRepository;
	
	@RequestMapping(value = "/listClients",method=RequestMethod.GET)
	public List<Client> getUsers(){
		return clientRepository.findAll() ;
	}
	
	@RequestMapping(value = "/Client/{cni}",method=RequestMethod.GET)
	public Optional<Client> getClient(@PathVariable("cni") int cni){
		return clientRepository.findById(cni);
	}
	
	@RequestMapping(value = "/saveClient",method=RequestMethod.POST)
	@ResponseBody
	 public Client saveClient(@RequestBody Client c){
		return clientRepository.save(c) ;
		 
	}
	
	@RequestMapping(value ="/Client/{cni}",method=RequestMethod.DELETE)
	public boolean deleteClient(@PathVariable int cni){
		clientRepository.deleteById(cni);;
		return true ;
	}
	
	
	@RequestMapping(value = "/updateClient",method=RequestMethod.PUT)
	public Client updateUser(@RequestBody Client c){
		return clientRepository.saveAndFlush(c) ;
	}
	
	

}
