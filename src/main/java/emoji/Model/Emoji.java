package emoji.Model;

import emoji.Utils.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emoji {

    private int id;
    private String code;
    private String characters;

    public Emoji()
    {
       id = 0;
       code = "";
       characters = "";
    }

    public Emoji(int id, String code, String characters) {
        this.id = id;
        this.code = code;
        this.characters = characters;
    }

    public static List<Emoji> findAll()
    {
        try {
            // Création de la liste d'emoji à partir des données en BDD
            List<Emoji> emojis = new ArrayList<>();
            // Envoie une requête en BDD et récupère les résultats
            ResultSet set = DatabaseHandler.query("SELECT * FROM `emoji`");

            while (set.next()) {
                Emoji emoji = new Emoji(
                  set.getInt("id"),
                  set.getString("code"),
                  set.getString("characters")
                );
                // Ajoute l'objet à la liste
                emojis.add(emoji);
            }
            // Renvoie la liste
            return emojis;
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }
}
