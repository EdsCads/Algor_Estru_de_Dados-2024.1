package Questao1;

public class Hash {

    public static int of(String frase){
        int hashValue = 0;
        for (int i = 0; i < frase.length(); i++) {
            hashValue = (((int)Math.pow(frase.charAt(i),i+1) * 31)  + hashValue);
        }
        return Math.abs(hashValue);
    }

}
