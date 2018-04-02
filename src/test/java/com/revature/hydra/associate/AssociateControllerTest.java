package com.revature.hydra.associate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
/**
 * 
 * @author RRosario
 * Associate controller tests
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociateRepositoryServiceApplication.class)
@WebAppConfiguration
public class AssociateControllerTest {
	private static final Logger log = Logger.getLogger(AssociateRepositoryTests.class);
	
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
	private Associate testAssociate, addAssociate;

	/**
	 * Test environment setup for each test case
	 */
	@Before
	public void setUp() throws Exception {
		log.info("AssociateControllerTest setup.");
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

	/**
	 * Teardown after each test case.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		log.info("AssociateControllerTest teardown");
		int testId = testAssociate.getMarketingStatusId();
		if (test.findOne(testId) != null) {
			test.delete(testId);
		}
	}

	/**
	 * Test for finding an associate by associateId
	 * @throws Exception
	 */
	@Test
	public void TestfindOneByAssociateId() throws Exception {
		log.info("fineOneByAssociateId() test");
		mockMvc.perform(get("/one/associate/" + testAssociate.getAssociateId()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.associateFirstName", is(testAssociate.getAssociateFirstName())))
				.andExpect(jsonPath("$.associateLastName", is(testAssociate.getAssociateLastName())));
	}
	
	/**
	 * Test for finding associates by marketingStatusId
	 * @throws Exception
	 */
	@Test
	public void TestfindAllByMarketingStatusId() throws Exception {
		log.info("findAllByMarketingStatusId() test");
        mockMvc.perform(get("/all/associate/marketingStatus/" + testAssociate.getMarketingStatusId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is(testAssociate.getAssociateFirstName())))
                .andExpect(jsonPath("$[0].associateLastName", is(testAssociate.getAssociateLastName())));
    }
	
	/**
	 * Test for finding associates by clientId
	 * @throws Exception
	 */
	@Test
	public void TestfindAllByClientId() throws Exception {
		log.info("findAllByClientId() test");
        mockMvc.perform(get("/all/associate/client/" + testAssociate.getClientId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	/**
	 * Test for finding associates by endClientId
	 * @throws Exception
	 */
	@Test
	public void TestfindAllByEndClientId() throws Exception {
		log.info("findAllByEndClientId() teardown");
        mockMvc.perform(get("/all/associate/endClient/" + testAssociate.getEndClientId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	/**
	 * Test for finding associates by batchId
	 * @throws Exception
	 */
	@Test
	public void TestfindAllByBatchId() throws Exception {
		log.info("findAllByBatchId() test");
        mockMvc.perform(get("/all/associate/batch/" + testAssociate.getBatchId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].associateFirstName", is("Test")))
                .andExpect(jsonPath("$[0].associateLastName", is("Test")));
    }
	
	/**
	 * Test for retrieving all associates
	 * @throws Exception
	 */
	@Test
	public void TestfindAllAssociates() throws Exception {
		log.info("findAllAssociates() test");
        mockMvc.perform(get("/all/associate"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
	
	/**
	 * Test for adding an associate
	 * @throws Exception
	 */
	@Test
	public void TestaddAssociate() throws Exception {
		log.info("addAssociate() test");
		addAssociate = new Associate();
		addAssociate.setAssociateFirstName("ADD TEST");
		addAssociate.setAssociateLastName("ADD TEST");
		this.mockMvc.perform(post("/associate/add")
					.content(this.json(addAssociate))
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
					.andExpect(status().isOk());
	}

	/**
	 * Test for updating associate
	 * @throws Exception
	 */
	@Test
	public void TestupdateAssociate() throws Exception {
		log.info("updateAssociate() test");
		testAssociate = test.findOne(testAssociate.getAssociateId());
		testAssociate.setAssociateFirstName("UPDATE TEST");
		this.mockMvc.perform(put("/associate/update")
					.content(this.json(testAssociate))
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
					.andExpect(status().isOk());
	}
	
	/**
	 * Test for deleting an associate
	 * @throws Exception
	 */
	@Test
	public void TestdeleteAssociate() throws Exception {
		log.info("deleteAssociate() test");
		this.mockMvc.perform(delete("/associate/delete/" + testAssociate.getAssociateId()))
					.andExpect(status().isOk());
	}
	
	/**
	 * For converting Associate object to JSON representation.
	 * @throws IOException
	 */
	protected String json(Object obj) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		mappingJackson2HttpMessageConverter.write(obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}


}