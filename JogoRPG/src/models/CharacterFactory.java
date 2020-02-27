package models;

import java.util.ArrayList;

import java.util.List;

public class CharacterFactory {

	private List<TypeClass> typeClasses;

	public CharacterFactory(List<TypeClass> typeClasses) {
		this.typeClasses = typeClasses;

	}

	public List<Character> GetCharacters() {

		List<Character> characters = new ArrayList<Character>();

		for (int i = 0; i < typeClasses.size(); i++) {

			if (typeClasses.get(i) == TypeClass.Dragon) {

				Dragon dragon = new Dragon();
				characters.add(dragon);
			}
			if (typeClasses.get(i) == TypeClass.Knight) {
				Knight knight = new Knight();
				characters.add(knight);
			}

		}
		return characters;

	}

}
