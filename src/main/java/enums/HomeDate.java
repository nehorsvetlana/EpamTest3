package enums;

import java.util.Arrays;

public enum HomeDate {
    LOGIN("epam"),
    PASSWORD("1234"),
    USER_NAME("PITER CHAILOVSKII"),
    HOME_PAGE_TEXT1("To include good practices\nand ideas from successful\nEPAM projec"),
    HOME_PAGE_TEXT2("To be flexible and\ncustomizable"),
    HOME_PAGE_TEXT3("To be multiplatform"),
    HOME_PAGE_TEXT4("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
    HOME_PAGE_TEXT("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
    HOME_PAGE_TITLE("EPAM framework Wishes…"),
    HOME_PAGE_DROP_HEADER_MENU_T1("Support"),
    HOME_PAGE_DROP_HEADER_MENU_T2("Dates"),
    HOME_PAGE_DROP_HEADER_MENU_T3("Complex Table"),
    HOME_PAGE_DROP_HEADER_MENU_T4("Simple Table"),
    HOME_PAGE_DROP_HEADER_MENU_T5("Table with pages"),
    HOME_PAGE_DROP_HEADER_MENU_T6("Different Elements");
    private String text;
    HomeDate(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
       return this.text;
    }


}
