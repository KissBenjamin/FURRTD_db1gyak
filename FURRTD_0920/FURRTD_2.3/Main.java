import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int sorid = 0;
        try {
            System.out.println("Az elso szo a txt fajl neve\n");
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = null;
            System.out.println("irj szavakat, a program az 'end' szoig olvas!\n");
            while (sorid >= 0) {
                final String sor = br.readLine();
                if (sorid == 0) {
                    bw = new BufferedWriter(new FileWriter("src/"+sor));
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
    }
}