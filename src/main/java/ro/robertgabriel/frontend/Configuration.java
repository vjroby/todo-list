package ro.robertgabriel.frontend;

import java.util.LinkedList;
import java.util.List;

public class Configuration {
    private String appName = "Todo List Web App";
    private List<MenuItem> menuItems;
    private String appSubtitle = "Create your own todo list...SOON!";

    public Configuration(){
        List<MenuItem> menuItemList = new LinkedList<MenuItem>();
        menuItemList.add((new MenuItem().setName("Home").setUrl("#top")));
        menuItemList.add((new MenuItem().setName("About").setUrl("#about")));
        menuItemList.add((new MenuItem().setName("Services").setUrl("#services")));
        menuItemList.add((new MenuItem().setName("Portfolio").setUrl("#portfolio")));
        menuItemList.add((new MenuItem().setName("Contact").setUrl("#contact")));
        this.setMenuItems(menuItemList);
    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getAppSubtitle() {
        return appSubtitle;
    }

    public void setAppSubtitle(String appSubtitle) {
        this.appSubtitle = appSubtitle;
    }
}
