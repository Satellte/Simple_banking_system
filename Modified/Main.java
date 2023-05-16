package Modified;

import Modified/DAO/Bank.java;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:/home/kwizard/IdeaProjects/Simple Banking System (Java)" +
                "/Simple Banking System (Java)/task/" + args[1];

        Bank(url);
        doSomething();
        showMenu();
    }
}
