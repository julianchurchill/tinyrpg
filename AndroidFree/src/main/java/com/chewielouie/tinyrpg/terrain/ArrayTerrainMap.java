package com.chewielouie.tinyrpg.terrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayTerrainMap implements TerrainMap {
    List<TerrainPiece> terrain = new ArrayList<TerrainPiece>();

    public int size() {
        return terrain.size();
    }

    public void add( TerrainPiece p ) {
        terrain.add( p );
    }

    public Iterator<TerrainPiece> iterator() {
        return terrain.iterator();
        //return this;
    }

    //public boolean hasNext() {
        //return false;
    //}

    //public TerrainPiece next() {
        //return null;
    //}

    //public void remove() {
        //throw new UnsupportedOperationException();
    //}
}

