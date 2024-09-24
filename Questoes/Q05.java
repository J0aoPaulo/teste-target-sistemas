/*
5) Escreva um programa que inverta os caracteres de um string.
*/

package Questoes;

public class Q05 {
    public static void main(String[] args) {
        String original = "teste target sistemas";
        String invertida = inverterString(original);
        System.out.println("String invertida: " + invertida);
    }

    private static String inverterString(String str) {
        StringBuilder invertida = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            invertida.append(str.charAt(i));
        }
        return invertida.toString();
    }
}
