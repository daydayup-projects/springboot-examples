package tech.alexchen.springboot.hello.Bean;

import lombok.Data;

/**
 * @author alexchen
 */
@Data
public class User {
    Integer id;
    String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
