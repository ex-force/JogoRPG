package models;

import java.util.List;

public class Player {

	public String name;
	public List<Character> characters;

	public Player(String name, List<Character> characters){
		this.name = name;
		this.characters = characters;
	}

	public List<Character> getCharacters(){
		return characters;
	}

}
