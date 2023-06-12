package packages.dataformat;

/**
 * initialize the value of carry bit, add bits, and the two values q and m. here q and m is the targeted value.
 * 
 * @author Md Mursalatul Islam Pallob
*/
public class Initializing {
    public String c = "0", a = "", q, m;
    public final int len; // store the len of the bits(here len of c = a = q = m)

    public Initializing (String x, String y) {
        // setting the len (max len)
        if (x.length() >= y.length()) {
            len = x.length();
        }
        else {
            len = y.length();
        }

        q = x;
        m = y;
        formatLen();
    }

    // add zeros
    private String addZero(int num_of_zeros_added, String s) {
        String temp_zeros = "";
        for (int i = 0; i < num_of_zeros_added; i++) {
            temp_zeros += "0";
        }
        s = temp_zeros + s;
        return s;
    }

    // make the 3 binary number same size
    private void formatLen() {
        // converting q and m same lenght
        if (q.length() > m.length()) {
            // add leading zeros with m
            m = addZero(q.length() - m.length(), m);
        }
        else {
            // add leading zeros with q
            q = addZero(m.length() - q.length(), q);
        }
        // initialize a(at first it will contain only zeros)
        a = addZero(q.length(), a);
    }

    // add a and m
    public void add() {
        // convert a and m into integer number
        int int_a = Integer.parseInt(a, 2);
        int int_m = Integer.parseInt(m, 2);

        // convert the summation of a and b into binary String again
        String temp_sum = Integer.toBinaryString(int_a + int_m);
        if (temp_sum.length() > len) {
            c = "1";
            // no need to use addZero as len of temp_sum is already greater then len. so there is a carry
            // placing the sum in a
            a = "";
            for (int i = 1; i < len + 1; i++) {
                a += temp_sum.charAt(i);
            }
        }
        else {
            c = "0";
            
            // front zeros can be auto deleted. so fixing the lenght again after calculating summation.
            // for currect bit shifting len of a must be equal to len of q
            temp_sum = addZero(len - temp_sum.length(), temp_sum); 
            // placing the sum in a
            a = "";
            for (int i = 0; i < len; i++) {
                a += temp_sum.charAt(i);
            }
        }
    }

    // shift 
    public void shift() {
        String temp_a = "", temp_q = "";
        
        // shifting carry
        temp_a += c;
        c = "0";
        // shifting a
        for (int i = 0; i < len - 1; i++) { // run len - 1 times cause already value of c is shifted
            temp_a += a.charAt(i);
        }

        // shifting q
        temp_q += a.charAt(len - 1);
        for (int i = 0; i < len - 1; i++) {
            temp_q += q.charAt(i);
        }
        a = temp_a;
        q = temp_q;
        
    }
}
