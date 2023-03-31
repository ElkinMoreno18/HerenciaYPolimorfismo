import view.AppBanco;

import javax.swing.*;

public class Aplication {
    public static void main(String[] args) {


        AppBanco jFrame = new AppBanco();
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);
    }
}
