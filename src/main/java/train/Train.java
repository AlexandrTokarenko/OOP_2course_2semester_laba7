package train;

import java.io.Serializable;
import java.util.Objects;

public class Train implements Serializable, Comparable<Train>{

    private String point;
    private int number;
    private int hour;
    private int minute;
    private int common;
    private int compartment;
    private int berth;
    private int luxury;

    public Train(String point, int number, int hour, int minute, int common, int compartment, int berth, int luxury) {

        this.point = point;
        this.number = number;
        this.hour = hour;
        this.minute = minute;
        this.common = common;
        this.compartment = compartment;
        this.berth = berth;
        this.luxury = luxury;
    }

    public Train() {

        this(null,-1,-1,-1,-1,-1,-1,-1);
    }

    public String getPoint() { return point; }
    public int getNumber() { return number; }
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getCommon() { return common; }
    public int getCompartment() { return compartment; }
    public int getBerth() { return berth; }
    public int getLuxury() { return luxury; }

    public void setPoint(String point) { this.point = point; }
    public void setNumber(int number) { this.number = number; }
    public void setHour(int hour) { this.hour = hour; }
    public void setMinute(int minute) { this.minute = minute; }
    public void setCommon(int common) { this.common = common; }
    public void setCompartment(int compartment) { this.compartment = compartment; }
    public void setBerth(int berth) { this.berth = berth; }
    public void setLuxury(int luxury) { this.luxury = luxury; }


    @Override
    public String toString() {
        return "Пункт призначення: " + point + " Номер поїзду: " + number + " Час відправки: " + hour + ":" + minute +
                " Число місць загальних: " + common + " Число місць купе: " + compartment + " Число місць купе: " + berth +
                " Число місць люкс: " + luxury;
    }

    @Override
    public int compareTo(Train o) {
        if (this.hour != o.getHour()) {
            return this.hour - o.getHour();
        } else if (this.minute != o.getMinute()) {
            return this.minute - o.getMinute();
        } else return this.minute - o.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, number, hour,minute,common,compartment,berth,luxury);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;

        Train train = (Train) o;

        if (getNumber() != train.getNumber()) return false;
        if (getHour() != train.getHour()) return false;
        if (getMinute() != train.getMinute()) return false;
        if (getCommon() != train.getCommon()) return false;
        if (getCompartment() != train.getCompartment()) return false;
        if (getBerth() != train.getBerth()) return false;
        if (getLuxury() != train.getLuxury()) return false;
        return getPoint().equals(train.getPoint());
    }
}