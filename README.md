# Overview

I call the program a fortune generator. It was built to mimic horoscopes to give you a personalized fortune. It calculates your Zodiac sign using the month and day of your birth. It then uses a list of words and a prewritten template, placing those words into the template based on the word's part of speach (noun, verb, ect.), if the word is positive or negative, and if the word matches your Zodiac sign.

I wrote this program to learn some Java and to practice object oriented programming. I also have a passing interest in all things supernatural and thought that it might be a fun challange to try making a fortune telling machine that was at least somewhat comprehensible. In addition I wanted to make a program that was somewhat configurable. I could compleatly swap out the template and so long as it is formatted properly and the JSON files had the appropriate words, it would work fine.

[Software Demo Video](https://youtu.be/hl4RlCdbOlA)

# Development Environment

VS Code - [Extension Pack for Java]()

Java 8 - OpenJDK 1.8.0_345

* org.json.simple
* java.util.random & scanner
* java.io.File, FileNotFoundException, & FileReader

JSON

# Useful Websites

- [Geeks for Geeks - Java](https://www.geeksforgeeks.org/java/?ref=shm)
- [Tutorials Point - Java + JSON](https://www.tutorialspoint.com/how-to-read-parse-json-array-using-java)

# Future Work

- Change positive and negative traits of others to be based of compatability of other signs, not just yours.
- Increase the conifgurability of the program. It should itterate through all parts of speach and personality traits without being hard coded.
- Create more templates and add the ability to mix and match between them.
