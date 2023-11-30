package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.entity.living.Role;

public record KeyWrapper(Role role, ApplianceType applianceType) {
}
