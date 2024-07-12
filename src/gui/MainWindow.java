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
		
	}

}
