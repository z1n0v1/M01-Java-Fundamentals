package L07ObjectsAndClasses.Exercise.More.T04TeamworkProjects;

import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {
    public int compare(Team firstTeam, Team secondTeam) {
        if (firstTeam.getNumMembers() == secondTeam.getNumMembers()) {
            return firstTeam.getName().compareTo(secondTeam.getName());
        }
        return secondTeam.getNumMembers() - firstTeam.getNumMembers();
    }
}
