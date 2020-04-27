package com.stackroute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class RepeatedCharacter {

    //Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
        //Use Scanner to get input from console
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char out = RepeatedCharacter.findRepeatedCharacter(input);
        System.out.println(out);


    }

    public static Character findRepeatedCharacter(String input) {


        Map<Character, Integer> repmap = new HashMap<Character, Integer>();
        Map<Character, Integer> repmap1 = new HashMap<Character, Integer>();


        List<Character> replist = new ArrayList<Character>();
        Character key = null;
        Character listval = null;
        Integer value = 0;
        char outchar;
        int val = 0;
        int asciiCode = 0;

        if (input.isEmpty() || input == null) {

            return 0;
        }
        //convert lowercase to uppercase
        String output = input.toLowerCase();
        //System.out.println(output);
        for (int i = 0; i < output.length(); i++) {
            char keys = output.charAt(i);
            //adding each character and count of each character to hashmap

            if (repmap.containsKey(keys)) {
                repmap.replace(keys, repmap.get(keys) + 1);
            } else {
                repmap.put(keys, 1);
            }
        }
        //System.out.println(repmap);

        //find max


        int max = 0;
        replist.add(null);
        for (char KEY : repmap.keySet()) {
            val = repmap.get(KEY);

            if (val > max) {
                max = val;
                replist.clear();
                replist.add(KEY);

            } else if (val == max) {
                // no change in max
                replist.add(KEY);

            }


        }
        //System.out.println(replist);

        int listsize = replist.size();
        if (listsize == 1) {
            //only one element is reapeated many times
            //return the character
            outchar = replist.get(0);
            //System.out.println(outchar);
            return outchar;


        } else {
            //list has multiple elements
            for (int y = 0; y < replist.size(); y++) {
                listval = replist.get(y);
                asciiCode = listval;
                repmap1.put(listval, asciiCode);
            }
            //System.out.println(repmap1);

        }
        // sorting array in ascending order
        Map<Character, Integer> treeMap = new TreeMap<Character, Integer>(repmap1);
        System.out.println(treeMap);
        char firstKey = (char) repmap1.keySet().toArray()[0];
        //System.out.println(firstKey);
        return firstKey;


    }
}