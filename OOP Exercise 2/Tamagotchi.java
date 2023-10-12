public class Tamagotchi {


    private int hunger, happiness, discipline, age, name;

    String hungerStat, happinessStat, disciplineStat;


    public void age() {

        age += 1;
        happiness -= 1;
        discipline -= 1;

        hunger += 1;

    }
    int day = age / 1440;
    int hour = (age - (day * 1440)) / 60;
    int minute = age % 60;

    public void feed() {
        hunger = hunger - 10;
    }

    public void play() {
        happiness += 10;
    }


    public void scold() {
        discipline += 10;
    }

    





    public String toString() {

        return String.format(("STATUS: \nname: %s \nage: %d days, %d hours, %d minutes \nhunger: %d \nhappiness = %d  \ndiscipline = %d } \n "), name, age, hunger, happiness, discipline);



    }



}