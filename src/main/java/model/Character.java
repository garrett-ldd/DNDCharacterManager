package model;

import action.WeaponAttack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Holds character state and provides functionality for reading/writing disk and parsing JSON.
 *
 * @author rzc
 */
public class Character {

    private transient String configFileName;

    private String name;
    private String race;
    private String characterClass;
    private String alignment;
    private int level;
    private WeaponAttack[] weaponAttacks;

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

    @Override
    public String toString() {
        return "model.Character{" +
                "configFileName='" + configFileName + '\'' +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", alignment='" + alignment + '\'' +
                ", level=" + level +
                ", actions=" + Arrays.toString(weaponAttacks) +
                '}';
    }
}
