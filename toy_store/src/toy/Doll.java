package toy;

 public  class Doll extends MasterToy implements IToy {
    private String hairColor;
    private String eyeColor;
    private static int COUNTER = 3000000;
    public Doll(String Name, double MSRP,
                String hairColor,String eyeColor){
        super(Name,MSRP);
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
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
    @Override
    public String toString(){
        String wholeDesc = super.toString() + "hair color=" + this.getHairColor()
                + ", eye color=" + this.getEyeColor() + "]";
        return wholeDesc;


    }
}
