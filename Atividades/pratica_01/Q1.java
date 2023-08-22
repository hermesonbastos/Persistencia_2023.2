import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Q1 {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Por favor, use: java Q1.java <nomeDoArquivo>");
            return;
        }

        try (InputStream is = new FileInputStream("texts/" + args[0])) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            int x = 0;

            while((line = br.readLine()) != null && x < 10) {
                System.out.println(line);
                x++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
