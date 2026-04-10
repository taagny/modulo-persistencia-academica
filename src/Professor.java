public class Professor extends Pessoa {
    private String registroFuncional;
    private String disciplinaPrincipal;

    public Professor(String nome, String cpf, String registroFuncional, String disciplinaPrincipal) {
        super(nome, cpf);
        this.registroFuncional = registroFuncional;
        this.disciplinaPrincipal = disciplinaPrincipal;
    }

    public String getRegistroFuncional()   { return registroFuncional; }
    public String getDisciplinaPrincipal() { return disciplinaPrincipal; }

    @Override
    public void exibirIdentificacao() {
        System.out.println("PROFESSOR | Nome: " + getNome() +
                " | CPF: " + getCpf() +
                " | RF: " + registroFuncional +
                " | Disciplina: " + disciplinaPrincipal);
    }
}