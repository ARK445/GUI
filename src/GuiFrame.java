import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class GuiFrame extends JFrame {

    private JFrame window;
    private JButton button1,button2;
    private JPanel panel1;
    private view1Methods v1 = new view1Methods();
    private JOptionPane pane1;

    public void setPanel1(){
        panel1 = new JPanel();
        panel1.setBounds(212,200,600,350);
        panel1.setBackground(Color.blue);
        panel1.add(button1);
        panel1.add(button2);
        panel1.setLayout(null);
        panel1.setVisible(true);
        window.add(panel1);
    }

    public void setButton1(){
        button1 = new JButton("hello");
        button1.setBounds(50,50,100,25);
        button1.setFocusable(false);
        // button1.setFont(btnFont);
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.setVisible(true);
        button1.addActionListener(e -> {
            v1.increment();
            button1.setText(""+v1.getI());
        
        });
        
    }
    public void setButton2(){
        button2 = new JButton("reset");
        button2.setBounds(50,150,100,25);
        button2.setFocusable(false);
        // button1.setFont(btnFont);
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.setVisible(true);
        button2.addActionListener(e -> {
            v1.setI(0);
            button1.setText(""+v1.getI());
            pane1("number reset");
        });
    }
    public void view1(){
        setButton1();
        setButton2();
        setPanel1();
    }
    public void  pane1(String s){
         pane1 = new JOptionPane();
         pane1.showMessageDialog(null,s);

    }
    public GuiFrame(){
        window=new JFrame ("Blaine Lim :> ");
        setWindow();
        window.setSize(1024,640);
        window.setLocationRelativeTo(null);
        view1();
        BasicMenuBarWithMethodReferences();
        
    }
    public void setWindow(){
        window.setResizable(false);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void BasicMenuBarWithMethodReferences() {
        // Set up the frame
        setTitle("Basic Menu Bar Example with Method References");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the File menu
        JMenu fileMenu = new JMenu("File");

        // Create menu items
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to the File menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Add a separator line
        fileMenu.add(exitItem);

        // Add the File menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add action listeners using method references
        menuBar.setVisible(true);
        openItem.addActionListener(this::openFile);
        saveItem.addActionListener(this::saveFile);
        exitItem.addActionListener(this::exitApplication);
        window.add(menuBar);
    }

    // Method to handle "Open" action
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
}
