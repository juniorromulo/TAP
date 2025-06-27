
/**
 * Classe TurmaMain - classe utilizada para testes das classes Aluno, Professor
 * e Turma
 */
public class TurmaMain {
    /**
     * Função main para executar os testes
     * 
     * @param args
     */
    public static void main(String[] args) {
        Aluno al = new Aluno();
        Professor prof = new Professor();
        Turma turma = new Turma("Parapsicologia", 2010, 2, prof);

        turma.addAluno(al);
        System.out.println(turma.getDescricao());
    }
}
