package org.sid;

import java.util.Date;

import org.sid.bo.Pret;
import org.sid.dao.ClientRepository;
import org.sid.dao.PretRepository;
import org.sid.dao.VersementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendLepApplication implements CommandLineRunner{
	
	@Autowired
	public PretRepository pretRest ;
	
	@Autowired
	public ClientRepository clientRepository;
	
	@Autowired
	private VersementRepository versementRepository ;

	public static void main(String[] args) {
		SpringApplication.run(BackendLepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//pretRest.save(new Pret(60000, new Date(), clientRepository.getOne(1234567))) ;
		
		
	}

}

