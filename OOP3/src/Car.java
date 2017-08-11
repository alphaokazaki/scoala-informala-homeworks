/**
 * @author Alpha
 * Implements Vehicle, defines all cars.
 */
public abstract class Car implements Vehicle {

    //static properties of cars
    private float fuelTankSize;
    private  String fuelType;
    private  int gears;
    private  float consumptionPer100Km;

    //configurable properties
    private float availableFuel;
    private int tyreSize;

    //instance specific properties
    private String chassisNumber;
    private int currentGear;
    private float currentConsumption;
    private int consumptionMeter;

    public Car(float availableFuel, String chassisNumber,float fuelTankSize,String fuelType){
        this.availableFuel=availableFuel;
        this.chassisNumber=chassisNumber;
        this.fuelTankSize=fuelTankSize;
        this.fuelType=fuelType;
    }

    /**
     * Consumption per 100km, consumption meter, current gear is set to 0 on start.
     */
    @Override
    public void start() {
    setConsumptionPer100Km(0);
    setConsumptionMeter(0);
    setCurrentGear(0);
    }

    /**
     * Current gear is set to 0 on stop.
     * Average consumption per 100km is calculated on stop.
     */
    @Override
    public void stop(){
    setCurrentGear(0);
    setConsumptionPer100Km(consumptionPer100Km/ consumptionMeter);
    }

    /**
     * The following function calculates the available fuel depending on consumption and distance.
     * @param distance
     */
    public void drive(float distance){
        setAvailableFuel(getAvailableFuel()-(getCurrentConsumption()*distance/100));
        setConsumptionMeter(getConsumptionMeter()+1);
        setConsumptionPer100Km(getConsumptionPer100Km()+ getCurrentConsumption());
    }

    /**
     * Calculating the consumption for each gear.
     */
    public void setGearsConsumption(float consumption1,float consumption2,float consumption3,float consumption4,float consumption5,float consumption6){
        switch(getCurrentGear()){
            case 1:{
                setCurrentConsumption(consumption1);
            }break;

            case 2:{
                setCurrentConsumption(consumption2);
            }break;

            case 3:{
                setCurrentConsumption(consumption3);
            }break;

            case 4:{
                setCurrentConsumption(consumption4);
            }break;

            case 5:{
                setCurrentConsumption(consumption5);
            }break;

            case 6:{
                setCurrentConsumption(consumption6);
            }break;

            default:{
                if(getCurrentGear()==0)
                    System.out.println("you're in neutral");
                else
                    System.out.println("inexistent gear");
            }break;
        }
    }

    public void shiftGear(int nextGear){
    this.currentGear =nextGear;
    }

    public float getFuelTankSize() {
        return fuelTankSize;
    }

    public void setFuelTankSize(float fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public float getConsumptionPer100Km() {
        return consumptionPer100Km;
    }

    public void setConsumptionPer100Km(float consumptionPer100Km) {
        this.consumptionPer100Km = consumptionPer100Km;
    }

    public float getAvailableFuel() {
        return availableFuel;
    }

    public void setAvailableFuel(float availableFuel) {
        this.availableFuel = availableFuel;
    }

    public int getTyreSize() {
        return tyreSize;
    }

    public void setTyreSize(int tyreSize) {
        this.tyreSize = tyreSize;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public float getCurrentConsumption() {
        return currentConsumption;
    }

    public void setCurrentConsumption(float currentConsumption) {
        this.currentConsumption = currentConsumption;
    }

    public int getConsumptionMeter() {
        return consumptionMeter;
    }

    public void setConsumptionMeter(int consumptionMeter) {
        this.consumptionMeter = consumptionMeter;
    }
}
