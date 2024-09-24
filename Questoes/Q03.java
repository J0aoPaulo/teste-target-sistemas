/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
*/

package Questoes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q03 {
    public static void main(String[] args) {
        String caminhoArquivo = "Questoes/dados.json";

        try {
            StringBuilder conteudoJson = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                conteudoJson.append(linha);
            }
            bufferedReader.close();

            JSONArray faturamentos = new JSONArray(conteudoJson.toString());

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentos.length(); i++) {
                JSONObject diaFaturamento = faturamentos.getJSONObject(i);
                double valor = diaFaturamento.getDouble("valor");

                if (valor > 0) {
                    if (valor < menorValor) menorValor = valor;
                    if (valor > maiorValor) maiorValor = valor;
                    soma += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = soma / diasComFaturamento;
            int diasAcimaDaMedia = 0;

            for (int i = 0; i < faturamentos.length(); i++) {
                double valor = faturamentos.getJSONObject(i).getDouble("valor");
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibe os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da média mensal: " + diasAcimaDaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (org.json.JSONException e) {
            System.err.println("Erro ao processar o JSON: " + e.getMessage());
        }
    }
}
