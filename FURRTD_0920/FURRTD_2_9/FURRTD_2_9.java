import java.io.*;

public class FURRTD_2_9 implements Serializable
{
    private static final long serialVersionUID = 1L;
    String rsz;
    String tipus;
    int ar;
    private static int db;

    static {
        FURRTD_2_9.db = 0;
    }

    public FURRTD_2_9(final String rsz, final String tipus, final int ar) {
        this.rsz = rsz;
        this.tipus = tipus;
        this.ar = ar;
    }

    public static void main(final String[] args) {
        input();
        try {
            average();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            redCar();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            mostExpensive();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void input() {
        final FURRTD_2_9[] autoim = { new FURRTD_2_9("R11", "piros", 789), new FURRTD_2_9("R12", "fekete", 453), new FURRTD_2_9("R14", "z\u00f6ld", 124) };
        FURRTD_2_9.db = autoim.length;
        try {
            final ObjectOutputStream fileout = new ObjectOutputStream(new FileOutputStream("src/Autok.dat"));
            FURRTD_2_9[] array;
            for (int length = (array = autoim).length, i = 0; i < length; ++i) {
                final FURRTD_2_9 auto = array[i];
                fileout.writeObject(auto);
            }
            fileout.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hiba a fajl megnyitasa soran!\n");
        }
        System.out.println("OK");
    }

    public static void mostExpensive() throws FileNotFoundException {
        try {
            final File fn = new File("src/Autok.dat");
            if (fn.exists()) {
                final ObjectInputStream fileout = new ObjectInputStream(new FileInputStream("src/Autok.dat"));
                FURRTD_2_9 max = (FURRTD_2_9)fileout.readObject();
                try {
                    while (true) {
                        final FURRTD_2_9 ma = (FURRTD_2_9)fileout.readObject();
                        if (ma.ar > max.ar) {
                            max = ma;
                        }
                    }
                }
                catch (EOFException ee) {
                    final FURRTD_2_9 ma = null;
                    fileout.close();
                    System.out.println("A legdragabb auto rendszama: " + max.rsz + " ara: " + max.ar);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hiba a fajl megnyitasa soran!\n");
        }
    }

    public static void redCar() throws FileNotFoundException {
        int pirosak = 0;
        try {
            final File fn = new File("src/Autok.dat");
            if (fn.exists()) {
                final ObjectInputStream fileout = new ObjectInputStream(new FileInputStream("src/Autok.dat"));
                try {
                    while (true) {
                        final FURRTD_2_9 ma = (FURRTD_2_9)fileout.readObject();
                        if (ma.tipus.equalsIgnoreCase("piros")) {
                            ++pirosak;
                        }
                    }
                }
                catch (EOFException ee) {
                    final FURRTD_2_9 ma = null;
                    fileout.close();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hiba a fajl megnyitasa soran!\n");
        }
        System.out.println("Piros autok szama: " + pirosak);
    }

    public static void average() throws FileNotFoundException {
        int sum = 0;
        try {
            final File fn = new File("src/Autok.dat");
            if (fn.exists()) {
                final ObjectInputStream fileout = new ObjectInputStream(new FileInputStream("src/Autok.dat"));
                try {
                    while (true) {
                        final FURRTD_2_9 ma = (FURRTD_2_9)fileout.readObject();
                        sum += ma.ar;
                    }
                }
                catch (EOFException ee) {
                    final FURRTD_2_9 ma = null;
                    fileout.close();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hiba a fajl megnyitasa soran!\n");
        }
        System.out.println("Az autok atlagara: " + sum / FURRTD_2_9.db);
    }
}