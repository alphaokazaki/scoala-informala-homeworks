/**
 * @author Alpha
 * class - Logan , parent - Dacia
 * The car has AC, if it's on, the fuel consumption will be increased by 50%
 */
public class Logan extends Dacia {
    public Logan(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tyreSize,boolean airConditioner) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tyreSize,airConditioner);
    }

    @Override
    public void drive(float distance){
        setGearsConsumption(7,6,5,7,8,7);
        if(isSpecialAttribute())//if AC is on
            setCurrentConsumption(getCurrentConsumption()+ getCurrentConsumption()*50/100);//consumption increased by 50%
        setAvailableFuel(getAvailableFuel()-(getCurrentConsumption()*distance/100));
        setConsumptionMeter(getConsumptionMeter()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+ getCurrentConsumption());
    }
}
