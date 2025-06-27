package sistema_oficina.SQL;

import java.sql.*;

/** Classe BancoDeDados: classe base que configura a conexao do banco de dados MySQL, ela sera herdada por classes que fazem o controle de tabelas*/
public class BancoDeDados {
	  private static String url = "jdbc:mysql://localhost:3306/tap";
	  private static String user = "rom";	
	  private static String pass = "";
	  protected static Connection conexao = null;

	  public BancoDeDados() {
	    if (conexao == null) conecta();
	  }
	  /** Estabelece uma conexao com o BD
	   * 
	   * @return true, se a conexao foi estabelecida, ou false caso contrario
	   */
	  private static boolean conecta() {
	    try {
	      conexao = DriverManager.getConnection(url, user, pass);
	      System.out.println("Deu bom no estabelecimento da conexão");
	      return true;
	    } catch (SQLException e) { 
	    	System.out.println("Deu ruim no estabelecimento da conexão");
	    	return false; }
	  }
	  /** Encerra a conexao com o BD
	   * 
	   * @return true, se a conexao foi encerrada, ou false caso contrario
	   */
	  public static boolean desconecta() {
	    try {
	      conexao.close();
	      return true;
	    } catch (SQLException e) { return false; }
	  }
}

