# Hungy
A simple minecraft mod that enables hunger and disables regeneration in peaceful mode.

It's as simple as two mixins and **does not require fabric API**.
All it does is:
- make a player always lose hunger, regardless of whether they're in peaceful
- disable health and hunger regeneration on peaceful mode 
(by tricking that specific check into thinking the world is always in normal mode, this does not affect anything else)

That's it! Enjoy actually eating food in peaceful