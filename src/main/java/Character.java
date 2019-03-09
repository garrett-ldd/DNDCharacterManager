import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

/**
 * Holds character state and provides functionality for reading/writing disk and parsing JSON.
 *
 * @author rzc
 */
public class Character {

    private transient String configFileName;

    private String name;

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
        System.out.println("json: " + json);
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

}
