public class SensorNivelRio extends ComponenteTerritorial implements Sensor {

    public SensorNivelRio(int id, String nome, String regiao) {
        super(id, nome, regiao);
    }

    @Override
    public double lerValor() {
        return Math.random() * 10; // Simula nível do rio em metros (0 a 10m)
    }

    @Override
    public boolean verificarFuncionamento() {
        return this.status;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Nível do Rio";
    }

    @Override
    public void verificarStatus() {
        if (this.status) {
            System.out.println(nome + ": Nível do rio a ser monitorizado.");
        } else {
            System.out.println("ATENÇÃO: " + nome + " offline.");
        }
    }
}