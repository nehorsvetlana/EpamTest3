package enums;

public enum DifferentDate {
    CHECKBOX1("Water"),
    CHECKBOX2("Wind"),
    RADIOB("Selen"),
    DROPDOWN("Yellow");
    private String text;
    DifferentDate(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
