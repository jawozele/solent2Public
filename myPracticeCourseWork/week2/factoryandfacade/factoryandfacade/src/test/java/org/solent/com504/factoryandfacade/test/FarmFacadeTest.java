package org.solent.com504.factoryandfacade.test;

import java.util.List;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {

    @Test
    public void farmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        assertNotNull(farmFacade);

        // WHAT TESTS WOULD YOU CREATE HERE TO SET UP AND TEST THE FARM FACADE?
        farmFacade.addCat("Tom");
        farmFacade.addDog("Fido");
        farmFacade.addCow("Muri");

        List<Animal> animals = farmFacade.getAllAnimals();
        System.out.println("sixed of animals on farm " + animals.size());
        assertEquals(3, animals.size());

        boolean foundTom = false;
        for (Animal animal : animals) {
            String name = animal.getName();
            foundTom = "Tom".equals(name);
            if (foundTom) {
                break;
            }
        }
        assertTrue(foundTom);

        boolean foundTom2 = false;
        ListIterator<Animal> iterator = animals.listIterator();
        while (iterator.hasNext() && !foundTom2) {
            Animal animal = iterator.next();
            String name = animal.getName();
            foundTom2 = "Tom".equals(name);
        }
        assertTrue(foundTom2);

    }
}
