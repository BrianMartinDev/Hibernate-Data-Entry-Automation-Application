package create;

import com.tableEntry.Character;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * @Author Brian Martin
 */
public class CreateToDoItem {

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
                    String characterName = inputCharacter.nextLine();
                    String characterHouse = inputCharacter.nextLine();
                    String characterTraits = inputCharacter.nextLine();
                    String characterFriend = inputCharacter.nextLine();

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
                        String name = inpuTest.nextLine();
                        String name2 = inpuTest.nextLine();
                        String name3 = inpuTest.nextLine();
                        String name4 = inpuTest.nextLine();
                        System.out.println("Row " + " | " + name + " | " + name2 + " | " + name3 + " | " + name4);

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
