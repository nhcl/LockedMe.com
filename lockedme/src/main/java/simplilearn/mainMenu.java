package simplilearn;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class mainMenu {
	
	final static String FOLDER = "C:\\Users\\ngs93\\eclipse-workspace\\LockedMe.com\\lockedme\\CopyTo";
	
	
	public static void ShowWelcomeScreen() {
    	System.out.println("--------------------");
    	System.out.println("Application: LockedMe.com");
    	System.out.println("Developer: Narges Goshayeshisafa");
    	System.out.println("--------------------");
    	
    }
	
	public static void showMainMenu() {
    	System.out.println("-- Main Menu --");
    	System.out.println("1.) Show file in ascending order");
    	System.out.println("2.) Perform file operations");
    	System.out.println("3.) Close the application");
    	System.out.println("--------------------");
    	collectMainMenueOption();
    }
	
	public static void collectMainMenueOption() {
	    	System.out.println("Please choose 1,2 or 3: ");
	    	Scanner scannerMain = new Scanner(System.in);
			String option = scannerMain.nextLine();
	    	
	    	switch (option) {
	    		case "1":
	    			showFileInAscendingOrder();
	    			break;
	    		case "2":
	    			fileOperations.showFileOperations();
	    			break;
	    		case "3":
	    			System.out.println("Thank you for using lockedme.com. Closing the application.");
	    			System.exit(0);
	    			break;
	    		default:
	    			System.out.println("Invalid input provided, please enter 1, 2, or 3: ");
	    	}
	    	showMainMenu();
	    }
	 
	public static void showFileInAscendingOrder() {
	    	System.out.println("--------------------");
	    	System.out.println("Showing files in ascending order");
	    	
	    	File[] files = new File(FOLDER).listFiles();
	    	
	    	Set<String> sorted = new TreeSet<>();
	    	
	    	if(files.length > 0) {
	    		for (File file : files) {
	        		sorted.add(file.getName());
	        	}
	    	}else {
	    		System.out.println("No file exists in this directory");
	    		System.out.println("--------------------");
	    	}
	    	
	    	
	    	sorted.forEach(System.out::println);
	    	
	    }
	    

}
