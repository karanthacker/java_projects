package toy;

 public class ActionFigure extends MasterToy implements IToy {
    private String hairColor;
    private String eyeColor;
    private static int COUNTER = 5000000;
    private boolean kungFuGrip;
    public ActionFigure(String Name, double MSRP,String hairColor,
                        String eyeColor,boolean kungFuGrip){
        super(Name,MSRP);
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.kungFuGrip = kungFuGrip;
        int ProductCode = COUNTER;
        this.COUNTER += 1;
        super.setProductCode(ProductCode);

    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isKungFuGrip() {
        return kungFuGrip;
    }

    @Override
    public String toString(){
        String wholeDesc = super.toString() + "hair color=" + this.getHairColor()
                + ", eye color=" + this.getEyeColor() + ", kung-fu grip=" + this.isKungFuGrip()+ "]";
        return wholeDesc;
    }

}
