import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Q3 {

    public static void readFile(String file) {
        try (InputStream is = new FileInputStream("texts/" + file)) {

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            while(br.readLine() != null) {
                System.out.println(br.readLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Por favor, use: java Q3.java <nomeDoArquivo1> <nomeDoArquivo2>");
            return;
        }

        String file1 = args[0];
        String file2 = args[1];

        readFile(file1);
        readFile(file2);
    }
}
