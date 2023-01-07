package sistemavet;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String caminhoConsulta= "C:\\Users\\Íris\\Desktop\\veterinário dados\\Consultas.txt";
		String caminhoFuncionario= "C:\\Users\\Íris\\Desktop\\veterinário dados\\Funcionários.txt";
		String caminhoAnimal= "C:\\Users\\Íris\\Desktop\\veterinário dados\\Pacientes.txt";
		String caminhoTemp= "C:\\Users\\Íris\\Desktop\\veterinário dados\\temp.txt";
		Scanner ler= new Scanner(System.in);
		String op, opAux;
		do { //menu principal
			System.out.println("MENU PRINCIPAL.");
			System.out.println("");
			System.out.println("1- Informações de consultas.");
			System.out.println("2- informações de pacientes.");
			System.out.println("3- informações de funcionários.");
			System.out.println("s- sair do programa.");
			op=ler.nextLine();
			switch(op) { //switch dos menus
			case "1":{
				do { //menu de consultas
					System.out.println("MENU DE CONSULTAS.");
					System.out.println("");
					System.out.println("1- Marcar consulta.");
					System.out.println("2- Cancelar consulta.");
					System.out.println("3- Reagendar consulta.");
					System.out.println("4- Listar consultas.");
					System.out.println("5- Exibir dados de uma consulta.");
					System.out.println("s- Sair do menu de consultas.");
					opAux=ler.nextLine();
					switch(opAux) {  //switch do menu consultas
					case "1":{ //cadastrar novo
						System.out.println("Digite o nome do animal.");
						String nome=ler.nextLine();
						System.out.println("Digite a espécie do animal.");
						String especie=ler.nextLine();
						System.out.println("Digite o proprietário do animal.");
						String proprietario=ler.nextLine();
						System.out.println("Digite a condição do animal.");
						String condiçao=ler.nextLine();
						System.out.println("Digite o horario desejado.");
						String horario=ler.nextLine();
						
						Consultas cons= new Consultas(nome, especie, proprietario, condiçao, horario);
						if(cons.inserirDados(caminhoConsulta)){
							System.out.println("Nova consulta salva.");
						}else {
							System.out.println("Falha ao inserir uma nova consulta.");
						}
					}break; //fim do cadastrar novo
					case "2":{ //excluir
						System.out.println("Digite o horário da consulta a ser excluido");
						String procurado = ler.nextLine();
						Consultas c = new Consultas();
						c.deletarArquivo(caminhoConsulta, procurado);
						c.transferir(caminhoTemp, caminhoConsulta);
					}break; //fim do excluir
					case "3":{ //reagendar
						System.out.println("Digite o horario da consulta a ser reagendada.");
						String procurado = ler.nextLine();
						System.out.println("Digite o novo horario da consulta.");
						String novoHorario = ler.nextLine();
						Consultas c = new Consultas();
						c.reagendar(caminhoConsulta, procurado, novoHorario);
						c.transferir(caminhoTemp, caminhoConsulta);
					}break; //fim do editar
					case "4":{ //listar
						Consultas c= new Consultas();
						c.listarTodos(caminhoConsulta);
					}break; //fim do listar 
					case "5":{ //localizar
						System.out.println("Digite o horario da consulta procurada.");
						String procurado = ler.nextLine();
						Consultas c = new Consultas();
						c.localizar(caminhoConsulta, procurado);
					}break;//fim do localizar
					} //fim do switch do menu consultas
				}while(!opAux.equalsIgnoreCase("s"));
			}break;
			case "2":{
				do { //menu de pacientes
					System.out.println("MENU DE PACIENTES.");
					System.out.println("");
					System.out.println("1- Cadastrar novo paciente.");
					System.out.println("2- Excluir dados de um paciente.");
					System.out.println("3- Editar dados de um paciente.");
					System.out.println("4- Listar dados de todos os pacientes.");
					System.out.println("5- Exibir dados de um paciente.");
					System.out.println("s- Sair do menu de pacientes.");
					opAux=ler.nextLine();
					switch(opAux) {  //switch do menu pacientes
					case "1":{ //cadastrar novo
						System.out.println("Digite o nome do animal.");
						String nome=ler.nextLine();
						System.out.println("Digite a espécie do animal.");
						String especie=ler.nextLine();
						System.out.println("Digite a raça do animal.");
						String raça=ler.nextLine();
						System.out.println("Digite a idade do animal.");
						String idade=ler.nextLine();
						System.out.println("Digite o nome do proprietário do animal.");
						String proprietario=ler.nextLine();
						System.out.println("Digite a condição do animal.");
						String condiçao=ler.nextLine();
						
						Animal an= new Animal(nome, especie, raça, idade, proprietario, condiçao);
						if(an.inserirDados(caminhoAnimal)){
							System.out.println("Novo paciente cadastrado com sucesso.");
						}else {
							System.out.println("Falha ao inserir novo paciente.");
						}
					}break; //fim do cadastrar novo
					case "2":{ //excluir
						System.out.println("Digite o nome do animal a ser excluido.");
						String nomeProcurado = ler.nextLine();
						System.out.println("Digite o nome do proprietário do animal a ser excluido.");
	       				String proprietarioProcurado = ler.nextLine();
						Animal an = new Animal();
						an.deletarArquivo(caminhoAnimal, nomeProcurado, proprietarioProcurado);
						an.transferir(caminhoTemp, caminhoAnimal);
					}break; //fim do excluir
					case "3":{ //editar
						System.out.println("Digite o nome do animal a ser editado.");
						String nomeProcurado = ler.nextLine();
						System.out.println("Digite o nome do proprietário do animal a ser editado.");
	       				String proprietarioProcurado = ler.nextLine();
						System.out.println("Digite a nova condição.");
	       				String novaCondicao = ler.nextLine();
						Animal an = new Animal();
						an.editar(caminhoAnimal, nomeProcurado, proprietarioProcurado, novaCondicao);
						an.transferir(caminhoTemp, caminhoAnimal);
					}break; //fim do editar
					case "4":{ //listar
						Animal a= new Animal();
						a.listarTodos(caminhoAnimal);
					}break; //fim do listar 
					case "5":{ //localizar
						System.out.println("Digite o nome do paciente procurado");
						String procurado = ler.nextLine();
						Animal an = new Animal();
						an.localizar(caminhoAnimal, procurado);
					}break;//fim do localizar
					}
				}while(!opAux.equalsIgnoreCase("s"));
			}break;
			case "3":{
				do { //menu de funcionários
					System.out.println("MENU DE FUNCIONÁRIOS.");
					System.out.println("");
					System.out.println("1- Cadastrar novo funcionário.");
					System.out.println("2- Excluir dados de um funcionário.");
					System.out.println("3- Editar dados de um funcionário.");
					System.out.println("4- Listar dados de todos os funcionários.");
					System.out.println("5- Exibir dados de um funcionário.");
					System.out.println("s- Sair do menu de funcionários.");
					opAux=ler.nextLine();
					switch(opAux) {  //switch do menu funcionários
					case "1":{ //cadastrar novo
						System.out.println("Digite o nome do funcionário.");
						String nome=ler.nextLine();
						System.out.println("Digite o CPF do funcionário.");
						String cpf=ler.nextLine();
						System.out.println("Digite a data de nascimento do funcionário.");
						String data=ler.nextLine();
						System.out.println("Digite a função do funcionário.");
						String funçao=ler.nextLine();
						System.out.println("Digite o salário do funcionário.");
						String salario=ler.nextLine();
						System.out.println("Digite o turno do funcionário.");
						String turno=ler.nextLine();
						
						Pessoa p= new Pessoa(nome, cpf, data, funçao, salario, turno);
						if(p.inserirDados(caminhoFuncionario)){
							System.out.println("Novo funcionário cadastrado com sucesso.");
						}else {
							System.out.println("Falha ao inserir novo funcionário.");
						}
					}break; //fim do cadastrar novo
					case "2":{ //excluir
						System.out.println("Digite o nome do CPF do funcionário a ser excluido");
						String procurado = ler.nextLine();
						Pessoa p = new Pessoa();
						p.deletarArquivo(caminhoFuncionario, procurado);
						p.transferir(caminhoTemp, caminhoFuncionario);
					}break; //fim do excluir
					case "3":{ //editar
						System.out.println("Digite o CPF do funcionário a ser editado.");
						String cpfProcurado = ler.nextLine();
						System.out.println("Digite o novo salário do funcionário.");
	       				String novoSalario = ler.nextLine();
						Pessoa p = new Pessoa();
						p.editar(caminhoFuncionario, cpfProcurado, novoSalario);
						p.transferir(caminhoTemp, caminhoFuncionario);
					}break; //fim do editar
					case "4":{ //listar
						Pessoa p= new Pessoa();
						p.listarTodos(caminhoFuncionario);
					}break; //fim do listar 
					case "5":{ //localizar
						System.out.println("Digite o nome do funcionário procurado");
						String procurado = ler.nextLine();
						Pessoa p = new Pessoa();
						p.localizar(caminhoFuncionario, procurado);
					}break;//fim do localizar
					} //fim do switch menu funcionarios
				}while(!opAux.equalsIgnoreCase("s"));
			}break;
			} // fim do switch de menus
			
		}while(!op.equalsIgnoreCase("s"));
		ler.close();
		System.out.print("PROGRAMA ENCERRADO.");
	}

}
