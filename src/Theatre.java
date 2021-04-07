/*
Exercise 2
    Write a program that exemplifies the concept of inheritance.
    Comment the program accordingly to describe your example.
    You should use real-life concepts as classes in the program.
     */

import java.util.ArrayList;

//"Theatre" er en abstrakt superclass, dvs., at der ikke kan oprettes instanser af denne class,
// men den besidder 3 attributter og 1 metode, der nedarves til subklasserne.
abstract class Theatre {
    String name;
    boolean wonTony;
    String firstLine;

    //Constructor
    public Theatre(String name, boolean wonTony, String firstLine){
        this.name = name;
        this.wonTony = wonTony;
        this.firstLine = firstLine;
    }

    //Denne metode er ikke abstrakt, og den har en body, så den kan bruges af subklasserne uden at blive overridet.
    public String firstLine()
    {
        return "The first line of " + name + " is: \"" + firstLine + "\"\n";
    }

}

//Denne subclass arver attributterne og metoden fra "Theatre", men den har yderligere 3 attributter, og den overrider metoden.
class Musical extends Theatre {
    int numberOfSongs;
    boolean onBroadway;
    String firstSong;

    //Constructor
    public Musical(String name, boolean wonTony, String firstLine, int numberOfSongs, boolean onBroadway, String firstSong) {
        super(name, wonTony, firstLine);
        this.numberOfSongs = numberOfSongs;
        this.onBroadway = onBroadway;
        this.firstSong = firstSong;

    }


    //Superklassens metode overrides, idet der for denne subclass skal printes mere info.
    @Override
    public String firstLine() {
        return super.firstLine() + "The first song of " + name + " is called: \"" + firstSong+ "\"\n";
    }

}

//Denne subclass arver fra superklassen og tilføjer ikke noget.
class Revue extends Theatre {

    public Revue(String name, boolean wonTony, String firstLine) {
        super(name, wonTony, firstLine);
    }
}

//Denne subclass arver fra superklassen, og der tilføjes én attribut.
class StagePlay extends Theatre {
    boolean onBroadway;

    //Constructor
    public StagePlay(String name, boolean wonTony, String firstLine, boolean onBroadway) {
        super(name, wonTony, firstLine);
        this.onBroadway = onBroadway;
    }
}

class Test {
    public static void main(String[] args) {

        //Der oprettes 5 instanser af Theatre
        Musical m1 = new Musical("Wicked", true, "GOOD NEWS, SHE'S DEAD!", 20, true, "No One Mourns the Wicked");
        Musical m2 = new Musical("Hamilton", true, "How does a bastard, orphan, son of a whore", 46, true, "Alexander Hamilton");
        Musical m3 = new Musical("Ronja Røverdatter", false, "Hallo?", 15, false, "Røverture");
        Revue r1 = new Revue("Fysikrevy 2017", false, "Fysikrevyen er aflyst!");
        StagePlay s1 = new StagePlay("Hamlet", true, "Who's there?", true);

        //Alle instanser tilføjes et array af theatre
        ArrayList<Theatre> theatreList = new ArrayList<Theatre>();

        theatreList.add(m1);
        theatreList.add(m2);
        theatreList.add(m3);
        theatreList.add(r1);
        theatreList.add(s1);


        //firsLine-metoden bruges til at printe information om alle instanser.
        System.out.println("***Info on the beginning of the theatre-pieces***\n");

        for(Theatre theatre : theatreList) {
            System.out.println(theatre.firstLine());
        }

        //Antallet af Tony-vindende instanser i arrayet tælles, og hvert navn printes med en besked.
        System.out.println("***Info on Tonys for the theatre-pieces***\n");
        int tonyCounter = 0;
        for(Theatre theatre : theatreList) {
            if (theatre.wonTony == true) {
                System.out.println(theatre.name + " has won at least one Tony!");
                tonyCounter++;
            }
        }

        //Konklusionen på antallet af Tony-vindere afhænger af antallet. Den printes kun, hvis der er flere instanser end 1 i arrayet.
        if (theatreList.size() > 1) {
            if (tonyCounter == 0) {
                System.out.println("None of the pieces have won a Tony.");
            } else if (tonyCounter == 1){
                System.out.println("All in all, " + tonyCounter + " of the " + theatreList.size() + " pieces has won at least one Tony!");
            } else if (tonyCounter > 1){
                System.out.println("All in all, " + tonyCounter + " of the " + theatreList.size() + " pieces have won at least one Tony!");
            } else {
                System.out.println("Tonycounter ran into an error.");
            }
        }


    }
}