Tiny RPG
==============

A tiny RPG initially for Android. This is another exercise in TDD in an Android environment.

Don't forget to drive the development by producing value - the value is game content and this should drive the development of functionality to support it.

To list all virtual devices                             - 'android list avd'
Pick a virtual device by name and run in the emulator   - 'emulator @<name>' , e.g. 'emulator @emu-htc-desire-s'
To run the logging                                      - 'adb logcat'
To get a shell on the emu                               - 'adb shell'

Backlog
=======

* [FEATURE] User can move around world with 8-way compass for navigation, big enough to be usable, small enough to not obscure view. User is bounded by edges of the world.
  * DONE [TEST] On user action of move(direction) presenter calls model
  * DONE [TEST] On successful user movement BasicModel calls listeners
  * DONE [TEST] BasicModel implements 8 directions of movement, updating player position appropriately
  * [TEST] BasicModel does not change player position if they attempt to leave the map
  * [TEST] BasicModel does not notify listeners of changed player position if they attempt to leave the map
  * [TEST] Presenter listens to Model for user movement and tells view of new player position
  * [TEST] When user touches compass, WorldView converts to user movement action and calls UserActionHandler interface
  * [TEST] Presenter implements UserActionHandler interface
  * [TEST] Activity connects WorldView to presenter as the UserActionHandler

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

* [FEATURE] User location is shown in view
* [FEATURE] User can see the terrain surrounding them.

