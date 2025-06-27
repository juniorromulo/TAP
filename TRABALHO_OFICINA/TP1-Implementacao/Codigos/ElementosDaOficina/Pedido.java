package sistema_oficina.ElementosDaOficina;

/** @author Rômulo José
 * 
 * Classe Pedido: representa um pedido generico feito pelo cliente, a classe eh herdada pelas classes Orcamento e Servico
 *
 */
public abstract class Pedido {
	/** Código de identificação do serviço */
	protected int ID;
	
	/** Cliente que solicitou o orçamento */
	protected Cliente cliente;
	
	/** Aparelho que foi realizado o orçamento */
	protected Aparelho aparelho;
	
	/** Custo do serviço */ 
	protected double custoServico;
	
	/** Construtor da classe Pedido
	 * @param cliente cliente que solicitou o orçamento
	 * @param aparelho aparelho do cliente 
	 * @param custoServico custo mensurado para o serviço
	 */
	public Pedido(int ID, Cliente cliente, Aparelho aparelho, double custoServico) {
		this.ID = ID;
		this.cliente = cliente;
		this.aparelho = aparelho;
		this.custoServico = custoServico;
	}
	

	/** Retorna o ID 
	 * 
	 * @return id do servico
	 */
	public int getID() {
		return this.ID;
	}
	
	/** Retorna o cliente 
	 * 
	 * @return cliente que solicitou o servico
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/** Retorna o aparelho 
	 * 
	 * @return aparelho do servico
	 */
	public Aparelho getAparelho() {
		return aparelho;
	}
	
	/** Retorna o custo 
	 * 
	 * @return custo do servico
	 */
	public double getCusto() {
		return custoServico;
	}
	/** Descricao generica do pedido */
	public abstract String toString();

}
