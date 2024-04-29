package Questao1;

public class Main {

    public static void main(String[] args) {

        HashTable tabelaDois = new HashTable();

        tabelaDois.inserir("A");
        tabelaDois.inserir("B");
        tabelaDois.inserir("C");
        tabelaDois.inserir("d");
        tabelaDois.inserir("D");
        tabelaDois.inserir("f");
        tabelaDois.inserir("F");
        tabelaDois.inserir("g");
        tabelaDois.inserir("G");
        tabelaDois.inserir("P");
        tabelaDois.inserir("d");
        tabelaDois.inserir("g");
        tabelaDois.inserir("I");
        tabelaDois.inserir("P");
        tabelaDois.inserir("dgjhn");
        tabelaDois.inserir("sdh");
        tabelaDois.inserir("sdghj");
        tabelaDois.inserir("tuyh");
        tabelaDois.imprimir();
        
        System.out.println("\n\nBuscando: \n"+
        "dgjhn || " + tabelaDois.buscar("dgjhn")+
        "\nd || " + tabelaDois.buscar("d") +
        "\nI || " + tabelaDois.buscar("I"));

        System.out.println("\n\nRemovendo: dgjhn || d || I");
        tabelaDois.remover("dgjhn");
        tabelaDois.remover("d");
        tabelaDois.remover("I");

        tabelaDois.imprimir();

        System.out.println("\n\nBuscando: \n"+
        "dgjhn || " + tabelaDois.buscar("dgjhn")+
        "\nd || " + tabelaDois.buscar("d") +
        "\nI || " + tabelaDois.buscar("I"));

        

        System.out.println("Inicializando nova TabelaHash...");
        HashTable tabelaUm = new HashTable();
        
        System.out.println("\nInserindo linhas de texto do arquivo \"arquivo_50kb\"");
        tabelaUm.inserirDeArquivo("arquivo_50kb");
        tabelaUm.imprimir();
        
        System.out.println("Buscando c1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8\n"
            +tabelaUm.buscar("c1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8"));
        //
        System.out.println("Buscando 1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8\n"
            +tabelaUm.buscar("1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8"));

        System.out.println("Removendo c1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8");
        tabelaUm.remover("c1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8");
        
        System.out.println("Buscando c1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8\n"
            +tabelaUm.buscar("c1yf8w4r6i0ytqnweudfenhh3gqceckgh844akpqipmd7enfx8"));
        //
    }

}
