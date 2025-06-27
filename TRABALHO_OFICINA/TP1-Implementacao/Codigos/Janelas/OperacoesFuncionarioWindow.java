package sistema_oficina.Janelas;



import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import sistema_oficina.MainOficina;
import sistema_oficina.ElementosDaOficina.Servico;
import sistema_oficina.ElementosDaOficina.Tecnico;
import sistema_oficina.SQL.TecnicoDAO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacoesFuncionarioWindow {

	public JFrame frame;
	private final JLabel lblSessoDeCadastramento = new JLabel("Sessão de cadastramento de funcionários");

	
	/**
	 * Create the application.
	 */
	public OperacoesFuncionarioWindow() {
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
		lblSessoDeCadastramento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSessoDeCadastramento.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblSessoDeCadastramento);
		
		JButton btnNewButton = new JButton("Cadastrar um funcionário");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tecnicoInput = JOptionPane.showInputDialog(null, "Digite as informacoes do tecnico separadas por virgula. (Nome,CPF)", "Cadastro de tecnico", JOptionPane.INFORMATION_MESSAGE);
		     
		        if (tecnicoInput != null) {
		           
		            String[] dadosTecnico = tecnicoInput.split(",");

		            if (dadosTecnico.length == 2) {
		                String nome = dadosTecnico[0];
		                String cpf = dadosTecnico[1];
		        
		                if(MainOficina.buscaCliente(cpf) == null) {
		                	if (isCpfValido(cpf)) {
			                    Tecnico tecnico = new Tecnico(nome, cpf);
			                    TecnicoDAO tecnicoDAO = new TecnicoDAO();
			                    if(isCpfValido(cpf) && MainOficina.buscaCliente(cpf) == null && tecnicoDAO.adicionarTecnico(tecnico) == 1) {
			                    	MainOficina.addTecnico(tecnico);
				                    JOptionPane.showMessageDialog(null, "Tecnico cadastrado com sucesso!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
			                    }
			                    else {
				                    JOptionPane.showMessageDialog(null, " O CPF passado ja existe!", "Aviso", JOptionPane.WARNING_MESSAGE);

			                    }
			                	
			                } else {
			                    JOptionPane.showMessageDialog(null, "Dados do tecnico invalidos. Digite corretamente as informacoes", "Aviso", JOptionPane.WARNING_MESSAGE);
			                }
		                }
		                else {
		                    JOptionPane.showMessageDialog(null, "Esse cpf ja existe na base de dados, cadastre outro.", "Aviso", JOptionPane.WARNING_MESSAGE);

		                }
		                
		            } else {
		                JOptionPane.showMessageDialog(null, "Dados do tecnico inválidos. Certifique-se de digitar todas as informações corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            }
		        } else {
		            // O usuário pressionou "Cancelar" ou fechou a janela
		            JOptionPane.showMessageDialog(null, "Nenhum nome de tecnico digitado.", "Aviso", JOptionPane.WARNING_MESSAGE);
		        }
		    }
			
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atualizar um tecnico\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do tecnico.");
		        Tecnico tecnicoParaSerAtualizado = MainOficina.buscaTecnico(cpf);
		    	
		        if (tecnicoParaSerAtualizado != null) {
			    	String tecnicoInput = JOptionPane.showInputDialog(null, "Digite as NOVAS informações do cliente tecnico por vírgula. (Nome)", "Atualizacao de tecnico", JOptionPane.INFORMATION_MESSAGE);

		                    Tecnico tecnicoNovo = new Tecnico(tecnicoInput, cpf);
		                    TecnicoDAO tecnicoDAO = new TecnicoDAO();
		                    if(tecnicoDAO.atualizarTecnico(tecnicoNovo,cpf) == 1) {
		                    	MainOficina.setTecnico(MainOficina.buscaIndiceTecnico(cpf), tecnicoNovo);
			                    JOptionPane.showMessageDialog(null, "tecnico atualizado com sucesso!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
		                    }
		             
		                	
		                } else {
		                    JOptionPane.showMessageDialog(null, "Dados do tecnico inválidos. Digite corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
		                }
		         
		        
		        }
			
		});
		frame.getContentPane().add(btnNewButton_1);
		
//		JButton btnNewButton_3 = new JButton("Remover Funcionario");
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Atribuir um Servico");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Consultar servico");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do tecnico.");
				Tecnico tecnico = MainOficina.buscaTecnico(cpf);
				if(tecnico != null) {
					String id = JOptionPane.showInputDialog(null, "Digite o ID do servico procurado");
					int newInt = Integer.parseInt(id);
					Servico servico = tecnico.getServico(newInt);
                    if(servico != null) {
                    	JOptionPane.showMessageDialog(null, servico.toString(), "Servico encontrado!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Servico com id '" + id + "' nao encontrado, digite outro id.", "Aviso", JOptionPane.WARNING_MESSAGE);

                    }
                   

				}
			
				else {
                    JOptionPane.showMessageDialog(null, "CPF nao encontrado, digite corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do tecnico.");
		        Tecnico tecnico = MainOficina.buscaTecnico(cpf);
		        
		        if(tecnico != null) {
		        	String id = JOptionPane.showInputDialog(null, "Digite o ID do servico a ser atribuido.");
		        	int intID = Integer.parseInt(id);
		        	Servico servico = MainOficina.buscaServico(intID);
		        	if(MainOficina.servicoJaAlocado(intID) == false && servico != null) {
		        		System.out.print(servico.toString());
		        		TecnicoDAO tecnicoDAO = new TecnicoDAO();
			        	tecnicoDAO.atribuirServico(tecnico, intID);
			        	tecnico.addServico(servico);
			        	System.out.println(tecnico.toString());
			        	MainOficina.alocarServico(tecnico, servico);
	                    JOptionPane.showMessageDialog(null, "Servico alocado ao tecnico!", "Tudo ok!", JOptionPane.INFORMATION_MESSAGE);

		        	}
		        	else if(servico == null) {
	                    JOptionPane.showMessageDialog(null, "O ID de servico nao existe", "Aviso!", JOptionPane.WARNING_MESSAGE);

		        	}
		        	else {
	                    JOptionPane.showMessageDialog(null, "O servico ja foi alocado a um tecnico", "Alocamento nao foi feito.", JOptionPane.WARNING_MESSAGE);

		        	}
		        	
		        }
		        else {
                    JOptionPane.showMessageDialog(null, "CPF nao encontrado, digite corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
	}

	
	
	
	/** verifica de uma forma simples se o cpf é válido
	 * 
	 * @param cpf cpf do cliente
	 * @return true ou false
	 */
	private boolean isCpfValido(String cpf) {
		if(cpf.contains("-") && cpf.length()> 0){
			return true ;
		}
		return false;
}
}
