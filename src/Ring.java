public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    boolean firstHit;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {

        if (checkWeight()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== NEW ROUND ===========");
                if(firstHit){
                    this.f1.health = f2.hit(f1);

                    if(isWin()){
                        break;
                    }
                }

                else {

                    this.f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;

                    }

                }
                if (firstHit()) {

                    this.f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;

                    }

                } else {

                    this.f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;

                    }

                }
                printScore();
            }
                
            

        } 
        else {
            System.out.println("Their devision doesn't match");
        }


    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }
    private boolean firstHit(){
        firstHit = Math.random() * 2 <= 1;
        return firstHit;
        
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Winner is  : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Winner is  : " + f2.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Health Left \t:" + f1.health);
        System.out.println(f2.name + " Health Left \t:" + f2.health);
    }
}
