import java.util.ArrayList;

public class PrevisaoComparacao extends EstrategiaPrevisao {
    // Atributo específico desta classe
    private double fatorAjuste; 

    public PrevisaoComparacao(double fatorAjuste) {
        super("Previsão por Comparação"); // Chama a classe mãe
        this.fatorAjuste = fatorAjuste;
    }

    @Override
    public double prever(ArrayList<Double> leituras) {
        if (leituras == null || leituras.size() < 2) {
            return 0.0; // Precisa de pelo menos 2 leituras para comparar
        }

        // Pega as duas últimas leituras
        double leituraAtual = leituras.get(leituras.size() - 1);
        double leituraAnterior = leituras.get(leituras.size() - 2);

        // Calcula a diferença e aplica um fator de ajuste (simulação)
        double variacao = leituraAtual - leituraAnterior;
        
        return leituraAtual + (variacao * fatorAjuste);
    }
}