package emoji;


import emoji.Model.Emoji;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {
        for (Emoji emoji: Emoji.findAll()) {
            System.out.println(emoji.getCode() + " " +  emoji.getCharacters());
        }
    }
}
