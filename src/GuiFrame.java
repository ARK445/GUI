import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;


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
    public void pane1(String s){
         pane1 = new JOptionPane();
         pane1.showMessageDialog(null,s);

    }
    public GuiFrame(){
        window=new JFrame ("Blaine Lim :> ");
        setWindow();
        window.setSize(1024,640);
        window.setLocationRelativeTo(null);
        view1();
    }
    public void setWindow(){
        window.setResizable(false);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
