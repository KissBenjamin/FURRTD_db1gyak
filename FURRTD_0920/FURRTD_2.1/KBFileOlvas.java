import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KBFileOlvas {
    public static void read_text_file(final int olvas) {
        final String fnev = "src/kiss.txt";
        int db = 0;
        int sum = 0;
        try {
            final File myObj = new File(fnev);
            Scanner sc;
            for (sc = new Scanner(myObj); sc.hasNextLine() && db < olvas; ++db) {
                final int szam = sc.nextInt();
                sum += szam;
                System.out.println("A(z) " + db + ". adat: " + szam);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Hiba!\n");
            e.printStackTrace();
        }
        System.out.println("Az \u00f6sszeg: " + sum);
    }

}
