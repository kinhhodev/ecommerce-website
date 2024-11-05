package info.kinhho.kshop.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuObject {

    private String label;
    private String url;
    private String icon;
    private boolean show = true;
    private boolean active = false;
    private boolean disable = false;
    private List<MenuObject> children = new ArrayList<MenuObject>();

    public MenuObject(String label, String url, String icon) {
        this.label = label;
        this.url = url;
        this.icon = icon;
    }

    public MenuObject(String label, String url, String icon, boolean active) {
        this.label = label;
        this.url = url;
        this.icon = icon;
        this.active = active;
    }

    public MenuObject(String label, String url, String icon, boolean show, boolean disable) {
        this.label = label;
        this.url = url;
        this.icon = icon;
        this.show = show;
        this.disable = disable;
    }
    public MenuObject() {

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }
    public String getIconFileContent() {
        try {
            File file = new File(getClass().getResource("/static/svg/" + icon).getFile());
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder output = new StringBuilder();
            while (reader.ready() ) {
                output.append(reader.readLine());
            }
            return output.toString();
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void addChild(MenuObject menuObject) {
        children.add(menuObject);
    }

    public List<MenuObject> getChildren() {
        return children;
    }
}
