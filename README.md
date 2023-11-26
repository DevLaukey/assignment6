# gRPC Client Example

This project is a distributed system using gRPC for communication.  It interacts with various services, including an Echo service, Joke service, Library service, Encryption/Decryption service, and Trivia service. The client communicates with these services using Protocol Buffers and gRPC. The system also features a registry that keeps track of available services.

## Requirements Fulfilled

- gRPC Communication: Implemented a gRPC client-server architecture. Utilized gRPC for efficient and reliable communication between different services.
- Utilized Protocol Buffers for message serialization.
- Service Registry: Implemented a service registry for service discovery. Implemented a service registry to dynamically register and discover available services.
- Encryption Service: Created an encryption service featuring a Caesar cipher for both encryption and decryption.
- Library Management Service: Developed a library management service allowing users to check out and return books.
- Trivia Game Service: Implemented a trivia game service with random questions and answers.
- Added the project to amazon s3 instance.



## How to Run without Registry

### Run Node:

```bash
gradle runNode
```

### Run Client:

```bash
gradle Client
```

## How to Run wit Registry


### Run Registry Server:

```bash
gradle runRegistryServer -PgrpcPort=<grpcPort>
```

### Run Node (Service):

```bash
gradle runRegistryServer -PgrpcPort=<grpcPort>
```

### Run Client:

```bash
gradle runClient -PserviceHost=<serviceHost> -PservicePort=<servicePort> -PregistryHost=<registryHost> -PgrpcPort=<grpcPort>  -PregOn=<regOn>
```

### Run Client2:

```bash
gradle runClient2 -PserviceHost=<serviceHost> -PservicePort=<servicePort> -PregistryHost=<registryHost> -PgrpcPort=<grpcPort> -Pmessage=<message> -PregOn=true 
```

## Working with the Encryption Service
### Encryption
To encrypt a string, you need to make a gRPC call to the encrypt method.

- Request Message:
EncryptRequest: Contains the string (input) to be encrypted.
Response Message:


- EncryptResponse: Indicates whether the operation was successful (isSuccess), provides the encrypted string (solution), and an error message (error) if applicable.
### Decryption
To decrypt a string, you need to make a gRPC call to the decrypt method.

- Request Message:
DecryptRequest: Contains the string (input) to be decrypted.
Response Message:

- DecryptResponse: Indicates whether the operation was successful (isSuccess), provides the decrypted string (solution), and an error message (error) if applicable.

## Working with the Library Service
### Checkout a Book
To check out a book, a client needs to make a gRPC call to the checkout method.

#### Request Message:

- LibraryReq: Contains the client's name (name) and the book to be checked out (book).
#### Response Message:

- LibraryRes: Indicates whether the checkout was successful (isSuccess), and an error message (error) if applicable.


### Return a Book
To return a book, a client needs to make a gRPC call to the returnBook method.

#### Request Message:
LibraryReq: Contains the client's name (name) and the book to be returned (book).

#### Response Message:
LibraryRes: Indicates whether the return was successful (isSuccess), and an error message (error) if applicable.

### View Available Books
To return a book, a client needs to make a gRPC call to the returnBook method.

#### Request Message:

google.protobuf.Empty: No additional information is required.
#### Response Message:

AvailableRes: Contains a list of available books (books).


## Working with the Trivia Game Service
### Get a Trivia Question

To get a random trivia question, a client needs to make a gRPC call to the getTriviaQuestion method.


#### Request Message:

- TriviaRequest: Contains the category (category) of the trivia question.
#### Response Message:

- TriviaResponse: Contains the trivia question (question) and a list of possible options (options).


### Submit a Trivia Answer
To submit an answer to a trivia question, a client needs to make a gRPC call to the submitTriviaAnswer method.

#### Request Message:
TriviaAnswerRequest: Contains the submitted answer (answer).

#### Response Message:
TriviaAnswerResponse: Indicates whether the answer was correct (isCorrect), and provides an explanation (explanation).




## Documentation
### Encryption Service
#### Encrypt Method:
Shifts characters using a Caesar cipher.
#### Decrypt Method:
Reverses the encryption process.

### Library Management Service
#### Checkout Method:

Allows users to check out books from the library.
#### Return Method:

Enables users to return books to the library.
#### Available Method:

Lists available books in the library.
### Trivia Game Service
#### Get Trivia Question:

Retrieves a random trivia question based on the specified category.
#### Submit Trivia Answer:

Allows users to submit an answer and provides feedback on correctness.


### ScreenCast
TASK 1 and 2
![demo](task1-2.gif)

TASK 3
![demo](task3.gif)
