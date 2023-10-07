package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.smarthome.Floor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Home {
    private static Home instance;
    private List<Floor> floorList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private List<Pet> petList = new ArrayList<>();
    private boolean isPowerEnable;

    private Home() {
        isPowerEnable = true;
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public void addPerson(Person person) {
        // TODO: add to a random floor and random room
        personList.add(person);
    }

    public void addPet(Pet pet) {
        // TODO: add to a random floor and random room
        petList.add(pet);
    }

    public static Home getInstance() {
        if (instance == null)
            instance = new Home();
        return instance;
    }
}
