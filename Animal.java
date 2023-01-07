package sistemavet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Animal {
	protected String nome;
	protected String especie;
	protected String raça;
	protected String idade;
	protected String proprietario;
	protected String condiçao;
	
	public Animal() { //construtor vazio
		super();
	}
	public Animal(String nome, String especie, String raça, String idade, String proprietario, String condiçao) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.raça = raça;
		this.idade = idade;
		this.proprietario = proprietario;
		this.condiçao = condiçao;
	}
	public String getNome() { //metodos get e set
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaça() {
		return raça;
	}
	public void setRaça(String raça) {
		this.raça = raça;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getCondiçao() {
		return condiçao;
	}
	public void setCondiçao(String condiçao) {
		this.condiçao = condiçao;
	}
	public boolean inserirDados(String caminho) {
		try {
			FileWriter fw = new FileWriter(caminho, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(nome+"#"+especie+"#"+raça+"#"+idade+"#"+proprietario+"#"+condiçao);
			bw.newLine();
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return false;
	}
	public void listarTodos(String caminho) {  //método para listar
		System.out.println("Listando todas os dados de todos os pacietes...");
		try {
			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);
			int cont= 1;
			while (br.ready()) {
				String linha = br.readLine();
				String vet[] = linha.split("#");
				System.out.println(cont++ + "Nome: " + vet[0] + " Espécie: " + vet[1] + " Raça: " + vet[2]
		     + " Idade: " + vet[3] + " Proprietário: " + vet[4] + " Condição: "+ vet[5]);}
			System.out.println("Listação finalizada.");
			br.close();
			fr.close();
			if (cont== 1) {
				System.out.println("Não há pacientes cadastrados.");
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
					setEspecie(vt[1]);
					setRaça(vt[2]);
					setRaça(vt[3]);
					setProprietario(vt[4]);
					setCondiçao(vt[5]);
					System.out.println("Nome do Animal: "+vt[0]);
					System.out.println("Espécie: "+vt[1]);
					System.out.println("Raça: "+vt[2]);
					System.out.println("Idade: "+vt[3]);
					System.out.println("Proprietário: " +vt[4]);
					System.out.println("Condição: "+vt[5]);
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
	public void deletarArquivo(String caminho, String nomeProcurado, String proprietarioProcurado) {
		try {
		    FileReader fr= new FileReader(caminho);
		    BufferedReader br= new BufferedReader(fr);
		    String temp= caminho.replace("Pacientes.txt", "temp.txt");
		    FileWriter fw= new FileWriter(temp); //abre e apaga tudo
		    BufferedWriter bw= new BufferedWriter(fw);
		while (br.ready()) {
			String linha = br.readLine();
			String vt[] = linha.split("#");
		if(vt[2].equalsIgnoreCase(proprietarioProcurado)&&vt[0].equalsIgnoreCase(nomeProcurado)) {
			//nada
		    System.out.println("Paciente deletado.");
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
	public void editar(String caminho, String nomeProcurado, String proprietarioProcurado, String novaCondicao) {
		try {
		    FileReader fr= new FileReader(caminho);
		    BufferedReader br= new BufferedReader(fr);
		    String temp= caminho.replace("Pacientes.txt", "temp.txt");
		    FileWriter fw= new FileWriter(temp); //abre e apaga tudo
		    BufferedWriter bw= new BufferedWriter(fw);
		while (br.ready()) {
			String linha = br.readLine();
			String vt[] = linha.split("#");
		if(vt[4].equalsIgnoreCase(proprietarioProcurado)&&vt[0].equalsIgnoreCase(nomeProcurado)) {
			vt[5]= novaCondicao;
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
