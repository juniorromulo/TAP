import java.util.Calendar;

/**
 * Classe Aluno - representa um aluno na aplicação
 * 
 * @author Romulo Jose
 */
public class Aluno {
    String nome;
    int matricula;
    int anoNascimento;

    Aluno() {
        this.nome = "Emmett L. Brown";
        this.matricula = 7714;
        this.anoNascimento = 2001;
    }

    /**
     * Constutor da classe:
     * 
     * @param nome          nome do aluno
     * @param matricula     matricula do aluno
     * @param anoNascimento ano de nascimento do aluno
     */
    public Aluno(String nome, int matricula, int anoNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.anoNascimento = anoNascimento;
    }

    /**
     * Retorna a idade do aluno baseado em seu ano de nascimento
     * 
     * @return int ano - this.anoNascimento;
     */
    public int getIdade() {
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        return ano - this.anoNascimento;
    }

    /**
     * Retorna uma descricao do aluno, mostrando os atributos da classe
     * 
     * @return String nome + " (mat=" + matricula + ", idade=" + getIdade() + ")"
     */
    public String getDescricao() {
        return nome + " (mat=" + matricula + ", idade=" + getIdade() + ")";
    }
}
