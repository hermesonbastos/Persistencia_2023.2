// 1. Crie uma aplicação em Java que recebe via linha de comando: (1) o nome de um arquivo CSV; (2) o delimitador usado para separar os campos do arquivo; (3) uma lista de nomes das colunas do arquivo CSV que serão processados. Considere que o arquivo CSV (1) deva ter um cabeçalho com os nomes das colunas em sua primeira linha e que não tenha internamente colunas com Strings contendo o mesmo caractere usado como delimitador (2). A aplicação deve exibir a soma e a média das colunas selecionadas em (3), caso tenham dados numéricos. Se não tiverem dados numéricos, somente exibir que aquela coluna não é numérica. Não usar bibliotecas externas para resolver esta questão (usar Java puro). Sugere-se navegar apenas uma única vez em cada linha do arquivo CSV. Fazer a aplicação de modo que ela possa processar arquivos CSV extremamente grandes, mesmo que não caibam na memória RAM. Dica: usar o método split da classe String para separar os valores das colunas em cada linha do arquivo CSV.

package Atividades.pratica_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Tente: Q1.java <arquivoCSV> <delimitador> <nomeDasColunas>");
            System.exit(1);
        }

        String[] wanted = args[2].split(",");

        try {
            BufferedReader br = new BufferedReader(new FileReader("texts/" + args[0]));
            String line = br.readLine();
            String[] headers = line.split(args[1]);
            int[] wantedIndex = new int[wanted.length];
            int wi = 0;

            for (int i = 0; i < wanted.length; i++) {
                for (int j = 0; j < headers.length; j++) {
                    if (wanted[i].equals(headers[j])) {
                        wantedIndex[wi] = j;
                        wi++;
                        break;
                    }
                }
            }

            String[] values = new String[headers.length];
            double[] sum = new double[wanted.length];
            int[] count = new int[wanted.length];
            boolean hasNonNumericData = false;

            while ((line = br.readLine()) != null) {
                values = line.split(args[1]);

                for (int i = 0; i < wantedIndex.length; i++) {
                    for (int j = 0; j < values.length; j++) {
                        if (wantedIndex[i] == j) {
                            try {
                                double numericValue = Double.parseDouble(values[j]);
                                sum[i] += numericValue;
                                count[i]++;
                                break;
                            } catch (NumberFormatException e) {
                                hasNonNumericData = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (hasNonNumericData) {
                System.out.println("Atenção: Pelo menos uma das colunas contém valores não numéricos.");
            } else {
                for (int i = 0; i < sum.length; i++) {
                    System.out.println(wanted[i] + " total: " + sum[i]);
                    System.out.println(wanted[i] + " medio(a): " + sum[i]/count[i] + "\n");
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
