package com.chewielouie.tinyrpg;

import com.chewielouie.tinyrpg.terrain.TerrainMap;

public interface TinyRPGModel {
    public enum Direction { North, South, East, West,
        NorthEast, NorthWest, SouthEast, SouthWest };
    public TerrainMap allTerrain();
    public Coordinate playerPosition();
    public void tryToMovePlayer( Direction d );
}


