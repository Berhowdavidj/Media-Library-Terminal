package project1_berhow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Library implements Serializable {

    private ArrayList<MediaItem> library;

    //Makes a file if one does not exist, if one does exist, it loads it into ArrayList<MediaItem> library
    public Library() throws Exception {
        File libraryFile = new File("Library.bin");
        if(libraryFile.exists()){
            try{
            readBinFile();
            }catch(Exception e){
                throw new Exception("FileNotFound");
            }
        }else{
            this.library = new ArrayList<>();
        }
    }

    //this will read from the bin file and place everything into an array list
    public void readBinFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Library.bin")));
        library = (ArrayList<MediaItem>) ois.readObject();
        ois.close();
    }                       

    //writes the bin File
    //for updating the library
    public void writeBinFile(ArrayList<MediaItem> library) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Library.bin")));
        oos.writeObject(library);
        oos.close();
    }

    public ArrayList<MediaItem> getLibrary() {
        sortAlphabetically();
        return this.library;
    }
    
    //prints the command menu and returns an integer 
    public int commandMenu(Scanner keyboard) {
        System.out.println("__________________________________________________________");
        System.out.println("__________________________________________________________");
        System.out.println("Please choose an option from below,");
        System.out.println("1. List current media \n2. Insert new media \n3. Loan media"
                + " \n4. Return media\n5. Remove media\n6. Quit");
        System.out.println("__________________________________________________________");
        System.out.println("__________________________________________________________");
        int option = keyboard.nextInt();
        keyboard.nextLine(); // consume <enter> after number
        //bad input...
        while (option > 6 || option < 1) {
            System.out.println("");
            System.out.println("That is an invalid option, please choose an option"
                    + " from above.");
            System.out.println("");
            System.out.println("__________________________________________________________");
            System.out.println("__________________________________________________________");
            System.out.println("Please choose an option from below,");
            System.out.println("1. List current media \n2. Insert new media \n3. Loan media"
                    + " \n4. Return media\n5. Remove media\n6. Quit");
            System.out.println("__________________________________________________________");
            System.out.println("__________________________________________________________");

            option = keyboard.nextInt();
            keyboard.nextLine();
        }
        return option;
    }

    //adds new media to the arrayList                                           
    public void newMedia(MediaItem media) throws Exception {
        if (!library.contains(media)) {
            library.add(media);
        } else {
            throw new Exception(media.getMediaName() + " alreadiy exists");
        }
    }

    //loan media 
    public void loanMedia(MediaItem media, String rentersName) throws Exception {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getMediaName().startsWith(media.getMediaName())) {
                if (!library.get(i).getloan()) {
                    library.get(i).setDate();
                    library.get(i).setLoan(true);
                    library.get(i).setRentersName(rentersName);
                    return;
                } else {
                    throw new Exception(media.getMediaName() + " is already on loan");
                }
            }
        }
    }

    //return media to the arrayList
    public void returnMedia(MediaItem media) throws Exception {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getMediaName().startsWith(media.getMediaName())) {
                if (library.get(i).getloan()) {
                    library.get(i).setDate();
                    library.get(i).setLoan(false);
                    library.get(i).setRentersName(null);
                    return;
                } else {
                    throw new Exception(media.getMediaName() + " is not on loan");
                }
            }
        }
    }

    //display the arrayList
    public void displayMediaLibrary() {
        System.out.println("\n\n__________________________________________________________\nCurrent Media:\n");
        for (int i = 0; i < library.size(); i++) {
            System.out.println("\t" + library.get(i));
        }
        System.out.println("__________________________________________________________\n\n");
    }

    //removes media from the arrayList                                          
    public void removeMedia(MediaItem media) throws Exception {                 
        if (library.contains(media)) {
            library.remove(media);
        } else {
            throw new Exception(media.getMediaName() + " does not exist.");
        }
    }

    //sorts the library alphabetically 
    public void sortAlphabetically() {
         for (int i = 0; i < library.size(); i++) {
            MediaItem temp = library.get(i);
            for (int j = 0; j < library.size(); j++) {
                MediaItem temp1 = library.get(j);
                MediaItem temp2 = library.get(j);
                if ((int) temp.getMediaName().charAt(0) < (int) temp1.getMediaName().charAt(0)) {
                    library.set(j, temp);
                    library.set(i, temp2);
                    i--;
                    break;
                }
            }
        }
    }                               


}
