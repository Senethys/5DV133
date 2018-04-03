package clock;

public class AlarmClock extends Clock {

    private String alarmTime;
    private boolean status = false;
    Clock clock = new Clock();

    AlarmClock() throws LimitException { }


    //Denna metod används för att ställa ett larm.
    public void setAlarm(int hour, int minute) throws LimitException {

        this.status = true;
        this.alarmTime = String.format("%02d:%02d", hour, minute);
    }


    //Denna metod används för att avläsa om alarmet ringer (returnerar en bool).
    public void isTriggered() {
        String time = clock.getTime();
        if(time.equals(alarmTime)) {
            System.out.println("alarm");
        }
    }


    //Denna metod används för att slå på ett larm.
    public void turnOn() {
        this.status = true;

    }

    //Denna metod används för att stänga av ett larm.
    public void turnOff() {
        this.status = false;

    }
}
