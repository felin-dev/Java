package computers;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {

   private final Computer computer = new Computer("AMD");

   @Test
   public void testAddPartsInComputer() {
      assertEquals(0, computer.getParts().size());
      computer.addPart(createPart(0));
      assertEquals(1, computer.getParts().size());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAddNullPartsInComputerThrowsEx () {
      computer.addPart(null);
   }

   @Test
   public void testRemovingPart() {
      fillParts();
      Part part = createPart(3);
      computer.addPart(part);
      assertEquals(4, computer.getParts().size());
      computer.removePart(part);
      assertEquals(3, computer.getParts().size());
   }

   @Test
   public void testGetPart() {
      fillParts();
      Part expectedPart = createPart(3);
      computer.addPart(expectedPart);
      assertEquals(4, computer.getParts().size());
      Part actualPart = computer.getPart(expectedPart.getName());
      assertNotNull(actualPart);
      assertEquals(expectedPart, actualPart);
   }

   @Test
   public void testGetTotalPrice() {
      fillParts();
      assertEquals(2470, computer.getTotalPrice(), 0.1);
   }

   @Test
   public void testGetName() {
      assertEquals("AMD", computer.getName());
   }

   @Test(expected = UnsupportedOperationException.class)
   public void testGetUnmodifiableCollection() {
      fillParts();
      List<Part> parts = computer.getParts();
      assertNotNull(parts);
      parts.add(createPart(3));
   }

   @Test(expected = IllegalArgumentException.class)
   public void testConstructorNullName() {
      new Computer(null);
   }

   private void fillParts() {
      computer.addPart(createPart(0));
      computer.addPart(createPart(1));
      computer.addPart(createPart(2));
   }

   private Part createPart(int indexOfPart) {
      Part[] parts = {
              new Part("Motherboard", 170),
              new Part("VideoCard", 1300),
              new Part("CPU", 1000),
              new Part("PowerSupply", 150)
      };

      return parts[indexOfPart];
   }
}