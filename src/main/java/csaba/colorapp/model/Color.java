package csaba.colorapp.model;

import java.util.regex.Pattern;

public class Color {
    private static final short MIN_VALUE = 0;
    private static final short MAX_VALUE = 255;

    private final static char[] VALUES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F' };

    /**
     * Valeur décimale du rouge entre 0-255
     */
    private int red;

    /**
     * Valeur décimale du vert entre 0-255
     */
    private int green;

    /**
     * Valeur décimale du bleu entre 0-255
     */
    private int blue;

    /**
     * tableau de caractères de taille 6 avec les cases 0 et 1 pour le rouge, 2 et 3
     * pour le vert et 4 et 5 pour le bleu en hexadécimal.
     */
    private char[] tabChar;

    /**
     * Constructeur de Color au format RGB
     *
     * @param red
     *            le rouge entre 0-255
     * @param green
     *            le vert entre 0-255
     * @param blue
     *            le bleu entre 0-255
     */
    public Color(int red, int green, int blue) {
        tabChar = new char[6];
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    /**
     * Constructeur de Color au format hexa
     *
     * @param hexValue
     *            valeur hexa décimale de la couleur (eg. "#F2AA76").
     */
    public Color(String hexValue) {
        tabChar = new char[6];
        setHexValue(hexValue);
    }

    /**
     * Méthode toString()
     *
     * @return la couleur au format : [value=#D58D35, r=213, g=141, b=53]
     */
    @Override
    public String toString() {
        return "[value=" + getHexValue() + ", r=" + getRed() + ", g=" + getGreen() + ", b=" + getBlue() + "]";
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa du rouge
     */
    private void updateRedHexValue() {
        tabChar[0] = VALUES[red / 16];
        tabChar[1] = VALUES[red % 16];
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa du vert
     */
    private void updateGreenHexValue() {
        tabChar[2] = VALUES[green / 16];
        tabChar[3] = VALUES[green % 16];
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa du bleu
     */
    private void updateBlueHexValue() {
        tabChar[4] = VALUES[blue / 16];
        tabChar[5] = VALUES[blue % 16];
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa à partir d'une chaîne de
     * caractère bien formée.
     *
     * @param s
     *            la chaîne bien formée
     */
    private void updateHexValueFromString(String s) {
        tabChar[0] = s.charAt(1);
        tabChar[1] = s.charAt(2);
        tabChar[2] = s.charAt(3);
        tabChar[3] = s.charAt(4);
        tabChar[4] = s.charAt(5);
        tabChar[5] = s.charAt(6);
    }

    /**
     * Méthode permettant de mettre à jour la valeur de RGB à partir de la valeur
     * hexa
     */
    private void updateRGB() {
        red = indexOf(tabChar[0]) * 16 + indexOf(tabChar[1]);
        green = indexOf(tabChar[2]) * 16 + indexOf(tabChar[3]);
        blue = indexOf(tabChar[4]) * 16 + indexOf(tabChar[5]);
    }

    /**
     * Récupère la valeur décimal d'un élément hexa, exemple : '1' -> 1, 'A' -> 10.
     *
     * @param charValue
     *            le caractère cherché
     * @return la valeur décimal correspondante
     */
    private int indexOf(char charValue) {

        for (int i = 0; i < VALUES.length; i++)
            if (VALUES[i] == charValue)
                return i;

        throw new IllegalArgumentException();
    }

    /**
     * Test une valeur RGB si elle est comprise entre 0 et 255
     *
     * @param RGBvalue
     *            à tester
     * @return true si elle est entre 0 et 255 inclus, false sinon
     */
    private boolean isCorrectRGBValue(int RGBvalue) {
        return MIN_VALUE > RGBvalue || RGBvalue > MAX_VALUE;
    }

    /**
     * Test si la valeur hexa décimal est correcte (eg. #21A4F3).
     *
     * @param hexValue
     *            à tester
     * @return true si l'expression régulière correspondant à une valeur hexa est
     *         respéctée par la valeur à tester.
     */
    private boolean isCorrectHexValue(String hexValue) {
        return Pattern.matches("^#([0-9A-F]{6})$", hexValue);
    }

    /**
     * Méthode de type get permettant de retourner la valeur hexa de la couleur
     *
     * @return la couleur au format hexa
     */
    public String getHexValue() {
        return "#" + new String(tabChar);
    }

    /**
     * Méthode de type set permettant de modifier la couleur avec une nouvelle
     * valeur hexa
     *
     * @param hexValue
     *            nouvelle valeur hexa
     */
    public void setHexValue(String hexValue) {
        if (hexValue == null || !isCorrectHexValue(hexValue)) {
            throw new IllegalArgumentException("Hex color is incorrect");
        }

        updateHexValueFromString(hexValue);
        updateRGB();
    }

    /**
     * Méthode de type get permettant de retourner la valeur du rouge
     *
     * @return le rouge entre 0-255
     */
    public int getRed() {
        return red;
    }

    /**
     * Méthode de type set permettant de modifier le rouge de la couleur
     *
     * @param red
     *            nouvelle valeur de rouge entre 0-255
     */
    public void setRed(int red) {
        if (isCorrectRGBValue(red)) {
            throw new IllegalArgumentException();
        }
        this.red = red;
        updateRedHexValue();
    }

    /**
     * Méthode de type get permettant de retourner la valeur du vert
     *
     * @return le vert entre 0-255
     */
    public int getGreen() {
        return green;
    }

    /**
     * Méthode de type set permettant de modifier le vert de la couleur
     *
     * @param green
     *            nouvelle valeur de vert entre 0-255
     */
    public void setGreen(int green) {
        if (isCorrectRGBValue(green)) {
            throw new IllegalArgumentException();
        }
        this.green = green;
        updateGreenHexValue();
    }

    /**
     * Méthode de type get permettant de retourner la valeur du bleu
     *
     * @return le bleu entre 0-255
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Méthode de type set permettant de modifier le bleu de la couleur
     *
     * @param blue
     *            nouvelle valeur de bleu entre 0-255
     */
    public void setBlue(int blue) {
        if (isCorrectRGBValue(blue)) {
            throw new IllegalArgumentException();
        }
        this.blue = blue;

        updateBlueHexValue();
    }
}