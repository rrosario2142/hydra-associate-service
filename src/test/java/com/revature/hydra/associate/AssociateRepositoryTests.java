package com.revature.hydra.associate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Associate;
import com.revature.hydra.associate.application.AssociateRepositoryServiceApplication;
import com.revature.hydra.associate.data.AssociateRepository;

/**
 * 
 * @author RRosario
 * Associate Repository tests
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociateRepositoryServiceApplication.class)
public class AssociateRepositoryTests {
	private static final Logger log = Logger.getLogger(AssociateRepositoryTests.class);
	
	@Autowired
	AssociateRepository test;
	Associate testAssociate;
	
	/**
	 * Associate object creation to be used for each test case.
	 */
	@Before
	public void init() {
		log.info("Initializing an associate object for testing.");
		testAssociate = new Associate();
		testAssociate.setAssociateId(10101);
		testAssociate.setAssociateFirstName("Test");
		testAssociate.setAssociateLastName("Test");
		testAssociate.setMarketingStatusId(20202);
		testAssociate.setClientId(30303);
		testAssociate.setEndClientId(40404);
		testAssociate.setBatchId(50505);
		test.save(testAssociate);
	}

	/**
	 * Associate object deletion after each test case
	 */
	@After
	public void teardown() {
		log.info("Remove test associate from db");
		if (test.findOneByAssociateId(testAssociate.getAssociateId()) != null) {
			test.delete(testAssociate);
		}
	}
	
	/**
	 * Test for finding an associate by associateId
	 */
	@Test
	public void TestfindOneByAssociateId() {
		log.info("findOneByAssociateId() test");
		Associate associate = test.findOneByAssociateId(215);
		assertNotNull(associate);
	}

	/**
	 * Test for finding all by marketingStatusId
	 */
	@Test
	public void TestfindAllByMarketingStatusId() {
		log.info("findAllByMarketingStatusId() test");
		List<Associate> associates = test.findAllByMarketingStatusId(7);
		assertNotNull(associates);
	}
	
	/**
	 * Test for finding associates by clientId
	 */
	@Test
	public void TestfindAllByClientId() {
		log.info("findAllByClientId() test");
		List<Associate> associates = test.findAllByClientId(30303);
		assertNotNull(associates);
	}
	
	/**
	 * Test for finding associates by endClientId
	 */
	@Test
	public void TestfindAllByEndClientId() {
		log.info("findAllByEndClientId() test");
		List<Associate> associates = test.findAllByEndClientId(40404);
		assertNotNull(associates);
	}
	
	/**
	 * Test for finding associates by batchId
	 */
	@Test
	public void TestfindAllByBatchId() {
		log.info("findAllByBatchId() test");
		List<Associate> associates = test.findAllByBatchId(32);
		assertNotNull(associates);
	}
	
	/**
	 * Test for finding all associates
	 */
	@Test
	public void TestfindAll() {
		log.info("findAll() test.");
		List<Associate> associates = test.findAll();
		assertNotNull(associates);
	}
	
	/**
	 * Test for adding an associate
	 */
	@Test
	public void TestaddAssociate() {
		log.info("addAssociate() test");
		testAssociate = test.save(testAssociate);
		assertTrue(test.findAll().contains(testAssociate));
	}
	
	/**
	 * Test for updating an associate
	 */
	@Test
	public void TestUpdateAssociate() {
		log.info("updateAssociate() test");
		testAssociate.setEndClientId(5);
		Associate updatedAssociate = test.save(testAssociate);
		assertEquals(updatedAssociate.getEndClientId(), testAssociate.getEndClientId());
	}
	
	/**
	 * Test for deleting an associate
	 */
	@Test
	public void TestDeleteAssociate() {
		log.info("deleteAssociate() test");
		test.delete(testAssociate);
		assertNull(test.findOneByAssociateId(testAssociate.getAssociateId()));
	}
}