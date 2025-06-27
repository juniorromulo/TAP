

public class Carro {
    String marca, modelo;
    Proprietario proprietario;
    Placa placa;
    Motor motor;

    Carro(String marca, String modelo, Proprietario proprietario, Placa placa, Motor motor){
        this.marca = marca;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.motor = motor;
        this.placa = placa;
    }
    String getDescricao(){
        return "Carro "+ marca + "/" + modelo + ". "+ proprietario.getDescricao() + placa.getDescricao() + motor.getDescricao();
    }
}
