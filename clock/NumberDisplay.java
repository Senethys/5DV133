package clock;

import java.lang.String;

public class NumberDisplay {
    private int minLimit;
    private int maxLimit;
    private int value;

    NumberDisplay(int min, int max) throws LimitException {
        if (min > max || min == max) {
            throw new LimitException("Min is bigger tha max limit!");
        }
        this.minLimit = min;
        this.maxLimit = max;
    }


    public int getValue() {

        return value;
    }

    public void setValue(int newValue) throws LimitException {
        if (newValue < minLimit || newValue > maxLimit) {
            throw new LimitException("Wrong Limit!");
        }
        this.value = newValue;
    }


    public String getDisplayValue() {
        String result = String.format("%02d", this.value);
        return result;
    }

    public void increment() {
        if (didWrapAround()) {
            this.value = minLimit;
        }
        else {
            this.value++;
        }

    }

    public boolean didWrapAround() {
        //This if statement checks if the clock starts at 0 or not.
        //otherwise it would never increment form starting position.
        if (this.value != 0) {
            return (this.value % this.maxLimit == 0);
        } else {
            return false;
        }
    }

}