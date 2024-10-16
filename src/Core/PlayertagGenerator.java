package Core;

import java.util.Random;

/**
 * Generate player tag information.
 * This class gives players in this game a unique tag identifier.
 */
public class PlayertagGenerator {
    private  final String CHARACTERS;
    private final  int NUMBERS_MIN; //
    private  final int NUMBERS_MAX; //
    private final String specialCharacter;

    /**
     * Describe all the characters that you want to include in your player tag.
     *
     */
    public PlayertagGenerator() {
        this.CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        this.NUMBERS_MIN = 1;
        this.NUMBERS_MAX =  1000;
        this.specialCharacter = "!@#$%&_^~";
    }

    /***
     * Generate a random string player tag for a specific length of your choice.
     * @return a string representation.
     */
    public  String generateRandomString() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        // Generate a random number between 1000000 and 9999999
        for (int i = 0; i < 2; i++){
            int randomNumber = NUMBERS_MIN + random.nextInt(NUMBERS_MAX - NUMBERS_MIN + 1);
            stringBuilder.append(randomNumber);
        }
        // Generate 2 random characters and append them to the string
        for (int i = 0; i < 2; i++) {
            char randomChar = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            stringBuilder.append(randomChar);
        }

        char specialCharacter1 = specialCharacter.charAt(random.nextInt(specialCharacter.length()));
        stringBuilder.append(specialCharacter1);

        return stringBuilder.toString();
    }

}
