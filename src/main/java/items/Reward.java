package items;

public class Reward {
    private String reward;


    public Reward(String reward) {
        this.reward = reward;

        System.out.println("congrats your getting" + reward);
    }
    public String getReward(){
        return reward;
}
    public void setReward(String reward) {
        this.reward = reward;
    }

    }
