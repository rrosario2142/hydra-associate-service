package com.revature.hydra.associate.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Associate;

/**
 * AssociateRepository Data Access Object with various methods to communicate with database
 *
 */
@Repository
public interface AssociateRepository extends JpaRepository<Associate, Integer> {

	/**
	 * Find an associate by associateId.
	 * 
	 * @param associateId
	 * @return Associate
	 */
	Associate findOneByAssociateId(Integer associateId);

	/**
	 * Find all associates.
	 * 
	 * @return List of associates
	 */
	List<Associate> findAll();

}
