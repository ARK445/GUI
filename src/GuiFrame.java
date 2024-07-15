import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiFrame extends JFrame {

    private JFrame window;
    private JButton button1, button2;
    private JPanel panel1;
    private JOptionPane pane1;
    private JMenu menuForTopMenu;
    private JMenuBar topMenuBar;
    private JMenuItem topMenuItem1, topMenuItem2, topMenuItem3;

    private view1Methods v1 = new view1Methods();

    private void setTopMenuBar() {
        topMenuBar = new JMenuBar();
        menuForTopMenu = new JMenu("Options");
        topMenuItem1 = new JMenuItem("File");
        topMenuItem2 = new JMenuItem("Save");
        topMenuItem3 = new JMenuItem("Exit");

        menuForTopMenu.add(topMenuItem1);
        menuForTopMenu.add(topMenuItem2);
        menuForTopMenu.add(topMenuItem3);

        topMenuItem1.addActionListener(this::openFile);
        topMenuItem2.addActionListener(this::saveFile);
        topMenuItem3.addActionListener(this::exitApplication);

        topMenuBar.add(menuForTopMenu);
        window.setJMenuBar(topMenuBar);
    }

    private void openFile(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Open menu item clicked");
    }

    // Method to handle "Save" action
    private void saveFile(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Save menu item clicked");
    }

    // Method to handle "Exit" action
    private void exitApplication(ActionEvent e) {
        System.exit(0);
    }

    public void setPanel1() {
        panel1 = new JPanel();
        panel1.setBounds(212, 200, 600, 350);
        panel1.setBackground(Color.blue);
        panel1.add(button1);
        panel1.add(button2);
        panel1.setLayout(null);
        window.add(panel1);
    }

    public void setButton1() {
        button1 = new JButton("hello");
        button1.setBounds(50, 50, 100, 25);
        button1.setFocusable(false);
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.addActionListener(e -> {
            v1.increment();
            button1.setText("" + v1.getI());
        });
    }

    public void setButton2() {
        button2 = new JButton("reset");
        button2.setBounds(50, 150, 100, 25);
        button2.setFocusable(false);
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.addActionListener(e -> {
            v1.setI(0);
            button1.setText("" + v1.getI());
            pane1("number reset");
        });
    }

    public void view1() {
        setButton1();
        setButton2();
        setPanel1();
        setTopMenuBar();
    }

    public void pane1(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public GuiFrame() {
        window = new JFrame("Blaine Lim :>");
        window.setSize(1024, 640);
        window.setLocationRelativeTo(null);
        view1();
        setWindow();
    }

    public void setWindow() {
        window.setResizable(false);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}