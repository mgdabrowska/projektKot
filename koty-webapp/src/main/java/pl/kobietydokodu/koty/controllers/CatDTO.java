package pl.kobietydokodu.koty.controllers;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

public class CatDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp="^\\d{4}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[12]\\d|3[01])$")
    private String dateofBirth;

    @NotNull
    private Float weight;

    @NotBlank
    private String nameofOwner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getNameofOwner() {
        return nameofOwner;
    }

    public void setNameofOwner(String nameofOwner) {
        this.nameofOwner = nameofOwner;
    }
}
