import menu.Menu;
import textFile.TextFile;
import train.Train;

import java.util.*;

public class Main {

    public static void main(String[] args)  {

        new Main().run();
    }

    private void run() {

        Train tr = new Train("Коломия",12,15,15,10,10,10,10);

        TextFile textFile = new TextFile();
        JsonFile jsonFile = new JsonFile();
        List<Train> trains = new ArrayList<>();
        Menu menu = new Menu();
        int item;
        do {
            menu.show();
            item = menu.getSelection();
            switch (item) {
                case 1:
                    trains = textFile.readFromFile("laba7.txt");
                    break;
                case 2:
                    textFile.writeToFile(trains,"laba7.txt");
                    break;
                case 3:
                    trains = jsonFile.readFromFile("target/train.json");
                    break;
                case 4:
                    jsonFile.writeToFile(trains,"target/train.json");
                    break;
                case 5:
                    trains.add(tr);
                    break;
                case 6:
                    deleteElement(trains);
                    break;
                case 7:
                    sortByTime(trains);
                    break;
                case 8:
                    findSentAfterHour(trains);
                    break;
                case 9:
                    findTrainsHaveSeat(trains);
                    break;
                case 10:
                    findTrainsByPointAndSortSeat(trains);
                    break;
                case 11:
                    printTrains(trains);
                    break;
                case 12:
                    contains(trains);
                    break;
            }
        } while (item != 0);
    }

    private void contains(List<Train> trains) {
        System.out.println("Введіть номер потяга");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (findTrainByNumber(trains,number)) System.out.println("Потяг з таким номером існує");
        else System.out.println("Потяг з таким номером НЕ існує");
    }

    private boolean findTrainByNumber(List<Train> trains,int number) {
        for (Train train: trains) if (train.getNumber() == number) return true;
        return false;
    }

    private void findTrainsByPointAndSortSeat(List<Train> arr) {

        System.out.println("Введіть пункт призначення");
        Scanner in = new Scanner(System.in);
        String point = in.next();
        List<Train> trains = findTrainsByPoint(arr,point);
        sortByNumberOfPlaces(trains);
        printTrains(trains);
    }

    private void sortByNumberOfPlaces(List<Train> trains) {
        for (int i = trains.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int count1 = trains.get(j).getCommon() + trains.get(j).getLuxury() + trains.get(j).getBerth() + trains.get(j).getCompartment();
                int count2 = trains.get(j+1).getCommon() + trains.get(j+1).getLuxury() + trains.get(j+1).getBerth() + trains.get(j+1).getCompartment();
                if (count1 > count2) {
                    Train tmp = trains.get(j);
                    trains.set(j,trains.get((j+1)));
                    trains.set(j+1,tmp);
                }
            }
        }
    }

    private void findTrainsHaveSeat(List<Train> arr) {

        System.out.println("Введіть пункт призначення");
        Scanner in = new Scanner(System.in);
        String point = in.next();
        List<Train> trains = findTrainsByPoint(arr,point);
        for(int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getCommon() > 0) {

            } else trains.remove(i);
        }
        printTrains(trains);
    }

    private void findSentAfterHour(List<Train> trains) {

        System.out.println("Введіть пункт призначення");
        Scanner in = new Scanner(System.in);
        String point = in.next();
        System.out.println("Введіть годину після якої відправляється потяг");
        int hour = in.nextInt();
        List<Train> arr = findTrainsByPoint(trains,point);
        List<Train> trains1 = new ArrayList<>();
        for (Train train : arr) if (train.getHour() >= hour) trains1.add(train);
        printTrains(trains1);
    }

    private void sortByTime(List<Train> trains) {

        System.out.println("Введіть пункт призначення");
        Scanner in = new Scanner(System.in);
        String point = in.next();
        List<Train> result = findTrainsByPoint(trains,point);
        Collections.sort(result);
        printTrains(result);
    }

    private List<Train> findTrainsByPoint(List<Train> trains, String point) {

        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getPoint().equals(point)) {
                result.add(train);
            }
        }
        return result;
    }

    private static void deleteElement(List<Train> trains) {

        System.out.println("Введіть пункт призначення потяга");
        Scanner in = new Scanner(System.in);
        String point = in.next();
        System.out.println("Введіть номер потяга");
        int number = in.nextInt();
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getPoint().equals(point)) {
                if (trains.get(i).getNumber() == number) {
                    trains.remove(i);
                    break;
                }
            }
        }
    }

    public void printTrains(List<Train> trains) {

        for (Train train : trains) {
            System.out.println(train);
        }
    }

}

    /*List<Train> write = new ArrayList<>();
        write.add( new Train("Київ",121, 20,30,0,50,12,32));
                write.add( new Train("Львів", 100,14,28,125,100,32,50));
                write.add( new Train("Харків", 22,12,0,100, 100, 45,58));
                write.add( new Train("Київ", 1,6,5,0,90,31,24));
                write.add( new Train("Одеса",10,13,45,75,35,34,45));*/




//Person person = new Person("Vova", "Gray");
        /*try {
            objectMapper.writeValue(new File("target/person.json"), person);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try {
            String personAsString = objectMapper.writeValueAsString(person);
            System.out.println(personAsString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/

        /*try {
            Person person = objectMapper.readValue(new File("target/person.json"), Person.class);
            System.out.println(person.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*String json = "{ \"name\" : \"Vasya\", \"lastName\" : \"Pupkin\" }";
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String lastName = jsonNode.get("lastName").asText();
        System.out.println(lastName);*/

        /*String jsonPeopleArray =
                "[{ \"name\" : \"Vova\", \"lastName\" : \"Green\" }, { \"name\" : \"Petya\",\"lastName\" : \"Bulkin\" }]";
        try {
            List<Person> people = objectMapper.readValue(jsonPeopleArray, new TypeReference<List<Person>>(){});
            for (Person person: people) System.out.println(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/