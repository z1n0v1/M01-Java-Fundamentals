package L07ObjectsAndClasses.Exercise.More.T04TeamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Team {
    private User creator;
    private String name;
    private List<User> users;
    private int numMembers;

    public String getName() {
        return name;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public Team(User creator, String name) {
        this.creator = creator;
        this.name = name;
        this.numMembers=0;
        users = new ArrayList<>();
        creator.setInTeam(true);
    }

    public void addUser(User user) {
        if (user.isInTeam()) {
            System.out.printf("Member %s cannot join team %s!%n",user.getName(), name);
        } else {
            users.add(user);
            user.setInTeam(true);
            numMembers++;
        }
    }

    public void printTeam() {
        System.out.println(name);
        System.out.println("- " + creator.getName());
        if (numMembers > 0) {
            users.sort(Comparator.comparing(User::getName));
            for (User user : users) {
                System.out.println("-- " + user.getName());
            }
        }
    }
}
