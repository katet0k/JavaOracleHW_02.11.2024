public abstract class AbstractBuilding implements Building {
    protected String address;

    public AbstractBuilding(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}