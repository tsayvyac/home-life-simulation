package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.Type;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * Role of a person in a family.
 * <p>
 * Each role has a list of types that it can be assigned to.
 * <p>
 * For example, a mother can be assigned to an adult and a person.
 * <p>
 * A dog can only be assigned to a pet.
 */
@Getter
public enum Role {
    MOTHER(Type.ADULT, Type.PERSON),
    FATHER(Type.ADULT, Type.PERSON),
    DAUGHTER(Type.KID, Type.PERSON),
    SON(Type.KID, Type.PERSON),
    GRANDMOTHER(Type.ADULT, Type.PERSON),
    GRANDFATHER(Type.ADULT, Type.PERSON),
    UNCLE(Type.ADULT, Type.PERSON),
    COUSIN(Type.KID, Type.PERSON),
    DOG(Type.PET),
    CAT(Type.PET),
    FROG(Type.PET),
    RABBIT(Type.PET);

    private final List<Type> type;

    Role(Type... type) {
        this.type = Arrays.asList(type);
    }
}
