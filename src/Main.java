import Controllers.Controller;
import Views.MainFrame;

public class Main {

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        Controller controller = new Controller(mainFrame);
        mainFrame.setController(controller);

    }

}
