/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.earthguake;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Saku
 */
public class Main {

    public static void main(String[] args) {
        /*
    In case of an earthquake, your home alarm goes off with probability 0.81. If your home is broken 
    into, the alarm goes off with probability 0.92. If these both should occur at the same time, 
    the alarm goes off with probability 0.97. If nothing special is going on, there's a false alarm 
    with probability 0.0095.*/

        double alarmKunEQ = 0.81;
        double alarmKunB = 0.92;
        double alarmKunEQJaB = 0.97;
        double alarmFalse = 0.0095;
        double earthquake = 1.0 / 111.0;
        double burglar = 1.0 / 365.0;

        Random rand = new Random();
        
        ArrayList<ArrayList<Boolean>> megaLista = new ArrayList();
        
        for (int i = 0; i < 10000000; i++) {

            double randomi = rand.nextDouble();

            Boolean B;

            B = randomi <= burglar;

            randomi = rand.nextDouble();

            Boolean E;

            E = randomi <= earthquake;

            Boolean A = false;
            randomi = rand.nextDouble();

            if (B && !E) {
                A = randomi < alarmKunB;
            }
            if (!B && E) {
                A = randomi < alarmKunEQ;
            }
            if (B && E) {
                A = randomi < alarmKunEQJaB;
            } if (!B && !E) {
                 A = randomi < alarmFalse;
            }
            
            ArrayList<Boolean> lista = new ArrayList();
            
            lista.add(E);
            lista.add(B);
            lista.add(A);
            
            megaLista.add(lista);

        }
        
        //Among the tuples with A=1, what is the fraction where B=1?
        
        int alarmit = 0;
        int burglaritKunAlarmit = 0;
       // int earhquaket = 0;
        
        
        for (int i = 0; i < megaLista.size(); i++) {
            if(megaLista.get(i).get(2)) {
                alarmit ++;
                if(megaLista.get(i).get(1)){
                    burglaritKunAlarmit ++;
                }
            } if(megaLista.get(i).get(0)){
              //  earhquaket++;
            }
        }
        
        double fraction = (burglaritKunAlarmit*1.0)/(alarmit*1.0);
        
        System.out.println("Eka: P(B | A)");
        //System.out.println("eqt " + earhquaket);
        System.out.println(burglaritKunAlarmit + "/" + alarmit + " = " + fraction);
        
        //Among the tuples with A=1 and E=1, what is the fraction where B=1?
        
        alarmit = 0;
        burglaritKunAlarmit = 0;
        
        for (int i = 0; i < megaLista.size(); i++) {
            if(megaLista.get(i).get(2) && megaLista.get(i).get(0)) {
                alarmit ++;
                if(megaLista.get(i).get(1)){
                    burglaritKunAlarmit ++;
                }
            }
        }
        
        fraction = (burglaritKunAlarmit*1.0)/(alarmit*1.0);
        
        System.out.println("Toka:  P(B | A,E)");
        System.out.println(burglaritKunAlarmit + "/" + alarmit + " = " + fraction);
        
        System.out.println("First answer is not in line with my intuition. Fraction is lower than I feel is right");
        
    }
}
