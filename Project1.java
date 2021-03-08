import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Author: Daniel Odinta
//Assignment: Project 1
//Date: 03/07/2021

public class Project1 {
	public static String directory = "C:\\Users\\Project1Directory";
	public static String filename  = "\\projectone.txt"; 
	public static String fileNameToSearch = "bestydocus.txt";
	static int flag = 0;
	
	public static void createFile(String fullPath) throws IOException {
	    File newfile = new File(fullPath);
	    newfile.getParentFile().mkdirs();
	    newfile.createNewFile();
	}
	
	public static void searchFileInDirectory(String directory, String fileNameToSearch ) {
		File file = new File(directory);
        String[] fileList = file.list(); 
        if(fileList == null) {
        	System.out.println("Directory Not Found");
        }else {
        	for(int i= 0; i<fileList.length; i++) {
        		String aFile = fileList[i];
        		if(aFile.equalsIgnoreCase(fileNameToSearch)) {
                	System.out.println(aFile + " Searched File Found");
                	flag =1;
        		}
        	}
        }
        
        if(flag == 0) {
        	System.out.println("Search File Not Found"); 
        }
		
	}

	public static void main(String[] args) {
		
		//Create a new file and return the current file names in ascending order. 
		try {			
			File file = new File(directory);
			if(file.isDirectory()) {
				List<String> listfile = Arrays.asList(file.list());
				for(String list:listfile) 
				{
				System.out.println(list);
				}
				
				System.out.println("----------------------------------------");
				System.out.println("---Sorted filemes----");
				Collections.sort(listfile);
				for(String list:listfile) 
					{
					System.out.println(list);
					}
				
				//Add a file to the existing directory list
				File newFiles= new File(directory+filename);
				if(!newFiles.exists()) {
					createFile(directory+filename);
				}else {
					newFiles.delete();
					createFile(directory+filename);
				}
				System.out.println("----------------------------------------");
				System.out.println("----Added projectone.txt file to the existing directory----");
				if(file.isDirectory()) {
				List<String> newlists = Arrays.asList(file.list());
				for(String newlist:newlists) 
				{									
					System.out.println(newlist);
				}
			}
				
			System.out.println("----------------------------------------");	
			// Delete the specified file added to the directory and display the current filenames in the directory 
			List<String> fileList = Arrays.asList(file.list());
			if(fileList.contains("projectone.txt")){
				newFiles.delete();
				System.out.println("The new added file is deleted");
				}else {
					System.out.println("File Not Found");
				}
				
				System.out.println("-The current files in the directory after deleting the newly added file are:");
				
				List<String> currentFileList = Arrays.asList(file.list());

				for(String NewCurrentFilesList:currentFileList) 
				{									
					System.out.println(NewCurrentFilesList);
				}			
			}
			
			System.out.println("----------------------------------------");
			
			//Search a user specified file from the main directory
			searchFileInDirectory(directory, fileNameToSearch);			
			
		}catch(Exception e) {
		    System.err.println("Error: " + e.getMessage());
		}

	}

}
