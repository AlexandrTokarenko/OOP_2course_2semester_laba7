package convertor;

import train.Train;

public class TrainConvertor {
    public static Train fromText(String text) {
        String[] s = text.split(" ");
        return new Train(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]),
                Integer.parseInt(s[5]),Integer.parseInt(s[6]),Integer.parseInt(s[7]));
    }

    public static String toText(Train train) {
        return train.getPoint() + " " + train.getNumber() + " " + train.getHour() + " " + train.getMinute() +
                " " + train.getCommon() + " " + train.getCompartment() + " " + train.getBerth() +
                " " + train.getLuxury();
    }
}
