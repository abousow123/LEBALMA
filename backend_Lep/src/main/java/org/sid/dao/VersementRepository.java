package org.sid.dao;

import org.sid.bo.Client;
import org.sid.bo.Pret;
import org.sid.bo.Versement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VersementRepository extends JpaRepository<Versement, Integer> {
	
	
	@Query("select c from Versement c where c.identiteClient like :x")
	public Page<Versement> chercher(@Param("x") int mc,Pageable pageable) ;
	
	@Query("select v from Versement v")
	public Page<Versement> allVersement(Pageable pageable) ;

}
