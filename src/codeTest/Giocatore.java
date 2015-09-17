package codeTest;

/**
 * 
 *
 */
public class Giocatore {
	
	
	private String sesso;
	private String nome;
	private int vittorie;
	private int sconfitte;
	private int pareggi;
	private int punteggio;
	
	public Giocatore() {}
	
	public Giocatore(String nome, String sesso) {
		super();
		this.nome = nome;
		this.sesso = sesso;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVittorie() {
		return vittorie;
	}
	public void setVittorie(int vittorie) {
		this.vittorie = vittorie;
	}
	public int getSconfitte() {
		return sconfitte;
	}
	public void setSconfitte(int sconfitte) {
		this.sconfitte = sconfitte;
	}
	public int getPareggi() {
		return pareggi;
	}
	public void setPareggi(int pareggi) {
		this.pareggi = pareggi;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Giocatore))
			return false;
		Giocatore other = (Giocatore) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pareggi != other.pareggi)
			return false;
		if (punteggio != other.punteggio)
			return false;
		if (sconfitte != other.sconfitte)
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		if (vittorie != other.vittorie)
			return false;
		return true;
	}
	
 	
	
}
