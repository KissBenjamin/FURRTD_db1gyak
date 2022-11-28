import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("A beolvasando ertekek szama: ");
        boolean ok = true;
        int olvas = 0;
        do {
            try {
                ok = true;
                olvas = sc.nextInt();
                if (olvas <= 0 || olvas > 10) {
                    System.out.println("a megadott szam nem megfelelo!\n");
                    ok = false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(e);
                ok = false;
            }
        } while (!ok);
        KBFileOlvas.read_text_file(olvas);
        sc.close();
    }
}