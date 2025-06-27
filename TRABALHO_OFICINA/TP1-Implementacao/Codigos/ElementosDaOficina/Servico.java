package sistema_oficina.ElementosDaOficina;

/** Classe Serviço: representa um serviço de um eletrodoméstico autorizado pelo cliente 
 *  @author Rômulo José*/

public class Servico extends Pedido{
	
	/** Tempo em dias restantes em relação ao prazo da entrega do serviço */
	private int prazo;
	
	/** Construtor da classe Servico
	 * @param ID código de identificação do serviço
	 * @param cliente cliente que solicitou o orçamento
	 * @param aparelho aparelho do cliente 
	 * @param custoServico custo mensurado para o serviço
	 * @param prazo prazo em dias para a entrega do serviço
	 */
	public Servico(int ID, Cliente cliente, Aparelho aparelho, double custoServico, int prazo) {
		super(ID,cliente,aparelho,custoServico);
		this.prazo = prazo;
	}
	
	/** Construtor da classe Servico que utiliza um orçamento já criado 
	 * @param orcamento orçamento de um serviço
	 * @param prazo prazo em dias para a entrega do serviço
	 */
	public Servico(Orcamento orcamento, int prazo) {
		super(orcamento.getID(), orcamento.getCliente(), orcamento.getAparelho(), orcamento.getCusto());
		this.prazo = prazo;
	}
	
	
	/** Retorna o prazo 
	 * 
	 * @return prazo do servico (em dias)
	 */
	public int getPrazo() {
		return prazo;
	}
	
	/** Altera o valor do prazo 
	 * @param valor novo valor do prazo
	 */
	public void setPrazo(int valor) {
		if(valor >=0) {
			prazo = valor;
		}
	}
	
	/** Retorna uma descrição do serviço
	 * @return descricao do servico
	 */
	public String toString() {
		return "\n"+ "Valor: R$ " + this.custoServico + "; "+ this.aparelho.toString() + " ; ID: " + this.ID + "; Dias restantes: " + this.prazo;
	}
	
}
