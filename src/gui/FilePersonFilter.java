
package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FilePersonFilter extends FileFilter {

	public boolean accept(File file) {
		if(file.isDirectory())return true;
		
		String name = file.getName();
		String extension = getFileExtension(name);
		
		if(extension!=null) return extension.equals("per");
		
		return false;
	}

	public String getDescription() {
		
		return "File Filter of Person dataBase *.per";
	}
	
	public String getFileExtension(String name){
		int index = name.lastIndexOf(".");
		if (index== -1) {
			return null;
		}
		else if (index== (name.length()-1)) {
			return null;
		} 
		return name.substring(index+1, name.length());
	} 

}
