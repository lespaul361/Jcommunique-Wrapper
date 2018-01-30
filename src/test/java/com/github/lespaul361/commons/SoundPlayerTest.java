/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons;

import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Hamilton
 */
public class SoundPlayerTest {
    
    public SoundPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of playSound method, of class SoundPlayer.
     */
    @Test
    public void testPlaySound() {
        System.out.println("playSound");
        try {
             //InputStream in=new FileInputStream("c:\\windows\\media\\windows notify messaging.wav");
        InputStream in = ClassLoader.class.getResourceAsStream("/Windows Notify System Generic.wav");
        SoundPlayer.playSound(in);
        } catch (Exception e) {
        }
       
    }
    
}
