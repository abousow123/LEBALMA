package org.sid.dao;

import org.sid.bo.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("select c from Client c where c.nom like :x")
	public Page<Client> chercher(@Param("x") String mc,Pageable pageable) ;

}
