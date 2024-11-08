package pl.kobietydokodu.koty.domain;

import java.util.ArrayList;
import java.util.Date;

public class Cat {

	String name;
	Date dateBirth;
	Float weight;
	String nameofMentor;

	public String introduceYourself() {
		return name + dateBirth + weight + nameofMentor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getNameofMentor() {
		return nameofMentor;
	}

	public void setNameofMentor(String nameofMentor) {
		this.nameofMentor = nameofMentor;
	}

	public static class CatDAO {
		Cat cat = new Cat();
		ArrayList<Cat> kitty;

		static void addCat(Cat cat) {

		}
	}

}
