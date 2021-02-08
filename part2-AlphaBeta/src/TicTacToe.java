
import java.util.ArrayList;

public class TicTacToe implements AlphaBetaNode {

    boolean crossesTurn;
    private String state;

    /**
     * Tic-tac-toe implementation
     *
     * @param state String that represents the state of the board. May only
     * contain characters: 'o', 'x' or '?'.
     */
    
    public TicTacToe(String state, boolean crossesTurn) {
        this.state = state;
        this.crossesTurn = crossesTurn;
    }

    @Override
    public int value() {
        int v = 0;
        if( won('x')){
            v = 1;
        }
        if(won('o')) {
            v = -1;
        }
        return v; // Implement this
    }

    @Override
    public ArrayList<AlphaBetaNode> generateChildren() {

        String mark = "o";
        if (crossesTurn) {
            mark = "x";
        }

        ArrayList<AlphaBetaNode> lapsiLista = new ArrayList();

        String[] lista = state.split("");

        for (int i = 0; i < 9; i++) {
            if (lista[i].equals("?")) {

                String[] uusiLista = state.split("");
                uusiLista[i] = mark;

                TicTacToe uusi = new TicTacToe(uusiLista[0] + uusiLista[1] + uusiLista[2] +uusiLista[3] + uusiLista[4] + uusiLista[5] + uusiLista[6] + uusiLista[7] + uusiLista[8], !crossesTurn);
               // System.out.println(uusi);
                lapsiLista.add(uusi);
                
            }

        }

        return lapsiLista;// Implement this

    }

    @Override
    public boolean isEndState() {
        return state.indexOf('?') < 0 || won('x') || won('o');
    }

    public boolean won(char c) {
        String s = "" + c + c + c;
        return (state.substring(0, 3).equals(s)
                || state.substring(3, 6).equals(s)
                || state.substring(6, 9).equals(s)
                || ("" + state.charAt(0) + state.charAt(3) + state.charAt(6)).equals(s)
                || ("" + state.charAt(1) + state.charAt(4) + state.charAt(7)).equals(s)
                || ("" + state.charAt(2) + state.charAt(5) + state.charAt(8)).equals(s)
                || ("" + state.charAt(0) + state.charAt(4) + state.charAt(8)).equals(s)
                || ("" + state.charAt(6) + state.charAt(4) + state.charAt(2)).equals(s));
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        char[] arr = state.toCharArray();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret.append("|").append(arr[3 * i + j]);
            }
            ret.append("|\n");
        }
        return ret.toString();
    }

    @Override
    public boolean isMaxNode() {
        return crossesTurn;
    }
}
