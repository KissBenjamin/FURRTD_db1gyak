import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KBFileIr {
    public static void write_text_file(final int olvas) {
        final String fnev = "src/kiss.txt";
        int db = 0;
        final Scanner sc = new Scanner(System.in);
        boolean ok = true;
        String szam = "ok";
        try {
            final FileWriter myWriter = new FileWriter(fnev);
            System.out.println("Adjon meg " + olvas + " db szamot!");
            while (db < olvas) {
                do {
                    try {
                        ok = true;
                        szam = sc.nextLine();
                    }
                    catch (NumberFormatException e) {
                        System.out.println(e);
                        ok = false;
                    }
                } while (!ok);
                ++db;
                myWriter.write(String.valueOf(szam) + "\n");
            }
            myWriter.close();
            System.out.println("Az iras sikeres volt.");
        }
        catch (IOException e2) {
            System.out.println("IO hiba");
            e2.printStackTrace();
        }
        sc.close();
    }

    public static void read_text_file(final int olvas) {
        final String fnev = "src/kiss.txt";
        int db = 0;
        try {
            final File myObj = new File(fnev);
            Scanner sc;
            for (sc = new Scanner(myObj); sc.hasNextLine() && db < olvas; ++db) {
                final int szam = sc.nextInt();
                System.out.println("Az " + db + ". adat: " + szam);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Hiba!");
            e.printStackTrace();
        }
    }
}
