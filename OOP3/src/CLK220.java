/**
 * @author Alpha
 * Class - CLK220, parent - Mercedes.
 * The car has a sport mode, if it's on, fuel consumption increases by 50%
 */
public class CLK220 extends Mercedes {
    public CLK220(float availableFuel, String chassisNumber, float fuelTankSize, String fuelType, int tyreSize, boolean sportMode) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tyreSize,sportMode);
    }
    @Override
    public void drive(float distance){

        setGearsConsumption(10,9,8,10,11,13);
        if(isSportMode())//if sport mode is active
            setCurrentConsumption(getCurrentConsumption()+ getCurrentConsumption()*50/100);//consumption increases by 50%
        setAvailableFuel(getAvailableFuel()-(getCurrentConsumption()*distance/100));
        setConsumptionMeter(getConsumptionMeter()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+ getCurrentConsumption());
    }
}
