import java.util.*;
import java.text.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("Enter the no of liters to fill the tank");
        double l = sc.nextDouble();
        if (l <= 0) {
            System.out.println((int) l + " is an Invalid Input");
            System.exit(0);
        }
        System.out.println("Enter the distance covered");
        double d = sc.nextDouble();
        if (d <= 0) {
            System.out.println((int) d + " is an Invalid Input");
            System.exit(0);
        }

        double g = l * 0.2642;
        double m = d * 0.6214;
        double literPerKm = (l / d) * 100;
        double gallonPerKm = m / g;

        System.out.println("Liters/100KM");
        System.out.println(decimalFormat.format(literPerKm));
        System.out.println("Miles/gallons");
        System.out.println(decimalFormat.format(gallonPerKm));

    }
}