package sistema_oficina.Janelas;


import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import sistema_oficina.MainOficina;
import sistema_oficina.SQL.ClienteDAO;
import sistema_oficina.SQL.TecnicoDAO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacoesOficinaWindow {

	public JFrame frame;
	
	

	/**
	 * Create the application.
	 */
	public InformacoesOficinaWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Informacoes da Oficina");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Listar clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO clienteDAO = new ClienteDAO();
				String clientesCadastrados = clienteDAO.listarClientes();
				
				String[] clientesInfos = clientesCadastrados.split("\n");
				String retorno = "";
				try {
					for(String cliente : clientesInfos) {
						String[] clienteInfo = cliente.split(";");
						retorno += (MainOficina.buscaCliente(clienteInfo[3]).toString());
					}
					
	 				if(clientesCadastrados.length() > 0) {
						JOptionPane.showMessageDialog(null, retorno);
					}
				}
				catch(ArrayIndexOutOfBoundsException erro){
					JOptionPane.showMessageDialog(null, "Não ha clientes cadastrados...","Aviso!",JOptionPane.WARNING_MESSAGE);
				}
				

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar tecnicos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TecnicoDAO tecnicoDAO = new TecnicoDAO();
				String tecnicosCadastrados = tecnicoDAO.listarTecnicos();
				String[] tecnicosInfos = tecnicosCadastrados.split("\n");
				String retorno = "";
				
				try {
					for(String tecnico : tecnicosInfos) {
						String[] tecnicoInfo = tecnico.split(";");
						System.out.print(MainOficina.buscaTecnico(tecnicoInfo[1]).toString());
						retorno += MainOficina.buscaTecnico(tecnicoInfo[1]).toString() + "\n";
					}
					if(tecnicosCadastrados.length() > 0) {
						JOptionPane.showMessageDialog(null, retorno);
					}
				}
				catch(ArrayIndexOutOfBoundsException erro){
					JOptionPane.showMessageDialog(null, "Não ha tecnicos cadastrados...","Aviso!",JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(btnNewButton_1);
		

	}

}
