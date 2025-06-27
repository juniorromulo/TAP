package sistema_oficina.SQL;
import java.sql.*;

import sistema_oficina.ElementosDaOficina.Tecnico;

/** Classe TecnicoDAO: classe que fara a integracao Java e MySQL dos tecnicos da base */
public class TecnicoDAO extends BancoDeDados{

	
	/** Limpa os dados da tabela 'tecnicos' da ultima sessao criada pela MainOficina. Essa e uma forma de garantir que todos os dados da sessao atual sao realmente da sessao atual, tanto no MySQL quanto na MainOficina*/
	public void limparTabela() {
	    try {
	        Statement st = conexao.createStatement();
	        st.executeUpdate("DROP TABLE IF EXISTS tecnicos;");
	        st.executeUpdate("CREATE TABLE IF NOT EXISTS tecnicos (nome TEXT, cpf TEXT, idPedidosAlocados TEXT);");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	/** Consulta e lista todos os tecnicos no banco de dados */
	public String listarTecnicos() {
		String retorno = "";
		
		try {
		      Statement st = conexao.createStatement();
		      ResultSet rs = st.executeQuery("SELECT * FROM tecnicos;");
		      while (rs.next()) {
		        retorno = retorno + (rs.getString(1) + ";" +  rs.getString(2)+";"+ rs.getString(3) + "\n");
		      }
		    }
		catch (SQLException e) {
		    System.out.println("Erro SQL: " + e.getMessage());
		    e.printStackTrace();
		}

		return retorno;
	}
	
	/** Atualiza todos os dados do tecnico baseado no cpf
	 * 
	 * @param tecnico novos dados do tecnico
	 * @param cpf cpf de comparacao
	 * @return 1 se a atualização ocorreu, e 0 caso contrário
	 */
	
	public int atualizarTecnico(Tecnico tecnico, String cpf) {
	    try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM tecnicos WHERE cpf = '" + cpf + "'");
	        if (!rs.next()) {
	            System.out.println("Tecnico não encontrado!");
	            return 0;
	        }
	   
	        String updateQuery = "UPDATE tecnicos SET nome = '" + tecnico.getNome() + "' WHERE " +"cpf = '" +  cpf + "'";
	        int linhasAfetadas = st.executeUpdate(updateQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("Tecnico atualizado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao atualizar o tecnico.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}

	
	/** Adiciona um tecnico caso o cpf passado não exista na base
	 * @param tecnico tecnico que sera adicionado
	 * @return 1 caso a insercao seja feita, e 0 caso contrario
	 */
	public int adicionarTecnico(Tecnico tecnico) {
	    try {
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM tecnicos WHERE cpf = '" + tecnico.getCpf() + "'");
	        if (rs.next()) {
	            System.out.println("Esse tecnico já existe!");
	            return 0;
	        }
	       
	        String insertQuery = "INSERT INTO tecnicos (nome, cpf) VALUES ('" + tecnico.getNome() + "', " + "'"+ tecnico.getCpf() + "')";
	        int linhasAfetadas = st.executeUpdate(insertQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("tecnico adicionado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao adicionar o tecnico.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}
	
	/** Atribui um id de servico a um tecnico na tabela de tecnicos 
	 * 
	 * @param tecnico tecnico que se quer atribuir o servico
	 * @param id id do servico 
	 * @return 1 se o servico foi alocado ao tecnico, 0 caso contrario
	 */
	public int atribuirServico(Tecnico tecnico, int id) {
		try{
			
	        Statement st = conexao.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM tecnicos WHERE cpf = '" + tecnico.getCpf() + "'");
	        if (!rs.next()) {
	            System.out.println("tecnico não encontrado!");
	            return 0;
	        }
	        
	        
	        String idPedidos = rs.getString(3);
	        
	        
	        if(idPedidos == null){
	        	idPedidos = "" + id;
	        }
	        else if(idPedidos.contains(""+id)) {
	        	return 0;
	        }
	        else {
	        	idPedidos += "," + id;
	        }
	        
	        String updateQuery = "UPDATE tecnicos SET idPedidosAlocados = '" + idPedidos + "' WHERE cpf = '" + tecnico.getCpf() + "'";
	        int linhasAfetadas = st.executeUpdate(updateQuery);
	        if (linhasAfetadas > 0) {
	            System.out.println("tecnico atualizado com sucesso!");
	            return 1;
	        } else {
	            System.out.println("Falha ao atualizar o tecnico.");
	            return 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
	        return 0;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
