/**
 * @author Alpha
 * Class - Mercedes, parent - Car.
 * Defines Mercedes cars, some may have a sport mode
 */
public abstract class Mercedes extends Car {
    private boolean sportMode;
    public Mercedes(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tyreSize,boolean sportMode) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType);
        setTyreSize(tyreSize);
        setSportMode(sportMode);
    }

    public boolean isSportMode() {
        return sportMode;
    }

    public void setSportMode(boolean sportMode) {
        this.sportMode = sportMode;
    }
}
