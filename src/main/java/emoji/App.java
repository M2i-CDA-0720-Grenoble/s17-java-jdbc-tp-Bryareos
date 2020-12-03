package emoji;


import emoji.Model.Emoji;

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
            System.out.println(emoji.getCode() + " " +  emoji.getCharacters());
        }
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("> ");
        String userInput = scanner.nextLine().trim().toLowerCase();
        Emoji emoji = Emoji.findByCode(userInput);
        System.out.println(emoji.getCharacters());
    }
}
