package csaba.colorapp.controller;

import csaba.colorapp.model.Color;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class ColorController implements Initializable {

    private Color color;
    @FXML
    private TextField hexValueField;
    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private TextField redValueField;
    @FXML
    private TextField greenValueField;
    @FXML
    private TextField blueValueField;
    @FXML
    private Rectangle colorRectangle;
    @FXML
    private Rectangle matchingColor1;
    @FXML
    private Rectangle matchingColor2;
    @FXML
    private Rectangle matchingColor3;
    @FXML
    private Rectangle matchingColor4;
    @FXML
    private Rectangle matchingColor5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int red = (int) redSlider.getValue();
        int green = (int) greenSlider.getValue();
        int blue = (int) blueSlider.getValue();
        color = new Color(red, green, blue);

        hexValueField.setText(color.getHexValue());
        redValueField.setText(String.valueOf(color.getRed()));
        greenValueField.setText(String.valueOf(color.getGreen()));
        blueValueField.setText(String.valueOf(color.getBlue()));
        colorRectangle.setFill(javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));

        bindSliderTextFieldHexField(redSlider, redValueField, color::setRed, color::getRed);
        bindSliderTextFieldHexField(greenSlider, greenValueField, color::setGreen, color::getGreen);
        bindSliderTextFieldHexField(blueSlider, blueValueField, color::setBlue, color::getBlue);
    }

    private void bindSliderTextFieldHexField(Slider slider, TextField textField, Consumer<Integer> setMethod, IntSupplier getMethod) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int intValue = newValue.intValue();
            textField.setText(String.valueOf(intValue));
            setMethod.accept(intValue);
            hexValueField.setText(color.getHexValue());
            colorRectangle.setFill(javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));
            Color[] matchingColors = generateMatchingColors(color, 5);
            matchingColor1.setFill(javafx.scene.paint.Color.rgb(matchingColors[0].getRed(), matchingColors[0].getGreen(), matchingColors[0].getBlue()));
            matchingColor2.setFill(javafx.scene.paint.Color.rgb(matchingColors[1].getRed(), matchingColors[1].getGreen(), matchingColors[1].getBlue()));
            matchingColor3.setFill(javafx.scene.paint.Color.rgb(matchingColors[2].getRed(), matchingColors[2].getGreen(), matchingColors[2].getBlue()));
            matchingColor4.setFill(javafx.scene.paint.Color.rgb(matchingColors[3].getRed(), matchingColors[3].getGreen(), matchingColors[3].getBlue()));
            matchingColor5.setFill(javafx.scene.paint.Color.rgb(matchingColors[4].getRed(), matchingColors[4].getGreen(), matchingColors[4].getBlue()));
        });
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                slider.setValue(Double.parseDouble(newValue));
            } catch (IllegalArgumentException illegalArgumentException) {
                slider.setValue(0.0);
            };
        });
        hexValueField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                color.setHexValue(newValue);
                slider.setValue(getMethod.getAsInt());
            } catch (IllegalArgumentException ignored) {
            }
        });
    }

    private static Color[] generateMatchingColors(Color startingColor, int numColors) {
        Color[] matchingColors = new Color[numColors];

        // Extract the RGB values of the starting color
        int red = startingColor.getRed();
        int green = startingColor.getGreen();
        int blue = startingColor.getBlue();

        // Calculate the range for variation
        int variationRange = 255 / (numColors + 1);

        // Generate the matching colors by varying the RGB values
        for (int i = 0; i < numColors; i++) {
            int newRed = (red + (i + 1) * variationRange) % 256;
            int newGreen = (green + (i + 1) * variationRange) % 256;
            int newBlue = (blue + (i + 1) * variationRange) % 256;

            matchingColors[i] = new Color(newRed, newGreen, newBlue);
        }

        return matchingColors;
    }
}