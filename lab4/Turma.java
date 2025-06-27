import java.util.ArrayList;

/**
 * Classe Turma - representa uma turma de uma disciplina com seus respectivos
 * alunos e professor
 */
public class Turma {
    String disciplina;
    int ano;
    int semestre;
    Professor professor;
    ArrayList<Aluno> alunos;

    /**
     * Construtor da classe:
     * 
     * @param disciplina
     * @param ano
     * @param semestre
     * @param professor
     */
    Turma(String disciplina, int ano, int semestre, Professor professor) {
        this.alunos = new ArrayList<Aluno>();
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.professor = professor;
    }

    /**
     * Adiciona um aluno na turma, caso esse aluno não esteja nela
     * 
     * @param aluno
     */
    void addAluno(Aluno aluno) {
        if (getAluno(aluno.matricula) == null) {
            alunos.add(aluno);
        }
    }

    /**
     * retorna um aluno da lista de alunos que possui a matrícula especificada.
     * Retorna nulo caso o aluno não esteja na turma.
     * 
     * @param matricula
     * @return
     */
    Aluno getAluno(int matricula) {

        for (int i = 0; i < alunos.size(); i++) {
            Aluno alunoAtual = alunos.get(i);
            if (alunoAtual.matricula == matricula) {
                return alunoAtual;
            }
        }
        return null;
    }

    double getMediaIdade() {
        int acumulador = 0;
        for (int i = 0; i < alunos.size(); i++) {
            acumulador += alunos.get(i).getIdade();
        }
        return (double) acumulador / (double) alunos.size();
    }

    String getDescricao() {
        String retorno = "Turma " + this.disciplina + " - " + this.ano + "/" + this.semestre + " ("
                + professor.getDescricao() + "):\n";

        for (int i = 0; i < alunos.size(); i++) {
            String strConcatena = " - Aluno " + (i + 1) + ": " + alunos.get(i).getDescricao() + "\n";
            retorno += strConcatena;
        }
        return retorno;
    }
}
