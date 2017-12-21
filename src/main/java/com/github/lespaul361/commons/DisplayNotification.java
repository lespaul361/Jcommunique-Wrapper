package com.github.lespaul361.commons;

import com.notification.NotificationFactory;
import com.notification.manager.SlideManager;
import com.sun.media.sound.JavaSoundAudioClip;
import com.theme.ThemePackagePresets;
import com.utils.Time;
import java.awt.TrayIcon;
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;

/*
 * Class to help simplify showing notifications such as in windows 10 to the 
 * user using JCommunique by Samuel Pfrommer found at 
 * https://github.com/spfrommer/JCommunique. Also plays a sound when 
 * notification is shown.
 *
 *@author Charles Hamilton
 */
/**
 *
 * @author David Hamilton
 */
public class DisplayNotification {

    /**
     * Preset theme packs
     */
    public enum ThemePackPresets {
        CleanDark, CleanLight, Aqua
    }

    /**
     * Shows a notification to the user for 5 seconds using the theme
     * ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     */
    public static void showNotification(String title, String subTitle) {
        showNotification(title, subTitle, (double) 5);
    }

    /**
     * Shows a notification to the user for 5 seconds using the theme
     * ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            ThemePackPresets preset) {
        showNotification(title, subTitle, (double) 5, preset);
    }

    /**
     * Shows a notification to the user for 5 seconds using the theme
     * ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     */
    public static void showNotification(String title, String subTitle,
            TrayIcon.MessageType messageType) {
        showNotification(title, subTitle, messageType, (double) 5);
    }

    /**
     * Shows a notification to the user for 5 seconds using the theme
     * ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            TrayIcon.MessageType messageType, ThemePackPresets preset) {
        showNotification(title, subTitle, messageType, (double) 5, preset);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param seconds the length of time in seconds to show the notification
     */
    public static void showNotification(String title, String subTitle, 
            double seconds) {
        showNotification(title, subTitle, null, seconds);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param seconds the length of time in seconds to show the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle, 
            double seconds, ThemePackPresets preset) {
        showNotification(title, subTitle, null, seconds, preset);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param seconds the length of time in seconds to show the notification
     */
    public static void showNotification(String title, String subTitle, 
            TrayIcon.MessageType messageType, double seconds) {
        showNotificationHelper(title, subTitle, getImageIcon(messageType), seconds);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param seconds the length of time in seconds to show the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle, 
            TrayIcon.MessageType messageType, double seconds, 
            ThemePackPresets preset) {
        showNotificationHelper(title, subTitle, getImageIcon(messageType), seconds, preset);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     */
    public static void showNotification(String title, String subTitle, int milliSeconds) {
        showNotificationHelper(title, subTitle, null, milliSeconds);
    }
    
        /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle, 
            int milliSeconds, ThemePackPresets preset) {
        showNotificationHelper(title, subTitle, null, milliSeconds, preset);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     */
    public static void showNotification(String title, String subTitle, 
            TrayIcon.MessageType messageType, int milliSeconds) {
        showNotificationHelper(title, subTitle, getImageIcon(messageType), 
                milliSeconds);
    }
    
        /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle, 
            TrayIcon.MessageType messageType, int milliSeconds, 
            ThemePackPresets preset) {
        showNotificationHelper(title, subTitle, getImageIcon(messageType), 
                milliSeconds, preset);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param icon icon to use
     * @param time the amount of time to show the notification
     * @param soundClip a stream with the sound to play
     */
    public static void showNotification(String title, String subTitle, ImageIcon icon, Time time, InputStream soundClip) {
        showNotificationHelper(title, subTitle, icon, time, soundClip);
    }
    
    /**
     * Shows a notification to the user for the given length of time using the
     * theme ThemePackagePresets.cleanDark
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param icon icon to use
     * @param time the amount of time to show the notification
     * @param soundClip a stream with the sound to play
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle, 
            ImageIcon icon, Time time, InputStream soundClip, 
            ThemePackPresets preset) {
        showNotificationHelper(title, subTitle, icon, time, soundClip, preset);
    }

    private static void showNotificationHelper(String title, String subTitle, ImageIcon icon, Object time) {
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                NotificationFactory factory = new NotificationFactory(ThemePackagePresets.cleanDark());
                SlideManager manager = new SlideManager(NotificationFactory.Location.SOUTHEAST);
                manager.setSlideDirection(SlideManager.SlideDirection.WEST);
                Time tme = null;

                if (time instanceof Double) {
                    tme = Time.seconds((double) time);
                } else {
                    tme = Time.milliseconds((int) time);
                }
                if (icon != null) {
                    manager.addNotification(factory.buildIconNotification(title, subTitle, icon), tme);
                } else {
                    manager.addNotification(factory.buildTextNotification(title, subTitle), tme);
                }
            }
        };
        playSound();
        Thread t2 = new Thread(r2);
        t2.start();

    }

    private static void showNotificationHelper(String title, String subTitle, ImageIcon icon, Time time, InputStream soundClip) {
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                NotificationFactory factory = new NotificationFactory(ThemePackagePresets.cleanDark());
                SlideManager manager = new SlideManager(NotificationFactory.Location.SOUTHEAST);
                manager.setSlideDirection(SlideManager.SlideDirection.WEST);
                Time t2 = null;
                if (time == null) {
                    t2 = Time.seconds(5);
                } else {
                    t2 = time;
                }

                if (icon != null) {
                    manager.addNotification(factory.buildIconNotification(title, subTitle, icon), t2);
                } else {
                    manager.addNotification(factory.buildTextNotification(title, subTitle), t2);
                }
            }
        };
        playSound(soundClip);
        Thread t2 = new Thread(r2);
        t2.start();

    }

    private static ImageIcon getImageIcon(TrayIcon.MessageType messageType) {
        String fileName = "";
        switch (messageType) {
            case ERROR:
                fileName = "error.ico";
                break;
            case WARNING:
                fileName = "warning.ico";
                break;
            case INFO:
                fileName = "exclamation.ico";
                break;
            case NONE:
                return null;

        }
        URL imageURL = DisplayNotification.class.getResource(fileName);
        ImageIcon icon = new ImageIcon(imageURL);
        return icon;
    }

    private static void playSound() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                InputStream is = DisplayNotification.class.getResourceAsStream("Windows Notify System Generic.wav");
                try {
                    JavaSoundAudioClip audio = new JavaSoundAudioClip(is);
                    audio.play();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
    }

    private static void playSound(InputStream soundStream) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    JavaSoundAudioClip audio = new JavaSoundAudioClip(soundStream);
                    audio.play();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
    }

}
