package codeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CustomException.CustomException;

/**
 * 
 *
 */
public class Match {
	private Giocatore giocatoreA;
	private Giocatore giocatoreB;
	private Giocatore vincitore;
	private String campo;
	private Integer numeroSet;
	private List<Set> sets;
	
	private static final Map <String, Integer> quantiSet =  new HashMap<String, Integer>();
		
	static{
		quantiSet.put("corto", 3);
		quantiSet.put("intermedio", 5);
		quantiSet.put("completo", 7);
	}
	
	/**
	 * 
	 * @param campo
	 * @param tipo
	 * @param ospite
	 * @param avversario
	 * @throws Exception
	 */
	public Match(String campo, String tipo, Giocatore ospite, Giocatore avversario) throws Exception {
		super();
		if (campo == null || campo.equalsIgnoreCase("") || campo.trim().equalsIgnoreCase("")  ) 
			throw new CustomException("dati del campo di gioco non validi;");
		else 
			this.campo = campo;
		
		if (ospite == null || avversario == null)
			throw new CustomException("dati degli avversari non validi;");
		else {
			this.giocatoreA = ospite;
			this.giocatoreB = avversario;
		}
		
		if (tipo == null || quantiSet.get(tipo) != null) 
			this.numeroSet =  quantiSet.get(tipo.toLowerCase().trim().replace(" ", "") );
		else {
			throw new CustomException("tipologia di gioco non valida;");
		}
		
		this.sets = new ArrayList<Set>();
	}
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public static Map<String, Integer> getMatch() {
		return quantiSet;
	}

	public Integer getNumeroSet() {
		return numeroSet;
	}

	public List<Set> getRisultato() {
		return sets;
	}

	public void setRisultato(List<Set> risultato) {
		this.sets = risultato;
	}

	public Giocatore getGiocatoreA() {
		return giocatoreA;
	}

	public void setGiocatoreA(Giocatore giocatoreA) {
		this.giocatoreA = giocatoreA;
	}

	public Giocatore getGiocatoreB() {
		return giocatoreB;
	}

	public void setGiocatoreB(Giocatore giocatoreB) {
		this.giocatoreB = giocatoreB;
	}
	
	public String playMatch() {
		int vincitore = 0; 
		for (int iSet = 1; iSet <= numeroSet; iSet++) {
			Set set = new Set();
			set.playSet(giocatoreA, giocatoreB);
			sets.add(set);
			
			if (set.getVincitore().equals(this.giocatoreA) ) vincitore++;
			else if (set.getVincitore().equals(this.giocatoreB) ) vincitore--;
		} 
		if (vincitore > 0) this.vincitore = giocatoreA;
		else if (vincitore < 0) this.vincitore = giocatoreB;
		
		return this.toString();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		sb.append("Su campo di ");
		sb.append(this.getCampo());
		sb.append(" si sono sfidati ");
		sb.append(this.giocatoreA.getNome() );
		sb.append(" e ");
		sb.append(this.giocatoreB.getNome());
		sb.append("; \n");
		sb.append("Ha vinto ");
		sb.append(this.vincitore.getNome());
		sb.append("; \n");
		for (int iSet = 0; iSet < numeroSet; iSet++) {
			sb.append("SET ");
			sb.append(this.numeroSet );
			sb.append(": ");
			sb.append(this.sets.get(iSet).getPunteggio());
			sb.append("; /n");
		}
		
		return sb.toString();
	}

	/**
	 * @return the vincitore
	 */
	public Giocatore getVincitore() {
		return vincitore;
	}
}

