package P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person () {
        //company = null
        //car = null
        //parents = празен списък
        this.parents = new ArrayList<>();
        //children = празен списък
        this.children = new ArrayList<>();
        //pokemons = празен списък
        this.pokemons = new ArrayList<>();
    }

    public Person(Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pokemons) {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //getter for pokemons
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //Company:
        //Car:
        //Trabant 30
        //Pokemon:
        //Electrode Electricity
        //Parents:
        //Children:
        stringBuilder.append("Company:").append(System.lineSeparator());
        if (company != null) {
            stringBuilder.append(company).append(System.lineSeparator());
        }
        stringBuilder.append("Car:").append(System.lineSeparator());
        if (car != null) {
            stringBuilder.append(car).append(System.lineSeparator());
        }

        stringBuilder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            stringBuilder.append(pokemon).append(System.lineSeparator());
        }

        stringBuilder.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parents) {
            stringBuilder.append(parent).append(System.lineSeparator());
        }

        stringBuilder.append("Children:").append(System.lineSeparator());
        for (Child child : children) {
            stringBuilder.append(child).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

}
