import java.util.*;

public class Turma implements Comparable<Turma> {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios = new ArrayList<Integer>();

    Turma() {
        this.nome = "Algoritmos e Estrutura de Dados I";
        this.professor = "Edleno Silva";
        this.numAlunos = 60;
        this.acessivel = true;
        this.horarios.add(1);
        this.horarios.add(15);
        this.horarios.add(29);
    }

    Turma(String nome, String professor, int numAlunos, boolean acessivel) {
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
    }

    @Override
    public int compareTo(Turma outraTurma) {
        if (this.horarios.size() > outraTurma.horarios.size()) {
            return 1;
        } else if (this.horarios.size() < outraTurma.horarios.size()) {
            return -1;
        }
        return 0;
    }

    void addHorario(int horario) {
        this.horarios.add(horario);
        Collections.sort(this.horarios);
    }

    String getHorariosString() {
        String retorno = "", diaAtual, horaAtual;
        int subtrador;
        String horas[] = { "8", "10", "12", "14", "16", "18", "20" };

        for (int i = 0; i < this.horarios.size(); i++) {
            int horarioAtual = this.horarios.get(i);

            if (horarioAtual <= 7) {
                diaAtual = "segunda";
                subtrador = 0;
            } else if (horarioAtual <= 14) {
                diaAtual = "terça";
                subtrador = 7;
            } else if (horarioAtual <= 21) {
                diaAtual = "quarta";
                subtrador = 14;
            } else if (horarioAtual <= 28) {
                diaAtual = "quinta";
                subtrador = 21;
            } else {
                diaAtual = "sexta";
                subtrador = 28;
            }
            horaAtual = horas[horarioAtual - subtrador - 1];
            retorno += diaAtual + " " + horaAtual + "hs, ";
        }

        return retorno.substring(0, retorno.length() - 2);
    }

    String getDescricao() {
        String ehAcessivel;
        if (this.acessivel) {
            ehAcessivel = "sim";
        } else {
            ehAcessivel = "não";
        }
        return "Turma: " + nome + "\nProfessor: " + professor + "\nNúmero de alunos: " + numAlunos + "\nHorário: "
                + getHorariosString() + "\nAcessível: " + ehAcessivel;
    }
}