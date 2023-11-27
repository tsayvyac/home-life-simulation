package cz.cvut.fel.omo.component;

import cz.cvut.fel.omo.report.Visitor;

/**
 * Interface for updatable and visitable objects.
 */
public interface Component {

    /**
     * Accept a visitor.
     *
     * @param visitor {@link Visitor} for generate report
     * @return String that will be used to generate report
     */
    String accept(Visitor visitor);

    /**
     * Updates ticks.
     */
    void update();
}
