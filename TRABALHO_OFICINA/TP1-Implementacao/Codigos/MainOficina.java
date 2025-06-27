package sistema_oficina;
import java.util.*;

import sistema_oficina.ElementosDaOficina.Aparelho;
import sistema_oficina.ElementosDaOficina.Cliente;
import sistema_oficina.ElementosDaOficina.Orcamento;
import sistema_oficina.ElementosDaOficina.Servico;
import sistema_oficina.ElementosDaOficina.Tecnico;
import sistema_oficina.Janelas.MainWindow;
import sistema_oficina.SQL.ClienteDAO;
import sistema_oficina.SQL.TecnicoDAO;
public class MainOficina {
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
	private static ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static ArrayList<Aparelho> aparelhos = new ArrayList<Aparelho>();
	
	/**Adiciona um cliente a lista de clientes
	 * 
	 * @param c cliente a ser adicionado
	 */
	public static void addCliente(Cliente c) {
		MainOficina.clientes.add(c);
	}
	/**Adiciona um tecnico a lista de tecnicos
	 * 
	 * @param t tecnico a ser adicionado
	 */
	public static void addTecnico(Tecnico t) {
		MainOficina.tecnicos.add(t);
	}
	/**Adiciona um orcamento a lista de orcamentos
	 * 
	 * @param o orcamento a ser adicionado
	 */
	public static void addOrcamento(Orcamento o) {
		MainOficina.orcamentos.add(o);
	}
	/**Adiciona um servico a lista de servicos
	 * 
	 * @param s servico a ser adicionado
	 */
	public static void addServico(Servico s) {
		MainOficina.servicos.add(s);
	}
	/**Adiciona um aparelho a lista de aparelhos
	 * 
	 * @param a aparelho a ser adicionado
	 */
	public static void addAparelho(Aparelho a) {
		MainOficina.aparelhos.add(a);
	}
	/** Remove um cliente da lista de clientes
	 * 
	 * @param c cliente a ser removido
	 */
	public static void removerCliente(Cliente c) {
		MainOficina.clientes.remove(c);
	}
	/** Remove um orcamento da lista de orcamentos
	 * 
	 * @param o orcamento a ser removido
	 */
	public static void removerOrcamento(Orcamento o) {
		MainOficina.orcamentos.remove(o);
	}
	/** Remove um servico da lista de servicos
	 * 
	 * @param s servico a ser removido
	 */
	public static void removerServico(Servico s) {
		MainOficina.servicos.remove(s);
	}
	/** Remove um aparelho da lista de aparelhos
	 * 
	 * @param a aparelho a ser removido
	 */
	public static void removerAparelho(Aparelho a) {
		MainOficina.aparelhos.remove(a);
	}
	/** Atualiza um cliente na lista de clientes
	 * 
	 * @param index indice de atualizacao
	 * @param cliente cliente atualizado
	 */
	public static void setCliente(int index, Cliente cliente) {
		MainOficina.clientes.set(index,cliente);
	}
	
	/** Remove todos os orcamentos do cliente cujo CPF eh passado
	 * @param cpf CPF do cliente
	 */
	public static void removerOrcamentos(String cpf) {
	    Iterator<Orcamento> iterator = orcamentos.iterator();
	    while (iterator.hasNext()) {
	        Orcamento orcamento = iterator.next();
	        if (orcamento.getCliente().getCpf().equals(cpf)) {
	            iterator.remove();
	
	        }
	    }
	   
	}

	/** Remove todos os servicos do cliente cujo CPF eh passado, alem disso, os ids dos servicos removidos sao guardados para remocao dos servicos alocados a tecnicos
	 * @param cpf CPF do cliente
	 * @return intificadores ids dos servicos removidos
	 */
	public static void removerServicos(String cpf) {
	    Iterator<Servico> iterator = servicos.iterator();
	    
	    while (iterator.hasNext()) {
	        Servico servico = iterator.next();
	      
	        if (servico.getCliente().getCpf().equals(cpf)) {
	            iterator.remove();
	        }
	       
	    }
	}
	/** Remove todos os aparelhos do cliente cujo CPF eh passado
	 * @param cpf CPF do cliente
	 */
	public static void removerAparelhos(String cpf) {
	    Iterator<Aparelho> iterator = aparelhos.iterator();
	    while (iterator.hasNext()) {
	        Aparelho aparelho = iterator.next();
	        if (aparelho.getProprietario().getCpf().equals(cpf)) {
	            iterator.remove();
	        }
	    }
	}

	
	/** busca um cliente na lista de clientes pelo cpf
	 * 
	 * @param cpf cpf do cliente
	 * @return o cliente, caso ele exista, ou nulo, caso contrario
	 */
	public static Cliente buscaCliente(String cpf) {
		for(Cliente cliente : MainOficina.clientes) {
        	if(cliente.getCpf().equals(cpf)) {
        		return cliente;
        	}
        }
		return null;
	}
	
	/** busca um cliente na lista de clientes pelo cpf
	 * 
	 * @param cpf cpf do cliente
	 * @return o indice do cliente no ArrayList de clientes da MainOficina, caso ele exista, ou nulo, caso contrario
	 */
	public static int buscaIndiceCliente(String cpf) {
		for(int i = 0; i < MainOficina.clientes.size(); i++) {
			if(MainOficina.clientes.get(i).getCpf().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}
	
	/** busca um tecnico na lista de tecnicos pelo cpf
	 * 
	 * @param cpf cpf do tecnico
	 * @return o tecnico, caso ele exista, ou nulo, caso contrario
	 */
	public static Tecnico buscaTecnico(String cpf) {
		for(Tecnico tecnico : MainOficina.tecnicos) {
        	if(tecnico.getCpf().equals(cpf)) {
        		return tecnico;
        	}
        }
		return null;
	}
	
	/** busca um tecnico na lista de tecnicos pelo cpf
	 * 
	 * @param cpf cpf do tecnico
	 * @return o indice do tecnico no ArrayList de tecnicos da MainOficina, caso ele exista, ou nulo, caso contrario
	 */
	public static int buscaIndiceTecnico(String cpf) {
		for(int i = 0; i < MainOficina.tecnicos.size(); i++) {
			if(MainOficina.tecnicos.get(i).getCpf().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}
	
	/** Atualiza um tecnico na lista de tecnicos
	 * 
	 * @param index indice de atualizacao
	 * @param tecnico tecnico atualizado
	 */
	public static void setTecnico(int index, Tecnico tecnico) {
		MainOficina.tecnicos.set(index,tecnico);
	}
	
	/** Retorna se um id de pedido ja foi alocado para um tecnico 
	 * @param id ID do servico
	 * @return true se o pedido ja foi alocado, false caso contrario
	 */
	public static boolean servicoJaAlocado(int id) {
		for(Tecnico t : MainOficina.tecnicos) {
			if(t.possuiServico(id) == true) {
				System.out.print("ja");
				return true;
			}
		}
		return false;
	}
	
	/** Aloca um servico para um tecnico que esta na lista de tecnicos
	 * 
	 * @param t tecnico que o servico sera atribuido
	 * @param s servico passado para o tecnico
	 */
	public static void alocarServico(Tecnico t, Servico s) {
			t.addServico(s);
			int index = MainOficina.buscaIndiceTecnico(t.getCpf());
			MainOficina.tecnicos.set(index, t);
	}
	
	
	/** Remove um servico de um tecnico baseado no identificador.
	 * 
	 * @param id identificador do servico
	 */
	public static void removerServicoTecnico(int id) {
		for(Tecnico tecnico : MainOficina.tecnicos) {
			tecnico.printServicos();
			tecnico.removerServico(id);
		}
	}
	
	/** Remove servicos de um tecnico baseado no identificador.
	 * 
	 * @param ids identificadores dos servicos
	 */
	public static void removerServicosTecnico(ArrayList<Integer> ids) {
		for(Integer id : ids) {
			MainOficina.removerServicoTecnico(id);
		}
		
	}
	
	
	/** busca um orcamento na lista de orcamentos pelo id 
	 * 
	 * @param id do orcamento
	 * @return o orcamento, caso ele exista, ou nulo, caso contrario
	 */
	public static Orcamento buscaOrcamento(int id) {
		for(Orcamento o: MainOficina.orcamentos) {
			if(o.getID() == id) {
				return o;
			}
		}
		return null;
	}
	
	
	/** busca um servico na lista de servicos da MainOficina baseado no id
	 * 
	 * @param id id do servico 
	 * @return o servico, caso ele exista, ou null caso contrario
	 */
	public static Servico buscaServico(int id) {
		for(Servico s : servicos) {
			if(s.getID() == id) {
				return s;
			}
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		
		try {
			MainWindow window = new MainWindow();
			ClienteDAO c = new ClienteDAO();
			c.limparTabela();
			TecnicoDAO t = new TecnicoDAO();
			t.limparTabela();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
