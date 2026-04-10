import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcademicoDAO {
    private static final String URL    = "jdbc:mysql://localhost:3306/unipac_academico";
    private static final String USUARIO = "root";
    private static final String SENHA   = "";  // XAMPP não tem senha por padrão

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public void salvarPessoa(Pessoa p) {
        if (p instanceof Aluno) {
            Aluno a = (Aluno) p;
            String sql = "INSERT INTO alunos (nome, cpf, matricula) VALUES (?, ?, ?)";
            try {
                Connection con = conectar();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, a.getNome());
                stmt.setString(2, a.getCpf());
                stmt.setString(3, a.getMatricula());
                stmt.executeUpdate();
                System.out.println("Aluno salvo com sucesso!");
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao salvar aluno: " + e.getMessage());
            }

        } else if (p instanceof Professor) {
            Professor prof = (Professor) p;
            String sql = "INSERT INTO professores (nome, cpf, registro_funcional, disciplina_principal) VALUES (?, ?, ?, ?)";
            try {
                Connection con = conectar();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, prof.getNome());
                stmt.setString(2, prof.getCpf());
                stmt.setString(3, prof.getRegistroFuncional());
                stmt.setString(4, prof.getDisciplinaPrincipal());
                stmt.executeUpdate();
                System.out.println("Professor salvo com sucesso!");
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao salvar professor: " + e.getMessage());
            }
        }
    }

    public List<Pessoa> listarTodos() {
        List<Pessoa> lista = new ArrayList<>();

        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alunos");
            while (rs.next()) {
                Aluno a = new Aluno(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("matricula")
                );
                lista.add(a);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }

        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM professores");
            while (rs.next()) {
                Professor prof = new Professor(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("registro_funcional"),
                        rs.getString("disciplina_principal")
                );
                lista.add(prof);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }

        return lista;
    }
}