# Java Socket Programming – Detailed Walkthrough


## Client Side – `clientSide.java`

This is a beginner-friendly explanation of each step in our Java client-side socket program.  
The client connects to a server at 127.0.0.1:4444, sends a message typed by the user, receives a reply from the server, and prints it.

---

### Step 1: Create the socket

```java
Socket socket = new Socket("127.0.0.1", 4444);
```

We create a socket that connects to the server running on localhost (`127.0.0.1`) at port `4444`.  
This connection must succeed before we can send or receive data. If the server isn’t running or the port is incorrect, an exception will be thrown.

---

### Step 2: Prepare the stream to send data

```java
OutputStream output = socket.getOutputStream();
PrintWriter writer = new PrintWriter(output, true);
```

- `output` is the stream (or path) through which the client sends data to the server.
- We wrap it with `PrintWriter` to send text messages easily using `println()`.
- The `true` flag enables **auto-flush**, meaning the message is immediately pushed through the stream after every print.

---

### Step 3: Capture user input

```java
BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
```

- `System.in` captures keyboard input, but it's in raw bytes.
- `InputStreamReader` converts bytes to characters.
- `BufferedReader` allows line-by-line reading using `.readLine()`.

---

### Step 4: Loop to send and receive messages

```java
String clientMessage;
while((clientMessage = consoleInput.readLine()) != null){
    writer.println(clientMessage);
    String serverResponse = reader.readLine();
    System.out.println("Server says : " + serverResponse);
}
```

- We read user input using `readLine()` and immediately send it to the server using `writer.println()`.
- We then wait for the server’s reply and print it.

---

### Step 5: Close socket after communication ends

```java
socket.close();
```

This ends the connection from the client’s side and frees up the socket resource.

---

## Server Side – `serverSide.java`

This is a beginner-friendly explanation of each step in our Java server-side socket program.  
The server listens on port 4444, accepts a client, receives messages, responds to them, and exits when done.

---

### Step 1: Create a ServerSocket

```java
ServerSocket serversocket = new ServerSocket(4444);
System.out.println("Established server socket, ready to listen");
```

We create a server socket that listens on the specified port.

---

### Step 2: Accept a client connection

```java
Socket socket = serversocket.accept();
System.out.println("Client connected");
```

Once the serversocket finds a client on the port, it accepts it and creates  
a new "socket" to communicate with the socket it just accepted.

---

### Step 3: Setup input stream from the client

```java
InputStream input = socket.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(input));
```

Now we create a inputstream for the "socket" we newly created, to accept whatever data is coming  
and convert that data into characters from raw bytes.

---

### Step 4: Setup output stream to the client

```java
OutputStream output = socket.getOutputStream();
PrintWriter writer = new PrintWriter(output, true);
```

Now the server will send some response, so for that we create an output stream and `PrintWriter` object.

---

### Step 5: Read and respond in a loop

```java
String clientMessage;
while((clientMessage = reader.readLine()) != null){
    System.out.println("CLient says : " + clientMessage);
    writer.println("Hello Client, I got your message!");
}
```

Now we keep on reading the client input till it is null.

---

### Step 6: Close everything

```java
socket.close();
serversocket.close();
```

Once the input is null, we close both the sockets and exit.

---
