package userAuthentication;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DarkThemeUtil {

    /* ==============================
       BACKGROUND STYLING
       ============================== */
    public static void applyDarkBackground(StackPane rootPane) {
        rootPane.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0f172a, #111827, #1e293b);"
        );
    }

    /* ==============================
       CARD STYLING (FLOATING PANEL)
       ============================== */
    public static void styleCard(VBox card) {
        card.setStyle(
                "-fx-background-color: linear-gradient(to bottom, rgba(36,36,44,0.96), rgba(24,24,30,0.96));" +
                "-fx-background-radius: 24;" +
                "-fx-border-color: rgba(255,255,255,0.10);" +
                "-fx-border-width: 1.2;" +
                "-fx-border-radius: 24;" +
                "-fx-padding: 28 32 28 32;"
        );

        card.setFillWidth(false);
        card.setMaxWidth(420);
        card.setMaxHeight(320);

        DropShadow shadow = new DropShadow();
        shadow.setRadius(28);
        shadow.setOffsetY(12);
        shadow.setColor(Color.rgb(0, 0, 0, 0.45));

        card.setEffect(shadow);
    }

    /* ==============================
       TITLE LABEL
       ============================== */
    public static void styleTitle(Label label) {
        label.setStyle(
                "-fx-text-fill: #f8fafc;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );
    }

    /* ==============================
       MESSAGE LABEL
       ============================== */
    public static void styleMessageLabel(Label label) {
        label.setStyle(
                "-fx-text-fill: #cbd5e1;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 13px;"
        );
    }

    /* ==============================
       TEXT FIELD STYLING
       ============================== */
    public static void styleTextField(TextField field) {
        String normal =
                "-fx-background-color: rgba(15,23,42,0.90);" +
                "-fx-text-fill: #f8fafc;" +
                "-fx-prompt-text-fill: #94a3b8;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: rgba(255,255,255,0.10);" +
                "-fx-border-width: 1.2;" +
                "-fx-padding: 8 12 8 12;" +
                "-fx-alignment: CENTER_LEFT;";

        String focused =
                "-fx-background-color: rgba(15,23,42,0.98);" +
                "-fx-text-fill: #f8fafc;" +
                "-fx-prompt-text-fill: #94a3b8;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: #60a5fa;" +
                "-fx-border-width: 1.6;" +
                "-fx-padding: 8 12 8 12;" +
                "-fx-alignment: CENTER_LEFT;";

        // Prevent text clipping
        field.setPrefHeight(44);
        field.setMinHeight(44);
        field.setMaxHeight(44);

        field.setStyle(normal);

        field.focusedProperty().addListener((obs, oldVal, isFocused) ->
                field.setStyle(isFocused ? focused : normal)
        );
    }

    /* ==============================
       BUTTON STYLING
       ============================== */
    public static void styleButton(Button button, String baseColor) {
        String normal =
                "-fx-background-color: " + baseColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 10 18 10 18;";

        String hover =
                "-fx-background-color: derive(" + baseColor + ", 18%);" +
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 10 18 10 18;";

        String pressed =
                "-fx-background-color: derive(" + baseColor + ", -12%);" +
                "-fx-text-fill: white;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 10 18 10 18;";

        button.setStyle(normal);

        button.setOnMouseEntered(e -> button.setStyle(hover));
        button.setOnMouseExited(e -> button.setStyle(normal));
        button.setOnMousePressed(e -> button.setStyle(pressed));
        button.setOnMouseReleased(e ->
                button.setStyle(button.isHover() ? hover : normal)
        );
    }

    /* ==============================
       CONVENIENCE METHODS
       ============================== */
    public static void stylePrimaryButton(Button button) {
        styleButton(button, "#2563eb"); // Blue
    }

    public static void styleSecondaryButton(Button button) {
        styleButton(button, "#334155"); // Gray
    }

    public static void styleSuccessButton(Button button) {
        styleButton(button, "#16a34a"); // Green
    }

    public static void styleDangerButton(Button button) {
        styleButton(button, "#dc2626"); // Red
    }
}