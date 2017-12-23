
import com.github.lespaul361.commons.DisplayNotification;
import com.utils.Time;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author David Hamilton
 */
public class NewClass {
    public static void main(String[] args) {
        DisplayNotification.NotificationBuilder builder=new DisplayNotification.NotificationBuilder("title", "subtitle");
        builder.time(Time.seconds(20)).icon(DisplayNotification.MessageIconType.Question).theme(DisplayNotification.ThemePackagePresets.Aqua);
        builder.showNotification();
    }
}
