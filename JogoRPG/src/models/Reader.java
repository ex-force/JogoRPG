package models;

import java.util.Scanner;

public class Reader {
    public Scanner scanner;
    private static Reader reader;

    private Reader(){
        scanner = new Scanner(System.in);
    }

    public static Reader getReader(){
        if(reader != null){
            return reader;
        }
        else{
            reader = new Reader();
            return reader;
        }
    }

    public int readInt(){
        return scanner.nextInt();
    }

	public String readLine() {
		return scanner.nextLine();
	}
}