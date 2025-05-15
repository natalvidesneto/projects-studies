import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String caminho;
        String nomeacao;
        String linha;
        String linha2;
        Scanner scanner = new Scanner(System.in);
        
        try {
            String finalizar;
            int i = 0;
            System.out.println("Informe o nome do arquivo:");
            nomeacao = scanner.nextLine();
            String nomeArquivo = nomeacao + ".txt";
            // Local para gravação do arquivo .txt
            caminho = "C:\\Users\\User\\Documents" + "\\" + nomeArquivo;
            
            // Usando FileWriter com modo de acréscimo definido como verdadeiro
            FileWriter fileWriter = new FileWriter(caminho);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            System.out.println("Abrir editor? (s/n)");
            String abrir = scanner.nextLine();
            if (abrir.equalsIgnoreCase("s")) {  // Comparação de strings fixas
                System.out.println("Editor aberto. Pode digitar.");
                do {
                    System.out.print("Linha - " + i + " : ");
                    linha = scanner.nextLine();
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();  // Adicionar nova linha após cada entrada
                    i++;
                    System.out.println("Deseja continuar? (s/n)");
                    finalizar = scanner.nextLine();
                } while (finalizar.equalsIgnoreCase("s"));  // Comparação de strings fixas e condição de loop
            }
            bufferedWriter.close();  // Feche o escritor antes de ler
            
            System.out.println("Deseja ler o arquivo? (s/n)");
            String ler = scanner.nextLine();
            if (ler.equalsIgnoreCase("s")) {
                FileReader fileReader = new FileReader(caminho);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                System.out.println("Conteúdo do arquivo:");
                while ((linha2 = bufferedReader.readLine()) != null) {
                    System.out.println(linha2);
                }
                bufferedReader.close();
            }
            
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();  // Sempre imprimir exceções para depuração
        }
    }
}
