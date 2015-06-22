package newsManager;

import searchTree.SearchTreeMap;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newManagerGUI extends JPanel {
	
	private HashMap<String, SearchTreeMap<Time, String>> map = new HashMap<String, SearchTreeMap<Time, String>>();
	private JPanel top, bottom;
	private JLabel newsManager;
	private JButton addNewsSource, getNews, getNewsSources, updateNews;
	private JTextArea display;

	private newManagerGUI() {
		
		setPreferredSize(new Dimension(650, 300));
		setLayout(new BorderLayout());

		bottom = new JPanel();
		top = new JPanel();

		newsManager = new JLabel("NewsManager");
		addNewsSource = new JButton("Add News Source");
		getNews = new JButton("Get News");
		getNewsSources = new JButton("Get News Sources");
		updateNews = new JButton("Update News");
		
		display = new JTextArea(15, 50);
		display.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(display,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(top, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);
		
		top.add(newsManager);
		top.add(addNewsSource);
		top.add(getNews);
		top.add(getNewsSources);
		top.add(updateNews);
		
		bottom.add(scrollPane);
		
		addNewsSource.addActionListener(new addNewsSources());
		getNews.addActionListener(new getNews());
		getNewsSources.addActionListener(new getNewsSource());
		updateNews.addActionListener(new updateNews());
		
	}
	
	private class updateNews implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			String update = JOptionPane.showInputDialog(null, "Enter News Source Name");
			display.setText("Source " + update + " updated");
		}
	}
	
	private class getNewsSource implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			display.setText(map.keySet().toString());
		}
	}
	
	private class getNews implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String source = JOptionPane.showInputDialog(null, "Enter News Source Name(s) (comma seperated)");
			String begin = JOptionPane.showInputDialog(null, "Enter Start Time (hour:minute am/pm)");
			String end = JOptionPane.showInputDialog(null, "Enter End Time (hour:minute am/pm)");
			File file = new File("News/" + source);
			
			Time start = new Time(begin);
			Time finish = new Time(end);
			
			
			
		}
	}

	private class addNewsSources implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SearchTreeMap<Time, String> news = new SearchTreeMap<Time, String>();
			
			String sourceName = JOptionPane.showInputDialog(null, "Enter News Source Name: ");
			String sourceFile = JOptionPane.showInputDialog(null, "Enter News Source File: ");
			File file = new File("News/"+ sourceFile);
			
			map.put(sourceName, news);
			try{
				Scanner scanner = new Scanner(file);
				while(scanner.hasNextLine()){
					String temp = scanner.next();
					Time newsTime = new Time(temp);
					
					String tempNews = scanner.nextLine();
					news.put(newsTime, tempNews);
					
				}
			}catch(FileNotFoundException e){
				display.setText("file not found; 404 error");
			}
		}
	}

	public static String getFileContents(String filename) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader(filename));
		String line = bufferedReader.readLine();
		boolean firstTime = true;
		while (line != null) {
			if (!firstTime)
				stringBuffer.append("\n");
			stringBuffer.append(line);
			firstTime = false;
			line = bufferedReader.readLine();
		}
		return stringBuffer.toString();
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Counter");
		frame.setContentPane(new newManagerGUI());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
