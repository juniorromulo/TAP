
public class Sala{
    int bloco;
    int sala;
    int capacidade;
    boolean acessivel;

    Sala(){
        this(6, 101, 60, true);

    }
    Sala(int bloco, int sala, int capacidade, boolean acessivel){
        this.bloco = bloco;
        this.sala = sala;
        this.capacidade = capacidade;
        this.acessivel = acessivel;
    }
    String getDescricao(){
        String strAcessivel;
        if(this.acessivel){
            strAcessivel = "acessível";
        }
        else{
            strAcessivel = "não acessível";
        }
        return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, " + strAcessivel + ")";
    }
}