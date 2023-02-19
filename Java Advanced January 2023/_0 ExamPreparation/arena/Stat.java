package arena;

public class Stat {
    private int strength;
    private int flexibility;
    private int agility;
    private int skills;
    private int intelligence;

    public Stat(int strength, int flexibility, int agility, int skills, int intelligence) {
        this.strength = strength;
        this.flexibility = flexibility;
        this.agility = agility;
        this.skills = skills;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(int flexibility) {
        this.flexibility = flexibility;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
