

public class Proprietario {
    String nome;
    int cnh;
    int anoNascimento;
    
    Proprietario(){
        this.nome = "Emmett L. Brown";
        this.cnh = 98008173;
        this.anoNascimento = 1920;
    }
    Proprietario(String nome, int cnh, int anoNascimento){
        this.nome = nome;
        this.cnh = cnh;
        this.anoNascimento = anoNascimento;
    }
    
    int getIdade(int anoReferencia){
        return anoReferencia - anoNascimento;
    }

    String getDescricao(){
        return "Proprietario: nome=" + nome + ", cnh=" + cnh + ", anoNascimento=" + anoNascimento + ".";
    }
}
