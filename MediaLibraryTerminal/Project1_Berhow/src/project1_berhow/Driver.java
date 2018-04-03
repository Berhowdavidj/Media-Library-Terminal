/**
 * This program will create a library for media and have the functions of adding media
 * loaning media, return media, remove, and
 */
package project1_berhow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    private static Scanner keyboard = new Scanner(System.in);

    public static MediaItem selectMedia() {
        System.out.print("Please enter the name of the media: ");
        String mediaName = keyboard.nextLine();
        MediaItem temp = new MediaItem(mediaName);
        return temp;
    }

    public static void main(String[] args) throws Exception {
        Library library = new Library();//read or make new library object

        //while loop to make program run
        int commandMenuNumber = 0;//gets us into the loop

        while (commandMenuNumber != 6) {                                            
            try {
                commandMenuNumber = library.commandMenu(keyboard);//display menu get action number
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                keyboard.next();
                //break;
            }

            //logic for selecting correct method 
            
            if (commandMenuNumber == 1) {//display menu                               works
                library.displayMediaLibrary();

            } else if (commandMenuNumber == 2) {//new media                            works
                try {
                    MediaItem temp = selectMedia();
                    library.newMedia(temp);//adds media
                    System.out.print("Please enter the media type (CD, DVD, Book, XBox Game, etc.): ");
                    temp.setMediaType(keyboard.nextLine());
                    library.writeBinFile(library.getLibrary());//saves
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (commandMenuNumber == 3) {//rent media                           
                try {
                    MediaItem media = selectMedia();//gets user seleciton
                    System.out.print("Enter Renter's name: ");
                    String rentersName = keyboard.nextLine();//gets renters name
                    library.loanMedia(media, rentersName);//loans media
                    library.writeBinFile(library.getLibrary());//saves
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (commandMenuNumber == 4) {//return media                        works
                try {
                    library.returnMedia(selectMedia());//returns
                    library.writeBinFile(library.getLibrary());//saves
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (commandMenuNumber == 5) {//remove media                        works
                try {
                    MediaItem temp = selectMedia();
                    library.removeMedia(temp);//removes
                    library.writeBinFile(library.getLibrary());//saves
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (commandMenuNumber == 6) {
                try {
                    library.writeBinFile(library.getLibrary());//saves information
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return;//exits program
            }

        }

    }

}
