public class ResidentialHouse extends AbstractBuilding {
    private int residents;

    public ResidentialHouse(String address, int residents) {
        super(address);
        this.residents = residents;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    @Override
    public void setFieldsFromString(String input) {
        try {
            this.residents = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат ввода для жилого дома.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Жилой дом, Адрес: " + address + ", Количество жильцов: " + residents);
    }
}