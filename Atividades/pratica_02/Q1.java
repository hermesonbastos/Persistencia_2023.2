package Atividades.pratica_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Q1 {
    public static void main(String[] args) throws IOException {

        if(args.length != 2){
            System.err.println("Use: java Q1.java <arquivoDeEntrada> <arquivoDeSaida>");
            System.exit(1);
        }

        long startTime = System.currentTimeMillis();

        try(
            InputStream is = new FileInputStream("texts/" + args[0]);
            OutputStream os = new FileOutputStream("texts/" + args[1]);
        ) {
            int byteRead;
            while((byteRead = is.read()) != -1){
                os.write(byteRead);
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("\nTempo de E/S: " + totalTime + " ms\n");
        } catch(FileNotFoundException e) {
            System.err.println(e);
        }

    }
}
