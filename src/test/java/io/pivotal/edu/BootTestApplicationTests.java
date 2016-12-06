package io.pivotal.edu;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        // TODO-10 load the pre-configured database to make the test pass
        // uncomment the following line
        // , properties = "datasource.data=classpath:/BootTestApplicationTests.data.sql"
)
public class BootTestApplicationTests {

    @LocalServerPort
    int port;

    // TODO-9 add @Test annotation and run the test to see it fails
    public void accountFindByUsername() {

        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<Account> entity = restTemplate.getForEntity(
                "http://localhost:{port}/accounts/{username}",
                Account.class, port, "user");

        assertEquals("user should be pre-configured",
                HttpStatus.OK, entity.getStatusCode());

    }


    @Autowired
    TestRestTemplate testRestTemplate;

    // TODO-11 use spring managed TestRestTemplate to simplify the test
    // notice that we don't need to specify the port number any more
    // add @Test and run
    public void accountFindByUsernameSimplified() {
        ResponseEntity<Account> entity = testRestTemplate.getForEntity(
                "/accounts/{username}",
                Account.class, "user");

        assertEquals("user should be pre-configured",
                HttpStatus.OK, entity.getStatusCode());
    }

}
