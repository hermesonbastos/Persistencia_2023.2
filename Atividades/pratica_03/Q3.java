// 3. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

// arquivo config.properties
// arquivo = meu_arquivo.txt
// linha_inicial = 1
// linha_final = 3
// Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties.


package Atividades.pratica_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Properties properties = new Properties();
        properties.load(new FileReader("config.properties"));

        String arquivo = properties.getProperty("arquivo");

        int linhaInicial = Integer.parseInt(properties.getProperty("linha_inicial"));

        int linhaFinal = Integer.parseInt(properties.getProperty("linha_final"));

        FileReader reader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(reader);

        int linha = 1;
        while (bufferedReader.ready()) {
            String linhaTexto = bufferedReader.readLine();
            if (linha >= linhaInicial && linha <= linhaFinal) {
                System.out.println(linhaTexto);
            }
            linha++;
        }

        reader.close();
    }
}
