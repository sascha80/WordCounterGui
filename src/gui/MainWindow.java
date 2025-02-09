package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import wordcounter.WordCounter;
import utils.FileUtils;
import java.io.File;

/**		Die MainWindow class erstellt das Hauptfenster meiner Anwendung
 *  	Die JTextArea ist zur Eingabe von Text. Außerdem gibt es einen Button zum zählen der Wörter Zeichen sowie Sätzen im eingegebenen Text.
 *  	Ein weiterer Button ermöglicht das auswählen einer TXT Datei welche mit JTextArea geladen wird.
 */

public class MainWindow extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JLabel sentenceCountLabel;
    
    /** Konstruktor für das Hauptfenster.
     *  Initialisiert und konfiguriert die die GUI-Komponenten.
     */

    public MainWindow() {
    	
    /**
    *	setTitle setzt den Titel vom Hauptfenster, setSize setzt die größe des Hauptfensters, setDefaultCloseOperation gibt an das die Anwendung
    *	beim schließen beendet wird. setLocationRelativeTo Zentriert das Hauptfenster in der mitte des Bildschirms. setLayout setzt das Layout
    *	des Frames auf null damit man es manuell Positionieren kann.
    */
        setTitle("Word Counter" + " by S.Hinkelmann");
        setSize(500, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
        setLayout(null);
        
        

        JLabel label = new JLabel("Geben Sie Ihren Text ein:");
        label.setBounds(10, 10, 200, 25);
        add(label);

        textArea = new JTextArea();
        textArea.setBounds(10, 40, 460, 200);
        add(textArea);

        JButton countButton = new JButton("Zählen");
        countButton.setBounds(10, 250, 100, 25);
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = WordCounter.countWords(text);
                int charCount = WordCounter.countChars(text);
                int sentenceCount = WordCounter.countSentences(text);

                wordCountLabel.setText("Wörter: " + wordCount);
                charCountLabel.setText("Zeichen: " + charCount);
                sentenceCountLabel.setText("Sätze: " + sentenceCount);
            }
        });
        add(countButton);

        JButton fileButton = new JButton("Datei wählen");
        fileButton.setBounds(120, 250, 150, 25);
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String text = FileUtils.readFile(selectedFile);
                    textArea.setText(text);
                }
            }
        });
        add(fileButton);

        wordCountLabel = new JLabel("Wörter: 0");
        wordCountLabel.setBounds(10, 290, 200, 25);
        add(wordCountLabel);

        charCountLabel = new JLabel("Zeichen: 0");
        charCountLabel.setBounds(10, 320, 200, 25);
        add(charCountLabel);

        sentenceCountLabel = new JLabel("Sätze: 0");
        sentenceCountLabel.setBounds(10, 350, 200, 25);
        add(sentenceCountLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}