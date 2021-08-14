package util;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(){
        this.scanner = new Scanner(System.in);
    }

    public String getStringInput(){
        return scanner.next();
    }

    public void awaitEnter(){
        scanner.nextLine();
    }

    public int getIntegerInput(){
        while(true){
            String input = scanner.next();
            try{
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored){ }
        }
    }
}