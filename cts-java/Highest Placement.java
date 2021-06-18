import java.io.*;
import java.util.*;

class Placement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of students placed in CSE:");
        int c = sc.nextInt();
        System.out.println("Enter the no of students placed in ECE:");
        int e = sc.nextInt();
        System.out.println("Enter the no of students placed in MECH:");
        int m = sc.nextInt();
        if (c < 0 || e < 0 || m < 0) {
            System.out.println("Input is Invalid");
        } else if (c == e && e == m && m == c) {
            System.out.println("None of the department has got the highest placement");
        } else {
            int max = 0;
            if (max <= c)
                max = c;
            if (max <= e)
                max = e;
            if (max <= m)
                max = m;
            System.out.println("Highest placement");
            if (max == c)
                System.out.println("CSE");
            if (max == e)
                System.out.println("ECE");
            if (max == m)
                System.out.println("MECH");
        }
    }
}