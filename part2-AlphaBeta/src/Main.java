
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String emptyBoard = "xox" + "o??" + "ox?";
        
        TicTacToe r = new TicTacToe(emptyBoard, true);
        System.out.println(r);
        play(r);
    }

    private static void play(TicTacToe r) {
        // Implement this
        
        int jee  = AlphaBeta.alphaBetaValue(r);
        System.out.println(jee);
        
        
        
                
    }
}
