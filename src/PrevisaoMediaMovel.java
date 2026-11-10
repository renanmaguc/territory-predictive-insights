import java.util.ArrayList;

public class PrevisaoMediaMovel extends EstrategiaPrevisao {
    // Atributo específico desta classe
    private int tamanhoJanela; 

    public PrevisaoMediaMovel(int tamanhoJanela) {
        // O super() chama o construtor da classe mãe (EstrategiaPrevisao)
        super("Previsão por Média Móvel"); 
        this.tamanhoJanela = tamanhoJanela;
    }

    @Override
    public double prever(ArrayList<Double> leituras) {
        if (leituras == null || leituras.isEmpty()) {
            return 0.0; // Retorna 0 se não houver leituras para evitar erros
        }

        // Garante que não vamos tentar ler mais itens do que os que existem no ArrayList
        int qtdLeituras = Math.min(this.tamanhoJanela, leituras.size());
        double soma = 0;

        // Faz um loop apenas nas últimas leituras baseadas no tamanho da janela
        for (int i = leituras.size() - qtdLeituras; i < leituras.size(); i++) {
            soma += leituras.get(i);
        }

        // Retorna a média
        return soma / qtdLeituras;
    }
}