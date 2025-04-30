package InterviewPracticePackage;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InterviewPracticeCode {
    static void Q1() {
        //reverse only last name
        String s = "Sreelakshmi Kuruthatt";
        String firstName = s.split(" ")[0];
        String lastName = s.split(" ")[1];
        StringBuilder sb = new StringBuilder(lastName);
        String rev = sb.reverse().toString();
        String total = firstName + " " + rev;
        System.out.println(total);
    }

    static void Q2() {
        //Print the vowels in a given string
        String s = "Confident";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                System.out.print(c);

            }
        }

    }

    static void Q3() {
        //find the occurance of word
        String s = "Hello good morning morning ";
        Map<String, Integer> table = new HashMap<>();
        String[] words = s.split(" ");
        for (String word : words) {
            if (table.containsKey(word)) {
                table.put(word, table.get(word) + 1);
            } else {
                table.put(word, 1);
            }
        }
        for (String word : table.keySet()) {
            System.out.println(word + " " + table.get(word));
        }
    }

    static void Q4() {
        String s = "hello";
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (newString.indexOf(c) < 0) {
                newString = newString + c;
            }
        }
        System.out.println(newString);

    }
    static void Q5(){
    int[] arr= {0,0,9,0,0,8,9};
    int count=0;
    int []newArr=new int[arr.length];
    for(int i=0;i<arr.length;i++){
        if(arr[i]!=0){
            newArr[count]=arr[i];
            count++;
        }
    }
        System.out.println(Arrays.toString(newArr));
    }

static void Q6(){
    int[] arr= {0,0,9,0,0,8,9};
    int count=arr.length-1;
    int []newArr=new int[arr.length];
    for(int i=0;i<arr.length;i++){
        if(arr[i]!=0){
            newArr[count]=arr[i];
            count--;
        }
    }
    System.out.println(Arrays.toString(newArr));
}
}
