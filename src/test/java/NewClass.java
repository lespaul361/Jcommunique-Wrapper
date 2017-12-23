
import com.github.lespaul361.commons.DisplayNotification;

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
        DisplayNotification.showNotification("Title", "subtitle",DisplayNotification.MessageIconType.Warning, (double)10, DisplayNotification.ThemePackagePresets.Aqua);
        //System.exit(0);
    }
}
