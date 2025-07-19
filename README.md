# Client-Server Basic Socket Implementation

This repository contains a basic implementation of a client-server model using Java sockets. It was created as part of a hands-on exercise to understand how socket programming works in Java.

---

## Overview

- Demonstrates a simple one-to-one connection between a client and a server.
- Uses TCP sockets for reliable communication.
- Includes human-readable explanations of how the code works, based on inline comments.

---

## Files Included

- `serverSide.java`: The server that listens for incoming connections and responds to client messages.
- `clientSide.java`: The client that connects to the server and sends messages.
- `server_explained.md`: Step-by-step explanation of the server code.
- `client_explained.md`: Step-by-step explanation of the client code.

---

## How to Run

1. Compile the code:
   ```bash
   javac serverSide.java
   javac clientSide.java
   ```

2. Start the server:
   ```bash
   java serverSide
   ```

3. In a new terminal, start the client:
   ```bash
   java clientSide
   ```

---

## Purpose

This repo is purely for learning and experimentation with Java's socket API.
