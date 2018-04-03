package clock;

/*
* Objec oriented programming with Java
* Spring 18
* Assignment 1
* File:         Alarm.java (MWE)
* Description:  Simple program that simulates a clock with alarm functionality.
* Author:       Svitri Magnusson
* CS username:  kv13smn
* Date:         2018-04-03
* Input:        void
* Output:       console prints
* Run: javac -cp /usr/share/java/junit4.jar <filenames>
* java -cp -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore <main>
*
*/


public class Alarm {

    public static void  main(String[] args) throws LimitException {

        //Select when you want the alarm to go off.
        int hour = 13;
        int minute = 37;

        //Create alarm object and set alarm time
        AlarmClock alarm = new AlarmClock(hour, minute);

        //Prints out the time of the alarm.
        System.out.println(alarm.getAlarmTime());

        //While the alarm isn't triggered, increase time and print int.
        while(!alarm.isTriggered()) {
                alarm.clock.timeTick();
                alarm.clock.getTime();
                System.out.println(alarm.clock.getTime());

        }
    }
}
