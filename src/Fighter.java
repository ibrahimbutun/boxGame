public class Fighter {

    String name;
    int damage, health, weight, dodge;

    public Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if (dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
    }

    int hit(Fighter opponent) {
        System.out.println(this.name + " => " + opponent.name + " " + this.damage + "hasar vurdu");
        if (opponent.isDodge()) {
            System.out.println("-----------------------");
            System.out.println(opponent.name + " gelen hasarı blokladı ! ");
            System.out.println("-----------------------");
            return opponent.health;
        }
        if (opponent.health - this.damage < 0) {
            return 0;
        }
        return opponent.health - this.damage;
    }

    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }

}