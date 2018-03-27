package com.revature.hydra.associate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.beans.Associate;
import com.revature.hydra.associate.application.AssociateRepositoryServiceApplication;
import com.revature.hydra.associate.data.AssociateRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociateRepositoryServiceApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssociateControllerTest {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
	private AssociateRepository test;
	private MockMvc mockMvc;
	private Associate testAssociate;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		testAssociate = new Associate();
		testAssociate.setAssociateId(10101);
		testAssociate.setAssociateFirstName("Test");
		testAssociate.setAssociateLastName("Test");
		testAssociate.setMarketingStatusId(20202);
		testAssociate.setClientId(30303);
		testAssociate.setEndClientId(40404);
		testAssociate.setBatchId(50505);
		testAssociate = test.save(testAssociate);
	}

	@After
	public void tearDown() throws Exception {
		int testId = testAssociate.getMarketingStatusId();
		if (test.findOne(testId) != null) {
			test.delete(testId);
		}
	}

	@Test
	public void TestfindOneByAssociateId() throws Exception {
		mockMvc.perform(get("/one/associate/" + testAssociate.getAssociateId()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.associateId", is(testAssociate.getAssociateId())))
				.andExpect(jsonPath("$.associateFirstName", is(testAssociate.getAssociateFirstName())))
				.andExpect(jsonPath("$.associateLastName", is(testAssociate.getAssociateLastName())));
	}
	
	@Test
	public void TestfindAllByMarketingStatusId() throws Exception {
        mockMvc.perform(get("/all/associate/marketingStatus/7"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateId", is(212)))
                .andExpect(jsonPath("$[0].associateFirstName", is("Christopher")))
                .andExpect(jsonPath("$[0].associateLastName", is("Oler")))
                .andExpect(jsonPath("$[1].associateId", is(213)))
                .andExpect(jsonPath("$[1].associateFirstName", is("Emile")))
                .andExpect(jsonPath("$[1].associateLastName", is("Paul")));
    }
	
	@Test
	public void TestfindAllByClientId() throws Exception {
        mockMvc.perform(get("/all/associate/client/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateId", is(233)))
                .andExpect(jsonPath("$[0].associateFirstName", is("Peter")))
                .andExpect(jsonPath("$[0].associateLastName", is("Thompson")));
    }
	
	@Test
	public void TestfindAllByEndClientId() throws Exception {
        mockMvc.perform(get("/all/associate/endClient/40404"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	@Test
	public void TestfindAllByBatchId() throws Exception {
        mockMvc.perform(get("/all/associate/batch/36"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateId", is(231)))
                .andExpect(jsonPath("$[0].associateFirstName", is("Hunter")))
                .andExpect(jsonPath("$[0].associateLastName", is("Heard")))
                .andExpect(jsonPath("$[1].associateId", is(232)))
                .andExpect(jsonPath("$[1].associateFirstName", is("Daniel")))
                .andExpect(jsonPath("$[1].associateLastName", is("Kaczmarczyk")));
    }
	
	@Test
	public void TestfindAllAssociates() throws Exception {
        mockMvc.perform(get("/all/associate"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }

}