package fr.yghore.dyglib.Configuration;

import fr.yghore.dyglib.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

/**
 * Classe pour la gestion de la configuration
 */
public class Configuration
{

    private File fileConfig;


    private static Configurable config;

    public Configuration(String fileName, boolean defaultConfig, String logger)
    {
        new Logger(logger);
        this.fileConfig = new File(fileName);
        if(!fileConfig.exists())
        {
            Logger.getLogger().sendInfo(new String[]{"Le fichier n'existe pas !", "Création du fichier en cours..."});

            try {
                fileConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Logger.getLogger().sendError("\nUne erreur est survenue lors de la création du fichier de configuration");
                System.exit(1);
            }

            if(defaultConfig)
            {
                InputStream dconfig = Configuration.class.getClassLoader().getResourceAsStream("config.yml");
                try {
                    OutputStream file = new FileOutputStream(fileConfig);
                    file.write(dconfig.readAllBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                    Logger.getLogger().sendError("\nUne erreur est survenue lors de la création du fichier de configuration");
                    System.exit(1);
                }
            }

        }


    }

    /**
     * Permet de charger un fichier de configuration (la classe donnée pour le chargement doit forcémenent implémenter la classe Configurable
     * @see Configurable
     * @param c La classe qui fait office de structure pour le fichier
     * @return Une instance de la classe passé en paramètre avec les attributs définis
     * @throws ConfigurationException Si le fichier est mal formée par rapport à la classe
     */
    public Configurable loadConfig(Class<? extends Configurable> c) throws ConfigurationException
    {
        try {
            Yaml yaml = new Yaml(new Constructor(c));
            InputStream inputStream = new FileInputStream(this.fileConfig);
            Configurable config = yaml.load(inputStream);
            if(config == null)
            {
                throw new ConfigurationException("La configuration n'est pas bien formée !");
            }
            Configuration.config = config;
            return config;
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
            Logger.getLogger().sendError("Le fichier n'existe pas !");
            System.exit(1);
        }
        return null;
    }

    /**
     *
     * @return Retourne l'objet instancié si l'objet n'a pas été récupéré lors du chargement
     * @throws ConfigurationException
     */
    public static Configurable getConfig() throws ConfigurationException {
        if(Configuration.config == null)
        {
            throw new ConfigurationException("La configuration n'a pas êté correctement récupérée");
        }
        return Configuration.config;
    }


}
