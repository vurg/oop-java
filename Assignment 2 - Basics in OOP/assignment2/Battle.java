package assignment2;

public class Battle {

    //Method matches enum type with pokemon type.
    private static Type whatEnumType(String pokemonType){

        Type enumType = null;

        if(pokemonType.equals(Type.BUG.getLabel())){
            enumType = Type.BUG;
        }else if(pokemonType.equals(Type.DRAGON.getLabel())){
            enumType = Type.DRAGON;
        }else if(pokemonType.equals(Type.ELECTRIC.getLabel())){
            enumType = Type.ELECTRIC;
        }else if(pokemonType.equals(Type.FIRE.getLabel())){
            enumType = Type.FIRE;
        }else if(pokemonType.equals(Type.GRASS.getLabel())){
            enumType = Type.GRASS;
        }else if(pokemonType.equals(Type.ICE.getLabel())){
            enumType = Type.ICE;
        }else if(pokemonType.equals(Type.WATER.getLabel())){
            enumType = Type.WATER;
        }else if(pokemonType.equals(Type.NORMAL.getLabel())){
                enumType = Type.NORMAL;
        }return enumType;
    }

    //Method returns damage multiplier based on attacker and defender type.
    public static double damageModifier(String attacker, String defender){

        Type attackerType = whatEnumType(attacker);
        Type defenderType = whatEnumType(defender);
        double multiplier = Damage.NORMAL.dmgMultiplier();

        if(attackerType == Type.BUG){

            switch (defenderType) {
                case GRASS: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                break;
                case FIRE: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }

        if(attackerType == Type.DRAGON){

            switch (defenderType) {
                case DRAGON: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }

        if(attackerType == Type.ELECTRIC){

            switch (defenderType) {
                case WATER: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case DRAGON: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case ELECTRIC: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case GRASS: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }

        if(attackerType == Type.FIRE){

            switch (defenderType) {
                case BUG: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case GRASS: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case ICE: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case DRAGON: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case FIRE: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case WATER: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }

        if(attackerType == Type.GRASS){

            switch (defenderType) {
                case WATER: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case BUG: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case DRAGON: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case FIRE: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case GRASS: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }

        if(attackerType == Type.ICE){

            switch (defenderType) {
                case DRAGON: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case GRASS: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case FIRE: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case ICE: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case WATER: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }

        if(attackerType == Type.WATER){

            switch (defenderType) {
                case FIRE: multiplier = Damage.SUPER_EFFECTIVE.dmgMultiplier();
                    break;
                case DRAGON: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case GRASS: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                case WATER: multiplier = Damage.NOT_EFFECTIVE.dmgMultiplier();
                    break;
                default: multiplier = Damage.NORMAL.dmgMultiplier();
            }
        }
        return multiplier;
    }
}
