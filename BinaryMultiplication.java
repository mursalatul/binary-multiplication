import java.util.Scanner;

public class BinaryMultiplication {

    // print calculations
    public static void print(Initializing b_data, String mode) {
        System.out.println(b_data.c + "\t" + b_data.a + "\t" + b_data.q + "\t" + b_data.m + " (" + mode + ")");
    }

    // check input format
    public static boolean inputHealth(String a) {
        boolean status = true;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c != '0' && c != '1') {
                status = false;
                break;
            }
        }
        return status;
    }

    // take input
    public static String input() {
        Scanner ipt = new Scanner(System.in); // setup input stream
        String x;
        while (true) {
            x = ipt.nextLine();
            if (inputHealth(x) == true) {
                break;
            }
            else {
                System.out.print("Please enter a binary number!\n: ");
            }
        }
        return x;
    }

    public static void main(String[] args) {
        // taking the inputs
        String x, y;
        System.out.print("Enter the values\n  Q: ");
        x = input();
        System.out.print("  M: ");
        y = input();

        // initialing the binary datas
        Initializing binary = new Initializing(x, y);

        // for iterating (from back) to determine add+shift or just shift (1=add+shift,
        // 0=shift)
        String add_shift_indicator = binary.q; // storing copy of q

        // creating printing format
        System.out.println("C\tA\tQ\tM");
        print(binary, "initial value");

        for (int i = binary.len - 1; i >= 0; i--) {
            // binary summation of a and m
            if (add_shift_indicator.charAt(i) == '1') {
                binary.add();
                print(binary, "add");
            }
            // right shift
            binary.shift();
            print(binary, "shift");
        }

        // concatanation
        String mul = binary.c + binary.a + binary.q;
        System.out.println("------------------------------------------------------");
        System.out.println("Binary Multiplication: " + add_shift_indicator + " x " + binary.m + " = " + mul);

    }
}
