package emoji.Model;

import emoji.Utils.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tag {

    private int id;
    private String name;

    public Tag() {
        id = 0;
        name = "";
    }

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Tag> findAll()
    {
        try {
            // Création de la liste de tags à partir des données en BDD
            List<Tag> tags = new ArrayList<>();
            // Envoie une requête en BDD et récupère les résultats
            ResultSet set = DatabaseHandler.query("SELECT * FROM tags");

            while (set.next()) {
                Tag tag = new Tag(
                    set.getInt("id"),
                    set.getString("name")
                );
                // Ajoute l'objet à la liste
                tags.add(tag);
            }
            // Renvoie la liste
            return tags;
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    public static Tag findById(int id)
    {
        try {
            // Envoie une requête en base de données
            DatabaseHandler dbHandler = DatabaseHandler.getInstance();
            PreparedStatement statement = dbHandler.getConnection().prepareStatement("SELECT * FROM tags WHERE id = ?"
                // Rajouter ces deux lignes si on rencontre une erreur de type "Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY"
                , ResultSet.TYPE_SCROLL_SENSITIVE
                , ResultSet.CONCUR_UPDATABLE
            );
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();

            // Comme on sait que la requête peut uniquement renvoyer un seul résultat (s'il existe),
            // ou aucun (s'il n'existe pas), cherche le premier résultat de la requête...
            if (set.first()) {
                // ...et renvoie un nouvel objet à partir de ses données
                return new Tag(
                    set.getInt("id"),
                    set.getString("name")
                );
                // Si la requête ne renvoie aucun résultat, renvoie null
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}
