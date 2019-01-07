package org.sid.restful;

import java.util.List;
import java.util.Optional;

import org.sid.bo.Pret;
import org.sid.dao.ClientRepository;
import org.sid.dao.PretRepository;
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
public class PretRest {
	
	@Autowired
	public PretRepository pretRest ;
	
	@Autowired
	public ClientRepository clientRepository;
	
	
	@RequestMapping(value = "/listPrets",method=RequestMethod.GET)
	public List<Pret> getPrets(){
		return pretRest.findAll() ;
	}
	
	@RequestMapping(value = "/Pret/{idpret}",method=RequestMethod.GET)
	public Optional<Pret> getPret(@PathVariable("idpret") int idpret){
		return pretRest.findById(idpret);
	}
	
	@RequestMapping(value = "/savePret",method=RequestMethod.POST)
	@ResponseBody
	 public Pret savePret(@RequestBody Pret p){
		p.setClient(clientRepository.getOne(p.getIdentiteClient()));
		return pretRest.save(p) ;
		 
	}
	
	@RequestMapping(value = "/Pret/{idpret}",method=RequestMethod.DELETE)
	public boolean deletePret(@PathVariable int idpret){
		pretRest.deleteById(idpret);
		return true ;
	}
	
	
	@RequestMapping(value = "/updatePret",method=RequestMethod.PUT)
	public Pret updatePret(@RequestBody Pret p){
		return pretRest.saveAndFlush(p) ;
	}
	
	


}
