package com.revature.hydra.associate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Associate;
import com.revature.hydra.associate.data.AssociateRepository;

/**
 * associateService
 * 
 * associate services implementation with communication with associateRepository
 */
@Service
public class AssociateService {

	@Autowired
	private AssociateRepository associateRepository;

	/**
	 * Saving a associate
	 * 
	 * @param associate - associate to save
	 */
	public void save(Associate associate) {
		associateRepository.save(associate);
	}

	/**
	 * Update a associate
	 * 
	 * @param associate - associate to update
	 */
	public void update(Associate associate) {
		save(associate);
	}

	/**
	 * Delete a associate
	 * 
	 * @param associate - associate to delete
	 */
	public void delete(Associate associate) {
		associateRepository.delete(associate.getAssociateId());
	}

	/**
	 * Obtain list of all associates from associateRepository.
	 * 
	 * @return List<associate> - List of associates
	 */
	public List<Associate> findAll() {
		return associateRepository.findAll();
	}

	/**
	 * Obtain a associate from associateRepository with given associateId.
	 * 
	 * @param associateId
	 * @return associate - The associate object with given associateId
	 */
	public Associate findOneById(Integer associateId) {
		//These two methods exist by default in the repository, should have the same function.
		//return associateRepository.getOne(associateId);
		//return associateRepository.findOne(associateId);
		return associateRepository.findOneByAssociateId(associateId);
	}
}
	
	
	

