package io.pivotal.edu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
// TODO-6 uncomment the following line to add the unique constraint to make the test pass
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
class Account {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    // TODO-2 add @JsonIgnore to hide the password field and to make the test pass
    private String password;

    Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
