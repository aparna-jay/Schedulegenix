package com.example.schedulegenix1;


import android.view.View;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IT19127774 {
    private unit_temp FahrToCel;
    // View kgValue;
    @Before
    public void setup(){
        FahrToCel = new unit_temp();
    }

    @Test
    public void TestgetInFahr(){
        double result = FahrToCel.getFahrVal("10");
        assertEquals(-12.22, result, 0.01);
    }

    @Test
    public void TestgetCel(){
        double result = FahrToCel.getCelVal("10");
        assertEquals(50.00, result, 0.01);
    }
}