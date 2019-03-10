import java.util.Map;

public class WeaponAttack implements Action {

    private String name;
    private String weapon;
    private String damageType;
    private Map<Integer, Integer> damageDice; // i.e. d6 -> 2 (num rolls)

    public WeaponAttack(String name, String weapon, String damageType, Map<Integer, Integer> damageDice) {
        this.name = name;
        this.weapon = weapon;
        this.damageType = damageType;
        this.damageDice = damageDice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(Character character) {
        System.out.println("Hit die: " + rollHit());
        System.out.println("Hit? [y/n] ");
        if (Resource.console().nextLine().trim().equalsIgnoreCase("y")) {
            System.out.println("Damage: " + rollDamage() + " " + damageType + " damage!");
        }
        return true;
    }

    private int rollHit() {
        // TODO: prof and bonus
        return Dice.roll(20);
    }

    private int rollDamage() {
        int totalDamage = 0;
        for (int die : this.damageDice.keySet()) {
            for (int i = 0; i < damageDice.get(die); i++) {
                totalDamage += Dice.roll(die);
            }
        }
        return totalDamage;
    }

    @Override
    public String toString() {
        return "WeaponAttack{" +
                "weapon='" + weapon + '\'' +
                ", damageType='" + damageType + '\'' +
                ", damageDice=" + damageDice +
                '}';
    }
}
