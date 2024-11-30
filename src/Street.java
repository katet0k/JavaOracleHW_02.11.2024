import java.util.ArrayList;
import java.util.List;

public class Street {
    private String name;
    private List<Building> buildings;

    public Street(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(String address) {
        buildings.removeIf(building -> building.getAddress().equals(address));
    }

    public void displayStreetInfo() {
        System.out.println("Улица: " + name);
        for (Building building : buildings) {
            building.displayInfo();
        }
    }

    public void findShopsNearHouse(String houseAddress, String departmentType, int range) {
        System.out.println("Магазины с отделом \"" + departmentType + "\" в радиусе " + range + " домов от " + houseAddress + ":");
        int houseIndex = -1;

        for (int i = 0; i < buildings.size(); i++) {
            if (buildings.get(i) instanceof ResidentialHouse && buildings.get(i).getAddress().equals(houseAddress)) {
                houseIndex = i;
                break;
            }
        }

        if (houseIndex == -1) {
            System.out.println("Жилой дом с адресом " + houseAddress + " не найден.");
            return;
        }

        for (int i = Math.max(0, houseIndex - range); i <= Math.min(buildings.size() - 1, houseIndex + range); i++) {
            if (buildings.get(i) instanceof Shop) {
                Shop shop = (Shop) buildings.get(i);
                if (shop.getDepartments().contains(departmentType)) {
                    shop.displayInfo();
                }
            }
        }
    }
}