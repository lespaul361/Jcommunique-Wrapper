package com.github.lespaul361.commons;

import com.notification.NotificationFactory;
import com.notification.manager.SlideManager;
import com.notification.types.WindowNotification;
import com.theme.ThemePackage;
import com.utils.Time;
import java.io.InputStream;
import javax.swing.ImageIcon;

/**
 * Class to help simplify showing notifications such as in windows 10 to the
 * user using JCommunique by Samuel Pfrommer found at
 * <a href="https://github.com/spfrommer/JCommunique">https://github.com/spfrommer/JCommunique</a>.
 * Also plays a sound when notification is shown.
 *
 * @author Charles Hamilton
 */
public class DisplayNotification {

    /**
     * Preset theme packs
     */
    public enum ThemePackagePresets {
        /**
         * A black window with light text
         */
        CleanDark,
        /**
         * A white window with dark text
         */
        CleanLight,
        /**
         * An aqua window with dark text
         */
        Aqua
    }

    /**
     * The type of icon to use
     */
    public enum MessageIconType {
        /**
         * An exclamation icon
         */
        Exclamation,
        /**
         * A warning icon
         */
        Warning,
        /**
         * An error icon
         */
        Error,
        /**
         * A question icon
         */
        Question,
        /**
         * No icon
         */
        None
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
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification {@link MessageIconType}
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
     * @param preset a preset theme pack
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
     *
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
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
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
     *
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
     * @param seconds the length of time in seconds to show the notification
     * @param preset a preset theme pack
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
     *
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
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
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
     *
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
     * @param milliSeconds the length of time in milliseconds to show the
     * notification
     * @param preset a preset theme pack
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
     *
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
     * @param messageType a {@link MessageIconType} value to select the icon to
     * show in the notification
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
     * <table summary="" border="1">
     * <tr align="center">
     * <td>Preset Name</td>
     * <td>Description</td>
     * </tr>
     * <tr align="left">
     * <td>CleanDark</td>
     * <td>A black window with light text</td>
     * </tr>
     * <tr align="left">
     * <td>CleanLight</td>
     * <td>A white window with dark text</td>
     * </tr>
     * <tr align="left">
     * <td>Aqua</td>
     * <td>An aqua window with dark text</td>
     * </tr>
     * </table>
     *
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

                WindowNotification wn = null;
                if (icon != null) {
                    wn = factory.buildIconNotification(title, subTitle, icon);
                    wn.setCloseOnClick(true);
                } else {
                    wn = factory.buildTextNotification(title, subTitle);
                    wn.setCloseOnClick(true);
                }
                manager.addNotification(wn, t2);

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
                fileName = "Question.png";
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
                SoundPlayer.playSound(soundStream);
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
    }

    /**
     * Builder for making a notification. The default theme is cleanDark and
     * lasts 5 seconds.
     */
    public static class NotificationBuilder {

        private final String title;
        private final String subtitle;
        private ThemePackage themePackage = com.theme.ThemePackagePresets.cleanDark();
        private Time time = Time.seconds(5);
        private ImageIcon icon = null;
        private InputStream soundStream = getAudioFromResource();

        /**
         * Constructs a new <code>NotificationBuilder</code>
         *
         * @param title the title of the notification
         * @param subtitle the subtitle of the notification
         */
        public NotificationBuilder(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }

        /**
         * The amount of time to show the notification unless it is clicked
         *
         * @param time the time to show the notification. Default is 5 seconds
         * @return this notification builder
         */
        public NotificationBuilder time(Time time) {
            this.time = time;
            return this;
        }

        /**
         * Use a preset theme package
         *
         * @param preset a pre made theme package
         * <table summary="" border="1">
         * <tr align="center">
         * <td>Preset Name</td>
         * <td>Description</td>
         * </tr>
         * <tr align="left">
         * <td>CleanDark</td>
         * <td>A black window with light text</td>
         * </tr>
         * <tr align="left">
         * <td>CleanLight</td>
         * <td>A white window with dark text</td>
         * </tr>
         * <tr align="left">
         * <td>Aqua</td>
         * <td>An aqua window with dark text</td>
         * </tr>
         * </table>
         * @return this notification builder
         */
        public NotificationBuilder theme(ThemePackagePresets preset) {
            this.themePackage = getThemePackage(preset);
            return this;
        }

        /**
         * A custom theme to use for the notification
         *
         * @param themePackage the <code>ThemePackage</code> to use
         * @return this notification builder
         */
        public NotificationBuilder theme(ThemePackage themePackage) {
            this.themePackage = themePackage;
            return this;
        }

        /**
         * The icon to use from internal resources
         *
         * @param iconType a {@link MessageIconType} value to select the icon to
         * show in the notification
         * @return this notification builder
         */
        public NotificationBuilder icon(MessageIconType iconType) {
            this.icon = getImageIcon(iconType);
            return this;
        }

        /**
         * The icon to use for the notification
         *
         * @param icon an icon file
         * @return this notification builder
         */
        public NotificationBuilder icon(ImageIcon icon) {
            this.icon = icon;
            return this;
        }

        /**
         * An <code>InputStream</code> for the sound to play when the
         * notification is shown
         *
         * @param audioStream the sound stream
         * @return this notification builder
         */
        public NotificationBuilder sound(InputStream audioStream) {
            this.soundStream = audioStream;
            return this;
        }
        
        /**
         * Shows the notification from the builder
         */
        public void showNotification(){
            showNotificationHelper(title, subtitle, icon, time, soundStream, themePackage);
        }
    }
}
