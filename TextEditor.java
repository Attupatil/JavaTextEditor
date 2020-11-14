package editor;

import javax.swing.*;

public class TextEditor extends JFrame {
    public TextEditor() {
//        super("TextEditor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
        setLayout(null);

    }
    public static void main(final String[] args) {
        new TextEditor();
    }
    private void initComponents() {

        JTextArea TextArea = new JTextArea();
        TextArea.setName("TextArea");
        setTitle("TextEditor");
        TextArea.setLineWrap(true);
        TextArea.setWrapStyleWord(true);
        // JTextField nameTextField = new JTextField();
        // nameTextField.setBounds(1,1, 100,30);
        // add(nameTextField);
        add(TextArea);

    }


}
