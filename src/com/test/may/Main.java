package com.test.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<PersonChild> list = new ArrayList<>();
    public static int maxId = 0;
    public static int now;

    public static List<String> syllables = new ArrayList<>();
    public static List<String> ending = new ArrayList<>();
    public static List<String> maleNames = new ArrayList<>();
    public static List<String> femaleName = new ArrayList<>();

    public static void main(String[] args) {

        syllables.add("ма");
        syllables.add("по");
        syllables.add("га");
        syllables.add("ко");
        syllables.add("фу");

        ending.add("ов");
        ending.add("ин");
        ending.add("ен");
        ending.add("ров");
        ending.add("на");
        ending.add("ко");

        maleNames.add("Ваня"); // 1
        maleNames.add("Петя"); // 2
        maleNames.add("Коля"); // 3
        maleNames.add("Игорь"); // 4
        maleNames.add("Вася"); // 5
        maleNames.add("Вася"); // 6
        maleNames.add("Петр"); // 7
        maleNames.add("Саша"); // 8

        femaleName.add("Саша"); // 1
        femaleName.add("Ира"); // 2
        femaleName.add("Анна"); // 3
        femaleName.add("Даша"); // 4
        femaleName.add("Катя"); // 5
        femaleName.add("Сара"); // 6
        femaleName.add("Валя"); // 7
        femaleName.add("Женя"); // 8

        now = 0;

        for (int i = 0; i < 5; i++) {

            int newIQ = (int)(Math.random() * 80) + 70;
            boolean newMan = Math.random() >= 0.5;
            int newGetInfo = (int)(Math.random() * 10);
            int newGood = (int)(Math.random() * 10);
            int newAgeNewPerson = (int)(Math.random() * 30) + 18;
            int newDead = (int)(Math.random() * 40) + 70;
            String newSurname = getSurname();
            String name;

            if (newMan) {

                name = getMaleName();

            } else {

                name = getFemaleName();
            }

            PersonChild newPersonChild = new PersonChild(newIQ, newMan, newGetInfo, newGood, -1, newAgeNewPerson, maxId, -1, -1, newDead, name, newSurname, null, 0);
            list.add(newPersonChild);

            maxId++;
        }

        print();

        while (true) {

            if (list.size() == 0) {

                System.out.println("Человечество вымерло!");
                break;
            }

            now++;
            List<String> deadList = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {

                list.get(i).age++;

                // System.out.println(list.get(i).age + "      " + list.get(i).ageNewPerson);

                if (list.get(i).age > list.get(i).ageNewPerson - 1) {

                    getNewChild(list.get(i));

                }

                if (list.get(i).age > list.get(i).dead) {

                    deadList.add("Человек с ID " + list.get(i).id + " умирает!");
                    list.remove(i);

                    i++;
                }
            }

            System.out.println();
            print();

            for (String i2 : deadList) {

                System.out.println(i2);
            }

            System.out.println("\nНаселение - " + list.size());
            System.out.println(now + " год!");

            Scanner scanner = new Scanner(System.in);
            scanner.hasNextLine();
        }
    }

    public static void getNewChild(PersonChild i) {

        for (int num = 0; num < list.size(); num++) {

            if (list.get(num).age > i.ageNewPerson - 3 && list.get(num).age < i.ageNewPerson + 3 && list.get(num).man == !i.man && !list.get(num).booleanValue && !i.booleanValue && i.generation == list.get(num).generation) {

                list.get(num).booleanValue = !list.get(num).booleanValue;
                i.booleanValue = !i.booleanValue;

                list.get(num).surname = i.surname;
                String fatherName;

                if (i.man) {

                    fatherName = i.name;

                } else {

                    fatherName = list.get(num).name;
                }

                int random = (int)(Math.random() * 2) + 1;

                while (Math.random() < 0.65) {

                    random++;
                }

                for (int i2 = 0; i2 < random; i2++) {

                    PersonChild newPersonChild = PersonChild.getMean(i, list.get(num), maxId, i.surname, fatherName);

                    list.add(newPersonChild);
                    maxId++;
                }

                break;
            }
        }
    }

    public static void print() {

        for (PersonChild i : list) {

            System.out.println("IQ - " + i.IQ +
                    ", man? - " + i.man +
                    ", age - " + i.age +
                    ", age new person - " + i.ageNewPerson +
                    ", get info - " + i.getInfo +
                    ", dead - " + i.dead +
                    ", id - " + i.id +
                    ", mather id - " + i.matherId +
                    ", father id - " + i.fatherId +
                    ", name - " + i.name +
                    ", surname - " + i.surname +
                    ", father name - " + i.patronymic +
                    ", generation - " + i.generation);
        }

        System.out.println();
    }

    public static String getSurname() {

        int len = (int)(Math.random() * 3) + 1;
        StringBuilder surname = new StringBuilder();

        for (int i = 0; i < len; i++) {

            surname.append(getRandomElem());
        }

        surname.append(getRandomElem2());
        return surname.toString();
    }

    public static String getRandomElem() {

        int random = (int)(Math.random() * syllables.size());
        if (random == syllables.size()) random--;

        return syllables.get(random);
    }

    public static String getRandomElem2() {

        int random = (int)(Math.random() * ending.size());
        if (random == ending.size()) random--;

        return ending.get(random);
    }

    public static String getMaleName() {

        int random = (int)(Math.random() * maleNames.size());
        if (random == maleNames.size()) random--;

        return maleNames.get(random);
    }

    public static String getFemaleName() {

        int random = (int)(Math.random() * femaleName.size());
        if (random == femaleName.size()) random--;

        return femaleName.get(random);
    }
}
