package editor;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor extends JFrame {

    public static void main(final String[] args) {
        new TextEditor();
    }

    final private JTextArea jTextArea = new JTextArea();
    private JFileChooser jfc;

    public TextEditor() {
        super("TextEditor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        initComponents();
        setLayout(null);
        setVisible(true);


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



        JTextField FilenameField = new JTextField();
        FilenameField.setName("FilenameField");
        FilenameField.setBounds(10,10,220,30);
        add(FilenameField);



        //__________Save & Load Components (Button)____________
        JButton SaveButton = new JButton("Save");
        SaveButton.setName("SaveButton");
        SaveButton.setBounds(250,9,75,30);
        SaveButton.addActionListener(e -> {
            String Filename = FilenameField.getText();
            String Text = jTextArea.getText();
            outputToFile(Text,Filename);
        });
        add(SaveButton);

        JButton LoadButton = new JButton("Load");
        LoadButton.setName("LoadButton");
        LoadButton.setBounds(330,9,75,30);
        LoadButton.addActionListener(actionEvent -> {
            jTextArea.setText(null);
            String Filename = FilenameField.getText();
            jTextArea.setText(inputFromFile(Filename));


        });
        add(LoadButton);

//__________Menu Items____________

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.setName("MenuFile");

//        JMenu newMenuItem = new JMenu("New");
//        JMenuItem textFileMenuItem = new JMenuItem("Text File");
//        JMenuItem imgFileMenuItem = new JMenuItem("Image File");
//        JMenuItem folderMenuItem = new JMenuItem("Folder");

//        newMenuItem.add(textFileMenuItem);
//        newMenuItem.add(imgFileMenuItem);
//        newMenuItem.add(folderMenuItem);

//        fileMenu.add(newMenuItem);
        JMenuItem LoadMenuItem = new JMenuItem("Load");
        LoadMenuItem.setName("MenuLoad");
        LoadMenuItem.addActionListener(actionEvent -> {
            jTextArea.setText(null);
            String Filename = FilenameField.getText();
            jTextArea.setText(inputFromFile(Filename));


        });
        JMenuItem SaveMenuItem = new JMenuItem("Save");
        SaveMenuItem.setName("MenuSave");
        SaveMenuItem.addActionListener(e -> {
            String Filename = FilenameField.getText();
            String Text = jTextArea.getText();
            outputToFile(Text,Filename);
        });
//        JMenuItem closeAllMenuItem = new JMenuItem("Close All");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");
        exitMenuItem.addActionListener(event -> System.exit(0));
//        fileMenu.add(newMenuItem);
        fileMenu.add(SaveMenuItem);
        fileMenu.add(LoadMenuItem);
//        fileMenu.add(closeAllMenuItem);

        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);



//___________Panel ___________

        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(10,10,220,30);
        greenPanel.setLayout(new BorderLayout());
        // greenPanel.setBackground(Color.GREEN);
        add(greenPanel);


    }
    public static String outputToFile(String TextArea,String url) {
        File file = new File(url);
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(TextArea);
            return file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            return "Error! Try again, Reason:- Cannot write to file!" + e.getMessage();
        }
    }


    public static String inputFromFile(String url) {

        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(url) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }
}
