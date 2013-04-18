package com.chewielouie.tinyrpg;

public class TinyRPGPresenter implements RendersView {
    TinyRPGView view;
    TinyRPGModel model;

    public TinyRPGPresenter( TinyRPGView view, TinyRPGModel model ) {
        this.view = view;
        this.model = model;
    }

    public void render() {
        view.showTerrain( model.allTerrain() );
        view.showPlayerAt( model.playerPosition() ) ;
    }
}

