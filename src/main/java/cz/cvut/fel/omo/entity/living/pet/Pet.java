package cz.cvut.fel.omo.entity.living.pet;

import cz.cvut.fel.omo.entity.living.Executor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends Executor {
    private String name;
    private Type type;

    public Pet(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
