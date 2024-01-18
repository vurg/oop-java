package assignment2;

public enum Damage {
    SUPER_EFFECTIVE(2.0),
    NOT_EFFECTIVE(0.5),
    NORMAL(1.0);

    private final double dmgMultiplier;

    //constructor
    Damage(double dmgMultiplier){
        this.dmgMultiplier = dmgMultiplier;
    }

    //returns damage multiplier (1.0, 0.5, or 2.0)
    public double dmgMultiplier(){
        return this.dmgMultiplier;
    }


}
