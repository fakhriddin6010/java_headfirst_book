import java.io.*;

public class GameSaverTest{

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] { "bow", "sword", "dust" });
        GameCharacter two = new GameCharacter(200, "Troll", new String[] { "bare hands", "big axe" });
        GameCharacter three = new GameCharacter(120, "Magician", new String[] { "spells", "invisibility" });

        // Imagine code that does things with the characters that might change their
        // state!

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"))) {
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Set to null so we can't access from the heap.
        one = null;
        two = null;
        three = null;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"))) {
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            // Check if that worked.
            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's type: " + twoRestore.getType());
            System.out.println("Three's type: " + threeRestore.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class GameCharacter implements Serializable {
        int power;
        String type;
        String[] weapons;

        public GameCharacter(int p, String t, String[] w) {
            power = p;
            type = t;
            weapons = w;
        }

        public int getPower() {
            return power;
        }

        public String getType() {
            return type;
        }

        public String getWeapons() {
            String weaponList = "";

            for (String weapon : weapons) {
                weaponList += weapon + " ";
            }
            return weaponList;
        }
    }
}
