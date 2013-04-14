Tiny RPG
==============

A tiny RPG initially for Android. This is another exercise in TDD in an Android environment.

Don't forget to drive the development by producing value - the value is game content and this should drive the development of functionality to support it.

Backlog
=======

* [FEATURE] User can see the terrain surrounding them.
  * DONE [TEST] Set up MVP structure. On render presenter tells view of terrain. Presenter.render(), View.showTerrain( TerrainMap ), Model.allTerrain()
  * DONE [TEST] Model returns all available terrain on allTerrain() as a TerrainMap
  * DONE [TEST] TerrainMap contains TerrainPiece objects which can be accessed with an Enumerator/Iterator
  * [TEST] TerrainPiece objects have a Terrain type (e.g. Grass) and a Coordinate
  * [TEST] Terrain objects have a type (e.g. Grass) and properties - e.g. unnavigable
  * [TEST] 2DCoord implements Coordinate (x(), y(), z() ?? where z() always returns 0 for 2DCoord?)
  * [TEST] Model needs some default terrain to return for allTerrain() - 3x3 grid of Grass
  * [TEST] Activity implements View and draws TerrainMap

* [FEATURE] User location is shown in view
* [FEATURE] User can move around world
* [FEATURE] Implement new Terrain type Rock as unpassable/unnavigable

Done
====

1.0

---
