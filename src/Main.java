import java.util.List;

public class Main {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("Carlos Silva", "111.222.333-44", "2026001");
        Professor professor = new Professor("Ana Souza", "555.666.777-88", "RF-2024", "Programação Orientada a Objetos");
        System.out.println("=== Identificações ===");
        aluno.exibirIdentificacao();
        professor.exibirIdentificacao();

        System.out.println("\n=== Salvando no banco... ===");
        AcademicoDAO dao = new AcademicoDAO();
        dao.salvarPessoa(aluno);
        dao.salvarPessoa(professor);

        System.out.println("\n=== Dados recuperados do banco ===");
        List<Pessoa> todos = dao.listarTodos();
        for (Pessoa p : todos) {
            p.exibirIdentificacao();
        }
    }
}