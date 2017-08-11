/**
 * @author Alpha
 * class - Cobra, parent - Mercedes.
 * The car has increased consumption when tyres exceed size 17
 */
public class Cobra extends Mercedes {
    public Cobra(float availableFuel, String chassisNumber, float fuelTankSize, String fuelType, int tyreSize, boolean sportMode) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tyreSize,sportMode);
    }

    @Override
    public void drive(float distance) {
        setGearsConsumption(10,11,13,15,17,20);
        if(getTyreSize()>17)//consumption increases if tyre size is bigger than 17
            setCurrentConsumption(getCurrentConsumption()* getTyreSize()/10);//measuring consumption based on tyre size
        setAvailableFuel(getAvailableFuel()-(getCurrentConsumption()*distance/100));
        setConsumptionMeter(getConsumptionMeter()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+ getCurrentConsumption());
    }
}
