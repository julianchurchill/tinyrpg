package com.chewielouie.tinyrpg;

public class Coordinate2D implements Coordinate {
    private int x;
    private int y;

    public Coordinate2D( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int z() {
        return 0;
    }
}

