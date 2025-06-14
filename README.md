# MultiThreaded Java Client-Server Example

## Overview
This project demonstrates a simple multithreaded client-server architecture in Java. It consists of two main components:
- **Server**: Listens for incoming client connections on a specified port and handles each connection in a separate thread.
- **Client**: Connects to the server and communicates using sockets, with each client running in its own thread.

The project is intended for educational purposes, illustrating the basics of concurrent server programming and socket-based communication in Java.

## Project Structure
```
MultiThreaded/
├── src/
│   ├── Server.java      # Server implementation
│   ├── Client.java      # Client implementation
│   ├── Server.class     # Compiled Server bytecode
│   ├── Client.class     # Compiled Client bytecode
│   └── Client$1.class   # Compiled anonymous inner class from Client.java
├── MultiThreaded.iml    # IntelliJ IDEA project file
└── .gitignore           # Git ignore file
```

## How It Works
### Server
- Listens on port `8010` for incoming connections.
- For each client connection, spawns a new thread to handle communication.
- Sends a greeting message to the client and prints the client's response.

### Client
- Connects to the server at `localhost:8010`.
- Sends a greeting message to the server and prints the server's response.
- The main method starts 100 client threads to demonstrate concurrent connections.

## Usage
### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compilation
Navigate to the `src` directory and compile both Java files:
```sh
javac Server.java Client.java
```

### Running the Server
Start the server (from the `src` directory):
```sh
java Server
```
You should see:
```
Server is listening on port 8010
```

### Running the Clients
In a separate terminal (also in the `src` directory), run:
```sh
java Client
```
This will start 100 client threads, each connecting to the server and exchanging messages.

## Example Output
**Server:**
```
Server is listening on port 8010
Hello from client :/127.0.0.1:XXXXX
...
```
**Client:**
```
Hello from the server  /127.0.0.1
...
```

## Notes
- The server uses a thread-per-client model. For production systems, consider using thread pools or asynchronous I/O for scalability.
- The code is designed for clarity and instructional value, not for high-performance or secure networking.

## License
This project is for educational use. Modify and use as needed.
