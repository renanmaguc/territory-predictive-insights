import java.util.ArrayList;

public abstract class EstrategiaPrevisao {
    // Atributo comum a todas as estratégias
    protected String nomeEstrategia;

    public EstrategiaPrevisao(String nomeEstrategia) {
        this.nomeEstrategia = nomeEstrategia;
    }

    // Método abstrato que as classes filhas terão de sobrescrever obrigatoriamente
    public abstract double prever(ArrayList<Double> leituras);

    public String getNomeEstrategia() {
        return nomeEstrategia;
    }
}