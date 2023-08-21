import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String filePath;
        Scanner sc = new Scanner(System.in);

        Boolean close = false;
        int op = 0;

        while(!close){
            System.out.println("Digite 1 para ler um arquivo.");
            System.out.println("Digite 2 para sair.");
            op = sc.nextInt();
            sc.nextLine();

            switch(op){
                case 1:
                    try {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Digite o nome do arquivo a ser lido: ");
                        String fileName = sc.nextLine();
                        filePath = "alt/texts/" + fileName;
                        File file = new File(filePath);
                        Scanner re = new Scanner(file);
                        for(int i = 0; i < 10; i++) {
                            String line = re.nextLine();
                            System.out.println((i + 1) + ". " + line);
                        }
                        System.out.println("\n\n");
                        re.close();
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("Erro ao ler arquivo:" + e);
                    }
                break;
                case 2:
                    close = true;
            }
        }

        sc.close();
    }
}
