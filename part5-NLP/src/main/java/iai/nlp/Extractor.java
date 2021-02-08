package iai.nlp;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import opennlp.tools.parser.Parse;

public class Extractor {

    /**
     * Finds the subject of a sentence from a syntax tree.
     *
     *
     * @param root root of the tree (S)
     * @return Subject as a String
     */
    public static String extractSubject(Parse root) {

        Parse np = null;
        if (!(root == null)) {
            if (root.getChildCount() > 0) {
                Parse[] ihasama = root.getChildren();

                for (Parse parse : ihasama) {
                    if (parse.getType().equals("NP")) {
                        np = parse;
                    }
                }
            }
        }
        if (np == null) {
            return "";
        }

        HashSet<Parse> visited = new HashSet();

        ArrayDeque<Parse> list = new ArrayDeque();
        list.add(np);

        while (!list.isEmpty()) {
            Parse node = list.pollFirst();

            if (!visited.contains(node)) {
                visited.add(node);
                if (node.getType().equals("NN") || node.getType().equals("NNP") || node.getType().equals("NNPS") || node.getType().equals("NNS")) {
                    return node.getCoveredText();
                }

                Parse[] lapset = node.getChildren();

                for (Parse parse : lapset) {
                    list.addLast(parse);
                }

            }
        }

        return "";
    }

    public static String extractVerb(Parse root) {
        Parse np = null;
        if (!(root == null)) {
            if (root.getChildCount() > 0) {
                Parse[] ihasama = root.getChildren();

                for (Parse parse : ihasama) {
                    if (parse.getType().equals("VP")) {
                        np = parse;
                    }
                }
            }
        }
        if (np == null) {
            return "";
        }

        HashSet<Parse> visited = new HashSet();

        ArrayDeque<Parse> list = new ArrayDeque();
        list.add(np);

        while (!list.isEmpty()) {
            Parse node = list.pollFirst();

            if (!visited.contains(node)) {
                visited.add(node);
                if (node.getType().startsWith("VB")) {
                    return node.getCoveredText();
                }

                Parse[] lapset = node.getChildren();

                for (Parse parse : lapset) {
                    list.addLast(parse);
                }

            }
        }

        return "";

    }

}
