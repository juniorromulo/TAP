import java.util.ArrayList;

public class Ensalamento {
    ArrayList<Sala> salas;
    ArrayList<Turma> turmas;
    ArrayList<TurmaEmSala> ensalamento;

    Ensalamento() {
        this.salas = new ArrayList<Sala>();
        this.turmas = new ArrayList<Turma>();
        this.ensalamento = new ArrayList<TurmaEmSala>();
    }

    void addSala(Sala sala) {
        this.salas.add(sala);
    }

    void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    Sala getSala(Turma turma) {
        for (TurmaEmSala turmaAtual : this.ensalamento) {
            if (turmaAtual.turma.equals(turma)) {
                return turmaAtual.sala;
            }
        }
        return null;
    }

    boolean salaDisponivel(Sala sala, int horario) {
        for (TurmaEmSala turmaAtual : this.ensalamento) {
            if ((turmaAtual.sala.equals(sala)) && (turmaAtual.turma.horarios.contains(horario))) {
                return false;
            }
        }
        return true;
    }

    boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {
        for (TurmaEmSala turmaAtual : this.ensalamento) {
            if (turmaAtual.sala.equals(sala)) {
                for (Integer horario : horarios) {
                    if (turmaAtual.turma.horarios.contains(horario)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean alocar(Turma turma, Sala sala) {

        if (salaSeAdequa(turma, sala)) {
            TurmaEmSala novaTurma = new TurmaEmSala(turma, sala);
            this.ensalamento.add(novaTurma);
            return true;
        }
        return false;
    }

    // método a mais que eu adicionei
    boolean salaSeAdequa(Turma turma, Sala sala) {
        if (((turma.acessivel == sala.acessivel) && (turma.numAlunos <= sala.capacidade))
                || ((turma.acessivel == false) && (turma.numAlunos <= sala.capacidade))) {
            // System.out.println("A turma se adequa a sala\n");

            if (salaDisponivel(sala, turma.horarios)) { // se a sala estiver disponível
                // System.out.println("Turma pode ser inserida!\n");
                return true;
            }
        }
        return false;
    }

    void alocarTodas() {
        Sala salaQueMelhorSeAdequa = null;
        int melhorDiferenca = 999999999;

        for (Turma turma : this.turmas) {
            melhorDiferenca = 999999999;
            for (Sala salaAtual : this.salas) {
                if (salaSeAdequa(turma, salaAtual) == true) {
                    int diferencaAtual = salaAtual.capacidade - turma.numAlunos;

                    if (diferencaAtual >= 0 && diferencaAtual < melhorDiferenca) {
                        salaQueMelhorSeAdequa = salaAtual;
                        melhorDiferenca = diferencaAtual;

                    }
                    // System.out.printf("dif atual: %d | melhor dif: %d\n", diferencaAtual,
                    // melhorDiferenca);

                }

            }
            System.out.printf("A sala q melhor se adequa é a:\n%s",
                    salaQueMelhorSeAdequa.getDescricao());
            alocar(turma, salaQueMelhorSeAdequa);
        }
    }

    int getTotalTurmasAlocadas() {
        int numSalas = 0;
        for (TurmaEmSala turmaAlocada : this.ensalamento) {
            if (turmaAlocada.sala != null) {
                numSalas++;
            }
        }
        return numSalas;
    }

    int getTotalEspacoLivre() {
        int espacoLivre = 0;

        for (TurmaEmSala turmaAlocada : this.ensalamento) {
            espacoLivre += turmaAlocada.sala.capacidade - turmaAlocada.turma.numAlunos;
        }

        return espacoLivre;
    }

    String relatorioResumoEnsalamento() {
        return "Total de Salas: " + this.salas.size() + "\nTotal de Turmas: " + this.turmas.size()
                + "\nTurmas Alocadas: " + getTotalTurmasAlocadas() + "\nEspaços Livres: " + getTotalEspacoLivre();
    }

    String relatorioTurmasPorSala() {
        String retorno = "";

        retorno = retorno + relatorioResumoEnsalamento() + "\n\n";
        for (Sala sala : this.salas) {
            retorno += "--- " + sala.getDescricao() + " ---\n\n";

            for (TurmaEmSala turmaAlocada : this.ensalamento) {
                if (sala.equals(turmaAlocada.sala)) {
                    retorno += turmaAlocada.turma.getDescricao() + "\n\n";
                }
            }
        }
        return retorno;
    }

    String relatorioSalasPorTurma() {
        String retorno = "";
        retorno = retorno + relatorioResumoEnsalamento() + "\n\n";
        for (Turma turma : this.turmas) {
            Sala salaAlocada = getSala(turma);
            retorno += turma.getDescricao() + "\nSala: ";
            if (salaAlocada != null) {
                retorno += salaAlocada.getDescricao();
            } else {
                retorno += "SEM SALA";
            }
            retorno += "\n\n";

        }
        return retorno;
    }
}
