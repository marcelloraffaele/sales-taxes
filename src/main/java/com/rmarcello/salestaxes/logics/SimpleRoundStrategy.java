package com.rmarcello.salestaxes.logics;

/**
 * This class provide round to n/100.
 * 
 * @author Raffaele Marcello
 */
public class SimpleRoundStrategy implements RoundStrategy{

    public float round(float f) {
        return (float) Math.round(f * 100.0f) / 100.0f;
    }
    
}
