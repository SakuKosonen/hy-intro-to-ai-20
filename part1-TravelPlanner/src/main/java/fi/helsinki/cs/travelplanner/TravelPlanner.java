package fi.helsinki.cs.travelplanner;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TravelPlanner {

    /**
     * Implement breadth-first search. Return the answer as a linked list
     * where the first node points to the goal and each node has a stop
     * and is linked to the previous node in the path.
     * The last node in the list is the starting stop and its previous node is null.
     *
     * You can get the neighboring stops by calling the getNeighbors()-method on a stop.
     *
     * @param start Code of the start stop
     * @param goal Code of the goal stop
     * @return A linked list of States from goal to start
     */
    public State search(Stop start, Stop goal) {
                
        HashSet<Stop> visited = new HashSet();        
        State firstState = new State(start, null);        
        ArrayDeque<State> list = new ArrayDeque();                
        list.addFirst(firstState);
        
        while(!list.isEmpty()) {
                        
            State node = list.pollFirst();
            
            if(!visited.contains(node.getStop())) {
                visited.add(node.getStop());
                
                if(node.getStop().equals(goal)) {
                    return node;                    
                }
                                
                Collection<Stop> naapurit = node.getStop().getNeighbors();
                
                for (Stop naapuri : naapurit) {
                    State naapuriStatena = new State(naapuri, node);
                    list.addLast(naapuriStatena);
                }
                
                
            }
        } 
        
        
        return null;
    }
}
