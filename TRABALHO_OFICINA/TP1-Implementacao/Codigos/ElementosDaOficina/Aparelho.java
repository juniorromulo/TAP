package sistema_oficina.ElementosDaOficina;

/** Classe Aparelho: representa um aparelho eletrodoméstico de um Cliente 
 * @author Rômulo José
*/
public class Aparelho {
	/** Nome do aparelho */
	private String nome;
	
	/** Proprietário do aparelho */
	private Cliente proprietario;
	
	/** Construtor da classe Aparelho
	 * 
	 * @param nome nome do aparelho
	 * @param proprietario proprietario do aparelho
	 */
	public Aparelho(String nome, Cliente proprietario) {
		this.nome = nome;
		this.proprietario = proprietario;
	}
	
	/** Retorna o proprietario do aparelho*/
	public Cliente getProprietario() {
		return this.proprietario;
	}
	/** Retorna uma descrição do aparelho */
	public String toString() {
		return "Aparelho: " + this.nome + "; Proprietario: " + proprietario.getNome();
	}
	
}
