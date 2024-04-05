package toy;

 public class Robot extends MasterToy implements IToy {
    private BatteryType batteryType;
    private int noOfBatteries;
    private String sound;
    private int batteryLevel = 100;
    private static int COUNTER = 7000000;

     public Robot(String Name,double MSRP,BatteryType batteryType,
                 int noOfBatteries,String sound){
        super(Name,MSRP);
        this.batteryType = batteryType;
        this.noOfBatteries = noOfBatteries;
        this.sound = sound;

        int ProductCode = COUNTER;
        this.COUNTER += 1;
        super.setProductCode(ProductCode);

    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public BatteryType getBatteryType() {
        return batteryType;
    }

    public int getNoOfBatteries() {
        return noOfBatteries;
    }

    public String getSound() {
        return sound;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString(){
        String wholeDesc = super.toString() + "battery type=" + this.getBatteryType()
                + ", number of batteries=" + this.getNoOfBatteries() +
                ", battery level=" + this.getBatteryLevel() +
                "%, sound=" + this.getSound() + "]";
        return wholeDesc;
    }

    @Override
    public void play(){
        if (this.getBatteryLevel() == 0){
            System.out.println("The batteries are dead! Let's replace them...");
            this.setBatteryLevel(100);
        }
        this.setBatteryLevel(this.getBatteryLevel()-15);
        String playStr1 = this.getName()+" goes '" + this.getSound() + "'";
        System.out.println(playStr1);
        super.play();
    }

}
