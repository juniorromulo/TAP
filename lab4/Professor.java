
/**
 * Classe Professor - representa um professor na aplicação
 * 
 * @author Romulo Jose
 */

public class Professor {
    String titulacao;
    String nome;
    int matricula;

    Professor() {
        this.titulacao = "Dr.";
        this.nome = "Hubert J. Farnsworth";
        this.matricula = 2208;
    }

    /**
     * Construtor da classe:
     * 
     * @param titulacao
     * @param nome
     * @param matricula
     */
    Professor(String titulacao, String nome, int matricula) {
        this.titulacao = titulacao;
        this.nome = nome;
        this.matricula = matricula;
    }

    /**
     * Retorna uma descricao do professor, mostrando os atributos da classe
     * 
     * @return String "Prof. " + titulacao + " " + nome + " - mat " + matricula
     */
    String getDescricao() {
        return "Prof. " + titulacao + " " + nome + " - mat " + matricula;
    }
}
