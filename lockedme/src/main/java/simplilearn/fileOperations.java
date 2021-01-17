package simplilearn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class fileOperations {
		
	public static void showFileOperations() {
	    	System.out.println("--------------------");
	    	System.out.println("1.) Add a file");
	    	System.out.println("2.) Delete a file");
	    	System.out.println("3.) Search for a file");
	    	System.out.println("4.) Back to main menu");
	    	System.out.println("--------------------");
	    	collectFileOperation();
	    }
	 
	 
	public static void collectFileOperation() {
	    	System.out.println("Please choose 1, 2, 3 or 4:");
	    	Scanner scannerCollect = new Scanner(System.in);
	        String option = scannerCollect.nextLine();
	        switch (option) {
	            case "1":
	                addAFile();
	                break;
	            case "2":
	            	deleteAFile();
	                break;
	            case "3":
	            	searchFile();
	                break;
	            case "4":
	            	mainMenu.showMainMenu();
	                break;
	        }
	        showFileOperations();
	        
	 }
	 

	public static void addAFile() throws InvalidPathException {
	    	System.out.println("Please provide a file path: ");
	    	Scanner scannerAdd = new Scanner(System.in);
			String filePath = scannerAdd.nextLine();
			Path path = Paths.get(filePath);
			
	        if (!Files.exists(path)) {
	            System.out.println("File does not exist");
	            return;
	        }

	        String newFilePath = mainMenu.FOLDER + "\\" + path.getFileName();
	        int inc = 0;
	        while (Files.exists(Paths.get(newFilePath))) {
	            inc++;
	            newFilePath = mainMenu.FOLDER + "\\" + inc + "_" + path.getFileName();
	        }
	        try {
	            Files.copy(path, Paths.get(newFilePath));
	            System.out.println("File " + path.getFileName() +" added successfully.");
	        } catch(IOException e) {
	            System.out.println("Unable to copy file to " + newFilePath);
	        }
	        
	 }
	 
	 
	public static void deleteAFile() {
	    	System.out.println("Please provide a file name: ");
	    	Scanner scannerDel = new Scanner(System.in);
			String fileName = scannerDel.nextLine();
			String newFilePath = mainMenu.FOLDER + "\\" + fileName;
			
			Path path = Paths.get(newFilePath);
			
	        if (!Files.exists(path)) {
	            System.out.println("File Not Found");
	            return;
	        }
	        
	        File file = new File(newFilePath);
	        
	        if(file.delete()){ 
	            System.out.println("File deleted successfully"); 
	        }else { 
	            System.out.println("Failed to delete the file"); 
	        } 	
	        
	 }
	 
	 
	public static void searchFile() {
	    	System.out.println("Please provide a file name: ");
	    	Scanner scannerSearch = new Scanner(System.in);
			String fileName = scannerSearch.nextLine();
			String newFilePath = mainMenu.FOLDER + "\\" + fileName;
			
			Path path = Paths.get(newFilePath);
			
			if (!Files.exists(path)) {
	            System.out.println("File Does Not Exist");
	        }else {
	        	System.out.println("The File Exists: " + path.getFileName());
	        }
			
	 }
	     
}

