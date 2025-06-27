

public class Placa {
    String placa;
    int tipo;

    Placa(){
        this.placa = "OAT-3966";
        this.tipo = 6;
    }
    Placa(String placa, int tipo){
        this.placa = placa;
        this.tipo = tipo;
    }
    String getTipoString(){
        String retorno;
        if(tipo == 1){
            retorno = "Normal";
        }
        else if( tipo == 2){
            retorno = "Servico";
        }
        else if( tipo ==3 ){
            retorno = "Oficial";
        }
        else if( tipo == 4){
            retorno = "Auto Escola";
        }
        else if( tipo == 5){
            retorno = "Prototipo";
        }
        else if ( tipo == 6){
            retorno = "Colecionador";
        }
        else{
            retorno = "Outros";
        }
        return retorno;
    }
    boolean temEstacionamentoLivre(){
        if(tipo == 2 || tipo == 3){
            return true;
        }
        else{
            return false;
        }
    }
    String getDescricao(){
        return "Placa: placa=" + placa + ", tipo=" + getTipoString() + ", estacionamentoLivre=" + temEstacionamentoLivre() + ".";
    }
}
