package com.company;

public final class Levels {

    private static int PozycjaGracza; //początkowa pozycja gracza
    private static int StartGracza; //poprzednia pozycja gracza
    private static int Meta; //pozycja mety
    private static int[] Kolumny; //rozmieszczenie kolumn labiryntu
    private static int level;// dodaj więcej kolumn

    static void lvl1() {
        level = 1;
        StartGracza = 0;
        Meta = 90;
        Kolumny = new int[]{10, 26, 11, 12, 13, 18, 23, 24, 25, 28, 38, 48, 93, 50, 51, 52, 53, 54, 55, 56, 58, 68, 83, 73};
    }

    static void lvl2() {
        level = 2;
        StartGracza = 9;
        Meta = 35;
        Kolumny = new int[]{10, 7, 17, 12, 56, 33, 95, 75, 44, 25, 28, 38, 48, 93, 57, 65, 54};
    }

    static void lvl3() {
        level = 3;
        StartGracza = 35;
        Meta = 55;
        Kolumny = new int[]{34, 24, 14, 4, 5, 6, 45, 36, 26, 27, 28, 38, 48, 58, 68, 78, 88};
    }

    public static void setLevel(int level) {

        switch (level) {
            case 1:
                lvl1();
                break;
            case 2:
                lvl2();
                break;
            case 3:
                lvl3();
                break;
        }
    }

    public static void setNext() {
        switch (level) {
            case 1:
                lvl2();
                level = 2;
                break;
            case 2:
                lvl3();
                level = 3;
                break;
        }
    }

    public static int getLevel() {
        return level;
    }

    public static int[] getKolumny() {
        return Kolumny;
    }

    public static int getStartGracza() {
        return StartGracza;
    }

    public static int getMeta() {
        return Meta;
    }


}
