package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logic.Stop;
import fi.helsinki.cs.reittiopas.logic.State;
import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    private final Stop goal;

    public StateComparator(Stop goalStop) {
        this.goal = goalStop;
    }

    /**
     * Implement this
     *
     * @param stop
     * @return Estimated remaining time
     */
    public double heuristic(Stop stop) {
        return 0.0;
    }

    /**
     * Implement this
     *
     * @param t1
     * @param t2
     * @return result of the comparison
     */
    @Override
    public int compare(State t1, State t2) {
        return 0;
    }

}
