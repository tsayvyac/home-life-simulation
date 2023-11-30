package cz.cvut.fel.omo.entity.living.pet;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.Role;
import lombok.Getter;
import lombok.Setter;

/**
 * Pet is an executor that is owned by a person.
 */
@Getter
@Setter
public class Pet extends Executor {

    /**
     * Name of the pet.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name Name of the pet.
     * @param role Role of the pet.
     */
    public Pet(String name, Role role) {
        super(role);
        this.name = name;
    }
}
