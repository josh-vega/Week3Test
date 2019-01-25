package com.example.week3test;

public class Room {
    public final boolean isInfected;
    public boolean visited = false;
    Room(boolean infected){
        isInfected = infected;
    }

    public static boolean isOutbreak(Room[][] floor){
        int rowlength = floor.length;
        int collength = floor[0].length;

        for(int r=0; r<rowlength; r++){
            for(int c=0; c<collength; c++){
                if(floor[r][c].isInfected){
                    int infectedRooms = checkSurroundings(r, c, floor);
                    if(infectedRooms>4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkRight(int r, int c, Room[][] fr){
        if(fr[r+1][c].isInfected){
            return true;
        }
        return false;
    }

    private static boolean checkBelow(int r, int c, Room[][]fr){
        if(fr[r][c+1].isInfected){
            return true;
        }
        return false;
    }

    private static boolean checkLeft(int r, int c, Room[][]fr){
        if(fr[r-1][c].isInfected){
            return true;
        }
        return false;
    }

    private static boolean checkAbove(int r, int c, Room[][]fr){
        if(fr[r][c-1].isInfected){
            return true;
        }
        return false;
    }

    private static int checkSurroundings(int r, int c, Room[][]fr){
        int counter = 0;
        if(r+1 <= fr.length && r >= 0 && c+1 <= fr[0].length && c >= 0){

            if(fr[r][c].isInfected && !fr[r][c].visited){
                fr[r][c].visited = true;
                counter++;
                return checkSurroundings(r+1, c, fr) + checkSurroundings(r, c+1, fr) +
                        checkSurroundings(r-1, c, fr) + checkSurroundings(r, c-1, fr) + counter;
            }
        }
        return counter;
    }

}
