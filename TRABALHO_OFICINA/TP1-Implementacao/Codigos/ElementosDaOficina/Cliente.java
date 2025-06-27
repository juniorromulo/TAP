package sistema_oficina.ElementosDaOficina;
import java.util.ArrayList;

/**
 * Classe Cliente: representa um cliente da oficina em questão
 * @author Rômulo José
 *
 */

public class Cliente {
	
	/** Nome do cliente*/
	private String nome;
	
	/** Idade do cliente */ 
	private int idade;
	
	/** Telefone do cliente */
	private String telefone;
	/** CPF do cliente */
	private String cpf;
	
	
	/** Lista de pedidos do cliente. Pode ser um orçamento ou um serviço autorizado */
	private ArrayList<Pedido> pedidos  = new ArrayList<Pedido>();
	
	/** Construtor da classe sem passar a lista de pedidos do cliente 
	 *
	 * @param nome nome do cliente
	 * @param idade idade do cliente
	 * @param cpf cpf do cliente
	 */
	 
	public Cliente(String nome, int idade, String telefone,String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	/** Construtor da classe incluindo uma lista de pedidos já criada
	 * @param nome nome do cliente
	 * @param idade idade do cliente
	 * @param cpf cpf do cliente
	 * @param pedidos lista de pedidos (orçamento ou serviço) do cliente
	 */
	public Cliente(String nome, int idade, String telefone ,String cpf, ArrayList<Pedido> pedidos ){
		this(nome, idade, telefone ,cpf);
		this.pedidos = pedidos;
	}
	
	/** Adiciona um orçamento à lista de pedidos do cliente 
	 * 
	 * @param orcamento orçamento feito para o cliente
	 */
	public void addPedido(Orcamento orcamento) {
		if(orcamento != null) {
			pedidos.add(orcamento);
		}
		
	}
	/** Adiciona um orçamento à lista de pedidos do cliente 
	 * 
	 * @param servico serviço autorizado pelo cliente
	 */
	public void addPedido(Servico servico) {
		if(servico != null) {
			pedidos.add(servico);
		}
		
	}
	
	/** Retorna o indice de um orcamento na lista de pedidos
	 * 
	 * @param o orcamento que se quer o indice
	 * @return o indice do orcamento, caso ele exista, ou -1 caso contrario
	 */
	private int getIndexOrcamento(Orcamento o) {
		for(int i = 0; i< pedidos.size(); i++) {
			if(pedidos.get(i) instanceof Orcamento && pedidos.get(i).equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	/**Transforma um orcamento em um servico, ou seja, autoriza um servico
	 * 
	 * @param o orcamento que foi autorizado
	 * @param prazo prazo do servico
	 */
	public void autorizarServico(Orcamento o, int prazo) {
		Servico s = new Servico(o, prazo);
		int index = getIndexOrcamento(o);
		pedidos.set(index, s);
	}
	
	/** Retorna um orçamento da lista de pedidos do cliente baseado em um identificador 
	 * 
	 * @param ID identificador do orçamento
	 * @return Um objeto da classe Orcamento ou nulo, caso o identificador não exista
	 */
	public Orcamento getOrcamento(int ID) {
		for(int i= 0; i< pedidos.size(); i++) {
			if(pedidos.get(i) instanceof Orcamento && ((Orcamento)pedidos.get(i)).getID() == ID) {
				return (Orcamento)pedidos.get(i);
			}
		}
		return null;
	}
	
	/** Retorna um serviço da lista de pedidos do cliente baseado em um identificador 
	 * 
	 * @param ID identificador do orçamento
	 * @return Um objeto da classe Servico ou nulo, caso o identificador não exista
	 */
	public Servico getServico(int ID) {
		for(int i= 0; i< pedidos.size(); i++) {
			if(pedidos.get(i) instanceof Servico && ((Servico)pedidos.get(i)).getID() == ID) {
				return (Servico)pedidos.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Integer> getIdsServicos(){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for(Pedido pedido : pedidos) {
			try {
				Servico servico = (Servico)pedido;
				ids.add(servico.getID());
			}
			catch(Error error){
				
			}
		}
		return ids;
	}
	
	/** Retorna o nome do cliente 
	 * 
	 * @return nome do cliente
	 */
	public String getNome() {
		return this.nome;
	}
	
	/** Retorna a idade do cliente 
	 * 
	 * @return idade do cliente
	 */
	public String getIdade() {
		return  "" + this.idade;
	}
	
	/** Retorna o cpf do cliente 
	 * 
	 * @return cpf do cliente
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/** Retorna o telefone do cliente 
	 * 
	 * @return telefone do cliente
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/** Retorna uma descrição do cliente
	 * @return descrição do cliente 
	 */
	public String toString() {
		return "Nome: " + this.nome + "; Idade: " + this.idade + "; CPF: " + this.cpf + ";\n";
	}
	
	
	
}
