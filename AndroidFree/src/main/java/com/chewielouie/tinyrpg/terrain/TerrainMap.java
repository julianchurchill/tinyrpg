package com.chewielouie.tinyrpg.terrain;

import java.util.Iterator;

public interface TerrainMap extends Iterable<TerrainPiece> {
    public int size();
    public void add( TerrainPiece p );
}

