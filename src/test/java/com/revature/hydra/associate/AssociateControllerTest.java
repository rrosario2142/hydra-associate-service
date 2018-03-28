package com.revature.hydra.associate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
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
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	
	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
					.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
					.findAny()
					.orElse(null);
		
		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}
	
	@Autowired
	private AssociateRepository test;
	private MockMvc mockMvc;
	private Associate testAssociate;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		testAssociate = new Associate();
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
				.andExpect(jsonPath("$.associateFirstName", is(testAssociate.getAssociateFirstName())))
				.andExpect(jsonPath("$.associateLastName", is(testAssociate.getAssociateLastName())));
	}
	
	@Test
	public void TestfindAllByMarketingStatusId() throws Exception {
        mockMvc.perform(get("/all/associate/marketingStatus/" + testAssociate.getMarketingStatusId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is(testAssociate.getAssociateFirstName())))
                .andExpect(jsonPath("$[0].associateLastName", is(testAssociate.getAssociateLastName())));
    }
	
	@Test
	public void TestfindAllByClientId() throws Exception {
        mockMvc.perform(get("/all/associate/client/" + testAssociate.getClientId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	@Test
	public void TestfindAllByEndClientId() throws Exception {
        mockMvc.perform(get("/all/associate/endClient/" + testAssociate.getEndClientId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	@Test
	public void TestfindAllByBatchId() throws Exception {
        mockMvc.perform(get("/all/associate/batch/" + testAssociate.getBatchId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	@Test
	public void TestfindAllAssociates() throws Exception {
        mockMvc.perform(get("/all/associate"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
/*	
	@Test
	public void TestupdateAssociate() throws Exception {
		testAssociate = test.findOne(testAssociate.getAssociateId());
		testAssociate.setAssociateFirstName("UPDATE TEST");
		this.mockMvc.perform(put("/associate/update")
					.content(this.json(this.testAssociate))
					.contentType(this.mediaTypeJson))
					.andExpect(status().isOk());
	}
*/
}