package create;

import com.tableEntry.Character;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * @Author Brian Martin
 */
public class CharacterForm {

    public static void main(String[] args) {

        System.out.println("===== This is a database entry application in Java. ===== ");
        System.out.println("Commands: ");
        System.out.println("    Enter (1) to Add a to-do item.");
        System.out.println("    Enter (2) to test the database setup");

        do {
            System.out.println();
            System.out.print("Enter a command: ");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if (!command.matches("[0-9]+")) {
                System.out.println("Invalid number");
            }

            switch (command) {
                case "1":


                    /***
                     * Console inputs that push an entry to the database.
                     */
                    System.out.println("Input a Character: ");
                    Scanner inputCharacter = new Scanner(System.in);
                    // Console inputs for a character
                    System.out.println("Enter name of Character");
                    String characterName = inputCharacter.nextLine();
                    System.out.println("Enter house of Character");
                    String characterHouse = inputCharacter.nextLine();
                    System.out.println("Enter trait of Character");
                    String characterTraits = inputCharacter.nextLine();
                    System.out.println("Enter friend of Character");
                    String characterFriend = inputCharacter.nextLine();
                    System.out.println("Name " + " | " + "House" + " | " + "Trait" + " | " + "Friend");
                    System.out.println("__________________________________");
                    System.out.println(characterName + " | " + characterHouse + " | " + characterTraits + " | " + characterFriend);

                    // create session factory
                    SessionFactory factory = new Configuration()
                            .configure()
                            .addAnnotatedClass(Character.class)
                            .buildSessionFactory();

                    // create session
                    Session session = factory.getCurrentSession();

                    try {

                        try {
                            /***
                             * New character object to send to the database
                             */
                            System.out.println("Creating new character object...");
                            // create a character object
                            Character characterItem = new
                                    Character(characterName, characterHouse, characterTraits, characterFriend);

                            // start a transaction
                            session.beginTransaction();

                            // save the character object
                            System.out.println("Saving the character...");
                            session.save(characterItem);

                            // commit transaction
                            session.getTransaction().commit();

                            System.out.println("Done!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } finally {
                        /***
                         * Close Database
                         */
                        factory.close();
                    }
                    break;
                case "2":
                    /***
                     * This is a console test use only to check your entry formatting
                     */
                    try {

                        Scanner inpuTest = new Scanner(System.in);
                        // Console inputs for a character test
                        System.out.println("Enter name of Character");
                        String test1 = inpuTest.nextLine();
                        System.out.println("Enter house of Character");

                        String test2 = inpuTest.nextLine();
                        System.out.println("Enter trait of Character");
                        String test3 = inpuTest.nextLine();
                        System.out.println("Enter friend of Character");
                        String test4 = inpuTest.nextLine();
                        System.out.println("Name " + " | " + "House" + " | " + "Trait" + " | " + "Friend");
                        System.out.println("__________________________________");
                        System.out.println(test1 + " | " + test2 + " | " + test3 + " | " + test4);

                    } finally {

                    }
                    break;

                default:

                    System.out.println("Commands: ");
                    System.out.println("    Enter (1) to Add a to-do item.");
                    System.out.println("    Enter (2) to test the database setup");
            }

        } while (true);

    }

}
