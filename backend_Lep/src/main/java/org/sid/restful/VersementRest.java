package org.sid.restful;


import java.util.Date;
import java.util.Optional;

import org.sid.bo.Versement;
import org.sid.dao.ClientRepository;
import org.sid.dao.VersementRepository;
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
public class VersementRest {
	
	@Autowired
	private VersementRepository versementRepository ;
	
	@Autowired
	public ClientRepository clientRepository;
	
	
	@RequestMapping(value = "/listVersements",method=RequestMethod.GET)
	public Page<Versement> getVersements(@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return versementRepository.allVersement(new PageRequest(page, size));
	}
	
	@RequestMapping(value = "/Versement/{idVerser}",method=RequestMethod.GET)
	public Optional<Versement> getVersement(@PathVariable("idVerser") int idVerser){
		return versementRepository.findById(idVerser);
	}
	
	
	@RequestMapping(value="/chercherVersement",method=RequestMethod.GET)
	public Page<Versement> chercher(@RequestParam(name="mc") int mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		
		  return versementRepository.chercher(mc, new PageRequest(page, size)) ;
	}
	
	@RequestMapping(value = "/saveVersement",method=RequestMethod.POST)
	@ResponseBody
	 public Versement saveVersement(@RequestBody Versement v){
		v.setClient(clientRepository.getOne(v.getIdentiteClient()));
		v.setDateversement(new Date());
		return versementRepository.save(v) ;
		 
	}
	
	@RequestMapping(value = "/Versement/{idVerser}",method=RequestMethod.DELETE)
	public boolean deleteVersement(@PathVariable int idVerser){
		versementRepository.deleteById(idVerser);;
		return true ;
	}
	
	
	@RequestMapping(value = "/updateVersement/{id}",method=RequestMethod.PUT)
	public boolean updateVersement(@PathVariable("id") int id,@RequestBody Versement v){
		v.setIdverser(id);
		v.setDateversement(new Date());
		versementRepository.save(v) ;
		return true ;
	}
	
	


}
