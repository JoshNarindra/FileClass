/*
Capita NOVUS Fullstack Development
Week 5. 13.12.22.
Java File management Lesson.
 */

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Create Directory + Filename
        String directory = "C:\\Users\\joshu\\OneDrive\\Documents\\newdirectory";
        String filename = "file.txt";
        File d = new File(directory);
        d.mkdirs();

        //Create File
        File f = new File("C:\\Users\\joshu\\OneDrive\\Documents\\filepath-java\\file.txt");
        if (!f.exists()) {
            System.out.println("The file does not exist");
            if (f.createNewFile()) {
                System.out.println("File Created.");
            } else {
                System.out.println("File could not be created");
            }
        }
        else {
            System.out.println("File exists!");
            fileWrite();
            readFile();
        }

        getFileInfo();
    }

    public static void fileWrite() {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\joshu\\OneDrive\\Documents\\filepath-java\\file.txt");
            myWriter.write("File accessed! \n"); //overwrites file
            myWriter.close();
            System.out.println("Sucessfully wrote to this file!");
        }
        catch (IOException e){
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }

    public static void readFile(){
        try {
            File f = new File("C:\\Users\\joshu\\OneDrive\\Documents\\filepath-java\\file.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    public static void getFileInfo(){
        File f = new File("C:\\Users\\joshu\\OneDrive\\Documents\\filepath-java\\file.txt");
        if (f.exists()){
            System.out.println("File name: " + f.getName());
            System.out.println("Absolute path: " + f.getAbsolutePath());
            System.out.println("Writeable: " + f.canWrite());
            System.out.println("Readable: " + f.canRead());
            System.out.println("File Size in bytes: " + f.length());
        }
        else {
            System.out.println("This file does not exist");
        }
    }

    public static void deleteFile(){
        File f = new File("C:\\Users\\joshu\\OneDrive\\Documents\\filepath-java\\file.txt");
        if (f.delete()){
            System.out.println("Deleted this file" + f.getName());
        }
        else {
            System.out.println("Failed to delete file.");
        }
    }
}

