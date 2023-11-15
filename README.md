# Binary Search Tree implementation

This project is an implementation of a binary search tree. It'll be shown how to compile and run the program, in addition to presenting the methods present in the implementation.

- [Software instalation guide](#software-instalation-guide)
- [Compiling and executing the program](#compiling-and-executing-the-program)
- [Commands model](#commands-model)

## Software instalation guide

In this project, it's used the version LTS 17 of JDK. However, if you haven't installed yet, here are some instructions for the instalation:

On `Linux` terminal, you'll use the following command:

`sudo apt install openjdk-17-jdk`

If you want to verify if everything is ok, you can use this command:

`java --version`

If everything went well, something like this is expected:

`openjdk 17.0.8.1 2023-08-24`

`OpenJDK Runtime Environment (build 17.0.8.1+1-Ubuntu-0ubuntu122.04)`

`OpenJDK 64-Bit Server VM (build 17.0.8.1+1-Ubuntu-0ubuntu122.04, mixed mode, sharing)`

Furthermore, the projects have two `.txt` files by default. The first one have a commands list `commands.txt`, the other one have an integers list to build the binary search tree `tree.txt`.

If you want a personalized commands list and a personalized tree, you can change the mentioned files content. Keep in mind that you have to keep the file names.

If everything runned well, this step is finished.

## Compiling and executing the program

To compile the program, use the following command on terminal:

`javac application/Program.java`

To run the program, you have to transfer the files `tree.txt` and `commands.txt` to the src folder, if this folder don't have these files yet, and use the following command:

`java application/Program`

An alternative way to compile and the program:

Cloning this repository and accomplishing the steps above, you can choose the `IDE` of your preference and import the project on it.

In this way, you can compile and execute the program.

## Commands Model

Here are an example that show how you can list the commands, you want to create a personalized `commands.txt`.

Example:

NTH N <br>
POSITION N <br>
MEAN <br>
PERFECT <br>
COMPLETE <br>
PRINT S <br>
REMOVE N <br>

---

Developed by Renzo Zukeram and Yuri Filgueira
