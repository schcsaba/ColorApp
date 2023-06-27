package csaba.colorapp.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorTest {
    // [value=#D58D35, r=213, g=141, b=53]
    private Color color;

    @BeforeEach
    public void setUp() {
        color = new Color(213, 141, 53);
    }

    @AfterEach
    public void tearDown() {
        color = null;
    }

    // -----------------------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------------------

    // -------------------------------------
    // Constructor Color(r, g, b)
    @Test
    public void test_constructor_RGB() {
        assertAll("Color object non conformes",
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void test_constructor_RGB_with_red_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(-3, 141, 53));
    }

    @Test
    public void test_constructor_RGB_with_red_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(264, 141, 53));
    }

    @Test
    public void test_constructor_RGB_with_green_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, -31, 53));
    }

    @Test
    public void test_constructor_RGB_with_green_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, 421, 53));
    }

    @Test
    public void test_constructor_RGB_with_blue_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, 141, -132));
    }

    @Test
    public void test_constructor_RGB_with_blue_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(213, 141, 533));
    }

    // -------------------------------------
    // Constructor Color(hexValue)
    @Test
    public void test_constructor_HexValue() {
        color = new Color("#D58D35");
        assertAll("Color object non conformes",
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void test_constructor_HexValue_with_null_value_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color(null));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_1_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("A26F76"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_2_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#a26F76"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_3_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#G26F76"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_4_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#A26F7"));
    }

    @Test
    public void test_constructor_HexValue_with_wrong_value_5_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color = new Color("#A26F71E"));
    }

    // -----------------------------------------------------------------------------
    // Override methods
    // -----------------------------------------------------------------------------
    @Test
    public void testToString_not_null() {
        assertNotNull(color.toString(), "toString() est null");
    }

    @Test
    public void testToString() {
        assertEquals("[value=#D58D35, r=213, g=141, b=53]", color.toString(), "toString() est incorrect");
    }

    // -----------------------------------------------------------------------------
    // Getters
    @Test
    public void testGetRed() {
        assertAll("Color object non conformes",
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testGetGreen() {
        assertAll("Color object non conformes",
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testGetBlue() {
        assertAll("Color object non conformes",
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testGetHexValue() {
        assertAll("Color object non conformes",
                () -> assertEquals("#D58D35", color.getHexValue(), "getHexValue() est incorrect"),
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"));
    }

    // -----------------------------------------------------------------------------
    // Setters
    // -----------------------------------------------------------------------------

    // -------------------------------------
    // RED
    @Test
    public void testSetRed() {
        color.setRed(25);
        assertAll("Color object non conformes",
                () -> assertEquals(25, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals("#198D35", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testSetRed_with_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setRed(425));
        assertEquals(213, color.getRed());
    }

    @Test
    public void testSetRed_with_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setRed(-12));
        assertEquals(213, color.getRed());
    }

    // -------------------------------------
    // GREEN
    @Test
    public void testSetGreen() {
        color.setGreen(2);
        assertAll("Color object non conformes",
                () -> assertEquals(2, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals("#D50235", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testSetGreen_with_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setGreen(615));
    }

    @Test
    public void testSetGreen_with_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setGreen(-132));
    }

    // -------------------------------------
    // BLUE
    @Test
    public void testSetBlue() {
        color.setBlue(134);
        assertAll("Color object non conformes",
                () -> assertEquals(134, color.getBlue(), "getBlue() est incorrect"),
                () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals("#D58D86", color.getHexValue(), "getHexValue() est incorrect"));
    }

    @Test
    public void testSetBlue_with_value_bigger_than_255_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setBlue(731));
    }

    @Test
    public void testSetBlue_with_value_smaller_than_0_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setBlue(-1));
    }

    // -------------------------------------
    // HEX VALUE
    @Test
    public void testSetHexValue() {
        color.setHexValue("#A26F76");
        assertAll("Color object non conformes",
                () -> assertEquals("#A26F76", color.getHexValue(), "getHexValue() est incorrect"),
                () -> assertEquals(162, color.getRed(), "getRed() est incorrect"),
                () -> assertEquals(111, color.getGreen(), "getGreen() est incorrect"),
                () -> assertEquals(118, color.getBlue(), "getBlue() est incorrect"));
    }

    @Test
    public void testSetHexValue_with_null_value_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue(null));
    }

    @Test
    public void testSetHexValue_with_wrong_value_1_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue("A26F76"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_2_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue("#a26F76"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_3_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue("#G26F76"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_4_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue("#A26F7"));
    }

    @Test
    public void testSetHexValue_with_wrong_value_5_Exception() {
        assertThrows(IllegalArgumentException.class, () -> color.setHexValue("#A26F71E"));
    }
}
