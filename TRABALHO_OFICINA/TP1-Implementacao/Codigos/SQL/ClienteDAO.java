package sistema_oficina.SQL;

import java.sql.*;

import sistema_oficina.ElementosDaOficina.Aparelho;
import sistema_oficina.ElementosDaOficina.Cliente;
import sistema_oficina.ElementosDaOficina.Orcamento;
import sistema_oficina.ElementosDaOficina.Servico;

/** Classe ClienteDAO: faz a integracao entre Java e MySQL dos clientes da base */
public class ClienteDAO extends BancoDeDados {
	
	/** Limpa os dados da tabela 'clientes' da ultima sessao criada pela MainOficina. Essa e uma forma de garantir que todos os dados da sessao atual sao realmente da sessao atual, tanto no MySQL quanto na MainOficina*/
	public void limparTabela() {
	    try {
	        Statement st = conexao.createStatement();
	        st.executeUpdate("DROP TABLE IF EXISTS clientes;");
	        st.executeUpdate("CREATE TABLE IF NOT EXISTS clientes (nome TEXT, idade INT, telefone TEXT, cpf TEXT, idPedidos TEXT);");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

	
	
	
	
	/** Consulta e lista todos os clientes no banco de dados */
	public String listarClientes() {
		String retorno = "";
		
		try {
		      Statement st = conexao.createStatement();
		      ResultSet rs = st.executeQuery("SELECT * FROM clientes;");
		      while (rs.next()) {
		        retorno = retorno + (rs.getString(1) + ";" +  rs.getInt(2)+";"+ rs.getString(3)+ ";"+ rs.getString(4) + ";" + rs.getString(5) + "\n");
		      }
		    }
		    catch (SQLException e) {System.out.println("Deu ruim no SQL"); }
		
		return retorno;
	}
	
	/** Atualiza todos os dados do cliente baseado no cpf
	 * 
	 * @param cliente novos dados do cliente 
	 * @param cpf cpf de comparação para a mudança
	 * @return 1 se a atualização ocorreu, e 0 caso contrário
	 */
	public int atualizarCliente(Cliente cliente, String cpf) {
	    try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cpf = '" + cpf + "'");
	        if (!rs.next()) {
	            System.out.println("Cliente não encontrado!");
	            return 0;
	        }
	   
	        String updateQuery = "UPDATE clientes SET nome = '" + cliente.getNome() + "', idade = " + cliente.getIdade() + ", telefone = '" + cliente.getTelefone() + "' WHERE cpf = '" + cpf + "'";
	        int linhasAfetadas = st.executeUpdate(updateQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente atualizado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao atualizar o cliente.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}
	
	/** Adiciona um cliente caso o cpf passado não exista na base
	 * 
	 * @param cliente cliente que sera adicionado
	 * @return 1 caso a insercao seja feita, e 0 caso contrario
	 */
	public int adicionarCliente(Cliente cliente) {
	    try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cpf = '" + cliente.getCpf() + "'");
	        if (rs.next()) {
	            System.out.println("Esse cliente já existe!");
	            return 0;
	        }
	       
	        String insertQuery = "INSERT INTO clientes (nome, idade, telefone, cpf) VALUES ('" + cliente.getNome() + "', " + cliente.getIdade() + ", '" + cliente.getTelefone() + "', '" + cliente.getCpf() + "')";
	        int linhasAfetadas = st.executeUpdate(insertQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente adicionado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao adicionar o cliente.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}

	
	/** remove um cliente da base de dados baseado no cpf
	 * 
	 * @param cpf cpf de comparação para a exclusão
	 * @return 1 se a remoção foi feita, e 0 caso contrário
	 */
	public int removerCliente(String cpf) {
		try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cpf = '" + cpf + "'");
	        if (!rs.next()) {
	            System.out.println("Cliente não encontrado!");
	            return 0;
	        }
	   
	        String updateQuery = "DELETE FROM clientes WHERE cpf = '" + cpf + "';";
	        int linhasAfetadas = st.executeUpdate(updateQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente removido com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha em remover o cliente.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}

	/** Adiciona um orcamento a lista de IDs de pedidos do cliente 
	 * 
	 * @param cpf cpf do cliente
	 * @param orcamento orcamento do produto
	 * @return 1 se a insercao foi feita, e 0 caso contrário
	 */
	public int fazerOrcamento(String cpf, Orcamento orcamento) {
	    try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cpf = '" + cpf + "'");
	        if (!rs.next()) {
	            System.out.println("Cliente não encontrado!");
	            return 0;
	        }
	        
	        
	        String idPedidos = rs.getString(5);
	        
	        
	        if(idPedidos == null){
	        	idPedidos = "" + orcamento.getID();
	        }
	        else if(idPedidos.contains(""+orcamento.getID())) {
	        	return 0;
	        }
	        else {
	        	idPedidos += "," + orcamento.getID();
	        }
	        
	        String updateQuery = "UPDATE clientes SET idPedidos = '" + idPedidos + "' WHERE cpf = '" + cpf + "'";
	        int linhasAfetadas = st.executeUpdate(updateQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente atualizado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao atualizar o cliente.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}
	
	/** Adiciona um servico a lista de IDs de pedidos do cliente 
	 * 
	 * @param cpf cpf do cliente
	 * @param servico servico feito para o produto
	 * @return 1 se a insercao foi feita, e 0 caso contrário
	 */
	public int fazerServico(String cpf, Servico servico) {
	    try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cpf = '" + cpf + "'");
	        if (!rs.next()) {
	            System.out.println("Cliente não encontrado!");
	            return 0;
	        }
	        
	        
	        String idPedidos = rs.getString(5);
	        
	        if(idPedidos == null){
	        	idPedidos = "" + servico.getID();
	        }
	        else if(idPedidos.contains(""+servico.getID())) {
	        	return 0;
	        }
	        else {
	        	idPedidos += "," + servico.getID();
	        }
	        
	        String updateQuery = "UPDATE clientes SET idPedidos = '" + idPedidos + "' WHERE cpf = '" + cpf + "'";
	        int linhasAfetadas = st.executeUpdate(updateQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente atualizado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao atualizar o cliente.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}
	
//	private static String removeId(String idRemocao, String idPedidos) {
//	    String[] numbersArray = idPedidos.split(",");
//	    StringBuilder retorno = new StringBuilder();
//	    
//	    for (String id: numbersArray) {
//	        if (!id.equals(idRemocao)) {
//	            retorno.append(id + ",");
//	        }
//	    }
//	    
//	    if (retorno.length() > 0) {
//	        retorno.deleteCharAt(retorno.length() - 1); 
//	    }
//	    
//	    return retorno.toString();
//	}

	
	
	public static void main(String args[]) {
		ClienteDAO cliente = new ClienteDAO();
		Cliente a = new Cliente("Oswaldo",80,"999-999", "678-987");
		Aparelho b = new Aparelho("geladeri", a);
		Orcamento o = new Orcamento(987,a,b,145);
		//System.out.println(cliente.listarClientes());
		//cliente.atualizarCliente(new Cliente("Oswaldo",80,"999-999"), "678-987");
		//cliente.removerCliente("123-456");
		//cliente.adicionarCliente(new Cliente("Pedro", 21, "3456-0000", "999-888"));
		cliente.fazerServico("123-456", new Servico(o,5) );
		
		System.out.println("fim.");
	}
}
