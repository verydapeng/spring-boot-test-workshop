package io.pivotal.edu;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@JsonTest
public class AccountJsonTest {

    @Autowired
    JacksonTester<Account> tester;

    Account account = new Account("user", "pass");

    // TODO-1 add @Test annotation and run the test to see it fails
    public void passwordShouldNotBeShown() throws IOException {
        // generally it may not be a good idea to serialize the domain objects
        // in stead we should consider using DTO
        tester.write(account)
                .assertThat()
                .doesNotHaveJsonPathValue("$.password");
    }

    // TODO-3 write another test to assert `username` is present in the json
    public void usernameIsInJson() throws IOException {
        tester.write(account)
                .assertThat()
        // hint: use `hasJsonPathStringValue` method
        ;
    }
}
