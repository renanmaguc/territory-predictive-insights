public class DadosTerritorio {

    private int populacao;
    private String regiao;
    private double limiteChuvaMilimetros;
    private String codigoAcessoAdmin;

    public DadosTerritorio(int populacao, String regiao, double limiteChuvaMilimetros, String codigoAcessoAdmin) {
        this.populacao = Math.max(populacao, 0); // Evita iniciar com número negativo
        this.regiao = regiao;
        this.limiteChuvaMilimetros = limiteChuvaMilimetros;
        this.codigoAcessoAdmin = codigoAcessoAdmin;
    }

    // --- Getters ---
    public int getPopulacao() {
        return populacao;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getLimiteChuvaMilimetros() {
        return limiteChuvaMilimetros;
    }

    // --- Setters com validação ---

    public void setPopulacao(int populacao) {
        if (populacao < 0) {
            System.out.println("ERRO: A população não pode ser negativa. Valor mantido em " + this.populacao);
        } else {
            this.populacao = populacao;
            System.out.println("População atualizada com sucesso para " + this.populacao);
        }
    }

    // Método que exige o código de acesso para alterar dados sensíveis
    public void setLimiteChuvaMilimetros(double novoLimite, String codigoInformado) {
        if (!this.codigoAcessoAdmin.equals(codigoInformado)) {
            System.out.println("ERRO: Código de acesso incorreto. O limite de chuva não foi alterado.");
            return;
        }

        // Validação da faixa de valores (não aceita limite fora da faixa)
        if (novoLimite < 0 || novoLimite > 200) {
            System.out.println("ERRO: O limite de chuva deve estar entre 0 e 200 mm. Valor mantido em " + this.limiteChuvaMilimetros);
        } else {
            this.limiteChuvaMilimetros = novoLimite;
            System.out.println("SUCESSO: Limite de chuva atualizado para " + this.limiteChuvaMilimetros + " mm.");
        }
    }
}