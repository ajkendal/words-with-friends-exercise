## Amanda J Kendal-Brown
### October 6th, 2015
### Words With Friends Problem

# Description
Application is meant for users to search certain words that contain individual letters, desired prefix, or a desired suffix, from a dictionary that contains a certain amount of words.<br />

# Original Problem Statement

## Words with Friends Problem

### Problem Statement

Given the included dictionary file `words.txt` write a program to take a shuffled set of letters and return:

 - what words from the dictionary the user can spell with these letters?
 - what words begin with these letters as a prefix?
 - what words end with these letters as a suffix?

You may use any programming language with which you're comfortable.  

Include along with your sourcecode any documentation necessary to compile / run your program.
 
Extra credit for performance optimizations and/or unit tests.

### Example Usage

Assume your program is called "scrabbler".

To find all the words you can spell with 7 letters "abcdefg" you should be able to type:

    $ scrabbler abcdefg
    
And get back a list of words as output.  Something like:

    ache
    ...
    chafed
    
To find all words that begin with a specific prefix:

    $ scrabbler --prefix fi
    fix
    fixed
    ...
    fiz
    fizzy
    
To find all words with a specific suffix:

    $ scrabbler --suffix o
    aero
    ...
    zydeco
    
# Files Included

1. Repository.java
2. Repository.class
3. LLNode.java
4. LLNode.class
5. QueueUnderflowException.java
6. QueueUnderflowException.class
7. QueueInterface.java
8. QueueInterface.class
9. UnboundedQueueInterface.java
10. UnboundedQueueInterface.class
11. DictionaryQueue.java
12. DictionaryQueue.class
13. Scrabbler.java
	* Application
14. Scrabbler.class
15. words.txt

# To Run

We will open Scrabbler.java to run main, once program is running it will display how many words in the files dictionary, then prompt user for a desired option.

```java
Welcome to Scrabbler
Your Dictionary Contains 63005 Words

1. Find all the words you can spell with 7 letters.
2. Find all the words with a specific prefix.
3. Find all the words with a specific suffix.
4. Print Entire Dictionary
5. Exit Scrabbler.

Enter Option:
```

Once user has decided on option, it will then allow the user to input desired characters that they are searching for.

# Logic 

## containChar Method

```java
public void containChar(String text){ 
	String tempString = "";
	int instanceCount = 0;
	
	LLNode node; node = front;

	while(node != null){
		tempString = tempString + node.getInfo();
		
		for(int outerCount = text.length()-1; outerCount >= 0; outerCount --){
			for(int innerCount = tempString.length()-1; innerCount >= 0; innerCount--){ 	if(tempString.charAt(innerCount) == text.charAt(outerCount)){
					instanceCount++;

					if(instanceCount == 1) System.out.print(tempString + "\n");
				}
			}
		}
		tempString = ""; 
		instanceCount = 0; 
		node = node.getLink();
	}
}
```

The String “text” will be passed into the method with the characters the user entered. The while loop will start at the front of the Queue and check each word in the dictionary. It creates an empty String “tempString” stored with the info from the dictionary.
	The nested for loops:
		* The “outerCount” will keep track of the character position that the user enters (they have up to seven)
		* The “innerCount” will keep track of the character position in the current word.
			* Inside the inner loop the if conditions will check for words that may have the same character multiple times so they aren’t repeated when being printed for the user.