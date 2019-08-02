package com.anz.sample;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.sample.controller.account.AccountResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleApplicationTests {

	@LocalServerPort
    private int localPort;
    private TestRestTemplate restTemplate = new TestRestTemplate();
    
    @Test
    public void testGetAllAccountsInSadPath() {

    	ResponseEntity<AccountResponse> response = restTemplate.getForEntity(createURLWithPort("/accounts/4537152876"), AccountResponse.class);
        String expectedAccountNo =  "4537152876";
        try {
            JSONAssert.assertEquals(expectedAccountNo, response.getBody().getAccountNumber(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + localPort + "/sample"+  uri;
    }

}
