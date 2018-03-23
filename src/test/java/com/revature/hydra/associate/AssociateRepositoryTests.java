package com.revature.hydra.associate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociateRepositoryServiceApplication.class)
public class AssociateRepositoryTests {
	private static final Logger log = Logger.getLogger(AssociateRepositoryTests.class);
	
	@Autowired
	AssociateRepository test;
	Associate testAssociate;

	@Before
	public void init() {
		log.info("Initializing an associate object for testing.");
		testAssociate = new Associate(10101, "Test", "Tester", 20202, 30303, 40404, 50505);
		test.save(testAssociate);
	}

	@After
	public void teardown() {
		log.info("Remove test associate from db");
		if (test.findOneByAssociateId(testAssociate.getAssociateId()) != null) {
			test.delete(testAssociate);
		}
	}
	
	@Test
	public void TestfindOneByAssociateId() {
		log.info("findOneByAssociateId() test");
		Associate associate = test.findOneByAssociateId(10101);
		assertNotNull(associate);
	}

	@Test
	public void TestfindAllByMarketingStatusId() {
		log.info("findAllByMarketingStatusId() test");
		List<Associate> associates = test.findAllByMarketingStatusId(30303);
		assertNotNull(associates);
	}
	
	@Test
	public void TestfindAllByClientId() {
		log.info("findAllByClientId() test");
		List<Associate> associates = test.findAllByClientId(30303);
		assertNotNull(associates);
	}
	
	@Test
	public void TestfindAllByEndClientId() {
		log.info("findAllByEndClientId() test");
		List<Associate> associates = test.findAllByEndClientId(40404);
		assertNotNull(associates);
	}
	
	@Test
	public void TestfindAllByBatchId() {
		log.info("findAllByBatchId() test");
		List<Associate> associates = test.findAllByBatchId(50505);
		assertNotNull(associates);
	}
	
	@Test
	public void TestfindAll() {
		log.info("findAll() test.");
		List<Associate> associates = test.findAll();
		assertNotNull(associates);
	}
	
	@Test
	public void TestaddAssociate() {
		log.info("Adding associate test.");
		testAssociate = new Associate(1111, "NewTest", "NewerTester", 2222, 3333, 4444, 5555);
		test.save(testAssociate);
		assertTrue(test.findAll().contains(testAssociate));
	}
	
	@Test
	public void TestUpdateAssociate() {
		log.info("Updating associate test.");
		testAssociate.setClientId(30305);
		Associate updatedAssociate = test.save(testAssociate);
		assertEquals(updatedAssociate.getClientId(), testAssociate.getClientId());
	}
}