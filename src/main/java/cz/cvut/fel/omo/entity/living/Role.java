package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.Type;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Role {
    MOTHER(Type.ADULT, Type.PERSON, Type.ALL),
    FATHER(Type.ADULT, Type.PERSON, Type.ALL),
    DAUGHTER(Type.KID, Type.PERSON, Type.ALL),
    SON(Type.KID, Type.PERSON, Type.ALL),
    GRANDMOTHER(Type.ADULT, Type.PERSON, Type.ALL),
    GRANDFATHER(Type.ADULT, Type.PERSON, Type.ALL),
    UNCLE(Type.ADULT, Type.PERSON, Type.ALL),
    COUSIN(Type.KID, Type.PERSON, Type.ALL),
    DOG(Type.PET, Type.ALL),
    CAT(Type.PET, Type.ALL),
    FROG(Type.PET, Type.ALL),
    RABBIT(Type.PET, Type.ALL);

    private final List<Type> type;

    Role(Type... type) {
        this.type = Arrays.asList(type);
    }
}
