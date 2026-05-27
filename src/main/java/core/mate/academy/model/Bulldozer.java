package core.mate.academy.model;

public class Bulldozer extends Machine {
    private int bladeWidth;

    public Bulldozer() {
    }

    public int getBladeWidth() {
        return bladeWidth;
    }

    public void setBladeWidth(int bladeWidth) {
        this.bladeWidth = bladeWidth;
    }

    @Override
    public void doWork() {
        System.out.println("Bulldozer started to work");
    }
}
