/**
 * @author Alpha
 * class - Dacia, parent - car.
 * Defines Dacia cars, some may have special attributes
 */
public abstract class Dacia extends Car {
    private boolean specialAttribute;
    public Dacia(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tyreSize,boolean specialAttribute) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType);
        setTyreSize(tyreSize);
        setSpecialAttribute(specialAttribute);
    }

    public boolean isSpecialAttribute() {
        return specialAttribute;
    }

    public void setSpecialAttribute(boolean specialAttribute) {
        this.specialAttribute = specialAttribute;
    }
}
