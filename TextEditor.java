// package editor;

import javax.swing.*;

public class TextEditor extends JFrame {
    public static void main(final String[] args) {
        new TextEditor();
    }
    public TextEditor() {
//        super("TextEditor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
        setLayout(null);

    }
    
    private void initComponents() {

//__________TEXT AREA____________

        JTextArea TextArea = new JTextArea();
        TextArea.setName("TextArea");
        setTitle("TextEditor");
        TextArea.setLineWrap(true);
        TextArea.setWrapStyleWord(true);
        // JTextField nameTextField = new JTextField();
        // nameTextField.setBounds(1,1, 100,30);
        // add(nameTextField);
        add(TextArea);

//__________ScrollPane____________
         JScrollPane ScrollPane = new JScrollPane(TextArea);  
         TextArea.setName("ScrollPane");
  
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        add(ScrollPane);
        

    }
}
