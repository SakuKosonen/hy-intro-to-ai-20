
public class AlphaBeta {
    
    private AlphaBetaNode paras;
    private AlphaBetaNode parasO;
    
    public static int alphaBetaValue(AlphaBetaNode node) {
        int v = 0;
        if (node.isMaxNode()) {
            v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            v = minValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return v;
    }

    private static int maxValue(AlphaBetaNode node, int alpha, int beta) {
        AlphaBetaNode paras = node;
        int isoin = 0; 
        
        if (node.isEndState()) {
            return node.value();
        }
        int v = Integer.MIN_VALUE;
        for (AlphaBetaNode lapsi : node.generateChildren()) {
            
            
            
            v = Integer.max(v, minValue(lapsi, alpha, beta));
            
            if(v>=isoin) {
                isoin = 1;
                paras = lapsi;
            } 
            
            alpha = Integer.max(alpha, v);
            if (alpha >= beta) {
                
                
                
                return v;
                
                
            }
            
        }
        System.out.println(paras);
        return v;
    }

    private static int minValue(AlphaBetaNode node, int alpha, int beta) {
        
        
        if (node.isEndState()) {
            return node.value();
        }
        int v = Integer.MAX_VALUE;
        for (AlphaBetaNode lapsi : node.generateChildren()) {
            v = Integer.min(v, maxValue(lapsi, alpha, beta));
            beta = Integer.min(beta, v);
            if (alpha >= beta) {
                return v;
            }
        }

        return v;
    }
}
