# DF_AdventureMode_Randomizer
In [Dwarf Fortress](http://www.bay12games.com/dwarves/), randomizes your adventurer's attributes and skills.

## Motivation

I've always liked challenges. It occurred to me that self imposed challenges work best.
It is easy to challenge an adventurer build by making arbitrary choices, like a musician, or a Misc. Object fighter; but these arbitrary choices remain too easy because they are not randomized.
Hence this program. It is used to fully randomize your starting skills. Most of the time in unplayable ways.

Have Fun.

## Running the program

Follow these steps to get the program running.
For now, the program is a single launch application that dies upon finish.
Launch the program again if you don't like your result.

### Prerequisites

You need Java 1.8 installed.

### Steps

Download a copy of the Main.jar file in the [Release](https://github.com/Spriggans12/DF_AdventureMode_Randomizer/releases/latest) screen.
Put that jar in a location on your computer.

Open a command line console, and navigate to the previous location
```
cd /location/to/main/jar/file
```

Simply execute the program with
```
java -jar Main.jar
```

### Options

Valid options are :

* -help : Displays a help message

* -c : Make output appear in color.
Like in the game, red is bad, green is good.
It will not work if your console does not support ANSI coding.
*EG. : Windows' cmd does not support it, but gitbash does.*

* -s <value> : Choose the status of your adventurer.
Value can be either 'p' (Peasant), 'h' (Hero) or 'g' (Semigod). Default value is 'p'

* -sex <value> : Choose the sex of your adventurer. Can be 'f' or 'm'. Defaults to a random value.

* -race <value> : Choose the race of your adventurer. Can be 'human', 'dwarf', 'elf' or 'goblin'. Defaults to a random value.

* -seed <value> : You can set the random generation seed with this parameter. It doesn't have much point. But here it is. Defaults to a random value.

### Examples

```
java -jar Main.jar -s h
```
Runs the randomizer with a Hero.

```
java -jar Main.jar -c
```
Runs the randomizer with a Peasant (default), and with ANSI coloration.

```
java -jar Main.jar -sex f -race elf
```
Runs the randomizer with a Peasant Female Elf.

## Compiling the program yourself

Feel free to update the code to your liking.
Once done, you can create an executable jar of the program by navigating to the make directory
```
cd make/
```

and running
```
sh makeJar.sh
```
*For Windows users, you have to run *makeJar.bat* instead.*

This will create a file, named Main.jar, similar to the one provided under [Releases](https://github.com/Spriggans12/DF_AdventureMode_Randomizer/releases/latest).

## License

This project is licensed under the Do What The F*ck You Want To Public License - see the [LICENSE.md](LICENSE.md) file for details, but yeah, it means I don't care who uses this or how.

## Acknowledgments

* Special thanks to [Bay12Games](http://www.bay12games.com/dwarves/) for making such an amazing game.

