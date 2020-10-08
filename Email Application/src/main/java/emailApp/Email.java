package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defultPasswordLength = 10;
    private String alternateEmail;
    private String companeSuffix = "company.com";

    //  Constructor to receive the first name and last name
    public Email() {
    }

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //  Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that return a random password
        this.password = randomPassword(defultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." +
                lastName.toLowerCase() + "@" +
                department + "." + companeSuffix;

    }

    //  Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + firstName +
                "\nDEPARTMENT CODES\n" +
                "1 for Sales\n" +
                "2 for Development\n" +
                "3 for Accounting\n" +
                "0 for none\n" +
                "Enter department code: ");

        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    //  Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "" +
                "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //  Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //  Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //  Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "\nDISPLAY NAME: " + firstName + " " +lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity;
    }
}