import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        final String[] k1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        final String[] k2 = {"egy ", "ketto ", "harom ", "negy ", "ot ", "hat ", "het ", "nyolc ", "kilenc ", "nulla"};
        try {
            final BufferedWriter bw = new BufferedWriter(new FileWriter("src/out.txt"));
            final BufferedReader br = new BufferedReader(new FileReader("src/in.txt"));
            String sor;
            while ((sor = br.readLine()) != null) {
                for (int i = 0; i < 10; ++i) {
                    sor = sor.replace(k1[i], k2[i]);
                }
                bw.write(sor);
                bw.newLine();
            }
            br.close();
            bw.close();
            System.out.println("Ok");
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}