package com.example.schedulegenix1;


import android.view.View;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IT19205120 {
    private Litte_Gallon litertogallon;
    // View kgValue;
    @Before
    public void setup(){
        litertogallon = new Litte_Gallon();
    }

    @Test
    public void Testgetgallon(){
        double result = litertogallon.getgallonVal("12");
        assertEquals(3.1704, result, 0.01);
    }

    @Test
    public void Testgetl(){
        double result = litertogallon.getlVal("3");
        assertEquals(11.356, result, 0.01);
    }
}