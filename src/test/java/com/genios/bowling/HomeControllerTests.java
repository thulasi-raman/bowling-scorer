package com.genios.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTests {

	@Autowired
    private HomeController controller;

	 @Autowired
	 private TestRestTemplate restTemplate;

	 @LocalServerPort
	 private int port;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void homeShouldReturnBowling() throws Exception {
    	String home = this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class);
    	assertThat(home.equalsIgnoreCase("home"));
    }

}
