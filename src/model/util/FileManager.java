package model.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static Scanner fileReader;

    public static List<Integer> readFirstFile(){
        try{
            File firstFile = new File("tree.txt");

            fileReader = new Scanner(firstFile);

            List<Integer> numbers = new ArrayList<>();

            String[] numbersList = fileReader.nextLine().split(" ");

            for (String s : numbersList) {
                numbers.add(Integer.parseInt(s));
            }

            return numbers;
        }catch(FileNotFoundException e){
            System.out.println("The file tree.txt wasn't found.");
        }finally{
            if(fileReader != null){
                fileReader.close();
            }
        }

        return null;
    }

    public static List<String> readSecondFile(){
        try{
            File secondFile = new File("commands.txt");

            fileReader = new Scanner(secondFile);

            List<String> commandsList = new ArrayList<>();

            while(fileReader.hasNextLine()){
                commandsList.add(fileReader.nextLine());
            }

            return commandsList;
        }catch(FileNotFoundException e){
            System.out.println("The file commands.txt wasn't found.");
        }finally{
            if(fileReader != null){
                fileReader.close();
            }
        }

        return null;
    }
}
