/**
 * 
 */
package it.aren.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.aren.common.Constant;
import it.aren.common.Settings;

/**
 * 
 *
 */
public class SettingsSaver implements FileSaver<Settings> {

    private static Gson gson;
    
    @Override
    public void saveFile(final Settings objToSave, final String fileName) {
        try (Writer writer = new FileWriter(Constant.MAIN_FOLDER + Constant.SEP + fileName)) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(objToSave, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveSettings(final Settings objToSave) {
        final SettingsSaver saver = new SettingsSaver();
        saver.saveFile(objToSave, "settings.json");
    }
}