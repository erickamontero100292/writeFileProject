package com.file;

import com.file.exception.WrongExtensionException;
import com.file.operations.Service;
import com.file.operations.ServiceImpl;

import java.util.Scanner;

public class Main {
    private static Service service;

    public Main() {
        service = new ServiceImpl();
    }

    public static void main(String[] args) {
        // write your code here
        service = new ServiceImpl();
//        String fileName = getNameFile();
        String typeFile = getFileExtension();
//        System.out.println("The file name is : " + fileName);
        System.out.println("The extension name is : " + typeFile);


    }

    private static String getFileExtension() {
        System.out.println("Please choose the file extension. You can write number or the extension name ");
        System.out.println("1-TXT\n2-PDF \n");
        int attempts = 3;
        Scanner inConsole = new Scanner(System.in);
        String chooseFileExtension = "";

        while (attempts > 0) {
            try {
                chooseFileExtension = inConsole.nextLine();
                chooseFileExtension = service.getFileExtension(chooseFileExtension);
                break;
            } catch (WrongExtensionException extension) {
                attempts--;
                System.out.println("Wrong choice.\nPlease choose the file extension. You can write number or the extension name ");
                System.out.println("1-TXT\n2-PDF \n");
                System.out.println("You have left " + attempts + " attempts");
                chooseFileExtension = "";
            }
        }
        return chooseFileExtension;


    }

    private static String getNameFile() {
        System.out.println("Please introduce file name");
        Scanner inConsole = new Scanner(System.in);
        String fileName = inConsole.nextLine();

        return fileName;
    }
}
