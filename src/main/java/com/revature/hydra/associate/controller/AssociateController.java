package com.revature.hydra.associate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public void setassociateService(AssociateService associateService) {
		this.associateService = associateService;
	}
	

    @RequestMapping(value = "/one/associate/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<Associate> findOneassociate(@PathVariable Integer id) {
    	Associate c = associateService.findOneById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/associate", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Associate>> findAllassociate() {
    	List<Associate> lc = associateService.findAll();
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }

}