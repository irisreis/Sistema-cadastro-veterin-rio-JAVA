package sistemavet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Consultas {
	protected String nomeAnimal;
	protected String especie;
	protected String proprietario;
	protected String veterinario;
	protected String horario;
	
	public Consultas() { //construtor vazio
		super();
	}
	public Consultas(String nomeAnimal, String especie, String proprietario, String veterinario, String horario) {
		super();
		this.nomeAnimal = nomeAnimal;
		this.especie = especie;
		this.proprietario = proprietario;
		this.veterinario = veterinario;
		this.horario = horario;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getProprietário() {
		return proprietario;
	}
	public void setProprietario(String proprietário) {
		this.proprietario = proprietário;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public boolean inserirDados(String caminho) {
		try {
			FileWriter fw = new FileWriter(caminho, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(getNomeAnimal()+"#"+getEspecie()+"#"+getProprietário()+"#"+getVeterinario()+"#"+getHorario());
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
		System.out.println("Listando todas os dados de todos as consultas...");
		try {
			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);
			int cont= 1;
			while (br.ready()) {
				String linha = br.readLine();
				String vet[] = linha.split("#");
				System.out.println(cont++ + " Nome do animal: " + vet[0] + " Espécie: " + 
				vet[1] + " Proprietário: " + vet[2] + " Veterinário: " + vet[3] +
				" Horario: "+ vet[4]);}
			System.out.println("Listação finalizada.");
			br.close();
			fr.close();
			if (cont== 1) {
				System.out.println("Não há consultas cadastrados.");
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	} //fim do método listar
	public void localizar(String caminho, String horaProcurada) {
		try {
			FileReader fr= new FileReader(caminho);
			BufferedReader br= new BufferedReader(fr);
			int cont = 0;
			while (br.ready()) {
				String linha= br.readLine();
				String vt[]= linha.split("#");
				if (vt[4].equalsIgnoreCase(horaProcurada)) {
					setNomeAnimal(vt[0]);
					setEspecie(vt[1]);
					setProprietario(vt[2]);
					setVeterinario(vt[3]);
					setHorario(vt[4]);
					System.out.println("Nome do Animal: "+vt[0]);
					System.out.println("Espécie: "+vt[1]);
					System.out.println("Proprietario: "+vt[2]);
					System.out.println("Veterinário: " +vt[3]);
					System.out.println("Horário: "+vt[4]);
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
	public void deletarArquivo(String caminho, String horaProcurada) {
		try {
		    FileReader fr= new FileReader(caminho);
		    BufferedReader br= new BufferedReader(fr);
		    String temp= caminho.replace("Consultas.txt", "temp.txt");
		    FileWriter fw= new FileWriter(temp); //abre e apaga tudo
		    BufferedWriter bw= new BufferedWriter(fw);
		while (br.ready()) {
			String linha = br.readLine();
			String vt[] = linha.split("#");
		if(vt[4].equalsIgnoreCase(horaProcurada)) {
			//nada
		    System.out.println("Consulta deletada.");
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
	public void reagendar(String caminho, String horaProcurada, String novaHora) {
		try {
		    FileReader fr= new FileReader(caminho);
		    BufferedReader br= new BufferedReader(fr);
		    String temp= caminho.replace("Consultas.txt", "temp.txt");
		    FileWriter fw= new FileWriter(temp); //abre e apaga tudo
		    BufferedWriter bw= new BufferedWriter(fw);
		while (br.ready()) {
			String linha = br.readLine();
			String vt[] = linha.split("#");
		if(vt[4].equalsIgnoreCase(horaProcurada)) {
			vt[4]= novaHora;
			String linha1= vt[0]+"#"+vt[1]+"#"+vt[2]+"#"+vt[3]+"#"+vt[4];
			bw.write(linha1);
			bw.newLine();
		    System.out.println("Consulta reagendada com sucesso.");
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
