package sistemavet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String dataNascimento;
	protected String funçao;
	protected String salario;
	protected String turno;
	
	public Pessoa() { //construtor vazio
		super();
	}
	public Pessoa(String nome, String cpf, String dataNascimento, String funçao, String salario, String turno) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.funçao = funçao;
		this.salario = salario;
		this.turno = turno;
	}
	public String getNome() {  //métodos get e set
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNacsimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getFunçao() {
		return funçao;
	}
	public void setFunçao(String funçao) {
		this.funçao = funçao;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean inserirDados(String caminho) { // metodo de inserir dados
		try {
			FileWriter fw = new FileWriter(caminho, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(nome+"#"+cpf+"#"+dataNascimento+"#"+funçao+"#"+salario+"#"+turno);
			bw.newLine();
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return false;
	} //fim do método de inserir dados
	public void listarTodos(String caminho) {  //método para listar
		System.out.println("Listando todas os dados de todos os funcionários...");
		try {
			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);
			int cont= 1;
			while (br.ready()) {
				String linha = br.readLine();
				String vet[] = linha.split("#");
				System.out.println(cont++ + "Nome: " + vet[0] + " Cpf: " + vet[1] + " Data de nascimento: " + vet[2]
		     + " Função: " + vet[3] + " Salário: " + vet[4] + " Turno: "+ vet[5]);}
			System.out.println("Listação finalizada.");
			br.close();
			fr.close();
			if (cont== 1) {
				System.out.println("Não há funcionários cadastrados.");
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	} //fim do método listar
	public void localizar(String caminho, String nomeProcurado) {
		try {
			FileReader fr= new FileReader(caminho);
			BufferedReader br= new BufferedReader(fr);
			int cont = 0;
			while (br.ready()) {
				String linha= br.readLine();
				String vt[]= linha.split("#");
				if (vt[0].equalsIgnoreCase(nomeProcurado)) {
					setNome(vt[0]);
					setCpf(vt[1]);
					setDataNascimento(vt[2]);
					setFunçao(vt[3]);
					setSalario(vt[4]);
					setTurno(vt[5]);
					System.out.println("Nome: "+vt[0]);
					System.out.println("CPF: "+vt[1]);
					System.out.println("Data de nascimento: "+vt[2]);
					System.out.println("Função: " +vt[3]);
					System.out.println("Salário: "+vt[4]);
					System.out.println("Turno: "+(vt[5]));
					cont++;
				}
			}
			if (cont == 0) {
				System.out.println("Nao foi localizado.");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	} //fim do metodo localizar
	public void deletarArquivo(String caminho, String cpfProcurado) {
		try {
			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);
			String temp = caminho.replace("Funcionarios.txt", "temp.txt");
			FileWriter fw = new FileWriter(temp); //abre e apaga
			BufferedWriter bw = new BufferedWriter(fw);
		while (br.ready()) {
		String linha = br.readLine();
		String vt[]=linha.split("#");//o cpf fica no indice 1
		if(vt[1].equals(cpfProcurado)) {
		//não fazer nada
		System.out.println("Funcionário deletado.");
		}else {
		bw.write(linha);
		bw.newLine();
		System.out.println("Não foi possível deletar funcionário.");
		}} //fim do while
		fr.close();
		br.close();
		fw.close();
		bw.close();
		}catch(Exception e) {
		System.out.println(e);
		}
} //fim do método deletar
	public void transferir(String caminhoOrigem, String caminhoDestino) {
		try {
			FileReader fr= new FileReader(caminhoOrigem);
			BufferedReader br= new BufferedReader(fr);
			FileWriter fw= new FileWriter(caminhoDestino);//abre e zera tudo
			BufferedWriter bw= new BufferedWriter(fw);
			while (br.ready()) {
				String linha = br.readLine();
				bw.write(linha);
				bw.newLine();
			}
			bw.close();
			fw.close();
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	} //fim do método transferir
	public void editar(String caminho, String cpfProcurado, String novoSalario) {
		try {
		    FileReader fr= new FileReader(caminho);
		    BufferedReader br= new BufferedReader(fr);
		    String temp= caminho.replace("Funcionários.txt", "temp.txt");
		    FileWriter fw= new FileWriter(temp); //abre e apaga tudo
		    BufferedWriter bw= new BufferedWriter(fw);
		while (br.ready()) {
			String linha = br.readLine();
			String vt[] = linha.split("#");
		if(vt[1].equals(cpfProcurado)) {
			vt[4]= novoSalario;
			String linha1= vt[0]+"#"+vt[1]+"#"+vt[2]+"#"+vt[3]+"#"+vt[4]+"#"+vt[5];
			bw.write(linha1);
			bw.newLine();
		    System.out.println("Editado com sucesso.");
		}else{
			    bw.write(linha);
			    bw.newLine();
			    }} //fim do while
		br.close();
		bw.close();
		fr.close();
		fw.close();
		}catch(Exception e) {
		System.out.println(e);
		}
} 
}