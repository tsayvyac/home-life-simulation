package cz.cvut.fel.omo.entity.living.pet;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends Executor {
    private String name;

    public Pet(String name, Role role) {
        super(role);
        this.name = name;
    }
}
