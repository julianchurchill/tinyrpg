package com.chewielouie.tinyrpg;

public interface Coordinate {
    public int x();
    public int y();
    public int z();
    public void translate( Coordinate delta );
}

