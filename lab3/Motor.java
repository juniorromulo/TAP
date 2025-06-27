

public class Motor {
    int tipo, potencia;
    double capacidade;
    
    Motor(){
        this.tipo = 1;
        this.capacidade = 2.85;

    }
    Motor(int tipo, double capacidade, int potencia ){
       this.capacidade = capacidade;
       this.tipo = tipo;
       this.potencia = potencia;
    }

    String getTipoString(){
        String retorno;
        if(tipo == 1){
            retorno = "Gasolina";
        }
        else if( tipo == 2){
            retorno = "Alcool";
        }
        else if( tipo ==3 ){
            retorno = "Flex";
        }
        else if( tipo == 4){
            retorno = "Diesel";
        }
        else if( tipo == 5){
            retorno = "Eletrico";
        }
        else{
            retorno = "Outros"; 
        }
        return retorno;
    }
    
    String getDescricao(){
        return "Motor: tipo=" + getTipoString() + ", capacidade=" + capacidade +"L, potencia= " + potencia + "CV.";
    }
}
