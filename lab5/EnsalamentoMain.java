
public class EnsalamentoMain {
    public static void main(String[] args) {
        Sala sala1 = new Sala(1, 1, 70, true);
        Sala sala2 = new Sala(1, 2, 60, true);

        Turma turma1 = new Turma("A", "A", 50, true);
        turma1.addHorario(1);
        turma1.addHorario(2);
        turma1.addHorario(3);

        Turma turma2 = new Turma("B", "B", 140, false);
        turma2.addHorario(8);
        turma2.addHorario(5);

        Turma turma3 = new Turma("C", "C", 60, false);
        turma3.addHorario(9);

        Turma turma4 = new Turma("D", "D", 70, false);
        turma4.addHorario(3);
        turma4.addHorario(9);

        Ensalamento ensalamento1 = new Ensalamento();

        ensalamento1.addSala(sala1);
        ensalamento1.addSala(sala2);
        ensalamento1.addTurma(turma1);
        ensalamento1.addTurma(turma2);
        ensalamento1.addTurma(turma3);
        ensalamento1.addTurma(turma4);

        ensalamento1.alocarTodas();

        System.out.println(ensalamento1.relatorioSalasPorTurma());
    }
}