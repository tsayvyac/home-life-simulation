package cz.cvut.fel.omo.state;

public interface State {

    StateType setState(StateType stateType);
    StateType getStateType();
}
