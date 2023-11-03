package cz.cvut.fel.omo.entity.living.person;

import cz.cvut.fel.omo.entity.living.Executor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends Executor  {
    private String name;
    private Role role;

    public Person(String name, Role role) {
        this.name = name;
        this.role = role;
    }
}
