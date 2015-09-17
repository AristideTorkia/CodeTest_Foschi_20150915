package test;


import org.junit.*;

import java.util.Scanner;

import CustomException.CustomException;
import codeTest.Giocatore;
import codeTest.Match;

/**
 * 
 *
 */
 
public class ClasseDiTest {
	
	private final String nomeDelCampo = "Calcianese";
	private final Giocatore A = new Giocatore("Bastianic");
	private final Giocatore B = new Giocatore("Gracco");
	
	
	@Test
	public void testSingoloMatch_Costanti1() {
		try {
			Match match = new Match(nomeDelCampo, "corto", A , B);
			
			System.out.println( match.playMatch() );
			
			Assert.assertTrue(match.getVincitore() != null );
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	@Test
	public void testSingoloMatch_Costanti2() {
		try {
			Match match = new Match(nomeDelCampo, "corto", A , B);
			
			System.out.println( match.playMatch() );
			
			Assert.assertTrue(match.getVincitore().equals(A) || match.getVincitore().equals(B));
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	

	
	@Test
	public void testSingoloMatch_ExeptionTest1 () {
		try {
			Match match = new Match("", "", A, B);
			
			match.playMatch();
			
		} catch (Exception ex) {
			Assert.assertTrue(ex instanceof CustomException);
		}
	}
	
	@Test
	public void testSingoloMatch_ExeptionTest2 () {
		try {
			Match match = new Match("Sorrento", "doppio", A, B );
			
			match.playMatch();
			
		} catch (Exception ex) {
			Assert.assertTrue(ex instanceof CustomException);
		}
	}
	
	@Test
	public void testSingoloMatch_ExeptionTest3 () {
		try {
			Match match = new Match("Dolomiti", "completo", null , new Giocatore());
			
			match.playMatch();
			
		} catch (Exception ex) {
			Assert.assertTrue(ex instanceof CustomException);
		}
	}
	
	@Test
	@Ignore
	public void testSingoloMatch_InputDaUtente() {
		@SuppressWarnings("resource")
		Scanner user_input = new Scanner( System.in );
		
		System.out.print("Inserisci il nome del campo: ");
		String campo = user_input.next( );
		
		System.out.print("Inserisci il nome del primo Giocatore : ");
		String nomeGioA = user_input.next( );
		
		System.out.print("Inserisci il nome del secondo Giocatore : ");
		String nomeGioB = user_input.next( );
		
		System.out.print("Inserisci la modalita di gioco: corto, intermedio, completo ");
		String gioco = user_input.next( );
		
		Giocatore gioA = new Giocatore(nomeGioA);
		Giocatore gioB = new Giocatore(nomeGioB);
		
		try {
			Match match = new Match(campo, gioco, gioA , gioB);
			
			System.out.println( match.playMatch() );
			
			Assert.assertTrue(match.getVincitore().equals(gioA) || match.getVincitore().equals(gioB));
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
