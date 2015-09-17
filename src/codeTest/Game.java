package codeTest;

/**
 * 
 *
 */
public class Game {
	private int ordineGame;
	private int pgA;
	private int pgB;
	
	public Game(int ordineGame) {
		super();
		this.ordineGame = ordineGame;
		this.pgA = 0;
		this.pgB = 0;
	}
	
	public int getPgA() {
		return pgA;
	}

	public int getPgB() {
		return pgB;
	}
	
	public String getRisultato() {
		return Punteggio.getScore().get(pgA) + " - " + Punteggio.getScore().get(pgB);  
	}

	public int getOrdineGame() {
		return ordineGame;
	}
	
	public int getRisultatoSingoloServizio() {
		return  ((int) (Math.random()*1000)%2);
	}
	
	public void playGame() {
		while (pgA < 6 && pgB < 6 && pgA < pgB+2 && pgB < pgA+2) {
			
			if (getRisultatoSingoloServizio() == 0) pgA++ ;
			else if (getRisultatoSingoloServizio() == 1) pgB++ ;
			
			//sorpasso
			if (pgA > 3 && pgA >= pgB+2) break;
			if (pgB > 3 && pgB >= pgA+2) break;
			
			//pareggio
			if (pgA > 3 && pgB > 3 && pgA == pgB) {
				pgA = 6;
				pgB = 6;
				break;
			}
			
			//limite superiore
			if (pgA > 3 && pgA < pgB+2)   	pgA = 4;
			else if (pgB > 3 && pgB < pgA+2) 	pgB = 4;
			 
		}
	}
	
}
