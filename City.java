interface MovementStrategy {
    String move();
}
class Walking implements MovementStrategy {
    @Override
    public String move() {
        return "Walking at 5 km/h";
    }
}
class Skateboarding implements MovementStrategy {
    @Override
    public String move() {
        return "Skateboarding at 15 km/h";
    }
}

class Jetpack implements MovementStrategy {
    @Override
    public String move() {
        return "Flying with Jetpack at 60 km/h";
    }
}

class Player {
    private MovementStrategy strategy;

    public Player(MovementStrategy initialStrategy) {
        this.strategy = initialStrategy;
    }

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }
    public String move() {
        return strategy.move();
    }
}


public class City {
    public static void main(String[] args) {
        Player player = new Player(new Walking());
        System.out.println("start");
        System.out.println(player.move());
        System.out.println("Picked up a skateboard");
        player.setStrategy(new Skateboarding());
        System.out.println(player.move());
        System.out.println("Found a jetpack");
        player.setStrategy(new Jetpack());
        System.out.println(player.move());
        System.out.println("Jetpack ran out of fuel");
        player.setStrategy(new Walking());
        System.out.println(player.move());
    }
}