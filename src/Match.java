public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight, maxWeight;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (check()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("===YENİ ROUND===");
                int firstAttack = (int) (Math.random() * 100);

                if (firstAttack < 50) {
                    System.out.println("ilk durum : " + firstAttack);
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                } else {
                    System.out.println("ikinci durum : " + firstAttack);
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                }

                // System.out.println(this.f2.health);

                System.out.println(this.f1.name + " Sağlık : " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık : " + this.f2.health);
            }
        } else {
            System.out.println("Sprocuların kiloları birbirine uymuyor!!");
        }

    }

    boolean check() {
        // kilo kontrolu tamam ise true döndürüyor.
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight)
                && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(f2.name + " kazandı !");
            return true;
        }

        if (this.f2.health == 0) {
            System.out.println(f1.name + " kazandı !");
            return true;
        }
        return false;
    }

}
