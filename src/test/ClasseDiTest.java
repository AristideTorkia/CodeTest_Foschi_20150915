package test;


import org.junit.*;
import CustomException.CustomException;
import codeTest.Giocatore;
import codeTest.Match;

/**
 * 
 *
 */
 
public class ClasseDiTest {
	
	private final String nomeDelCampo = "Calcianese";
	private final Giocatore A = new Giocatore("Bastianic", "M");
	private final Giocatore B = new Giocatore("Gracco", "M");
	
	
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
		
	}
}
