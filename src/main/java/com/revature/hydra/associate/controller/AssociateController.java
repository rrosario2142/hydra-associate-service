package com.revature.hydra.associate.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Associate;
//import com.revature.hydra.associate.AssociateRepositoryTests;
import com.revature.hydra.associate.service.AssociateService;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class AssociateController {
	private static final Logger log = Logger.getLogger(AssociateController.class);
	private AssociateService associateService;
	
	@Autowired
	public void setAssociateService(AssociateService associateService) {
		this.associateService = associateService;
	}
	
	/**
	 * Get associate by associateId
	 * 
	 * @param id
	 * @return associate
	 */
    @RequestMapping(value = "/one/associate/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<Associate> findOneByAssociateId(@PathVariable Integer id) {
    	log.info("Get associate by associateId");
    	Associate associate = associateService.findOneByAssociateId(id);
        return new ResponseEntity<>(associate, HttpStatus.OK);
    }
    
    /**
	 * Get all associates
	 * 
	 * @return associates
	 */
    @RequestMapping(value = "/all/associate", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAll() {
    	log.info("Get all associates");
    	List<Associate> associates = associateService.findAll();
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    /**
	 * Get all associates by marketingStatusId
	 * 
	 * @param id
	 * @return associates
	 */
    @RequestMapping(value = "/all/associate/marketingStatus/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByMarketingStatusId(@PathVariable Integer id) {
    	log.info("Get all associates by marketingStatusId");
    	List<Associate> associates = associateService.findAllByMarketingStatusId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    /**
   	 * Get all associates by clientId
   	 * 
   	 * @param id
   	 * @return associates
   	 */
    @RequestMapping(value = "/all/associate/client/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByClientId(@PathVariable Integer id) {
    	log.info("Get all associates by clientId");
    	List<Associate> associates = associateService.findAllByClientId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    /**
   	 * Get all associates by endClientId
   	 * 
   	 * @param id
   	 * @return associates
   	 */
    @RequestMapping(value = "/all/associate/endClient/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByEndClientId(@PathVariable Integer id) {
    	log.info("Get all associates by endClientId");
    	List<Associate> associates = associateService.findAllByEndClientId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    /**
   	 * Get all associates by batchId
   	 * 
   	 * @param id
   	 * @return associates
   	 */
    @RequestMapping(value = "/all/associate/batch/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByBatchId(@PathVariable Integer id) {
    	log.info("Get all associates by batchId");
    	List<Associate> associates = associateService.findAllByBatchId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    /**
   	 * Add associate
   	 * 
   	 * @consumes APPLICATION_JSON_VALUE
   	 */
	@RequestMapping(value = "/associate/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Associate> addAssociate(@Valid @RequestBody Associate associate) {
		log.info("Add associate: " + associate);
		associateService.save(associate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
   	 * Update associate by associateId
   	 * 
   	 * @consumes APPLICATION_JSON_VALUE
   	 */
	@RequestMapping(value = "/associate/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateAssociate(@Valid @RequestBody Associate associate) {
		log.info("Update associate by associateId: " + associate);
		associateService.update(associate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	 /**
   	 * Delete associate by associateId
   	 * 
   	 */
	@RequestMapping(value = "/associate/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAssociate(@PathVariable Integer id) {
		Associate associate = new Associate();
		associate.setAssociateId(id);
		log.info("Delete associate by associateId: " + id);
		associateService.delete(associate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}