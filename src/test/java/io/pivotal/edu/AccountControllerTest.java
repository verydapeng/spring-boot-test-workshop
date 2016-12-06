package io.pivotal.edu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AccountRepo repo;

    // TODO-7 add @Test and run the test to see it fails
    @Test
    public void findByUsername() throws Exception {
        given(repo.findByUsername("user"))
                // TODO-8 now make the repo return a real account to make the test pass
                //.willReturn(Optional.of(new Account(...)));
                .willReturn(Optional.empty());
        mvc.perform(get("/accounts/{username}", "user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("user")));
    }
}