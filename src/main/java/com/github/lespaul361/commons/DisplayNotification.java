package com.github.lespaul361.commons;

import com.notification.NotificationFactory;
import com.notification.manager.SlideManager;
import sun.audio.*;
import com.theme.ThemePackage;
import com.utils.Time;
import java.io.InputStream;
import javax.swing.ImageIcon;

/*
 * Class to help simplify showing notifications such as in windows 10 to the 
 * user using JCommunique by Samuel Pfrommer found at 
 * https://github.com/spfrommer/JCommunique. Also plays a sound when 
 * notification is shown.
 *
 *@author Charles Hamilton
 */
public class DisplayNotification {

    /**
     * Preset theme packs
     */
    public enum ThemePackagePresets {
        CleanDark, CleanLight, Aqua
    }

    public enum MessageIconType {
        Exclamation, Warning, Error, Question, None
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
     * Shows a notification to the user for 5 seconds using the selected preset
     * <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            ThemePackagePresets preset) {
        showNotification(title, subTitle, (double) 5, preset);
    }

    /**
     * Shows a notification to the user for 5 seconds using the supplied
     * <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            ThemePackage themePackage) {
        showNotification(title, subTitle, (double) 5, themePackage);
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
            MessageIconType messageType) {
        showNotification(title, subTitle, messageType, (double) 5);
    }

    /**
     * Shows a notification to the user for 5 seconds using the selected preset
     * <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            MessageIconType messageType, ThemePackagePresets preset) {
        showNotification(title, subTitle, messageType, (double) 5, preset);
    }

    /**
     * Shows a notification to the user for 5 seconds using the supplied
     * <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            MessageIconType messageType, ThemePackage themePackage) {
        showNotification(title, subTitle, messageType, (double) 5, themePackage);
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
     * selected preset <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param seconds the length of time in seconds to show the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            double seconds, ThemePackagePresets preset) {
        showNotification(title, subTitle, null, seconds, preset);
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * supplied <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param seconds the length of time in seconds to show the notification
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            double seconds, ThemePackage themePackage) {
        showNotification(title, subTitle, null, seconds, themePackage);
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
            MessageIconType messageType, double seconds) {
        Time t = Time.seconds(seconds);
        showNotificationHelper(title, subTitle, getImageIcon(messageType), t,
                getAudioFromResource(), getThemePackage(ThemePackagePresets.CleanDark));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * selected preset <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param seconds the length of time in seconds to show the notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            MessageIconType messageType, double seconds,
            ThemePackagePresets preset) {
        Time t = Time.seconds(seconds);
        showNotificationHelper(title, subTitle, getImageIcon(messageType), t,
                getAudioFromResource(), getThemePackage(preset));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * supplied <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param seconds the length of time in seconds to show the notification
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            MessageIconType messageType, double seconds,
            ThemePackage themePackage) {
        Time t = Time.seconds(seconds);
        showNotificationHelper(title, subTitle, getImageIcon(messageType), t,
                getAudioFromResource(), themePackage);
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
        Time t = Time.milliseconds(milliSeconds);
        showNotificationHelper(title, subTitle, null, t, getAudioFromResource(),
                getThemePackage(ThemePackagePresets.CleanDark));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * selected preset <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            int milliSeconds, ThemePackagePresets preset) {
        Time t = Time.milliseconds(milliSeconds);
        showNotificationHelper(title, subTitle, null, t, getAudioFromResource(),
                getThemePackage(preset));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * supplied <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            int milliSeconds, ThemePackage themePackage) {
        Time t = Time.milliseconds(milliSeconds);
        showNotificationHelper(title, subTitle, null, t, getAudioFromResource(),
                themePackage);
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
            MessageIconType messageType, int milliSeconds) {
        Time t = Time.milliseconds(milliSeconds);
        showNotificationHelper(title, subTitle, getImageIcon(messageType), t,
                getAudioFromResource(), getThemePackage(ThemePackagePresets.CleanDark));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * selected preset <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param preset a preset theme pack
     */
    public static void showNotification(String title, String subTitle,
            MessageIconType messageType, int milliSeconds,
            ThemePackagePresets preset) {
        Time t = Time.milliseconds(milliSeconds);
        showNotificationHelper(title, subTitle, getImageIcon(messageType), t,
                getAudioFromResource(), getThemePackage(preset));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * supplied <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param messageType selects the icon to show in the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            MessageIconType messageType, int milliSeconds,
            ThemePackage themePackage) {
        Time t = Time.milliseconds(milliSeconds);
        showNotificationHelper(title, subTitle, getImageIcon(messageType), t,
                getAudioFromResource(), themePackage);
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
    public static void showNotification(String title, String subTitle,
            ImageIcon icon, Time time, InputStream soundClip) {
        showNotificationHelper(title, subTitle, icon, time, soundClip,
                getThemePackage(ThemePackagePresets.CleanDark));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * selected preset <code>ThemePackage</code>
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
            ThemePackagePresets preset) {
        showNotificationHelper(title, subTitle, icon, time, soundClip,
                getThemePackage(preset));
    }

    /**
     * Shows a notification to the user for the given length of time using the
     * supplied <code>ThemePackage</code>
     *
     * @param title the title of the notification
     * @param subTitle the subtitle of the notification
     * @param icon icon to use
     * @param time the amount of time to show the notification
     * @param soundClip a stream with the sound to play
     * @param themePackage the theme to use
     */
    public static void showNotification(String title, String subTitle,
            ImageIcon icon, Time time, InputStream soundClip,
            ThemePackage themePackage) {
        showNotificationHelper(title, subTitle, icon, time, soundClip, themePackage);
    }

    private static void showNotificationHelper(String title, String subTitle,
            ImageIcon icon, Time time, InputStream soundClip, ThemePackage themePackage) {
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                NotificationFactory factory = new NotificationFactory(themePackage);
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

    private static InputStream getAudioFromResource() {
        InputStream in = ClassLoader.class.getResourceAsStream("/Windows Notify System Generic.wav");
        return in;
    }

    private static ImageIcon getImageIcon(MessageIconType messageType) {
        if (messageType == null) {
            return null;
        }
        String fileName = "";
        switch (messageType) {
            case Error:
                fileName = "error.png";
                break;
            case Exclamation:
                fileName = "exclamation.png";
                break;
            case Warning:
                fileName = "warning.png";
                break;
            case Question:
                fileName="Question.png";
                break;
            case None:
                return null;

        }
        try {
            InputStream in = ClassLoader.class.getResourceAsStream("/" + fileName);
            byte[] imageData = org.apache.commons.io.IOUtils.toByteArray(in);

            ImageIcon icon = new ImageIcon(imageData, "");
            return icon;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private static ThemePackage getThemePackage(ThemePackagePresets preset) {
        if (preset == null) {
            preset = ThemePackagePresets.CleanDark;
        }

        switch (preset) {
            case CleanDark:
                return com.theme.ThemePackagePresets.cleanDark();
            case CleanLight:
                return com.theme.ThemePackagePresets.cleanLight();
            case Aqua:
                return com.theme.ThemePackagePresets.aqua();
        }

        return null;
    }

    private static void playSound(InputStream soundStream) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                try {
                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(soundStream);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
    }

}
