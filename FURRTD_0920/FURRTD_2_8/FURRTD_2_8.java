import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class FURRTD_2_8
{
    private static FURRTD_2_8[] adatok;
    private String id;
    private String name;
    private static int sum;

    public FURRTD_2_8(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FURRTD_2_8 [id=" + this.id + ", name=" + this.name + "]";
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static int getSum() {
        return FURRTD_2_8.sum;
    }

    public static void setSum(final int sum) {
        FURRTD_2_8.sum = sum;
    }

    private static int mennyiAdat(final Scanner sc) {
        System.out.println("H\u00e1ny adatot szeretn\u00e9l megadni? ");
        boolean ok = true;
        int read = 0;
        do {
            try {
                ok = true;
                read = sc.nextInt();
                if (read <= 0) {
                    System.out.println("Helytelen sz\u00e1m!\n");
                    ok = false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(e);
                ok = false;
            }
        } while (!ok);
        return read;
    }

    public static FURRTD_2_8[] input(final FURRTD_2_8[] adatok, final Scanner sc) throws IOException {
        final FileWriter myWriter = new FileWriter("src/szemelyek.dat");
        for (int i = 0; i < adatok.length; ++i) {
            System.out.println("Add meg az azonos\u00edt\u00f3t: ");
            final String azonosito = sc.next();
            System.out.println("Add meg a nevet: ");
            final String nev = sc.next();
            adatok[i] = new FURRTD_2_8(azonosito, nev);
            ++FURRTD_2_8.sum;
            try {
                myWriter.write(String.valueOf(adatok[i].id) + " " + adatok[i].name + "\n");
                myWriter.flush();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        myWriter.close();
        return adatok;
    }

    public static void delete(final FURRTD_2_8[] adatok, final Scanner sc) throws IOException {
        final File file = new File("src/szemelyek2.dat");
        final File file2 = new File("src/szemelyek.dat");
        final FileWriter myWriter = new FileWriter("src/szemelyek2.dat");
        System.out.println("Hanyadik rekordot szeretned tarolni?");
        int bekert = sc.nextInt();
        --bekert;
        for (int i = 0; i < getSum(); ++i) {
            if (bekert == 0) {
                if (i != 0) {
                    myWriter.write(String.valueOf(adatok[i].id) + " " + adatok[i].name + "\n");
                    myWriter.flush();
                    setSum(getSum() - 1);
                }
            }
            else if (bekert != 0 && i != bekert) {
                myWriter.write(String.valueOf(adatok[i].id) + " " + adatok[i].name + "\n");
                myWriter.flush();
                setSum(getSum() - 1);
            }
        }
        myWriter.close();
        file2.delete();
        file.renameTo(file2);
    }

    public static void read(Scanner sc) throws IOException {
        final String fnev = "src/szemelyek.dat";
        int db = 0;
        try {
            final File myObj = new File(fnev);
            final BufferedReader buff1 = new BufferedReader(new FileReader(myObj.getAbsoluteFile()));
            sc = new Scanner(buff1);
            while (sc.hasNextLine()) {
                final String valami = sc.nextLine();
                System.out.println(db + ". adat: " + valami);
                ++db;
            }
            buff1.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Hiba!\n");
            e.printStackTrace();
        }
    }

    public static void modifies(final FURRTD_2_8[] adatok, final Scanner sc) throws IOException {
        System.out.println("Hanyadik rekordot szeretned modositani? " + getSum() + "db adat van az allomanyban.");
        final int szam = sc.nextInt();
        System.out.println("Mit szeretnel modositani?\n1.Azonosito\n2.Nev\n");
        final int mit = sc.nextInt();
        final FileWriter myWriter = new FileWriter("src/szemelyek.dat");
        for (int i = 0; i < getSum(); ++i) {
            if (i == szam - 1) {
                switch (mit) {
                    case 1: {
                        System.out.println("Add meg az uj azonositot! ");
                        final String id = sc.next();
                        adatok[i].id = id;
                        break;
                    }
                    case 2: {
                        System.out.println("Add meg az uj nevet! ");
                        final String name = sc.next();
                        adatok[i].name = name;
                        break;
                    }
                    default: {
                        System.out.println("Nincs ilyen opcio, kilepes..");
                        System.exit(-1);
                        break;
                    }
                }
            }
            myWriter.write(adatok[i].id + " " + adatok[i].name + "\n");
            myWriter.flush();
        }
        myWriter.close();
    }

    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        int szam = 0;
        while (szam != 5) {
            System.out.println("Mit szeretnel csinalni? \n1. Adatok felvitele\n2. Adatok torlese\n3. Adatok modositasa\n4. Adatok listazasa\n5. Kilepes\n\n");
            szam = sc.nextInt();
            switch (szam) {
                case 1: {
                    final int olvas = mennyiAdat(sc);
                    FURRTD_2_8.adatok = new FURRTD_2_8[olvas];
                    try {
                        input(FURRTD_2_8.adatok, sc);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                case 2: {
                    try {
                        delete(FURRTD_2_8.adatok, sc);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                case 3: {
                    try {
                        modifies(FURRTD_2_8.adatok, sc);
                    }
                    catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    continue;
                }
                case 4: {
                    try {
                        read(sc);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                case 5: {
                    System.out.println("Kilepes...\n");
                    System.exit(0);
                    break;
                }
            }
            System.out.println("ervenytelen opcio!\n");
        }
        sc.close();
    }
}