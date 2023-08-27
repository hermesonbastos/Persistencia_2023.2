package Atividades.pratica_02;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine();

        while(!(line.contains("FIM"))){
            str.append(line).append("\n");
            line = sc.nextLine();
        }

        System.out.print("Informe o nome do arquivo de saída: ");
        String file = sc.nextLine();

        try(FileWriter fw = new FileWriter("texts/" + file, StandardCharsets.ISO_8859_1)) {
            fw.write(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
