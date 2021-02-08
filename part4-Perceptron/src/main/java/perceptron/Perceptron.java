package perceptron;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perceptron {

    private final List<Image> images;

    public Perceptron(List<Image> images) {
        this.images = images;
    }

    /**
     * Fill in the perceptron implementation here.
     *
     * @param targetChar
     * @param oppositeChar
     * @param steps
     * @return
     */
    public double[] train(int targetChar, int oppositeChar, int steps) {
        Random rand = new Random();
        double[] w = new double[28 * 28];
        int kolmoset = 0;
        int vitoset = 0;
        int kolmosetV[] = new int[w.length];
        int vitosetV[] = new int[w.length];
        Double[] cpt3 = new Double[w.length];
        Double[] cpt5 = new Double[w.length];

        ArrayList<ArrayList<Integer>> listaLista = new ArrayList();

        for (int step = 0; step < 100 * steps;) {
            int example = rand.nextInt(5000); // pick random example

            // only care about the two classes
            if (images.get(example).characterClass != targetChar
                    && images.get(example).characterClass != oppositeChar) {
                continue;
            }
            step++;

            /*  boolean kolmoi = true;

            if (images.get(example).characterClass == targetChar) {
                kolmoset++;
            } else {
                kolmoi = false;
                vitoset++;
            }

            for (int i = 0; i < 28 * 28; i++) {
                if (images.get(example).vec[i] == 1) {
                    if (kolmoi) {
                        kolmosetV[i] = kolmosetV[i] + 1;
                        cpt3[i] = (kolmosetV[i] * 1.0) / (kolmoset * 1.0);
                    } else {
                        vitosetV[i] = vitosetV[i] + 1;
                        cpt5[i] = (vitosetV[i] * 1.0) / (vitoset * 1.0);
                    }
                }

            }
             */
            
            
            double z = 0.0;
            for (int j = 0; j < 28 * 28; j++) {
                z += images.get(example).vec[j] * w[j];
            }
            
             if (z >= 0 && images.get(example).characterClass == oppositeChar){
                 for (int j = 0; j < 28 * 28; j++) {
                     w[j] = w[j] - images.get(example).vec[j];
                 }
             }
             if(z < 0 && images.get(example).characterClass == targetChar) {
                 for (int j = 0; j < 28 * 28; j++) {
                     w[j] = w[j] + images.get(example).vec[j];
                 }
             }
        }

        return w;
    }

    /**
     * Tests the learned perceptron (with weight vector weights) with the last
     * 1000 x,y pairs. (Note that this only counts those ones that belong either
     * to the plus or minus classes.
     *
     * @param weights
     * @param targetChar
     * @param oppositeChar
     * @return ratio of failures
     */
    double test(double[] weights, int targetChar, int oppositeChar) {
        int success = 0;
        int trials = 0;

        for (int example = 5000; example < (int) images.size(); example++) {

            // choosing only from the + and - classes
            if (images.get(example).characterClass != targetChar
                    && images.get(example).characterClass != oppositeChar) {
                continue;
            }

            // calculate z
            double z = 0.0;
            for (int j = 0; j < 28 * 28; j++) {
                z += images.get(example).vec[j] * weights[j];
            }

            // Is the classification correct=
            if ((z >= 0 && images.get(example).characterClass == targetChar)
                    || (z < 0 && images.get(example).characterClass == oppositeChar)) {
                success++;
            }
            trials++;
        }

        return (double) (trials - success) / trials;
    }
}
