package assignment2;

public enum Type {
    BUG("Bug"),
    DRAGON("Dragon"),
    ELECTRIC("Electric"),
    FIRE("Fire"),
    GRASS("Grass"),
    ICE("Ice"),
    WATER("Water"),
    NORMAL("Normal");

    //attribute (label of enums)
    private final String label;

    //constructor
    Type(String label){
        this.label = label;
    }

    //gets label corresponding to each enum
    public String getLabel(){
        return label;
    }
}







