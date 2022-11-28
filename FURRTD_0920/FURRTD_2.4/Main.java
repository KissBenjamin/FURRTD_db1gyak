import java.io.*;

public class Main {
    public static String olvas() {
        int sorid = 0;
        String nev = "ok";
        try {
            System.out.println("Az els\u00f5 sz\u00f3 a txt f\u00e1jl neve");
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = null;
            System.out.println("\u00cdrj szavakat, a program 'end' sz\u00f3ig olvas!\n");
            while (sorid >= 0) {
                final String sor = br.readLine();
                if (sorid == 0) {
                    bw = new BufferedWriter(new FileWriter("src/" + sor));
                    nev = sor;
                }
                else {
                    bw.write(sor);
                    bw.newLine();
                }
                ++sorid;
                final String[] szavak = sor.split(" ");
                String[] array;
                for (int length = (array = szavak).length, i = 0; i < length; ++i) {
                    final String sz = array[i];
                    if (sz.compareTo("end") == 0) {
                        br.close();
                        sorid = -1;
                    }
                }
            }
            bw.close();
            System.out.println("Ok");
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        return nev;
    }
    public static void main(String[] args) {
        try {
            final BufferedReader br = new BufferedReader(new FileReader("src/" + olvas()));
            String sor;
            while ((sor = br.readLine()) != null) {
                System.out.println(sor.toUpperCase());
            }
            br.close();
            System.out.println("Ok");
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}