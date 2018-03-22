package com.revature.hydra.associate;

import static org.junit.Assert.assertNotNull;

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
		testAssociate = new Associate(1000, "Test", "Tester", 10101, 20202, 30303, 40404);
		test.save(testAssociate);
	}

	@After
	public void teardown() {
		log.info("Delete test associate object");
		if (test.findOneByAssociateId(testAssociate.getAssociateId()) != null) {
			test.delete(testAssociate);
		}
	}
	
	@Test
	public void TestfindAllByAssociateId() {
		log.info("fineOneByAssociateId() test");
		Associate associate = test.findOneByAssociateId(10101);
		assertNotNull(associate);
	}
	
	@Test
	public void TestfindAllByClientId() {
		log.info("fineOneByClientId() test");
		Associate associate = test.findOneByAssociateId(1);
		assertNotNull(associate);
	}

	@Test
	public void TestfindAllByMarketingStatusId() {
		log.info("fineOneByClientId() test");
		Associate associate = test.findOneByAssociateId(1);
		assertNotNull(associate);
	}
	
	@Test
	public void TestfindAllByEndClientId() {
		log.info("fineOneByClientId() test");
		Associate associate = test.findOneByAssociateId(1);
		assertNotNull(associate);
	}
	@Test
	public void TestfindAll() {
		log.info("findAll() test.");
		List<Associate> associates = test.findAll();
		assertNotNull(associates);
	}
	
	//@Test
//	public void addPlacement() {
//		log.info("Test adding a placement.");
//		testPlacement = new Placement(1001, new Timestamp(100_000), new Timestamp(200_000), 5510, 5510, 5503);
//		Placement savedPlacement = placementRepository.save(testPlacement);
//
//		assertTrue(placementRepository.findAll().contains(savedPlacement));
//	}
}