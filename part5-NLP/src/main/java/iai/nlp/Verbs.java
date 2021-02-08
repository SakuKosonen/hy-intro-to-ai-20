/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iai.nlp;

/**
 *
 * @author Saku
 */
public class Verbs implements Comparable<Verbs> {

    private int amount;
    private String text;

    public Verbs(String verb) {
        this.text = verb;
        this.amount = 1;
    }

    public void add() {
        amount++;
    }

    public int getAmount() {
        return amount;
    }

    public String getText() {
        return text;
    }

    @Override
    public int compareTo(Verbs arg0) {

        return Integer.compare(amount, arg0.getAmount());

    }

    @Override
    public String toString() {
        return this.text + ": " + this.amount;
    }
    
    

}
