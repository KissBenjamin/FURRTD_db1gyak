import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class FURRTD_2_6 implements Serializable {
    public static void main(String[] args) {
        hf4();
        try {
            visszaolvas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static final long serialVersionUID = 1L;
    String rsz;
    String tipus;
    int ar;

    public FURRTD_2_6(String r, String t, int a) {
        this.rsz = r;
        this.tipus = t;
        this.ar = a;
    }
    public static void hf4() {
        FURRTD_2_6[] autoim = { new FURRTD_2_6("R11", "Opel", 333), new FURRTD_2_6("R12", "Fiat", 233),
                new FURRTD_2_6("R14", "Skoda", 364) };
        try {
            ObjectOutputStream kifile = new ObjectOutputStream(new FileOutputStream("src/Autok.dat"));
            for (FURRTD_2_6 auto : autoim) {
                kifile.writeObject(auto);
            }
            kifile.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File nyitasi hiba");
        }
        System.out.println("OK");
    }
    public static void visszaolvas() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int db=0;
        System.out.println("Hanyadik rekordot szeretne visszaolvasni? Eddig " + db + " adat van");
        boolean ok = true;
        int olvas = 0;
        do {
            try {
                ok = true;
                olvas = sc.nextInt();
                if (olvas <= 0 || olvas > 10) {
                    System.out.println("nem jo szamot adott meg");
                    ok = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
                ok = false;
            }
        } while (!ok);

        sc.close();

        int sor =1;
        FURRTD_2_6 ma;
        try {
            File fn = new File("src/Autok.dat");
            if (fn.exists()) {
                ObjectInputStream kifile = new ObjectInputStream(new FileInputStream("src/Autok.dat"));
                try {
                    while (true) {
                        ma = (FURRTD_2_6) kifile.readObject();
                        if (sor==olvas) {
                            System.out.println("rendszam=" + ma.rsz);
                            System.out.println("tipus=" + ma.tipus);
                            System.out.println("ar=" + ma.ar);
                        }
                        sor++;
                    }
                } catch (EOFException ee) {
                    ma = null;
                }
                kifile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File nyitasi hiba");
        }
        System.out.println("OK2");

        sc.close();



    }

}