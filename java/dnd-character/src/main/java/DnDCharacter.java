import java.util.concurrent.ThreadLocalRandom;

class DnDCharacter {
  private int strength = ability();
  private int dexterity = ability();
  private int constitution = ability();
  private int intelligence = ability();
  private int wisdom = ability();
  private int charisma = ability();
  private int hitpoints;

  public DnDCharacter() {
    hitpoints = 10 + modifier(constitution);
  }

  public int getHitpoints() {
    return hitpoints;
  }

  public int getCharisma() {
    return charisma;
  }

  public int getWisdom() {
    return wisdom;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getStrength() {
    return strength;
  }

  int ability() {
    return ThreadLocalRandom.current().nextInt(3, 19);
  }

  int modifier(int input) {
    return (int) Math.floorDiv((input - 10), 2);
  }

}
