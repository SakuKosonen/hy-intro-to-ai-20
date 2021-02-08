

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saku
 */
public class Main {
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Boolean>> superLista = new ArrayList();
        
        for (int i = 0; i < 100000; i++) {
            
        
        Boolean B;
        
        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;
        
        if(randomNum == 1) {
            B = false;
        } else {
            B = true;
        }
        
        Boolean R;
        
        
        int randomNum1 = rand.nextInt(10) + 1;
        
        if(B) {
            if(randomNum1 == 1) {
                R = false;
            } else {
                R = true;
            }
        } else {
            R = false;
        }
        
        Boolean I;
        
        int randomNum2 = rand.nextInt(10) + 1;
        int randomNum3 = rand.nextInt(10) + 1;
        
        if(B) {
            if(randomNum2 == 1 && randomNum3 < 6) {
                I = false;
            } else {
                I = true;
            }
        }else {
            I = false;
        }
        
        Boolean G;
        
        int randomNum4 = rand.nextInt(10) + 1;
        int randomNum5 = rand.nextInt(10) + 1;
        
        if(randomNum4 == 1 && randomNum5 < 6) {
            G = false;
        } else {
            G = true;
        }
        
        Boolean S;
        
        int randomNum6 = rand.nextInt(10) + 1;
        int randomNum7 = rand.nextInt(10) + 1;
        
        if(I && G) {
            if(randomNum6 == 1 && randomNum7 == 1) {
                S = false;
            } else {
                S = true;
            }
        } else {
            S = false;
        }
        
        Boolean M; 
        
        double randomi = rand.nextDouble();
        
        if(S) {
            if(randomi > 0.01) {
                M = true;
            } else {
                M = false;
            }
        } else {
            M = false;
        }
        
        ArrayList<Boolean> lista = new ArrayList();
        
        lista.add(B);
        lista.add(R);
        lista.add(I);
        lista.add(G);
        lista.add(S);
        lista.add(M);
        
        //System.out.println(lista);
        
        superLista.add(lista);
        
        }
        
       // P(B | R,G,¬S)
        int keissit = 0;
        int batteriOli = 0;
        
        for (int i = 0; i < superLista.size(); i++) {
            
            if(superLista.get(i).get(1) && superLista.get(i).get(3) && !superLista.get(i).get(4)) {
                keissit ++;
                if(superLista.get(i).get(0)) {
                    batteriOli ++;
                }
            }
                        
        }
        
        double chaanssi = batteriOli/keissit;
        System.out.println(batteriOli + "/" + keissit + " = " + chaanssi);
        
        // P(S | R,I,G)
        
        int keissitEtRIG = 0;
        int starttaukset = 0;
        
        for (int i = 0; i < superLista.size(); i++) {
            if(superLista.get(i).get(1) && superLista.get(i).get(2) && superLista.get(i).get(3)) {
                keissitEtRIG ++;
                if(superLista.get(i).get(4)) {
                    starttaukset ++;
                }
            } 
        }
        
        Double chaanssi1 = (starttaukset*1.0)/(keissitEtRIG*1.0);
        
        System.out.println(starttaukset + "/" + keissitEtRIG + " = " + chaanssi1);
        
        // P(S | ¬R,I,G)
        
        int keissitEtKolmasHomma = 0;
        starttaukset = 0;
        
        for (int i = 0; i < superLista.size(); i++) {
            if(!superLista.get(i).get(1) && superLista.get(i).get(2) && superLista.get(i).get(3)) {
                keissitEtKolmasHomma ++;
                if(superLista.get(i).get(4)) {
                    starttaukset ++;
                }
            } 
        }
        
        Double chaanssi2 = (starttaukset*1.0)/(keissitEtKolmasHomma * 1.0);
        
        
        System.out.println(starttaukset + "/" + keissitEtKolmasHomma + " = " + chaanssi2);
        
        System.out.println("Käy järkeen");
        
    }
    
   
}
