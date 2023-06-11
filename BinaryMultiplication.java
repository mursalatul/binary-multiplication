import java.util.Scanner;

import packages.dataformat.Initializing;


public class BinaryMultiplication {
    
    // print calculations
    public static void print(Initializing b_data, String mode) {
        System.out.println(b_data.c + "\t" + b_data.a + "\t" + b_data.q + "\t" + b_data.m + " (" + mode + ")");
    }

    public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
        String x, y;
        System.out.print("Enter the vale of q and m: ");
        
        x = input.next();
        y = input.next();
        // System.out.println(x.length() + " " + y.length());

        Initializing binary = new Initializing(x, y);
        
        // for iterating (from back) to determine add+shift or just shift (1->add+shift, 0->shift)
        String add_shift_indicator = binary.q;
        
        // creating printing format
        System.out.println("C\tA\tQ\tM");
        print(binary, "initial value");
        
        for (int i = binary.len - 1; i >= 0; i--) {
            // add
            if (add_shift_indicator.charAt(i) == '1') {
                binary.add();
                print(binary, "add");
            }
            binary.shift();
            print(binary, "shift");
        }
        
        String mul = binary.c + binary.a + binary.q;

        System.out.println("So, \n" + add_shift_indicator + " x " + binary.m + " = " + mul);
        

        input.close();
    }
}
