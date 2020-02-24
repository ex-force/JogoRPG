package models;

public abstract class GameSystem {

    public static void showMessage(String message){
        System.out.println(message);
    }
    
    public static int readInt(){
        Reader reader = Reader.getReader();
        return reader.readInt();
    }

	public static String readString() {
        Reader reader = Reader.getReader();
        return reader.readLine();
	}
}