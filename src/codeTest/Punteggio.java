package codeTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
public class Punteggio {
	
	private static final Map <Integer, String> score; 
	static {
        Map<Integer, String> punteggi = new HashMap<Integer, String>();
        
        punteggi.put(0, "LOVE");
        punteggi.put(1, "FIFTEEN");
        punteggi.put(2, "THIRTY");
        punteggi.put(3, "FORTY");
        punteggi.put(4, "1STVANTAGE");
        punteggi.put(5, "2NDVANTAGE");
        punteggi.put(6, "DOUCE");
        
        score = Collections.unmodifiableMap(punteggi);
    }
	
	public static Map<Integer, String> getScore() {
		return score;
	}
	

	
}