// Kevinfied

public class Tamagotchi {


    private int hunger, happiness, discipline, age;
    private String name;
    String hungerStat, happinessStat, disciplineStat;


    public Tamagotchi(String name) {
        this.name = name;
        age = 0;
        hunger = 50;
        happiness = 50;
        discipline = 50;


    }

    public void age() {

        age++;
//        happiness -= 1;
//        discipline -= 1;
//
//        hunger += 1;


        hunger = Math.min(hunger+1, 100);

        happiness = Math.max(happiness-1, 0);
        discipline = Math.max(discipline-1, 0);

    }


    public void feed() {
        hunger = Math.max(hunger-10, 0);
    }

    public void play() {

//        happiness += 10;

        happiness = Math.min(happiness+10, 100);

    }


    public void scold() {
//        discipline += 10;

        discipline = Math.min(0, discipline+10);
//        discipline = Math.min(0, discipline+10);

    }



//    int day = age / 1440;
//    int hour = (age - (day * 1440)) / 60;
//    int minute = age % 60;



    public String toString() {
        String[] hungerStat = {"stuffed", "full", "content", "", "hungry", "starving"};
//        String[] hungerStat = {"starving", "hungry", "",  "content", "full", "stuffed"};
        String[] happinessStat = {"depressed", "unhappy", "content", "", "happy", "ecstatic"};
        String[] disciplineStat = {"rebellious", "misbehaving", "content", "", "well-behaved", "disciplined" ,"obedient"};

        int hungerIndex = (hunger+19) / 20;
        int happinessIndex = happiness/20;
        int disciplineIndex = discipline/20;


        int days = age / (60*24);
        int hours = age / 60 % 24;
        int minutes = age % 60;
        


//        return String.format(("STATUS: \nname: %s \nage: %d days, %d hours, %d minutes \nhunger: %d \nhappiness = %d  \ndiscipline = %d } \n "), name, age, hunger, happiness, discipline);
        return String.format("%s: %d %s ** %s ** %s",name,hunger,hungerStat[hungerIndex],happinessStat[happinessIndex],disciplineStat[disciplineIndex]);
    }



}
