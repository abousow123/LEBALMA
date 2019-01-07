package org.sid.dao;

import org.sid.bo.Versement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersementRepository extends JpaRepository<Versement, Integer> {

}
