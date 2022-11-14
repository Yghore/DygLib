package fr.yghore.dyglib.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
import java.time.LocalDateTime;

public class Json
{

    private final static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .setPrettyPrinting()
            .create();
    private transient String path;


    public Json(String path) {
        this.path = path;
    }

    public Json(){}


    /**
     * Permet de sauvegarder l'objet dans le fichier défini dans l'attribut path
     * Pour définir cette attribut, il faut passer par le {@link #Json(String) constructeur} ou la méthode {@link #setPath(String) setPath}
     */
    public void save(){
        File file = new File(path);
        try {
            if(!file.exists()){file.createNewFile();}


            String jsonText = GSON.toJson(this);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonText);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Chargement d'un fichier json
     * @param path Le fichier à charger
     * @param className La classe qui va être utilisé pour la création de l'objet (qui doit implémenter Salvageable)
     * @return L'instance de la classe passé en paramètre
     * @throws FileNotFoundException Permet de définir la chose à faire si le fichier n'existe pas (création d'un constructeur, etc...)
     */
    public static Json load(String path, Class<? extends Salvageable> className) throws FileNotFoundException {

            Json json = (Json) GSON.fromJson(new FileReader(path), className);
            json.path = path;
            return json;



    }

    public Json setPath(String path)
    {
        this.path = path;
        return this;
    }


}
