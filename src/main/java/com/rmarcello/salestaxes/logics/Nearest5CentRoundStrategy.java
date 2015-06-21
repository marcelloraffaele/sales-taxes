package com.rmarcello.salestaxes.logics;

/**
 * Implements the n/100 rounded up to the nearest 0.05.
 * 
 * @author Raffaele Marcello
 */
public class Nearest5CentRoundStrategy implements RoundStrategy{

    /**
     * Round the input float to the n/100 rounded up to the nearest 0.05
     * @param f
     * @return 
     */
    public float round(float f) {
        return (float) Math.ceil(f * 20.0f) / 20.0f;
    }
    
}
