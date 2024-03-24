package BattleShips.softUni.model.view;

public class ShipViewModel {
    private String name;
    private Integer health;
    private Integer power;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return this.power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
