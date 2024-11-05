package info.kinhho.kshop.dto;

import info.kinhho.kshop.objects.MenuObject;

import java.util.*;

public class MenuBuilder {

    private static final MenuBuilder INSTANCE = new MenuBuilder();

    private boolean hasSubmenu = false;
    private List<MenuObject> menus = new ArrayList<MenuObject>();

    public static MenuBuilder getInstance() {
        return INSTANCE;
    }

    public MenuBuilder newItem() {
        this.hasSubmenu = false;
        menus.add(new MenuObject());
        return this;
    }

    public MenuBuilder newSubItem() {
        this.hasSubmenu = true;
        getLastMenuItem(menus).addChild(new MenuObject());
        return this;
    }

    private MenuObject getLastMenuItem(List<MenuObject> menu) {
        if (menu.isEmpty()) return null;
        return menu.get(menu.size() - 1);
    }

    public MenuBuilder label(String label) {

        if (hasSubmenu) {
            MenuObject currentSubmenu = getLastMenuItem(getLastMenuItem(menus).getChildren());
            if ( currentSubmenu != null ) {
                currentSubmenu.setLabel(label);
            }
        }
        else {
            MenuObject currentMenu = getLastMenuItem(menus);
            if ( currentMenu != null ) {
                currentMenu.setLabel(label);
            }
        }
        return this;
    }
    public MenuBuilder url(String url) {
        if (hasSubmenu) {
            MenuObject currentSubmenu = getLastMenuItem(getLastMenuItem(menus).getChildren());
            if ( currentSubmenu != null ) {
                currentSubmenu.setUrl(url);
            }
        }
        else {
            MenuObject currentMenu = getLastMenuItem(menus);
            if ( currentMenu != null ) {
                currentMenu.setUrl(url);
            }
        }
        return this;
    }
    public MenuBuilder icon(String icon) {
        if (hasSubmenu) {
            MenuObject currentSubmenu = getLastMenuItem(getLastMenuItem(menus).getChildren());
            if ( currentSubmenu != null ) {
                currentSubmenu.setIcon(icon);
            }
        }
        else {
            MenuObject currentMenu = getLastMenuItem(menus);
            if ( currentMenu != null ) {
                currentMenu.setIcon(icon);
            }
        }
        return this;
    }
    public MenuBuilder show(boolean show) {
        if (hasSubmenu) {
            MenuObject currentSubmenu = getLastMenuItem(getLastMenuItem(menus).getChildren());
            if ( currentSubmenu != null ) {
                currentSubmenu.setShow(show);
            }
        }
        else {
            MenuObject currentMenu = getLastMenuItem(menus);
            if ( currentMenu != null ) {
                currentMenu.setShow(show);
            }
        }
        return this;
    }
    public MenuBuilder disable(boolean disable) {
        if (hasSubmenu) {
            MenuObject currentSubmenu = getLastMenuItem(getLastMenuItem(menus).getChildren());
            if ( currentSubmenu != null ) {
                currentSubmenu.setDisable(disable);
            }
        }
        else {
            MenuObject currentMenu = getLastMenuItem(menus);
            if ( currentMenu != null ) {
                currentMenu.setDisable(disable);
            }
        }
        return this;
    }
    public MenuBuilder active(boolean active) {
        if (hasSubmenu) {
            MenuObject currentSubmenu = getLastMenuItem(getLastMenuItem(menus).getChildren());
            if ( currentSubmenu != null ) {
                currentSubmenu.setActive(active);
            }
        }
        else {
            MenuObject currentMenu = getLastMenuItem(menus);
            if ( currentMenu != null ) {
                currentMenu.setActive(active);
            }
        }
        return this;
    }

    public List<MenuObject> build() {
        List<MenuObject> copyMenus = menus.stream().toList();
        menus = new ArrayList<MenuObject>();
        return copyMenus;
    }
}
