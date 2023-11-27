package cz.cvut.fel.omo.entity.living.person;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends Executor {
    private String name;

    public Person(String name, Role role) {
        super(role);
        this.name = name;
    }
}
