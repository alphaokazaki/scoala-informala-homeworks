/**
 * @author Alpha
 * class - Duster, parent - Dacia.
 * The car has on-the-go WiFi, if it's on, the fuel consumption increases by 5%
 */
public class Duster extends Dacia {
    public Duster(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType,int tyreSize,boolean wifi) {
        super(availableFuel, chassisNumber,fuelTankSize,fuelType,tyreSize,wifi);
    }

    @Override
    public void drive(float distance){
        setGearsConsumption(7,6,5,7,8,7);
        if(isSpecialAttribute())//if WiFi is on
            setCurrentConsumption(getCurrentConsumption()+ getCurrentConsumption()*5/100);//consumption increased by 5%
        setAvailableFuel(getAvailableFuel()-(getCurrentConsumption()*distance/100));
        setConsumptionMeter(getConsumptionMeter()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+ getCurrentConsumption());
    }
}
