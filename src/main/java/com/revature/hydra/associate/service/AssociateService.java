package com.revature.hydra.associate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Associate;
import com.revature.hydra.associate.data.AssociateRepository;

/**
 * associateService
 * 
 * associate services implementation with communication with AssociateRepository
 */
@Service
public class AssociateService {
	@Autowired
	private AssociateRepository associateRepository;

	/**
	 * Saving an associate
	 * 
	 * @param associate - associate to save
	 */
	public void save(Associate associate) {
		associateRepository.save(associate);
	}

	/**
	 * Update an associate
	 * 
	 * @param associate
	 */
	public void update(Associate associate) {
		associateRepository.save(associate);
	}

	/**
	 * Delete an associate
	 * 
	 * @param associate
	 */
	public void delete(Associate associate) {
		associateRepository.delete(associate.getAssociateId());
	}

	/**
	 * Obtain list of all associates from associateRepository.
	 * 
	 * @return List<Associate> - List of associates
	 */
	public List<Associate> findAll() {
		return associateRepository.findAll();
	}

	/**
	 * Obtain an associate with given associateId.
	 * 
	 * @param associateId
	 * @return Associate
	 */
	public Associate findOneByAssociateId(Integer associateId) {
		return associateRepository.findOneByAssociateId(associateId);
	}
	
	/**
	 * Obtain list of all associates by marketingStatusId.
	 * 
	 * @param marketingStatusId
	 * @return List<Associate>
	 */
	public List<Associate> findAllByMarketingStatusId(Integer marketingStatusId) {
		return associateRepository.findAllByMarketingStatusId(marketingStatusId);
	}
	
	/**
	 * Obtain list of all associates by clientId.
	 * 
	 * @param clientId
	 * @return List<Associate>
	 */
	public List<Associate> findAllByClientId(Integer clientId) {
		return associateRepository.findAllByClientId(clientId);
	}
	
	/**
	 * Obtain list of all associates by endClientId.
	 * 
	 * @param endClientId
	 * @return List<associate> - List of associates
	 */
	public List<Associate> findAllByEndClientId(Integer endClientId) {
		return associateRepository.findAllByEndClientId(endClientId);
	}
	
	/**
	 * Obtain list of all associates by batchId.
	 * 
	 * @param batchId
	 * @return List<Associate> - List of associates
	 */
	public List<Associate> findAllByBatchId(Integer batchId) {
		return associateRepository.findAllByBatchId(batchId);
	}
}
	
	
	

