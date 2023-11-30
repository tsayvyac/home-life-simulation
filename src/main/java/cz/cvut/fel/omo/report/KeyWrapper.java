package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.entity.living.Role;

/**
 * KeyWrapper for role and appliance type for using in ActivityAndUsageReporter
 *
 * @param role          role of the executor
 * @param applianceType type of the appliance
 */
public record KeyWrapper(Role role, ApplianceType applianceType) {
}
