package virtualshoppingsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
        public String path;
	
        public FileReader(String path) {
		this.path = path;
	}        
        public String[] openFile() throws IOException {
                java.io.FileReader fr = new java.io.FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String[] text = new String[countLines()];
		for (int i=0; i<text.length; i++)
			text[i] = br.readLine();
		
		return text;
	}
	public int countLines() throws IOException {
		java.io.FileReader fr = new java.io.FileReader(path);
		BufferedReader br = new BufferedReader(fr);
        	String line; 
                int numOfLines = 0;
		while ((line = br.readLine()) != null) {
			numOfLines++;
		}
		return numOfLines;
	}
        public ArrayList<String> readFile() throws IOException {
                java.io.FileReader fr = new java.io.FileReader(path);
		BufferedReader br = new BufferedReader(fr);

                ArrayList<String> text = new ArrayList<String>();
                String line;
		while ((line = br.readLine()) != null)
                    text.add(line);
		br.close();
		return text;
	}
       
}
