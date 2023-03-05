import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui {

    public final int SCREEN_WIDTH = 1080;
    public final int SCREEN_HEIGHT = 720;
    public final Rectangle BUTTON_SIZE = new Rectangle(SCREEN_WIDTH/4, SCREEN_HEIGHT / 8);

    public void startMenu() {

        JFrame frame = new JFrame();
        JButton start = new JButton("Start");
        JButton quit = new JButton("Quit");
        JTextField welcomeMsg = new JTextField("CRYPTOMANIA");

        welcomeMsg.setEditable(false);
        welcomeMsg.setFont(new Font("Arial", Font.BOLD, 48));
        welcomeMsg.setHorizontalAlignment(JTextField.CENTER);
        welcomeMsg.setBounds(SCREEN_WIDTH/8, SCREEN_HEIGHT / 5, SCREEN_WIDTH/8 * 6, SCREEN_HEIGHT / 4);

        start.setBounds((int) SCREEN_WIDTH/3 - 160, (int) (SCREEN_HEIGHT / 3) * 2, BUTTON_SIZE.width, BUTTON_SIZE.height);
        quit.setBounds((int) (SCREEN_WIDTH/3)*2 - 160, (int) (SCREEN_HEIGHT / 3) * 2, BUTTON_SIZE.width, BUTTON_SIZE.height);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // game.;
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        frame.add(welcomeMsg);
        frame.add(start);
        frame.add(quit);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
