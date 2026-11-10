public class SensorUmidade extends ComponenteTerritorial implements Sensor {

    public SensorUmidade(int id, String nome, String regiao) {
        super(id, nome, regiao);
    }

    @Override
    public double lerValor() {
        return Math.random() * 100; // Simula humidade de 0 a 100%
    }

    @Override
    public boolean verificarFuncionamento() {
        return this.status;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Humidade";
    }

    @Override
    public void verificarStatus() {
        if (this.status) {
            System.out.println(nome + ": Sensor de humidade operacional.");
        } else {
            System.out.println("ATENÇÃO: " + nome + " precisa de manutenção.");
        }
    }
}