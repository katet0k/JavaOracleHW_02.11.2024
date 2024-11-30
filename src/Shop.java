import java.util.List;

public class Shop extends AbstractBuilding {
    private List<String> departments;

    public Shop(String address, List<String> departments) {
        super(address);
        this.departments = departments;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public void setFieldsFromString(String input) {
        this.departments = List.of(input.split(","));
    }

    @Override
    public void displayInfo() {
        System.out.println("Магазин, Адрес: " + address + ", Отделы: " + departments);
    }
}