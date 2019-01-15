package org.sid.restful;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sid.bo.Client;
import org.sid.bo.Pret;
import org.sid.dao.ClientRepository;
import org.sid.dao.PretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<Pret> getPrets(@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return pretRest.tout(new PageRequest(page, size)) ;
	}
	
	@RequestMapping(value = "/Pret/{idpret}",method=RequestMethod.GET)
	public Optional<Pret> getPret(@PathVariable("idpret") int idpret){
		return pretRest.findById(idpret);
	}
	
	@RequestMapping(value = "/savePret",method=RequestMethod.POST)
	@ResponseBody
	 public Pret savePret(@RequestBody Pret p){
		p.setClient(clientRepository.getOne(p.getIdentiteClient()));
		p.setDatepret(new Date());
		return pretRest.save(p) ;
		 
	}
	
	@RequestMapping(value = "/Pret/{idpret}",method=RequestMethod.DELETE)
	public boolean deletePret(@PathVariable int idpret){
		pretRest.deleteById(idpret);
		return true ;
	}
	
	
	@RequestMapping(value="/chercherPret",method=RequestMethod.GET)
	public Page<Pret> chercher(@RequestParam(name="mc") int mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		
		  return pretRest.chercher(mc, new PageRequest(page, size)) ;
	}
	
	
	@RequestMapping(value = "/updatePret/{id}",method=RequestMethod.PUT)
	public boolean updatePret(@PathVariable("id") int id,@RequestBody Pret p){
		p.setIdpret(id);
		p.setDatepret(new Date());
		pretRest.saveAndFlush(p) ;
		return true ;
	}
	
	


}
