
public class CarroMain {
    public static void main(String[] args){
        Proprietario romulo = new Proprietario("Romulo", 12345, 2003);
        Placa placa_do_romulo = new Placa("ABC-1234", 1);
        Motor motor_romulo = new Motor();
        Carro carro_romulo = new Carro("Nissan", "GTR R34", romulo, placa_do_romulo, motor_romulo);
        System.out.println(romulo.getDescricao());
        System.out.println(placa_do_romulo.getDescricao());
        System.out.println(motor_romulo.getDescricao());
    }
}
