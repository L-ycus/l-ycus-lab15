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
        JPanel bottom = createBottom();

        f.add(tempPanel, BorderLayout.NORTH);
        f.add(bottom);
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
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                args[4] = "Encrypt";
                callComm();
            }
        });

        decrypt = new JButton("Decrypt");
        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                args[4] = "decrypt";
                callComm();        
            }
        });

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
    
    private JPanel createBottom() {
        JPanel panel = new JPanel();
        JPanel inPanel, outPanel;
        JLabel inputLabel, outputLabel;
        
        panel.setLayout(new BorderLayout());
        
        inPanel = new JPanel();
        inputLabel = new JLabel("Input");
        inputLabel.setPreferredSize(new Dimension(80, 100));
        input = new JTextArea();
        input.setPreferredSize(new Dimension(600, 100));
        
        outPanel = new JPanel();
        outputLabel = new JLabel("Output");
        outputLabel.setPreferredSize(new Dimension(80, 100));
        output = new JTextArea();
        output.setPreferredSize(new Dimension(600, 100));
        
        inPanel.add(inputLabel);
        inPanel.add(input);

        outPanel.add(outputLabel);
        outPanel.add(output);

        panel.add(inPanel, BorderLayout.NORTH);
        panel.add(outPanel);
        return panel;
    }

    public void callComm() {
        
        //if encrypt / decrypt clicked  
        //pull info from all textfields
        args[0] = innerBox.getSelectedItem().toString();
        args[1] = middleBox.getSelectedItem().toString();
        args[2] = outBox.getSelectedItem().toString();
        args[3] = initText.getText();

        args[5] = input.getText();
        String ret;
        //sets args[]
        try {
            ret = Comms.run(args);
            for(int i = 0; i < args.length; i++) {
                System.out.print(args[i] + " ");
            }
            System.out.println();
        } catch (Exception err) {
            err.printStackTrace();
            output.setText(err.toString());
            return;
        }

        if(ret == null) {
            return;
        }
        output.setText(ret);
    }

}