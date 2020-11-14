package _5_FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player (String name, int endurance, int sprint,
                   int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (NameValidator.notValid(name)) {
            System.out.println("A name should not be empty.");
            return;
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance (int endurance) {
        statsValidator(endurance, "Endurance");

        this.endurance = endurance;
    }

    private void setSprint (int sprint) {
        statsValidator(sprint, "Sprint");

        this.sprint = sprint;
    }

    private void setDribble (int dribble) {
        statsValidator(dribble, "Dribble");

        this.dribble = dribble;
    }

    private void setPassing (int passing) {
        statsValidator(passing, "Passing");

        this.passing = passing;
    }

    private void setShooting (int shooting) {
        statsValidator(shooting, "Shooting");

        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }



    private void statsValidator(int stat, String statName) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }
}
