package info.kinhho.kshop.controller.admin;

import info.kinhho.kshop.constant.GeneralSetting;
import info.kinhho.kshop.constant.MenuSetting;
import info.kinhho.kshop.dto.AdminPageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class DashboardAdminController {

    private final GeneralSetting generalSetting;

    public DashboardAdminController(GeneralSetting generalSetting) {
        this.generalSetting = generalSetting;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        // get file html at templates/admin/dashboard.html
        return AdminPageBuilder.newInstance(model)
                .withPageTitle("Dashboard")
                .withPageContent("admin/dashboard")
                .withMenuType(generalSetting.getMenuType())
                .withPageMode(generalSetting.getMenuMode())
                .withMenuData(MenuSetting.ofDashBoard())
                .build();
    }
}
