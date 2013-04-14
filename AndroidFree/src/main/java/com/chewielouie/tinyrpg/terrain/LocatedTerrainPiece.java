package com.chewielouie.tinyrpg.terrain;

import com.chewielouie.tinyrpg.Coordinate;

public class LocatedTerrainPiece implements TerrainPiece {
    private Coordinate coordinate;
    private Terrain terrain;

    public LocatedTerrainPiece( Coordinate c, Terrain t ) {
        this.coordinate = c;
        this.terrain = t;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public Terrain terrain() {
        return terrain;
    }
}

