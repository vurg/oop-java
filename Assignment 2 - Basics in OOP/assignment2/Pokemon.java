package assignment2;

public class Pokemon {
    private String name;
    private final String type;
    private Skill skill;
    private final int MAX_HP;
    private int currentHp;
    private final int MAX_EP;
    private int ep;

    public Pokemon(String name, int maxHp, String type){
        this.name = name;
        this.MAX_HP = maxHp;
        this.type = type;
        this.currentHp = maxHp;
        this.MAX_EP = 100;
        this.ep = MAX_EP;
        this.skill = null;
    }

    public String toString(){
        if(this.skill == null){
            String pokemon = String.format(this.name + " (" + this.type + ")");
            return pokemon;
        }else{
            String pokemon = String.format(this.name + " (" + this.type + "). Knows " + this.skill.getName() + " - AP: " + this.skill.getAp() + " EC: " + this.skill.getEc());
            return pokemon;
        }
    }

    public boolean equals(Object anotherObject){
        if(anotherObject == this){
            return true;
        }else if(anotherObject == null){
            return false;
        }else if(anotherObject instanceof Pokemon){
            Pokemon otherPokemon = (Pokemon) anotherObject;

            boolean sameName = this.name.equals(otherPokemon.getName());
            boolean sameType = this.type.equals(otherPokemon.getType());
            boolean sameMaxHp = this.MAX_HP == otherPokemon.getMAX_HP();
            boolean sameHp = this.currentHp == otherPokemon.getCurrentHP();
            boolean sameEP = this.ep == otherPokemon.getEnergy();
            return sameName && sameType && sameMaxHp && sameHp && sameEP;
        }else{
            return false;
        }
    }

    //Checks if pokemon knows skill. Returns false if no skill is learned.
    public boolean knowsSkill(){
        if(this.skill == null){
            return false;
        }else{
            return true;
        }
    }

    //Learns skill or overrides existing skill.
    public void learnSkill(String skillName, int ap, int ec){
        Skill skill = new Skill(skillName, ap, ec);
        this.skill = skill;
    }

    //Forget skill.
    public void forgetSkill(){
        this.skill = null;
    }

    //Pokemon receives damage if the attack is valid.
    private void receiveDMG(double damage){

        if(damage > this.currentHp){
            this.currentHp = 0;
        }else{
            this.currentHp = this.currentHp - (int)damage;
        }
    }

    //Attacks defending pokemon after checking if the attack conditions are valid.
    public String attack(Pokemon defenderPokemon){

        String message = "";

        if(this.isFainted()) {
            message = String.format("Attack failed. " + this.name + " fainted.");
        }else if(defenderPokemon.isFainted()){
            message = String.format("Attack failed. " + defenderPokemon.getName() + " fainted.");
        }else if(this.skill == null){
            message = String.format("Attack failed. " + this.name + " does not know a skill.");
        }else if(this.ep < this.skill.getEc()){
            message = String.format("Attack failed. " + this.name + " lacks energy: " +  this.ep + "/" + this.skill.getEc());
        }else{
            double damageModifier = Battle.damageModifier(this.type, defenderPokemon.getType());
            double totalDamage = (damageModifier * this.skill.getAp());
            defenderPokemon.receiveDMG(totalDamage);
            this.ep = this.ep - this.skill.getEc();

            String optEffect = "";
            String optFaints = "";

            if(damageModifier == 2.0){
                optEffect = " It is super effective!";
            }else if(damageModifier == 0.5){
                optEffect = " It is not very effective...";
            }
            if(defenderPokemon.isFainted()){
                optFaints = " " + defenderPokemon.getName() + " faints.";
            }
            message = String.format(this.name + " uses " + this.skill.getName() + " on " + defenderPokemon.getName() + "." + optEffect + System.lineSeparator() + defenderPokemon.getName() + " has " + defenderPokemon.getCurrentHP() + " HP left." + optFaints);
        }
        return message;
    }

    //Pokemon recovers energy if not fainted.
    public void recoverEnergy(){
        if(this.isFainted()){
            //Do nothing
        }else if(this.ep > (this.MAX_EP - 25)){
            this.ep = this.MAX_EP;
        }else{
            this.ep = this.ep + 25;
        }
    }

    //Resting behaviour increases HP if not fainted. Cant go over Max HP.
    public void rest(){

        if(this.isFainted()){
            //Do nothing.
        }else if (currentHp > (this.MAX_HP - 20)){
            this.currentHp = this.MAX_HP;
        }else{
            this.currentHp = this.currentHp +20;
        }
    }

    //Uses item. Recovered health will never go over Max HP.
    public String useItem(Item item){

        String message = "";

        if(this.currentHp == this.MAX_HP){
            message = this.name + " could not use Potion. HP is already full.";
        }else if(this.currentHp > (this.MAX_HP - item.getHealingPower())){
            message = this.name + " used Potion. It healed " + (this.MAX_HP - this.currentHp) + " HP.";
            this.currentHp = this.MAX_HP;
        }else{
            message = this.name + " used Potion. It healed " + item.getHealingPower() + " HP.";
            this.currentHp = this.currentHp + item.getHealingPower();
        }
        return message;
    }

    //Checks if pokemon is fainted.
    private boolean isFainted() {

        if (this.currentHp == 0) {
            return true;
        }else{
            return false;
        }
    }

    //Getter behaviour.
    public int getEnergy(){return this.ep;}

    public int getCurrentHP(){return currentHp;}

    public String getName(){return this.name;}

    public String getType(){return this.type;}

    public int getMAX_HP(){return this.MAX_HP;}

}
