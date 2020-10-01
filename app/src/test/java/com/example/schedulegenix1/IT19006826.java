package com.example.schedulegenix1;

import android.view.View;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IT19006826 {
        private CmInchConverter CmtoInch;
        // View kgValue;
        @Before
        public void setup(){
            CmtoInch = new CmInchConverter();
        }

        @Test
        public void Testgetinch(){
            double result = CmtoInch.getinchVal("10");
            assertEquals(3.937, result, 0.01);
        }

        @Test
        public void Testgetcm(){
            double result = CmtoInch.getcmVal("4");
            assertEquals(10.16, result, 0.01);
        }
    }

