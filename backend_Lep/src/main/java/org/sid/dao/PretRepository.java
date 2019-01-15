package org.sid.dao;

import org.sid.bo.Client;
import org.sid.bo.Pret;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PretRepository extends JpaRepository<Pret, Integer> {
	
	@Query("select c from Pret c where c.identiteClient like :x")
	public Page<Pret> chercher(@Param("x") int mc,Pageable pageable) ;
	
	@Query("select p from Pret p")
	public Page<Pret> tout(Pageable pageable) ;

}
