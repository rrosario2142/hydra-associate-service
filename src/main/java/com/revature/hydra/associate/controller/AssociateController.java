package com.revature.hydra.associate.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.revature.hydra.associate.service.AssociateService;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class AssociateController {
	
	private AssociateService associateService;
	
	@Autowired
	public void setAssociateService(AssociateService associateService) {
		this.associateService = associateService;
	}
	
    @RequestMapping(value = "/one/associate/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<Associate> findOneByAssociateId(@PathVariable Integer id) {
    	Associate associate = associateService.findOneByAssociateId(id);
        return new ResponseEntity<>(associate, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/associate", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAll() {
    	List<Associate> associates = associateService.findAll();
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/associate/marketingStatus/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByMarketingStatusId(@PathVariable Integer id) {
    	List<Associate> associates = associateService.findAllByMarketingStatusId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/associate/client/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByClientId(@PathVariable Integer id) {
    	List<Associate> associates = associateService.findAllByClientId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/associate/endClient/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByEndClientId(@PathVariable Integer id) {
    	List<Associate> associates = associateService.findAllByEndClientId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/associate/batch/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllByBatchId(@PathVariable Integer id) {
    	List<Associate> associates = associateService.findAllByBatchId(id);
        return new ResponseEntity<>(associates, HttpStatus.OK);
    }
    
	@RequestMapping(value = "/associate/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Associate> addAssociate(@Valid @RequestBody Associate associate) {
		//log.info("Saving placement: " + associate);
		associateService.save(associate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/associate/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updatePlacement(@Valid @RequestBody Associate associate) {
		//log.info("Updating placement: " + placement);
		associateService.update(associate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/associate/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePlacement(@PathVariable Integer id) {
		Associate associate = new Associate();
		associate.setAssociateId(id);
		//log.info("Deleting placement: " + id);
		associateService.delete(associate);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}