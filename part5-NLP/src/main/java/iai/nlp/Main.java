package iai.nlp;

import opennlp.tools.parser.Parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Use this object to access NLP methods, for example NLP.parse(sentence)
        NLPUtils NLP = new NLPUtils();

        File file = Paths.get("data", "metamorphosis.txt").toFile();
        // File file = new File(Main.class.getResource("/wikipedia.txt").getFile());
        List<String> lines = FileUtils.readLines(file);
        ArrayList<Verbs> lista = new ArrayList();
        String homma = "";
        for (String line : lines) {
            for (String sentence : NLP.detectSentences(line)) {
                // logic here  
                if (sentence.toLowerCase().contains("gregor")) {
                    Parse root = NLP.parse(sentence);

                    if (Extractor.extractSubject(root).toLowerCase().equals("gregor")) {
                        System.out.println(root.getText());
                        homma = homma + " " + root.getText();

                    }
                }
            }
        }

        String[] mm = homma.split(" ");

        for (int i = 0; i < mm.length; i++) {
            boolean ihanko = false;

            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getText().equals(mm[i])) {
                    lista.get(j).add();
                    ihanko = true;
                }
            }
            if (ihanko == false) {
                lista.add(new Verbs(mm[i]));
            }

        }
        Collections.sort(lista);
        for (Verbs verbs : lista) {
            System.out.println(verbs.toString());
        }

    }

}
