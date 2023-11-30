package cz.cvut.fel.omo.entity.living.person;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.Role;
import lombok.Getter;
import lombok.Setter;

/**
 * Person is an executor with a name.
 * It is used for the purpose of the simulation.
 */
@Getter
@Setter
public class Person extends Executor {

    /**
     * Name of the person.
     */
    private String name;

    /**
     * Constructor for the person.
     *
     * @param name Name of the person.
     * @param role Role of the person.
     */
    public Person(String name, Role role) {
        super(role);
        this.name = name;
    }
}
