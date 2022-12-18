package com.test.may;

public class PersonChild extends PersonParent {

    public static PersonChild getMean(PersonChild person1, PersonChild person2, int id, String surname, String patronymic) {

        int newIQ = (person1.IQ + person2.IQ) / 2;
        boolean newMan = Math.random() >= 0.5;
        int newGetInfo = (person1.getInfo + person2.getInfo) / 2;
        int newGood = (person1.good + person2.good) / 2;
        int newAgeNewPerson = (person1.ageNewPerson + person2.ageNewPerson) / 2;
        int newDead = (person1.dead + person2.dead) / 2;
        String name;

        newIQ += (int)(Math.random() * 30) - 15;
        newGetInfo += (int)(Math.random() * 2) - 1;
        newGood += (int)(Math.random() * 2) - 1;
        newAgeNewPerson += (int)(Math.random() * 4) - 2;
        newDead += (int)(Math.random() * 30) - 15;

        PersonChild mather;
        PersonChild father;

        if (person1.man) {

            mather = person2;
            father = person1;

        } else {

            mather = person1;
            father = person2;
        }

        if (newMan) {

            name = Main.getMaleName();

        } else {

            name = Main.getFemaleName();
        }

        PersonChild newPersonChild = new PersonChild(newIQ, newMan, newGetInfo, newGood, 0, newAgeNewPerson, id, mather.id, father.id, newDead, name, surname, patronymic, father.generation + 1);
        return newPersonChild;
    }

    PersonChild(int IQ2, boolean man2, int getInfo2, int good2, int age2, int ageNewPerson2, int id2, int matherId2, int fatherId2, int dead2, String name2, String surname2, String patronymic2, int generation2) {

        id = id2;
        generation = generation2;
        matherId = matherId2;
        fatherId = fatherId2;
        booleanValue = false;
        ageNewPerson = ageNewPerson2;
        age = age2;
        IQ = IQ2;
        man = man2;
        getInfo = getInfo2;
        good = good2;
        dead = dead2;
        name = name2;
        surname = surname2;
        patronymic = patronymic2;
    }
}
