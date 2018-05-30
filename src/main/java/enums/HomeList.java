package enums;

public enum HomeList {
    MENU_TEXTS(new String[]{"Support",
            "Dates",
            "Complex Table",
            "Simple Table",
            "Table With Pages",
            "Different Elements"
    });
    public String[] strList;

    HomeList(String[] i) {
        strList = i;
    }
}
