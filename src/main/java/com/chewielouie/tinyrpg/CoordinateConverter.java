package com.chewielouie.tinyrpg;

public class CoordinateConverter {
    private int viewWidth = 0;
    private int viewHeight = 0;
    private int viewUnitWidth = 1;
    private int viewUnitHeight = 1;
    private Coordinate worldCoordToCenterViewOn = new Coordinate2D( 0, 0 );

    public void setViewSize( int width, int height ) {
        this.viewWidth = width;
        this.viewHeight = height;
    }

    public void setViewUnitSize( int width, int height ) {
        this.viewUnitWidth = width;
        this.viewUnitHeight = height;
    }

    public Coordinate convertWorldToView( Coordinate coord ) {
        int translatedX = coord.x() - worldCoordToCenterViewOn.x();
        int translatedY = coord.y() - worldCoordToCenterViewOn.y();
        int x = offsetCenterOfViewX() + translatedX * viewUnitWidth;
        int y = offsetCenterOfViewY() + translatedY * viewUnitHeight;
        return new Coordinate2D( x, y );
    }

    private int offsetCenterOfViewX() {
        return viewWidth/2 - viewUnitWidth/2;
    }

    private int offsetCenterOfViewY() {
        return viewHeight/2 - viewUnitHeight/2;
    }

    public void centerViewOnWorldCoord( Coordinate coord ) {
        this.worldCoordToCenterViewOn = coord;
    }
}

