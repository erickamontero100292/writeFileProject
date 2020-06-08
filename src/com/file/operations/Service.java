package com.file.operations;


import com.file.exception.WrongExtensionException;

import java.util.ArrayList;
import java.util.Arrays;

public interface Service {

    ArrayList<String> EXTENSION_FILE = new ArrayList<>(Arrays.asList("txt", "pdf"));


    default String getFileExtension(String chooseFileExtension) throws WrongExtensionException {
        byte chosseExtension = 0;
        String selectedExtension ="";
        if (EXTENSION_FILE.contains(chooseFileExtension.toLowerCase())) {
            switch (chooseFileExtension.toLowerCase()) {

                case "txt":
                    selectedExtension = ".txt";
                    break;
                case "pdf":
                    selectedExtension = ".pdf";
                    break;
                case "xslx":
                    selectedExtension = ".xslx";
                    break;
                default:
                    selectedExtension = "";
            }
        } else if (isNumber(chooseFileExtension)) {

            chosseExtension = Byte.parseByte(chooseFileExtension);
            switch (chosseExtension) {

                case 1:
                    selectedExtension = ".txt";
                    break;
                case 2:
                    selectedExtension = ".pdf";
                    break;
                case 3:
                    selectedExtension = ".xslx";
                    break;
                default:
                    selectedExtension = "";
            }

        }


        return selectedExtension;
    }

    default boolean isNumber(String chooseFileExtension) throws WrongExtensionException {

        try {
            Byte.parseByte(chooseFileExtension);
        }catch (NumberFormatException e){
            throw  new WrongExtensionException();
        }

        return true;
    }
}
