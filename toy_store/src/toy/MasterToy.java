package toy;
import java.text.DecimalFormat;
  abstract class MasterToy {
    private int ProductCode;
    private String Name;
    private Condition Condition;
    private double MSRP;
    private double ResaleValue;

    protected MasterToy(String Name, double MSRP){
        this.Name = Name;
        this.ResaleValue = MSRP;
        this.MSRP = MSRP;
        this.Condition = Condition.MINT;

    }

    public int getProductCode() {
        return ProductCode;
    }

    public String getName() {
        return Name;
    }

    public Condition getCondition() {
        return Condition;
    }

    public double getMSRP() {
        return MSRP;
    }

    public double getResaleValue() {
        return ResaleValue;
    }

    public void setProductCode(int code) {
        this.ProductCode = code;
    }

    public void setResaleValue(double resaleValue) {
        ResaleValue = resaleValue;
    }

    public void setCondition(toy.Condition condition) {
        Condition = condition;
    }

    public void play(){
        Condition newCondition = Condition.degrade();
        this.setCondition(newCondition);
        double multiplier = this.getCondition().getMultiplier();
        setResaleValue(multiplier * this.getMSRP());
        System.out.println("After play, " + this.getName() + "'s condition is " + this.getCondition());

    }

    public String toString(){
       // DecimalFormat df = new DecimalFormat("####0.00");
        String descToy = this.getName() + " [product code=" + this.getProductCode()
               + ", MSRP=" + String.format("%.2f", this.getMSRP())+", condition=" + this.getCondition()
                + ", resale value="+String.format("%.2f", this.getResaleValue()) + ", ";
        return descToy;
    }


}
