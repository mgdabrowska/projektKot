package pl.kobietydokodu.koty;

import pl.kobietydokodu.koty.domain.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatDAO {
	
	List<Cat> kitty = new ArrayList<>();
	
	public void addCat (Cat cat) {
		kitty.add(cat);
		System.out.print("Thanks, I add cat correctly");
	}

}
