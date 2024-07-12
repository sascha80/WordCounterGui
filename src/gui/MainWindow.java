package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import wordcounter.WordCounter;
import utils.FileUtils;
import java.io.File;

public class MainWindow extends JFrame {
	
	private JTextArea textArea;
	private JLabel wordCountLabel;
	private JLabel charCountLabel;
	private JLabel sentenceCountLabel;
	
	puplic MainWindow() {
		setTitle("Word Counter");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativTo(null);
		setLayout(null);
		
		
		JLabel label = new JLabel("Bitte geben Sie Ihren Text ein:");
		label.setBounds(10, 10, 200, 25);
		add(label);
		
		
		
		
	}

}
