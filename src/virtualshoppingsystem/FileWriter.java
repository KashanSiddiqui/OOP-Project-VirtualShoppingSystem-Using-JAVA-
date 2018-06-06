package virtualshoppingsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriter {
	public String path;
	private boolean appendValue = true;
	
        public FileWriter(String path, boolean appendValue) {
		this.path = path;
		this.appendValue = appendValue;
	}
        public FileWriter(String path) {
        this.path = path;
        }
        public void writeToFile(String text) throws IOException {
		java.io.FileWriter fw = new java.io.FileWriter(path, appendValue);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(text);
		pw.close();
	}
        public void writeToFile(String[] text) throws IOException {
		java.io.FileWriter fw = new java.io.FileWriter(path, appendValue);
		PrintWriter pw = new PrintWriter(fw); 
                for(int i=0; i<text.length;i++){
                    pw.println(text[i]);
                }
		pw.close();
	}
        public void writeToFile(ArrayList<String> ItemsList) throws IOException{
        java.io.FileWriter fw = new java.io.FileWriter(path, appendValue);
		PrintWriter pw = new PrintWriter(fw); 
                for(int i=0;i<ItemsList.size();i++){
                pw.println(ItemsList.get(i));
                }
                pw.close();
        }
}