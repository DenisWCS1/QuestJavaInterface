public class Eagle extends Bird implements Fly {
    // attributes
    private boolean flying;
    private int altitude;

    // constuctor
    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void land() {
        if (this.altitude >= 2) {
            System.out.printf(" %s is too high, it can't land.%n", this.getName());
        } else {
            System.out.printf(" %s Hawkeye lands on the ground.%n", this.getName());
        }
    }

    @Override
    public void glide() {
        System.out.printf("%s glides into the air.%n", this.getName());
    }

    @Override
    public int ascend(int meters) {
        if (this.flying) {
            // 1000 est la moyenne d'altitude maximal de vol d'un aigle
            this.altitude = Math.min(this.altitude + meters, 1000);
            System.out.printf("%s flies upward, altitude: %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (this.flying) {
            // si l'aigle vol en dessous de 0 metre il devient une taupe
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude: %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky. %n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't land. %n", this.getName());
        }
    }

}
