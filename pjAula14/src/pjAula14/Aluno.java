package pjAula14;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Aluno {
	
	public static void main(String[] args) {
		//Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();
		Map<Integer, Aluno> alunos = new ConcurrentHashMap<Integer, Aluno>(10);
		
		Aluno aluno = new Aluno();
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		Aluno aluno4 = new Aluno();
		
		aluno.setRa(12345); aluno.setNome("Paulo");
		aluno1.setRa(987654); aluno1.setNome("Você");
		aluno2.setRa(159753); aluno2.setNome("Ele");
		// Demais alunos
		
		alunos.put(aluno.getRa(), aluno);
		alunos.put(aluno1.getRa(), aluno1);
		alunos.put(aluno2.getRa(), aluno2);
		// Demais alunos
		
		
		System.out.println(alunos);
		
		System.out.println(alunos.get(159753));
	}
	
	private int ra;
	private String nome;
	
	@Override
	public String toString() {
		return "[RA: " + getRa() + " Nome: " + getNome() + "]";
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ra;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ra != other.ra)
			return false;
		return true;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
