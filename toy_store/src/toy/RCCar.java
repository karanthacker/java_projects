package toy;

public class RCCar extends MasterToy implements IToy{
    private BatteryType batteryType;
    private int noOfBatteries;
    private int speed;
    private int batteryLevel = 100;
    private static int COUNTER = 6000000;

     public RCCar(String Name, double MSRP, BatteryType batteryType,
                 int noOfBatteries,int speed){
        super(Name,MSRP);
        this.batteryType = batteryType;
        this.noOfBatteries = noOfBatteries;
        this.speed = speed;

        int ProductCode = COUNTER;
        this.COUNTER += 1;
        super.setProductCode(ProductCode);

    }

    public BatteryType getBatteryType() {
        return batteryType;
    }

    public int getNoOfBatteries() {
        return noOfBatteries;
    }

    public int getSpeed() {

        return speed;
    }

    public int getBatteryLevel() {

        return batteryLevel;
    }

    protected void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString(){
        String wholeDesc = super.toString() + "battery type=" + this.getBatteryType()
                + ", number of batteries=" + this.getNoOfBatteries() +
                ", battery level=" + this.getBatteryLevel() +
                "%, speed=" + this.getSpeed() + "]";
        return wholeDesc;
    }

    @Override
    public void play(){
        if (this.getBatteryLevel() == 0){
            System.out.println("The batteries are dead! Let's replace them...");
            this.setBatteryLevel(100);
        }
        String playStr1 = this.getName()+" races in circles at " + this.getSpeed() + " mph!";
        this.setBatteryLevel(this.getBatteryLevel()-25);
        System.out.println(playStr1);
        super.play();
    }

}
