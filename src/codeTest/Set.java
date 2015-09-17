package codeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Set {
	private final int standardGame = 6;
	private int gameGiocati; 
	private List<Game> games;
	private Giocatore vincitore;
	private String punteggio = "";
	
	public Set() {
		super();
		this.games = new ArrayList<Game>();
	}
	public int getGameGiocati() {
		return gameGiocati;
	}
	public void setGameGiocati(int gameGiocati) {
		this.gameGiocati = gameGiocati;
	}
	public Giocatore getVincitore() {
		return vincitore;
	}
	public void setVincitore(Giocatore vincitore) {
		this.vincitore = vincitore;
	}
	public int getStandardGame() {
		return standardGame;
	} 
	
	public List<Game> getGames() {
		return games;
	}
	public String getPunteggio() {
		return punteggio;
	}
	public void playSet(Giocatore giocatoreA, Giocatore giocatoreB){
		int pgA_pgB = 0;
		for (gameGiocati = 1; gameGiocati <= standardGame; gameGiocati++) {
			Game game = new Game(gameGiocati);
			game.playGame();
			this.games.add(game);
			
			if (game.getPgA() > game.getPgB()) pgA_pgB++;
			else if (game.getPgA() < game.getPgB()) pgA_pgB--;
			
			punteggio += "Game "+game.getOrdineGame() + ": "+game.getRisultato() +"; /n ";
		}	
		
		if (pgA_pgB > 0) this.vincitore = giocatoreA;
		else if (pgA_pgB < 0) this.vincitore = giocatoreB;
		else this.vincitore = new Giocatore(); 
		
		gameGiocati--;
			
	}


}
