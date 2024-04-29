package Questao2;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //Leitura do arquivo de Entrada 1
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Entrada\\Entrada1.txt"))){
            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Saida\\Saida1.txt"));

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println("Calculando hash para a linha: " + linha);
                String hash = Hash.md5(linha); // Calcula o hash da linha
                System.out.println("Hash calculado: " + hash);
                bw.write(hash);
                bw.newLine();
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Leitura do arquivo de Entrada 2
        try (BufferedReader br = new BufferedReader(new FileReader("src\\Entrada\\Entrada2.txt"))){
            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Saida\\Saida2.txt"));

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println("Buscando original para o hash: " + linha);
                String original = buscarOriginal(linha);
                if(original!=null){System.out.println("Original encontrado: " + original);
                bw.newLine();
                bw.write(original);}
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buscarOriginal(String chave){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\Entrada\\Entrada1.txt"))) {
            System.out.println("Achei arquivo");
            String linha;
            while ((br.ready())) {
                linha = br.readLine();
                System.out.println("Calculando hash para a linha: " + linha);
                String hash = Hash.md5(linha); // Calcula o hash da linha
                System.out.println("Hash calculado: " + hash);
                if (hash.equals(chave)) {
                    br.close();
                    return linha;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
