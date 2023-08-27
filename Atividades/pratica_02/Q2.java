package Atividades.pratica_02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Q2 {
    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.err.println("Use: java Q1.java <arquivoDeEntrada> <arquivoDeSaida>");
            System.exit(1);
        }

        long startTime = System.currentTimeMillis();

        try(
            InputStream is = new FileInputStream("texts/" + args[0]);
            OutputStream os = new FileOutputStream("texts/" + args[1]);
        ) {
            
            byte[] buffer = new byte[8192];
            int bytesNum;

            while((bytesNum = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesNum);
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("Saída do Q2.java:" +"\nTempo de E/S: " + totalTime + " ms\n");

            // roda o código da Q1.java
            ProcessBuilder processBuilder = new ProcessBuilder("java", "Q1.java", "inputQ1.txt", "outputQ1.txt");
            Process process = processBuilder.start();

            // captura a saída do Q1.java
            InputStream inputStream = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder q1Output = new StringBuilder();
            while ((line = br.readLine()) != null) {
                q1Output.append(line);
            }

            System.out.println("Saída do Q1.java:\n" + q1Output.toString() + "\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
