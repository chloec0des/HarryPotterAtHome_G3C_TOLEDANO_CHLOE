package characters;

public class CharacterTest {

    public void testSetHealthPoints() {
        Character character = new TestCharacter("Test Character", 10, 100);

        character.setHealthPoints(50);

        assertEquals(50, character.getHealthPoints());
    }

    private void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected: %d, Actual: %d", expected, actual));
        }else {
            System.out.println("Test passed.");
        }
    }

    private static class TestCharacter extends Character {
        public TestCharacter(String name, int damage, int healthPoints) {
            super(name, damage, healthPoints);
        }
    }

    public static void main(String[] args) {
        CharacterTest test = new CharacterTest();
        test.testSetHealthPoints();
    }
}
