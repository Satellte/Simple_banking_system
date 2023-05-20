# Simple banking system
## Fifth project from HyperSkill.org
```HTML
https://hyperskill.org/projects/93?category=2&track=12
```
___
## Table of Contents
- [Description](#description)
- [Features](#features)
- [Usage](#usage)
- [Feedback](#feedback)
- [Contributing](#contributing)
- [Dependencies](#dependencies)
- [Contact Information](#contact-information)

## Description
This is a simple banking system project implemented in Java. The project aims to provide a basic understanding of how a banking system works, along with practical experience in working with databases and SQL. It also introduces fundamental concepts of object-oriented programming (OOP) through the use of classes.

## Features
The Simple Banking System offers the following features:
1. Account Creation: Users can create a new account, which includes generating a unique card number that is being verified by Luhn algorithm and a PIN code.
2. Account Login: Users can log into their existing accounts using existing in database card number and PIN.
3. Balance Inquiry: Logged-in users can check their account balance.
4. Income Addition: Logged-in users can add income to their account.
5. Fund Transfer: Logged-in users can transfer funds from their account to another existing in database, account.
6. Account Closure: Logged-in users can close (delete from database) their account.

## Usage
### To run the Simple Banking System project, follow these steps:

1. Set up the database: The project uses an SQLite database. Ensure that the SQLite JDBC driver is installed.
2. Download the project files: Obtain the project files from the provided link.
3. Compile the project: Compile the Java classes using a Java compiler.
4. Run the project: Execute the compiled Main class, providing the optional command-line argument -fileName to specify the database file name. If no file name is provided, the default file name will be used.
5. Follow the on-screen instructions: The program will display a menu with different options. Enter the corresponding number to perform the desired action.
