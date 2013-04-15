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
  * DONE [TEST] TerrainPiece objects have a Terrain type (e.g. Grass) and a Coordinate
  * DONE [TEST] Grass implements Terrain
  * DONE [TEST] Coordinate2D implements Coordinate (x(), y(), z() where z() always returns 0 for Coordinate2D)
  * DONE [TEST] Model needs some default terrain to return for allTerrain() - 3x3 grid of Grass
  * [TEST] Activity implements View and draws TerrainMap

* [FEATURE] User location is shown in view
* [FEATURE] User can move around world with 8-way compass for navigation, big enough to be usable, small enough to not obscure view
* [FEATURE] New Terrain type Rock as unpassable/unnavigable
* [FEATURE] Sideways view of game, best for including overlays and button for control
* [FEATURE] Items - can see items in nearby locations
* [FEATURE] Click to target on screen elements, second click does default action - pick up for items
* [FEATURE] Help button '?' - when pressed you can touch onscreen objects to get a hint about them, e.g. compass - used for navigation, healing spring - stand in to regenerate health
* [FEATURE] Character stats screen, health, money
* [FEATURE] Inventory button, view held items and details, drop/destroy items
* [FEATURE] Monsters
* [FEATURE] Second click after targetting attacks monsters
* [FEATURE] Armour/weapons button - see what you are wearing/wielding and swap with items in your inventory
* [FEATURE] New Terrain type Fire hurts when standing in it
* [FEATURE] New Terrain type Healing Spring heals when standing in it
* [FEATURE] Action buttons at the bottom of screen to act on targetted element, e.g. shoot, give
* [FEATURE] NPCs
* [FEATURE] Second click after targetting talks to NPCs
* [FEATURE] Auto-save/load onPause/onResume

Done
====

1.0

---
