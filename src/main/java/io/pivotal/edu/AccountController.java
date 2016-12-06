package io.pivotal.edu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AccountController {

    final AccountRepo repo;

    AccountController(AccountRepo repo) {this.repo = repo;}

    @GetMapping("accounts/{username}")
    Account findByUsername(@PathVariable String username) {
        return repo.findByUsername(username)
                .orElseThrow(AccountNotFoundException::new);
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "account not found")
    static class AccountNotFoundException extends RuntimeException {}
}
