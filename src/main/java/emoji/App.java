package emoji;


import emoji.Model.Emoji;
import emoji.Utils.ConsoleColor;

import java.util.Scanner;

public final class App {
    private static Scanner scanner;
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {
        for (Emoji emoji: Emoji.findAll()) {
            System.out.println(emoji.getCode() + " - " +  emoji.getCharacters());
        }
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.print("> ");
        String userInput = scanner.nextLine().trim().toLowerCase();
        Emoji emoji = Emoji.findByCode(userInput);
        System.out.println(emoji.getCharacters());

        System.out.println(ConsoleColor.MAGENTA + "Rechercher un nom de catégorie et lister les emojis y appertenant " + ConsoleColor.RESET);
        System.out.print("> ");
        String input = scanner.nextLine().trim().toLowerCase();
        System.out.println(ConsoleColor.MAGENTA + "Liste des emojis dans la catégorie `" + input + "`" + ConsoleColor.RESET);
        for (Emoji emojiByCategory: Emoji.findByCategory(input)) {
            System.out.println(emojiByCategory.getCode() + " " +  emojiByCategory.getCharacters());
        }
    }
}
