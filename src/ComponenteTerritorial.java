public abstract class ComponenteTerritorial {

    protected int id;
    protected String nome;
    protected String regiao;
    protected boolean status; 

    // Construtor

    public ComponenteTerritorial(int id, String nome, String regiao) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.status = true;
    }

    // Métodos concretos
    public void ativar() {
        this.status = true;
        System.out.println("O componente " + nome + " (" + regiao + ") foi ATIVADO.");
    }

    public void desativar() {
        this.status = false;
        System.out.println("O componente " + nome + " (" + regiao + ") foi DESATIVADO.");
    }

    // Método abstrato que as subclasses serão obrigadas a implementar
    public abstract void verificarStatus();

    public String getNome() {
        return nome;
    }
    
    public String getRegiao() {
        return regiao;
    }
}