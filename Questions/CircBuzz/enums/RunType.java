package Questions.CircBuzz.enums;

public enum RunType {

    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), SIX(5), WIDE_BALL(1);

    int runValue;

    RunType(int runValue) {
        this.runValue = runValue;
    }

    public int getRunValue() {
        return runValue;
    }
}
