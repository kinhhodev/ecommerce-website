package info.kinhho.kshop.constant;

import info.kinhho.kshop.dto.MenuBuilder;
import info.kinhho.kshop.objects.MenuObject;

import java.util.List;

public class MenuSetting {

    public static String MENU_NORMAL  = "menu";
    public static String MENU_SIDEBAR = "sidebar";

    public static MenuObject[] menus = new MenuObject[] {
        new MenuObject( "Dashboard", "/admin", "home.svg" ),
    };

    public static List<MenuObject> ofDashBoard() {

        return MenuBuilder.getInstance()
                .newItem().label("Dashboard").url("/admin").icon("home.svg").active(true)
                .newItem().label("Settings").url("/admin").icon("settings.svg")
                    .newSubItem().label("Settings 1").url("/admin").icon("settings.svg")
                    .newSubItem().label("Settings 2").url("/admin").icon("settings.svg")
                .build();
    }
}
