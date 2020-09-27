package com.example.schedulegenix1;

import android.view.View;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IT19123882 {
    private Kg_lb kgTolb;
   // View kgValue;
    @Before
    public void setup(){
        kgTolb = new Kg_lb();
    }

    @Test
    public void Testgetlb(){
        double result = kgTolb.getlbVal("12");
        assertEquals(26.4552, result, 0.01);
    }

    @Test
    public void Testgetkg(){
        double result = kgTolb.getkgVal("3");
        assertEquals(1.3608, result, 0.01);
    }
}
