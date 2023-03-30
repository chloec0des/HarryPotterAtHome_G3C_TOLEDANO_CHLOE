package items;

import org.game.Display;

public class Reward {
    private String reward;
    static Display display = new Display();


    public Reward(String reward) {
        this.reward = reward;

        display.printMessage("congrats your getting" + reward);
    }
    public String getReward(){
        return reward;
}
    public void setReward(String reward) {
        this.reward = reward;
    }

    }
