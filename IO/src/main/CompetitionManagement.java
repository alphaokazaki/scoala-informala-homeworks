package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alpha
 * Class - Competition Management, has methods that show the results
 */
public class CompetitionManagement {


    List<Athlete>athletes=new ArrayList<Athlete>();
    /**
     * Method calculates the shooting of an athlete by getting a string and storing it, every missed shot adds 10 seconds.
     * @param shooting : shooting results
     * @return seconds : caused by missed shots
     */
    public int calculateShooting(String shooting){
        int seconds=0;
        String[] splitedShooting=shooting.split("(?!^)");

        for(int i=0;i<5;i++){
            if(splitedShooting[i].equals("o"))
                seconds=seconds+10;
        }
        return seconds;
    }

    /**
     * Method calculates an athlete's time from all his shootings.
     * Adding seconds using calculateShooting method.
     * @param athlete : an athlete
     */
    public void calculateTime(Athlete athlete){
        athlete.setSeconds(athlete.getSeconds()+calculateShooting(athlete.getFirstShooting())+
                calculateShooting(athlete.getSecondShooting())+
                calculateShooting(athlete.getThirdShooting()));

        if (athlete.getSeconds()>=60)
        while(athlete.getSeconds()>=60){
            athlete.setMinutes(athlete.getMinutes()+1);
            athlete.setSeconds(athlete.getSeconds()-60);
        }
    }

    /**
     * Time comparator for athletes, used in ordering the winners places.
     */
    static class TimeComparator implements Comparator<Athlete>{
        @Override
        public int compare(Athlete a1, Athlete a2) {
            if (a1.getMinutes()==a2.getMinutes()&&a1.getSeconds()==a2.getSeconds())
                return 0;
            if (a1.getMinutes()==a2.getMinutes()&&a1.getSeconds()>a2.getSeconds())
                return 1;
            if (a1.getMinutes()>a2.getMinutes())
                return 1;
            return -1;
        }
    }

    /**
     * Methos calculates the results of the competition and the time of the athletes, while sorting the list using TimeComparator.
     */
    public void calculateResults(){
        for (Athlete athlete : athletes){
            calculateTime(athlete);
        }
        Collections.sort(athletes,new TimeComparator());

    }

    /**
     * Method shows the winners.
     */
    public void showResults(){
        calculateResults();
        System.out.println('\n'+"----====The Competition results====----");
        System.out.println("--- Winner --- "+athletes.get(0).getAthleteName()+" "+athletes.get(0).getMinutes()+
                ":"+athletes.get(0).getSeconds());
        System.out.println("-- Runner-up -- "+athletes.get(1).getAthleteName()+" "+athletes.get(1).getMinutes()+
                ":"+athletes.get(1).getSeconds());
        System.out.println("- Third Place - "+athletes.get(2).getAthleteName()+" "+athletes.get(2).getMinutes()+
                ":"+athletes.get(2).getSeconds());
    }

}
