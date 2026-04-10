public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }

    @Override
    public void exibirIdentificacao() {
        System.out.println("ALUNO | Nome: " + getNome() +
                " | CPF: " + getCpf() +
                " | Matrícula: " + matricula);
    }
}