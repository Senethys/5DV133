package clock;

public class Clock {

    private NumberDisplay minutes = new NumberDisplay(0, 59);
    private NumberDisplay hours = new NumberDisplay(0, 23);
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
        if(minutes.didWrapAround()) {
            this.hours.increment();
            this.minutes.increment();
        } else {
            minutes.increment();

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


    private void updateDisplay() {
        this.displayString = this.getTime();
    }


}
