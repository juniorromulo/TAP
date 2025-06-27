package sistema_oficina.ElementosDaOficina;

import java.util.ArrayList;
import java.util.Iterator;

/** Classe Tecnico: representa um técnico da oficina em questão 
 * @author Rômulo José
 */
public class Tecnico {
	/** Nome do técnico*/
	private String nome;
	/** CPF do técnico */
	private String cpf;
	/** Lista de servicos alocados para o técnico em questão */
	private ArrayList<Servico> servicos  = new ArrayList<Servico>();
	
	/** Construtor classe
	 * 
	 * @param nome nome do técnico
	 * @param cpf cpf do técnico
	 */
	public Tecnico(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	/** Retorna o nome do tecnico
	 * 
	 * @return nome do tecnico
	 */
	public String getNome() {
		return this.nome;
	}

	/** Retorna o cpf do tecnico 
	 * 
	 * @return CPF do tecnico
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/** Adiciona um serviço à lista de serviços do técnico
	 * 
	 * @param servico serviço a ser adicionado
	 */
	public void addServico(Servico servico) {
		if(servico != null) {
			servicos.add(servico);
		}
	}
	
	/** Remove um servico da lista de serviços do técnico baseado no identificador (ID) 
	 * 
	 * @param ID identificador do serviço a ser removido
	 */
	public void removerServico(int ID) {
	    Iterator<Servico> iterator = this.servicos.iterator();
	    while (iterator.hasNext()) {
	        Servico servico = iterator.next();
	        if (servico.getID() == ID) {
	            iterator.remove();
	            System.out.print("removi o id " + ID + "\n");
	        }
	    }
	}

	
	/** Verifica se um id esta na lista de servicos do tecnico e retorna true caso esteja, e false, caso contrario
	 * 
	 * @param ID
	 * @return true, caso id esta na lista de servicos do tecnico, ou false caso contrario
	 */
	public boolean possuiServico(int ID) {
		for(Servico s : servicos) {
			if(s.getID() == ID) {
				System.out.print("possui");
				return true;
			}
		}
		System.out.print("nao possui");
		return false;
	}
	
	/** Retorna um servico do tecnico 
	 * @param id identidicador do servico
	 * @return servico do tecnico com o id passado, ou nulo, caso nao exista
	 */
	public Servico getServico(int id) {
		
		for(Servico servico : this.servicos) {
			if(servico.getID() == id){
				return servico;
			}
		}
		return null;
	}
	
	/** Retorna uma descrição do técnico com seus respectivos serviços 
	 * @return descrição do técnico com seus respectivos serviços 
	 */
	public String toString() {
		return "Nome: " + this.nome + ";CPF: " + this.cpf;
	}
	
	public void printServicos() {
		for(Servico s : servicos) {
			System.out.print(s.toString());
		}
	}
	
	
	public static void main(String[] args) {
		Tecnico t = new Tecnico("AAA", "1-1");
		Cliente c = new Cliente("Romulo", 19, "123-456", "2-2");
		Aparelho a = new Aparelho("GELADEIRA",c);
		Servico s = new Servico(111,c,a,999.99,10);
		Servico s2 = new Servico(222,c,a,999.99,10);
		t.addServico(s);
		t.addServico(s2);
		c.addPedido(s);
		c.addPedido(s2);
		
		t.removerServico(222);
		t.possuiServico(222);
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids = c.getIdsServicos();
		for(Integer id : ids) {
			System.out.print(id + "\n");
		}
	}
}
