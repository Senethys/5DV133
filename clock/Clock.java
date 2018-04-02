package clock;

public class Clock {

    private NumberDisplay minutes = new NumberDisplay(0, 60);
    private NumberDisplay hours = new NumberDisplay(0, 24);
    private String displayString;

    Clock() throws LimitException {
        this.minutes.setValue(0);
        this.hours.setValue(0);
    }

    Clock(int hour, int minute) throws LimitException {
        this.minutes.setValue(minute);
        this.hours.setValue(hour);
    }

    public void timeTick() {
        this.minutes.increment();
        if(minutes.didWrapAround()) {
            this.hours.increment();
        }

    }

    public void setTime(int hour, int minute) throws LimitException {
        this.minutes.setValue(minute);
        this.hours.setValue(hour);

    }

    public String getTime() {
        String min = minutes.getDisplayValue();
        String hour = hours.getDisplayValue();
        String result = String.format("%s:%s", hour, min);
        return result;
    }


    private boolean updateDisplay() {
        System.out.print(this.getTime());
        return true;
    }


}
