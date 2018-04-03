package clock;

public class AlarmClock extends Clock {

    private String alarmTime;
    private boolean status = true;

    AlarmClock() throws LimitException { }

    AlarmClock(int hour, int minute) throws LimitException {
        setAlarm(hour, minute);
    }


    //Denna metod används för att ställa ett larm.
    public void setAlarm(int hour, int minute) throws LimitException {
        if (hour > 24 || hour < 0 || minute < 0 || minute > 59) {
            throw new LimitException("Min is bigger tha max limit!");
        }

        this.status = true;
        this.alarmTime = String.format("%02d:%02d", hour, minute);
    }


    //Denna metod används för att avläsa om alarmet ringer (returnerar en bool).
    public boolean isTriggered() {

        if(this.getTime().equals(this.alarmTime) && this.status) {
            System.out.println("alarm");
            this.status = false;
            return true;
        }
        return false;
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
