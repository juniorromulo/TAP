package sistema_oficina.ElementosDaOficina;

/** Classe Orçamento: representa um orçamento de um serviço feito por um cliente 
 * @author Rômulo José*/

public class Orcamento extends Pedido{
	
	/** Construtor da classe Orcamento
	 * @param cliente cliente que solicitou o orçamento
	 * @param aparelho aparelho do cliente 
	 * @param custoServico custo mensurado para o serviço
	 */
	public Orcamento(int ID, Cliente cliente, Aparelho aparelho, double custoServico) {

		super(ID,cliente,aparelho,custoServico);
	}

	
	/** Retorna uma descricao do orçamento 
	 * @return descricao do orçamento 
	 */
	public String toString() {
		return "Valor: " + this.custoServico+"; " + this.aparelho.toString() ;
	}
}
