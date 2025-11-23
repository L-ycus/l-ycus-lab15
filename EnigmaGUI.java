import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaGUI extends JFrame {
    //1 2 3 INITEXt Encrypt/decryt input
    private static String[] args = new String[6];

    private JTextArea input, output;
    private JComboBox<String> innerBox, middleBox, outBox;
    private JTextField initText;
    private JButton encrypt, decrypt;
        

    public EnigmaGUI() {
        createGUI();
    }

    public void createGUI() {
        JFrame f = new JFrame();

        f.setTitle("CSCI2113 Enigma!");
        f.setSize(800, 900);
        f.setLocation(100, 100);
        
        JPanel tempPanel = createHeader();
        
        f.add(tempPanel, BorderLayout.NORTH);
        f.pack();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

    private JPanel createHeader() {
        JPanel controlPanel = new JPanel();
        JLabel inner, middle, out, initPos;
        FlowLayout headerLayout = new FlowLayout();
       
        controlPanel.setLayout(headerLayout);
        String[] rotorNums = {"1", "2", "3", "4", "5"};

        inner = new JLabel("Inner");
        middle = new JLabel("Middle");
        out = new JLabel("Out");
        initPos = new JLabel("Initial Position");
        
        innerBox = new JComboBox<>(rotorNums);
        innerBox.setPreferredSize(new Dimension(55, 20));
        middleBox = new JComboBox<>(rotorNums);
        middleBox.setPreferredSize(new Dimension(55, 20));
        outBox = new JComboBox<>(rotorNums);
        outBox.setPreferredSize(new Dimension(55, 20));
        
        initText = new JTextField();
        initText.setPreferredSize(new Dimension(55, 20));
        
        encrypt = new JButton("Encrypt");

        decrypt = new JButton("Decrypt");

        controlPanel.add(inner);
        controlPanel.add(innerBox);
        controlPanel.add(middle);
        controlPanel.add(middleBox);
        controlPanel.add(out);
        controlPanel.add(outBox);
        controlPanel.add(initPos);
        controlPanel.add(initText);
        controlPanel.add(encrypt);
        controlPanel.add(decrypt);

        return controlPanel;
    }
    
    
}