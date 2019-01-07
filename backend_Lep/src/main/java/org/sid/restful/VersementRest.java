package org.sid.restful;

import java.util.List;
import java.util.Optional;

import org.sid.bo.Pret;
import org.sid.bo.Versement;
import org.sid.dao.ClientRepository;
import org.sid.dao.VersementRepository;
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
public class VersementRest {
	
	@Autowired
	private VersementRepository versementRepository ;
	
	@Autowired
	public ClientRepository clientRepository;
	
	
	@RequestMapping(value = "/listVersements",method=RequestMethod.GET)
	public List<Versement> getVersements(){
		return versementRepository.findAll();
	}
	
	@RequestMapping(value = "/Versement/{idVerser}",method=RequestMethod.GET)
	public Optional<Versement> getVersement(@PathVariable("idVerser") int idVerser){
		return versementRepository.findById(idVerser);
	}
	
	@RequestMapping(value = "/saveVersement",method=RequestMethod.POST)
	@ResponseBody
	 public Versement saveVersement(@RequestBody Versement v){
		v.setClient(clientRepository.getOne(v.getIdentiteClient()));
		return versementRepository.save(v) ;
		 
	}
	
	@RequestMapping(value = "/Versement/{idVerser}",method=RequestMethod.DELETE)
	public boolean deleteVersement(@PathVariable int idVerser){
		versementRepository.deleteById(idVerser);;
		return true ;
	}
	
	
	@RequestMapping(value = "/updateVersement",method=RequestMethod.PUT)
	public Versement updateVersement(@RequestBody Versement v){
		return versementRepository.saveAndFlush(v) ;
	}
	
	


}
