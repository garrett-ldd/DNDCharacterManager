package model;

import action.WeaponAttack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spell.Spell;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * Holds character state and provides functionality for reading/writing disk and parsing JSON.
 *
 * @author rzc
 *
 * TODO make this class abstract and subclass for different dnd classes
 */
public class Character {

    private transient String configFileName;

    private String name;
    private String race;
    private String characterClass;
    private String alignment;
    private String size;
    private int age;
    private int level;
    private int hitPoints;
    private int hitPointMax;
    private int armorClass;
    private int speed;
    private int remainingHitDie;
    private Map<String, Integer> abilityScores;
    private Map<Integer, SpellSlot> spellSlots;
    private WeaponAttack[] weaponAttacks;
    private Spell[] spells;

    public static Character loadFromDisk(String jsonCharacterFilePath) throws FileNotFoundException {
        // read file into memory
        Scanner configReader = new Scanner(new File(jsonCharacterFilePath));
        StringBuilder builder = new StringBuilder();
        while (configReader.hasNext()) {
            builder.append(configReader.next() + " ");
        }

        // parse into character
        Gson gson = new Gson();
        Character character = null;
        try {
            character = gson.fromJson(builder.toString(), Character.class);
            character.configFileName = jsonCharacterFilePath;
        } catch (Exception e) {
            System.err.println("Exception parsing character file: " + e.getMessage());
        }

        return character;
    }

    public void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(configFileName));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getConfigFileName() {
        return configFileName;
    }

    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public WeaponAttack[] getWeaponAttacks() {
        return weaponAttacks;
    }

    public void setActions(WeaponAttack[] weaponAttacks) {
        this.weaponAttacks = weaponAttacks;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHitPointMax() {
        return hitPointMax;
    }

    public void setHitPointMax(int hitPointMax) {
        this.hitPointMax = hitPointMax;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRemainingHitDie() {
        return remainingHitDie;
    }

    public void setRemainingHitDie(int remainingHitDie) {
        this.remainingHitDie = remainingHitDie;
    }

    public Map<String, Integer> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(Map<String, Integer> abilityScores) {
        this.abilityScores = abilityScores;
    }

    public void setWeaponAttacks(WeaponAttack[] weaponAttacks) {
        this.weaponAttacks = weaponAttacks;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Spell[] getSpells() {
        return spells;
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
    }

    public Map<Integer, SpellSlot> getSpellSlots() {
        return spellSlots;
    }

    public void setSpellSlots(Map<Integer, SpellSlot> spellSlots) {
        this.spellSlots = spellSlots;
    }
}
