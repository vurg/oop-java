package assignment2;

public class Skill {
    private final String name;
    private final int ap;
    private final int ec;

    public Skill(String name, int ap, int ec){
        this.name = name;
        this.ap = ap;
        this.ec = ec;
    }

    public String toString(){
        String skill = String.format(this.name + " - AP: " + this.ap +" EC: " + this.ec);
        return skill;
    }

    public boolean equals(Object anotherObject){

        if(anotherObject == this){
            return true;
        }else if(anotherObject == null){
            return false;
        }else if(anotherObject instanceof Skill){

            Skill otherSkill = (Skill) anotherObject;

            boolean sameName = this.name.equals(otherSkill.getName());
            boolean sameAP = this.ap == otherSkill.getAp();
            boolean sameEc = this.ec == otherSkill.getEc();
            return sameName && sameAP && sameEc;
        }else{
            return false;
        }
    }

    //Getter behaviours.
    public String getName(){return this.name;}
    public int getAp(){return this.ap;}
    public int getEc() {return this.ec;}
}
