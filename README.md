# DNDCharacterManager
Interactive CLI shell to manage a DnD 5E character!

## Example Usage
```
Starting DNDCharacterManager...

Dormor Moonnectar >> check perception
result: 1
Dormor Moonnectar >> show stats
	charisma: 4
	constitution: 2
	dexterity: 2
	wisdom: 0
	intelligence: -1
	strength: -2
Dormor Moonnectar >> act magic-missile

You create three glowing darts of magical force. Each dart hits a creature of your choice that you can see within range. A dart deals 1d4+1 force damage to its target. The darts all strike simultaneously and you can direct them to hit one creature or several.

At Higher Levels: When you cast this spell using a spell slot of 2nd level or higher, the spell creates one more dart for each slot above 1st.

Cast spell? [y/n] 
y
Roll #1: 3 + 1
Roll #2: 4 + 1
Roll #3: 1 + 1
11 force damage!
Dormor Moonnectar >> act longrest
Restored all spell slots!
Restored all hit points!
Dormor Moonnectar >> exit
Thanks for playing :)
```
## Features
- simple file-based state persistance
- easy to understand json character config files
- easy to understand code that is easy to customize

## Requirements
#### Build
- gradle 5.0+
- java 8
#### Run
- java 8

## TODO
- add to character model:
    - gold
    - proficiencies
    - items
- add commands:
    - generic roll command
    - roll initiative
- code fixes:
    - separate args validation from command business logic
    - create a generic way to define spell execution
