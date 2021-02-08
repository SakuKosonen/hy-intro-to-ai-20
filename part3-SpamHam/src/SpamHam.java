   // package spamham;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SpamHam {

    private final static String SPAM_PATH = "spamcount.txt";
    private final static String HAM_PATH = "hamcount.txt";
    private final static String MESSAGE_PATH = "spamesim.txt";

    private static List<String> readMessage(String file) throws IOException {
        String teksti = new String(Files.readAllBytes(Paths.get(file)));
        return Arrays.asList(teksti.split("\\s+"));
    }

    private static Map<String, Integer> readOccurences(String file)
            throws FileNotFoundException {
        Map<String, Integer> counts;
        try ( Scanner lukija = new Scanner(new File(file))) {
            counts = new HashMap<>();
            while (lukija.hasNext()) {
                int occurences = lukija.nextInt();
                String word = lukija.next();
                counts.put(word, occurences);
            }
        }

        return counts;
    }

    public static Map<String, Double> prob(Map<String, Integer> counts, int total) {

        Set setti = counts.keySet();
        HashMap<String, Double> todarit = new HashMap();

        for (Object sana : setti) {
            double prob = counts.get(sana)*1.0 / total;
            String jotain = sana.toString();
            todarit.put(jotain, prob);
        }

        return todarit;
    }

    /*
    P(s|spam) P(s|ham)
    
    P(ham|s)/P(spam|s) =  P(
    

     */
   

    public static Double spamicity(Map<String, Double> hamiTodarit, Map<String, Double> spamiTodarit, List<String> sanat) {
        
        Double ratio = 0.5/0.5;
        Double todEtSanaInSpami = 0.0;
        Double tESIH = 0.0;
        for (String sana : sanat) {
            
            if(hamiTodarit.containsKey(sana)) {
                tESIH = hamiTodarit.get(sana);
            } else {
                tESIH = 0.00001;
            }
            
            if(spamiTodarit.containsKey(sana)) {
                todEtSanaInSpami = spamiTodarit.get(sana);
            } else {
                todEtSanaInSpami = 0.00001;
            }
            
            ratio = ratio * todEtSanaInSpami / tESIH;
        }
        
        return ratio;
    }
    
    public static Double vastaus(Double spamicity) {
        return spamicity/(spamicity+1);
    } 

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, Integer> spam = readOccurences(SPAM_PATH);
        Map<String, Integer> ham = readOccurences(HAM_PATH);
        
        Map<String, Double> spamiTodarit = prob(spam, 75268);
        Map<String, Double> hamiTodarit = prob(ham, 290673);
        
        double spamicityR = spamicity(hamiTodarit, spamiTodarit, readMessage(MESSAGE_PATH));
        
        System.out.println(spamicityR);
        System.out.println("---");
        System.out.println(vastaus(spamicityR));
        
        
    }
}
