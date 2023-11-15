package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.Type;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Role {
    MOTHER(Type.ADULT, Type.PERSON),
    FATHER(Type.ADULT, Type.PERSON),
    DAUGHTER(Type.KID, Type.PERSON),
    SON(Type.KID, Type.PERSON),
    GRANDMOTHER(Type.ADULT, Type.PERSON),
    GRANDFATHER(Type.ADULT, Type.PERSON),
    DOG(Type.PET),
    CAT(Type.PET),
    FROG(Type.PET);

    private final List<Type> type;

    Role(Type ...type) {
        this.type = Arrays.asList(type);
    }
}
