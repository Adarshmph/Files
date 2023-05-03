package com.files.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileExample {

	public static void main(String[] args) throws IOException {
		while(true) {
		System.out.println("1. Creating Directory in C drive :\n"
				+ "2. Creating File :\n"
				+ "3. Delete a existing file\n"
				+ "4. Listing all the files inside the directory\n"
				+ "5. Checking the File is hidden or not\n"
				+ "6. Finding the parent directory of the current file\n"
				+ "7. Getting the Path for the current directory\n"
				+ "8. Renaming the current file\n"
				+ "9. Finding files using Patterns\n"
				+ "10.Copy the file");
		System.out.println("Enter the case : ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		File file = new File("C:/TaskDir");
		File file1 = new File("C:\\TaskDir\\task.txt");
		File dest = new File("C:\\TaskDir\\test.txt");
		
		switch(n) {
		case 1: if(!(file.exists() && file.isDirectory())) {
					file.mkdir();
					System.out.println("Directory is created successfully\n");
				}
				else {
					System.out.println("Directory is already exist\n");
				}
                break;
                
		case 2: if(!(file1.exists() && file1.isFile())){
					file1.createNewFile();
					System.out.println("File is created successfully\n");
				}
				else {
					System.out.println("File is already exist\n");
				}
        		break;
        	
		case 3: if((file1.exists() && file1.isFile())){
					file1.delete();
					System.out.println("File deleted successfully\n");
				}
				else {
					System.out.println("File does not exist\n");
				}
				break;
		
		case 4:	if(file.exists() && file.isDirectory()) {
					String files[] = file.list();
					for(int i=0; i<files.length; i++) {
						System.out.println(files[i] + "\n");
					}	
				}
				else {
					System.out.println("No files/Directories present inside the directory\n");
				}
        		break;
        		
		case 5: System.out.println(file1.isHidden());
				break;
			
		case 6: System.out.println(file1.getParent());
				break;
				
		case 7: System.out.println(file1.getPath());
				break;
				
		case 8:	if((file1.exists() && file1.isFile())){
					File rename = new File("C:\\TaskDir\\task1.txt");
					file1.renameTo(rename);
					System.out.println("Renamed successfully");
				}
				else {
					System.out.println("File is not there\n");
				}
				break;
				
		case 9: List<File> list = Arrays.asList(file.listFiles(new FilenameFilter(){
            			public boolean accept(File list, String name) {
            				return name.matches("[a-z A-z 0-9 ]+\\.[a-z]+");
                }}));
				System.out.println(list);
				
		case 10:FileInputStream fis = null;
        		FileOutputStream fos = null;
        		try {
                    fis = new FileInputStream("C:\\TaskDir\\task1.txt");
        
                    fos = new FileOutputStream("C:\\TaskDir1\\tast1.txt");
         
                    int c;
                    while ((c = fis.read()) != -1) {
         
                        fos.write(c);
                    }
        
                    System.out.println("copied the file successfully");
                }
        		finally {
        	
                    if (fis != null) {
                        fis.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                }
		}
		
		
		}
	}

}
