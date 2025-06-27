package sistema_oficina.Janelas;
import java.util.*;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import sistema_oficina.MainOficina;
import sistema_oficina.ElementosDaOficina.Aparelho;
import sistema_oficina.ElementosDaOficina.Cliente;
import sistema_oficina.ElementosDaOficina.Orcamento;
import sistema_oficina.ElementosDaOficina.Servico;
import sistema_oficina.SQL.ClienteDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacoesClienteWindow {

	public JFrame frame;


	/**
	 * Create the application.
	 */
	public OperacoesClienteWindow() {
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
		
		JLabel lblNewLabel = new JLabel("Sessão de cadastramento de clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar um cliente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String clienteInput = JOptionPane.showInputDialog(null, "Digite as informações do cliente separadas por vírgula. (Nome,Idade,telefone,CPF)", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);
		        
		        if (clienteInput != null) {
		           
		            String[] dadosCliente = clienteInput.split(",");

		            if (dadosCliente.length == 4) {
		                String nome = dadosCliente[0];
		                String idade = dadosCliente[1];
		                String telefone = dadosCliente[2];
		                String cpf = dadosCliente[3];
		                int newIdade = 0;
		                
		                try {
		                    newIdade = Integer.parseInt(idade);
		                } 
		                catch (NumberFormatException execption) {
		                    JOptionPane.showMessageDialog(null, "Dados do cliente inválidos. Certifique-se de digitar corretamente a idade.", "Aviso", JOptionPane.WARNING_MESSAGE);
		                    return;
		                }

		               

		                if (isCpfValido(cpf) && newIdade > 0) {
		                    Cliente cliente = new Cliente(nome, newIdade,telefone, cpf);
		                    ClienteDAO clienteDAO = new ClienteDAO();
		                    if(MainOficina.buscaTecnico(cpf) == null && clienteDAO.adicionarCliente(cliente) == 1) {
		                    	MainOficina.addCliente(cliente);
			                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                    else {
			                    JOptionPane.showMessageDialog(null, " O CPF passado ja existe!", "Aviso", JOptionPane.WARNING_MESSAGE);

		                    }
		                	
		                } else {
		                    JOptionPane.showMessageDialog(null, "Dados do cliente invalidos. Digite corretamente as informacoes", "Aviso", JOptionPane.WARNING_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Dados do cliente inválidos. Certifique-se de digitar todas as informações corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            }
		        } else {
		            // O usuário pressionou "Cancelar" ou fechou a janela
		            JOptionPane.showMessageDialog(null, "Nenhum nome de cliente digitado.", "Aviso", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});

		
		
		JButton btnNewButton_2 = new JButton("Remover um cliente\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clienteInput = JOptionPane.showInputDialog("Qual o cpf cliente você quer remover?");
				
				if(isCpfValido(clienteInput) && MainOficina.buscaCliente(clienteInput) != null) {
					ArrayList<Integer> idsRemovidos = new ArrayList<Integer>();
					Cliente clienteRemocao = MainOficina.buscaCliente(clienteInput);
					
					MainOficina.removerOrcamentos(clienteInput);
					MainOficina.removerAparelhos(clienteInput);
					MainOficina.removerServicos(clienteInput);
					ClienteDAO clienteDAO = new ClienteDAO();
					clienteDAO.removerCliente(clienteInput);
					// FALTA REMOVER O SERVICO DO TECNICO
					idsRemovidos = clienteRemocao.getIdsServicos();
					MainOficina.removerCliente(clienteRemocao);
					
					MainOficina.removerServicosTecnico(idsRemovidos);
					
					
					JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
                    JOptionPane.showMessageDialog(null, "CPF inválido ou não existe. Digite corretamente o CPF.", "Aviso!", JOptionPane.WARNING_MESSAGE);
                    return;
				}
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		
		JButton btnNewButton_x = new JButton("Atualizar um cliente");
		btnNewButton_x.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnNewButton_x.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente.");
		        Cliente clienteParaSerAtualizado = MainOficina.buscaCliente(cpf);
		    	
		        if (clienteParaSerAtualizado != null) {
			    	String clienteInput = JOptionPane.showInputDialog(null, "Digite as NOVAS informações do cliente separadas por vírgula. (Nome,Idade,telefone)", "Atualizacao de Cliente", JOptionPane.INFORMATION_MESSAGE);

		            String[] dadosCliente = clienteInput.split(",");

		            if (dadosCliente.length == 3) {
		                String nome = dadosCliente[0];
		                String idade = dadosCliente[1];
		                String telefone = dadosCliente[2];
		              
		                int newIdade = 0;
		                
		                try {
		                    newIdade = Integer.parseInt(idade);
		                } 
		                catch (NumberFormatException execption) {
		                    JOptionPane.showMessageDialog(null, "Dados do cliente inválidos. Certifique-se de digitar corretamente a idade.", "Aviso", JOptionPane.WARNING_MESSAGE);
		                }

		            
		                    Cliente clienteNovo = new Cliente(nome, newIdade,telefone, cpf);
		                    ClienteDAO clienteDAO = new ClienteDAO();
		                    if(clienteDAO.atualizarCliente(clienteNovo,cpf) == 1) {
		                    	MainOficina.setCliente(MainOficina.buscaIndiceCliente(cpf), clienteNovo);
			                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                
		                	
		                } else {
		                    JOptionPane.showMessageDialog(null, "Dados do cliente inválidos. Digite corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "CPF '"+ cpf + "' nao existe. Certifique-se de digitar todas as informações corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            }
		        
		        }
		    
		});
		frame.getContentPane().add(btnNewButton_x);
		
		
		JButton btnNewButton_3 = new JButton("Fazer um Orcamento");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        //String input = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1. Cadastrar Orcamento\n2. Cadastrar Servico");
		        String input2 = JOptionPane.showInputDialog(null, "Qual o CPF do cliente que deseja fazer o pedido?");
		        
		        Cliente clienteDoPedido = MainOficina.buscaCliente(input2);
		        
		        
		        if(clienteDoPedido == null) {
                    JOptionPane.showMessageDialog(null, "O cliente com CPF '" + input2 +"' não foi encontrado.");
		        	return;
		        }
		        System.out.println(clienteDoPedido.getCpf());
//		        if (input != null) {
//		            int option = Integer.parseInt(input);
		            
		           // if (option == 1) {
		                String orcamentoInput = JOptionPane.showInputDialog(null, "Digite os dados do Orcamento separados por vírgulas (ID,NomeAparelho,Custo):");
		                String[] orcamentoData = orcamentoInput.split(",");
		                
		                if (orcamentoData.length == 3) {
		                    int id = Integer.parseInt(orcamentoData[0]);
		                    String cpf = clienteDoPedido.getCpf();
		                    String nomeAparelho = orcamentoData[1];
		                    double custo = Double.parseDouble(orcamentoData[2]);
		                    
		                    if(MainOficina.buscaOrcamento(id) == null && MainOficina.buscaServico(id) == null) {
		                    	Aparelho aparelho = new Aparelho(nomeAparelho, clienteDoPedido);
			                    Orcamento orcamento = new Orcamento(id, clienteDoPedido, aparelho, custo);
			                    clienteDoPedido.addPedido(orcamento);
			                    MainOficina.addAparelho(aparelho);
			                    MainOficina.addOrcamento(orcamento);
			                    ClienteDAO c = new ClienteDAO();
			                    c.fazerOrcamento(cpf, orcamento);
			                    JOptionPane.showMessageDialog(null, "Orcamento adicionado!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                    else {
		                    	JOptionPane.showMessageDialog(null, "O ID passado já existe, crie outro!");
		                    }
		          
		                } else {
		                    JOptionPane.showMessageDialog(null, "Dados inválidos para o Orcamento. Voce pode ter digitado um ID ja existente");
		                }
//		            } //else if (option == 2) {
//		                String servicoInput = JOptionPane.showInputDialog(null, "Digite os dados do Servico separados por vírgulas (ID,NomeAparelho,Custo,Prazo):");
//		                String[] servicoData = servicoInput.split(",");
//		                
//		                if (servicoData.length == 4) {
//		                    int id = Integer.parseInt(servicoData[0]);
//		                    String cpf = clienteDoPedido.getCpf();
//		                    String nomeAparelho = servicoData[1];
//		                    double custo = Double.parseDouble(servicoData[2]);
//		                    int prazo = Integer.parseInt(servicoData[3]);
//		                    
//		                    Aparelho aparelho = new Aparelho(nomeAparelho, clienteDoPedido);
//		                    Servico servico = new Servico(id, clienteDoPedido, aparelho, custo, prazo);
//		                    
//		                    MainOficina.aparelhos.add(aparelho);
//		                    MainOficina.servicos.add(servico);
//		                    ClienteDAO c = new ClienteDAO();
//		                    c.fazerServico(cpf, servico);
//		                    JOptionPane.showMessageDialog(null, "Servico adicionado!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
//
//		                    // Faça o que for necessário com o objeto Servico criado
//		                } else {
//		                    JOptionPane.showMessageDialog(null, "Dados inválidos para o Servico.");
//		                }
//		            } else {
//		                JOptionPane.showMessageDialog(null, "Opção inválida.");
//		            }
//		        }
		    }
		});


		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Autorizar um Orcamento");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente para autorizar o orcamento");
        Cliente clienteDoPedido = MainOficina.buscaCliente(cpf);
        
        if(clienteDoPedido != null) {
        	String dadosTrocaServicoInput = JOptionPane.showInputDialog(null, "Digite o  ID do orcamento que foi autorizado e o prazo do servico (em dias) separados por virgulas (ID,Prazo):");
            String[] dadosColetados = dadosTrocaServicoInput.split(",");
        	if(dadosColetados.length == 2) {
            	int id = Integer.parseInt(dadosColetados[0]);
            	int prazo = Integer.parseInt(dadosColetados[1]);
            	if(MainOficina.buscaOrcamento(id) != null && MainOficina.buscaServico(id) == null) {
          
            		Orcamento orcamentoParaRemover = MainOficina.buscaOrcamento(id);
            		Servico servicoAutorizado = new Servico(orcamentoParaRemover,prazo);
                	MainOficina.addServico(servicoAutorizado); //aaaaaaaaaaaaaaaaaaaa
                	MainOficina.removerOrcamento(MainOficina.buscaOrcamento(id));
                	clienteDoPedido.autorizarServico(orcamentoParaRemover, prazo); //aaaaaaaaaaaaaaaaaaaaaa
                    JOptionPane.showMessageDialog(null, "Servico criado!", "Ótimo!", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "ID '" + id + "' não existe ou já foi criado!","Aviso!", JOptionPane.WARNING_MESSAGE);
            	}

            	
    		}
            else {
            	 JOptionPane.showMessageDialog(null, "Dados inválidos para o Servico.");
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "CPF inválido ou cliente não existe, tente novamente.", "Aviso!", JOptionPane.WARNING_MESSAGE);
        }
        
	}
	});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("Consultar um pedido");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente para autorizar o orcamento");
				
				if(isCpfValido(cpf)) {
					Cliente cliente = MainOficina.buscaCliente(cpf);
					if(cliente != null) {
						String id = JOptionPane.showInputDialog(null, "Digite o ID do pedido procurado para o cliente '" + cpf + "'");
						int newInt = Integer.parseInt(id);
						Servico servico = MainOficina.buscaServico(newInt);
						if(servico != null) {
							JOptionPane.showMessageDialog(null,servico.toString(), "Servico encontrado!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							Orcamento orcamento = MainOficina.buscaOrcamento(newInt);
							if(orcamento != null) {
								JOptionPane.showMessageDialog(null,orcamento.toString(), "Orcamento encontrado!", JOptionPane.INFORMATION_MESSAGE);

							}
							else {
								JOptionPane.showMessageDialog(null, "Nao existe um pedido com ID '" + id + "'.", "Aviso!", JOptionPane.WARNING_MESSAGE);

							}

						}
						

					}
					else {
						JOptionPane.showMessageDialog(null, "CPF '" + cpf + "' " + "nao existe.", "Aviso!", JOptionPane.WARNING_MESSAGE);

					}
				}
				else {
					JOptionPane.showMessageDialog(null, "CPF inválido, tente novamente.", "Aviso!", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton_1);
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
