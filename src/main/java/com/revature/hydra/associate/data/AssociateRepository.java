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
	 * Find associates by clientId.
	 * 
	 * @param clientId
	 * @return List<Associate>
	 */
	List<Associate> findAllByClientId(Integer clientId);
	
	/**
	 * Find all associates by marketingStatusId.
	 * 
	 * @param marketingStatusId
	 * @return List<Associate>
	 */
	List<Associate> findAllByMarketingStatusId(Integer marketingStatusId);
	
	/**
	 * Find all associates by endClientId.
	 * 
	 * @param endClientId
	 * @return List<Associate>
	 */
	List<Associate> findAllByEndClientId(Integer endClientId);
	
	/**
	 * Find all associates by batchId.
	 * 
	 * @param batchId
	 * @return List<Associate>
	 */
	List<Associate> findAllByBatchId(Integer batchId);

}
