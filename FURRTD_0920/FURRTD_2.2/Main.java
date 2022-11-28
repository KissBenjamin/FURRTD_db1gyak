import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Add meg hany adatot szeretnel beolvasni: ");
        boolean ok = true;
        int olvas = 0;
        do {
            try {
                ok = true;
                olvas = sc.nextInt();
                if (olvas <= 0 || olvas > 10) {
                    System.out.println("Nem megfelelo szamot adott meg!\n");
                    ok = false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(e);
                ok = false;
            }
        } while (!ok);
        KBFileIr.write_text_file(olvas);
        KBFileIr.read_text_file(olvas);
        sc.close();
    }
}