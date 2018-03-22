/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author David Hamilton
 */
class SoundPlayer {

    public static void playSound(InputStream in) {
        try {
            InputStream ain = null;
            if (in instanceof BufferedInputStream) {
                ain = in;
            } else {
                ain = new BufferedInputStream(in);
            }
            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(ain);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(ain);
            AudioFormat format = fileFormat.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
        }

    }
}
