package info.kinhho.kshop.dto;

import info.kinhho.kshop.constant.MenuSetting;
import info.kinhho.kshop.objects.MenuObject;
import org.springframework.ui.Model;

import java.util.List;

public class AdminPageBuilder {

    private final Model model;
    private String pageTitle;
    private String pageContentFile;
    private String menuType = MenuSetting.MENU_NORMAL;
    private String pageMode;
    private List<MenuObject> menuData;

    private AdminPageBuilder(Model model) {
        this.model = model;
    }
    public static AdminPageBuilder newInstance(Model model) {
        return new AdminPageBuilder(model);
    }

    public AdminPageBuilder withPageContent(String pageContent) {
        this.pageContentFile = pageContent;
        return this;
    }

    public AdminPageBuilder withPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        return this;
    }

    public AdminPageBuilder withMenuType(String menuType) {
        this.menuType = menuType;
        return this;
    }

    public AdminPageBuilder withPageMode(String pageMode) {
        this.pageMode = pageMode;
        return this;
    }
    public AdminPageBuilder withMenuData(List<MenuObject> menuData) {
        this.menuData = menuData;
        return this;
    }

    public String build() {
        this.model.addAttribute("PageTitle", this.pageTitle);
        this.model.addAttribute("PageContent", this.pageContentFile);
        this.model.addAttribute("MenuType", this.menuType);
        this.model.addAttribute("Menus", this.menuData);
        this.model.addAttribute("PageMode", this.pageMode);

        return "admin/index";
    }
}
