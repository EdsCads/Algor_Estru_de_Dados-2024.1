package Questao1_AgainDenovo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTable {

   Lista<Lista<String>> elementos;
   int max;
   int qtdElementos;

   public HashTable() {
      qtdElementos = 0;
      elementos = new Lista<>();
      max = 10;
      iniciaLista(elementos);
   }

   private void iniciaLista(Lista<Lista<String>> elementos) {
      for (int i = 0; i < max; i++) {
         elementos.inserir(new Lista<>(), i);
      }
   }

   private int gerarPosicao(String frase) {
      return Hash.of(frase) % max;
   }

   public void inserir(String frase) {
      if ((double) quantidadeElementos() / elementos.tamanho() >= 0.75) {
         resize();
      }
      if (buscar(frase) == false) {
         int posicao = gerarPosicao(frase);
         elementos.buscar(posicao).inserir(frase);
      }
   }

   public void inserirDeArquivo(String path) {
      String palavra = "";
      try (BufferedReader br = new BufferedReader(new FileReader("src\\Entrada\\" + path + ".txt"))) {
         while (br.ready()) {
            palavra = br.readLine();
            inserir(palavra);
         }
      } catch (IOException e) {
         System.out.println("Arquivo não encontrado");
      }
   }

   private int quantidadeElementos() {
      int quantidade = 0;
      for (int i = 0; i < elementos.tamanho(); i++) {
         Lista<String> atualLista = elementos.buscar(i);
         quantidade += atualLista.tamanho();
      }
      return quantidade;
   }

   public void remover(String frase) {
      if (buscar(frase) == true) {
         int posicao = gerarPosicao(frase);
         elementos.buscar(posicao).remover(frase);
      }
   }

   public void imprimir() {

      for (int i = 0; i < elementos.tamanho(); i++) {
         Lista<String> atual = elementos.buscar(i);
         System.out.println("\nLista: " + i + "- ");
         atual.exibir();
      }
   }

   public boolean buscar(String frase) {
      int posicao = gerarPosicao(frase);
      Lista<String> listaElemento = elementos.buscar(posicao);
      int hashFrase = Hash.of(frase);
      for (int i = 0; i < listaElemento.tamanho(); i++) {
         if (Hash.of(listaElemento.buscar(i)) == hashFrase) {
            listaElemento.buscar(i);
            return true;
         }
      }
      return false;
   }

   public void resize() {
      String frase = "";

      Lista<Lista<String>> novaLista = new Lista<>();
      Lista<Lista<String>> antigaLista = elementos;

      max = max + max / 2;
      iniciaLista(novaLista);
      elementos = novaLista;

      for (int i = 0; i < antigaLista.tamanho(); i++) {
         Lista<String> atual = antigaLista.buscar(i);

         for (int j = 0; j < atual.tamanho(); j++) {
            frase = atual.buscar(j);
            if (frase != null) {
               inserir(frase);
            }
         }
      }
   }

}
