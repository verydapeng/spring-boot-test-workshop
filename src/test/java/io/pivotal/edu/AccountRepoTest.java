package io.pivotal.edu;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepoTest {

    @Autowired
    TestEntityManager em;

    @Autowired
    AccountRepo repo;

    // TODO-4 add @Test annotation and run the test to see it fails
    // then use `TestEntityManager.persistAndFlush` to init the db and make the test pass
    public void findByUsername() {
        Optional<Account> user = repo.findByUsername("user");
        assertTrue("user exists", user.isPresent());
    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    // TODO-5 add @Test annotation and run the test to see it fails
    public void usernameIsUnique() {
        exception.expect(DataIntegrityViolationException.class);

        repo.save(new Account("user", "pass"));
        repo.save(new Account("user", "pass"));
    }
}
