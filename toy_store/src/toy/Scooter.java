package toy;

  public class Scooter extends MasterToy implements IToy{

    private String color;
    private String wheels;
    private int odometer = 0;
    private static int COUNTER = 9000000;

     public Scooter(String name, double MSRP,
                   String color,String wheels){
        super(name,MSRP);
        this.color = color;
        this.wheels = wheels;
        int ProductCode = COUNTER;
        this.COUNTER += 1;
        super.setProductCode(ProductCode);

    }

    public String getColor() {
        return color;
    }

    public String getWheels() {
        return wheels;
    }

    public int getOdometer() {
        return odometer;
    }

    @Override
    public void play() {
        super.play();
        odometer += 2;
    }
    @Override
    public String toString(){
        String wholeDesc = super.toString() + "color=" + this.getColor() + ", wheels=" + this.getWheels()
                + ", odometer=" + this.getOdometer() + "]";
        return wholeDesc;

    }

}
