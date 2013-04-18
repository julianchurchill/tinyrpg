package com.chewielouie.tinyrpg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.chewielouie.tinyrpg.terrain.TerrainMap;
import com.chewielouie.tinyrpg.terrain.Grass;
import com.chewielouie.tinyrpg.terrain.TerrainPiece;

public class WorldView extends View implements TinyRPGView {
    private Coordinate playerCoord = null;
    private TerrainMap terrainMap;
    private CoordinateConverter coordinateConverter;
    private Context context;
    private Canvas canvas;

    public WorldView( Context context, AttributeSet attrs ) {
        super( context, attrs );
        this.context = context;
    }

    @Override
    public void showPlayerAt( Coordinate pos ) {
        this.playerCoord = pos;
        invalidate();
    }

    @Override
    public void showTerrain( TerrainMap map ) {
        this.terrainMap = map;
        invalidate();
    }

    protected void onDraw( Canvas c ) {
        this.canvas = c;
        coordinateConverter = new CoordinateConverter();
        coordinateConverter.setViewSize( getWidth(), getHeight() );
        coordinateConverter.setViewUnitSize( tileWidth(), tileHeight() );
        coordinateConverter.centerViewOnWorldCoord( playerCoord );
        drawTerrain();
        drawPlayer();
    }

    private void drawTerrain() {
        for( TerrainPiece p : terrainMap ) {
            if( p.terrain() instanceof Grass ) {
                drawGrass( p.coordinate() );
            }
        }
    }

    private void drawGrass( Coordinate coord ) {
        Coordinate viewCoord = coordinateConverter().convertWorldToView( coord );
        fillTile( viewCoord, Color.GREEN );
        highlightTile( viewCoord );
    }

    private CoordinateConverter coordinateConverter() {
        return coordinateConverter;
    }

    private int tileWidth() {
        return 60;
    }

    private int tileHeight() {
        return 60;
    }

    private void fillTile( Coordinate coord, int color ) {
        Paint paint = new Paint();
        paint.setStyle( Paint.Style.FILL );
        paint.setColor( color );
        drawTile( coord, paint );
    }

    private void drawTile( Coordinate coord, Paint paint ) {
        canvas.drawRect( coord.x(), coord.y(),
                coord.x() + tileWidth(), coord.y() + tileHeight(), paint );
    }

    private void highlightTile( Coordinate coord ) {
        Paint paint = new Paint();
        paint.setStyle( Paint.Style.STROKE );
        paint.setColor( Color.RED );
        drawTile( coord, paint );
    }

    private void drawPlayer() {
        Coordinate viewCoord = coordinateConverter().convertWorldToView( playerCoord );
        Paint paint = new Paint();
        paint.setStyle( Paint.Style.FILL );
        paint.setColor( Color.BLUE );
        canvas.drawCircle( centerOfTileX( viewCoord ), centerOfTileY( viewCoord ),
                playerRadius(), paint );
    }

    private int centerOfTileX( Coordinate c ) {
        return c.x() + tileWidth() / 2;
    }

    private int centerOfTileY( Coordinate c ) {
        return c.y() + tileHeight() / 2;
    }

    private int playerRadius() {
        return tileWidth() / 3;
    }
}

