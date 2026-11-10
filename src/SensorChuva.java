public class SensorChuva extends ComponenteTerritorial implements Sensor {

    // O construtor repassa as informações para a classe mãe (ComponenteTerritorial)
    public SensorChuva(int id, String nome, String regiao) {
        super(id, nome, regiao);
    }

    // --- Métodos obrigatórios da interface Sensor ---

    @Override
    public double lerValor() {
        // Simula uma leitura de chuva entre 0 e 50 mm
        return Math.random() * 50; 
    }

    @Override
    public boolean verificarFuncionamento() {
        // Retorna o atributo 'status' que herdamos da ComponenteTerritorial
        return this.status;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Chuva";
    }

    // --- Método obrigatório da classe abstrata ComponenteTerritorial ---

    @Override
    public void verificarStatus() {
        if (this.status) {
            System.out.println(nome + " (" + regiao + "): Operando normalmente.");
        } else {
            System.out.println("ATENÇÃO: " + nome + " (" + regiao + ") está desativado ou com falha!");
        }
    }
}