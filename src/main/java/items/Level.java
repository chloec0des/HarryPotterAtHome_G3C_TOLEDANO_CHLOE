package items;

import characters.Wizard;

public abstract class Level {
    private String location;
    private String enemyName;
    private String description;

    public Level(String location, String enemyName, String description) {
        this.location = location;
        this.enemyName = enemyName;
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void play(Wizard wizard);
}
