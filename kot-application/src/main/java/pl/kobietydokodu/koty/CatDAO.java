package pl.kobietydokodu.koty;

import org.springframework.stereotype.Repository;
import pl.kobietydokodu.koty.domain.Cat;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatDAO {
	
	List<Cat> kitty = new ArrayList<>();
	
	public void addCat (Cat cat) {
		kitty.add(cat);
		System.out.print("Thanks, I add cat correctly");
	}

	public List<Cat> getCats(){
		return kitty;
	}

	public Cat getCatById(int id){
		if(id<kitty.size()){
			return kitty.get(id);
		}else{

			return null;

		}
	}

}
