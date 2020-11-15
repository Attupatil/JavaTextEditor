//package editor;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    public static void main(final String[] args) {
        new TextEditor();
    }
    final private JTextArea jTextArea = new JTextArea();

    public TextEditor() {
        super("TextEditor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
        setLayout(null);

    }

    private void initComponents() {

//__________TEXT AREA____________

        jTextArea.setName("TextArea");
        final JScrollPane TextArea = new JScrollPane(jTextArea);
        TextArea.setName("ScrollPane");
        TextArea.setBounds(10, 40, super.getWidth() - 25, super.getHeight() / 100 * 90);
        TextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        TextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(TextArea);

//__________Save & Load Components (Button)____________
        JButton SaveButton = new JButton("Save");
        SaveButton.setName("SaveButton");
        SaveButton.setBounds(250,9,75,30);
        SaveButton.addActionListener(actionEvent -> {
           //To be updated
        });
        add(SaveButton);
        JButton LoadButton = new JButton("Load");
        LoadButton.setName("LoadButton");
        LoadButton.setBounds(330,9,75,30);
        LoadButton.addActionListener(actionEvent -> {
              //To be updated
        });
        add(LoadButton);
        JTextField FilenameField = new JTextField();
        FilenameField.setName("FilenameField");
        FilenameField.setBounds(10,10,220,30);
        add(FilenameField);

        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(10,10,220,30);
        greenPanel.setLayout(new BorderLayout());
        // greenPanel.setBackground(Color.GREEN);
        add(greenPanel);


    }
}
