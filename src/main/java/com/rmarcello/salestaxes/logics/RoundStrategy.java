package com.rmarcello.salestaxes.logics;

/**
 *
 * @author Raffaele Marcello
 */
public interface RoundStrategy {
    
    /**
     * Returns rounded float. Depends on the implementation. 
     * 
     * @param f
     * @return 
     */
    public float round(float f);
}
