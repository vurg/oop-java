package assignment2;

public class Item {
    private final String name;
    private final int healingPower;
    private final double weight;

    public Item(String name, int healingPower, double weight){
        this.name = name;
        this.healingPower = healingPower;
        this.weight = weight;
    }

    public String toString(){
        String item = String.format("%s heals %d HP. (%.2f)", this.name, this.healingPower, truncate(this.weight));
        return item;
    }

    public boolean equals(Object anotherObject) {
        if (anotherObject == this) {
            return true;
        } else if (anotherObject == null) {
            return false;
        } else if (anotherObject instanceof Item) {
            Item otherItem = (Item) anotherObject;
            boolean sameName = this.name.equals(otherItem.getName());
            boolean sameHealingPower = this.healingPower == otherItem.getHealingPower();
            boolean sameWeight = this.weight == otherItem.getWeight();
            return sameName && sameHealingPower && sameWeight;
        }else{
            return false;
        }
    }

    //When called by toString, makes sure that all doubles have two decimals.
    private double truncate(double weight){
        weight = weight * 100;
        int truncated = (int) weight;
        weight = (double) truncated;
        weight = weight/100.00;

        return weight;
    }

    //Getter behaviours.
    public String getName(){return this.name;}

    public int getHealingPower(){return this.healingPower;}

    public double getWeight(){return  this.weight;}

}
