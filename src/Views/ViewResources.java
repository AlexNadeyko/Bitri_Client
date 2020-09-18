package Views;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class ViewResources {

    public static final Color COLOR_VIOLET;
    public static final Color COLOR_BACKGROUND;
    public static final Color COLOR_TEXT_FIELD;
    public static final Color COLOR_TEXT_FIELD_BORDER;
    public static final Color COLOR_TITLE_BAR_BACKGROUND;
    public static final Color COLOR_BACKGROUND_DIALOG;



    private static  Font FONT_BELL_MT_BOLD;
    private static  Font FONT_BELL_MT;

    public enum TypeOfPanel {
        PANEL_SIGN_UP,
        PANEL_LOGIN,
        PANEL_WELCOME
    }

    public enum ColorOfTextDialog{
        POSITIVE(77, 255, 77), NEGATIVE(255, 51, 51),
        NEUTRAL(170, 51, 255);

        private int r;
        private int g;
        private int b;

        ColorOfTextDialog(int r, int g, int b){
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public Color getColor(){
            return new Color(r, g, b);
        }
    }


    static{
        COLOR_VIOLET = new Color(170, 51, 255);
        COLOR_BACKGROUND = new Color(48,50,55);
        COLOR_TEXT_FIELD = new Color(63,65,72);
        COLOR_TEXT_FIELD_BORDER = new Color(87,90,100);
        COLOR_TITLE_BAR_BACKGROUND = new Color(13,13,14);
        COLOR_BACKGROUND_DIALOG = new Color(36, 37, 41);
        createMyFonts();
    }

    private static void createMyFonts(){
        try {
            InputStream streamFontFile = ViewResources.class.getClassLoader().getResourceAsStream("BellMTBold.ttf");
            FONT_BELL_MT_BOLD = Font.createFont(Font.TRUETYPE_FONT, streamFontFile).deriveFont(45f);
            InputStream streamFontFile1 = ViewResources.class.getClassLoader().getResourceAsStream("BellMT.ttf");
            FONT_BELL_MT = Font.createFont(Font.TRUETYPE_FONT, streamFontFile1);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Font getFontBellMtBold(){
        return FONT_BELL_MT_BOLD;
    }

    public static Font getFontBellMt(){
        return FONT_BELL_MT;
    }


}
