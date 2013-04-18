package com.chewielouie.tinyrpg;

import com.chewielouie.tinyrpg.terrain.ArrayTerrainMap;
import com.chewielouie.tinyrpg.terrain.Grass;
import com.chewielouie.tinyrpg.terrain.LocatedTerrainPiece;
import com.chewielouie.tinyrpg.terrain.TerrainMap;

public class BasicModel implements TinyRPGModel {
    private Coordinate playerPosition;
    private TerrainMap terrainMap;

    public BasicModel() {
        this.playerPosition = new Coordinate2D( 1, 1 );
        populateTerrain();
    }

    private void populateTerrain() {
        terrainMap = new ArrayTerrainMap();
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1,  1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0,  1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1,  1 ), new Grass() ) );
    }

    public TerrainMap allTerrain() {
        return terrainMap;
    }

    public Coordinate playerPosition() {
        return playerPosition;
    }
}

