package Atividades.pratica_02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Q3 {
    public static void main(String[] args) {
        try (
            InputStream is = new FileInputStream("texts/" + args[0]);
            OutputStream os = new FileOutputStream("texts/" + args[1]);
        ) {
            
            InputStreamReader isr = new InputStreamReader(is, "ISO-8859-1");
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

            int c;
            while((c = isr.read()) != -1){
                osw.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
