package com.consulting.core.cra;


import com.consulting.core.cra.model.Company;
import com.consulting.core.cra.repository.CompanyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CraApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mvc;

	@Autowired
	CompanyRepository repository;

	@Before
	public void setUp() throws Exception {

		Company company = new Company();
		repository.save(company);

	}

    @Test
    public void testSampleController() throws Exception {
        this.mvc.perform(get("/api/clients"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateClientSuccessfully() throws Exception {
        RequestBuilder request  = get("/api/clients");

        mvc.perform(request)
                .andExpect(status().isCreated());
    }

	@After
	public  void downUp(){
		this.mvc = null;
	}
}
