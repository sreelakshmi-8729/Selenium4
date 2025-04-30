package InterviewPracticeRepeat;

import java.util.Arrays;

public class PracticeRepeat {
    static void PracticeRepeat1() {
        int[] a = {0, 0, 9, 0, 0};
        int[] newArr = new int[a.length];
        int count = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                newArr[count] = a[i];
                count--;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    static void Q1() {
        String s = "Sreelakshmi Kuruthatt";
        String firstName = s.split(" ")[0];
        String lastName = s.split(" ")[1];
        StringBuilder builder = new StringBuilder(lastName);
        String rev = builder.reverse().toString();
        System.out.println(firstName + " " + rev);
    }

    static void Q2() {
        //Find the largest, 2nd largest and smallest number from an array

        //Approach 1
        int[] a = {32, 42, 22, 3, 43};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("Second Max: " + a[a.length - 2]);
        System.out.println("Minimum: " + a[0]);

        //Approach 2
        a = new int[]{-32, -42, -22, -3, -43};
        int max = Integer.MIN_VALUE; //34
        int secMax = Integer.MIN_VALUE; //28

        for(int i=0; i<a.length;i++){
            if(a[i]>max){ //28
                secMax = max;
                max = a[i];
            }else{
                if(a[i]>secMax){
                    secMax = a[i];
                }
            }
        }
        System.out.println("Second Max: " + secMax);

        // find the minimum
        a = new int[]{265,310,289,211,301};
        int min = Integer.MAX_VALUE;
        for(int i=0; i<a.length;i++){
            if(a[i]<min){
               min=a[i];
            }
        }
        System.out.println("Min Value: "+min);
    }
}
