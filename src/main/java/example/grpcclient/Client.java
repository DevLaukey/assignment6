package example.grpcclient;

import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import service.*;
import services.Trivia;
import services.TriviaGameGrpc;


/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class Client {
  private final EchoGrpc.EchoBlockingStub blockingStub;
  private final JokeGrpc.JokeBlockingStub blockingStub2;
  private final RegistryGrpc.RegistryBlockingStub blockingStub3;
  private final RegistryGrpc.RegistryBlockingStub blockingStub4;
  private final LibraryGrpc.LibraryBlockingStub blockingStub5;
  private final EncryptionGrpc.EncryptionBlockingStub blockingStub6;
  private final TriviaGameGrpc.TriviaGameBlockingStub blockingStub7;



  /** Construct client for accessing server using the existing channel. */
  public Client(Channel channel, Channel regChannel) {
    // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
    // responsibility to
    // shut it down.

    // Passing Channels to code makes code easier to test and makes it easier to
    // reuse Channels.
    blockingStub = EchoGrpc.newBlockingStub(channel);
    blockingStub2 = JokeGrpc.newBlockingStub(channel);
    blockingStub3 = RegistryGrpc.newBlockingStub(regChannel);
    blockingStub4 = RegistryGrpc.newBlockingStub(channel);
    blockingStub5 = LibraryGrpc.newBlockingStub(channel);
    blockingStub6 = EncryptionGrpc.newBlockingStub(channel);
    blockingStub7 = TriviaGameGrpc.newBlockingStub(channel);

  }


  public void askServerToParrot(String message) {

    ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
    ServerResponse response;
    try {
      response = blockingStub.parrot(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getMessage());
  }

  public void askForJokes(int num) {
    JokeReq request = JokeReq.newBuilder().setNumber(num).build();
    JokeRes response;

    // just to show how to use the empty in the protobuf protocol
    Empty empt = Empty.newBuilder().build();

    try {
      response = blockingStub2.getJoke(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
    System.out.println("Your jokes: ");
    for (String joke : response.getJokeList()) {
      System.out.println("--- " + joke);
    }
  }

  public void setJoke(String joke) {
    JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
    JokeSetRes response;

    try {
      response = blockingStub2.setJoke(request);
      System.out.println(response.getOk());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

//  LIBRARY
  public void checkoutBook(String clientName, String bookTitle, String bookAuthor) {
    LibraryReq request = LibraryReq.newBuilder()
            .setName(clientName)
            .setBook(Book.newBuilder().setTitle(bookTitle).setAuthor(bookAuthor).build())
            .build();
    LibraryRes response;

    try {
      response = blockingStub5.checkout(request);
      System.out.println(response.getIsSuccess() ? "Checkout successful" : "Checkout failed: " + response.getError());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
    }
  }

  public void available() {
    Empty request = Empty.newBuilder().build();
    AvailableRes response;

    try {
      response = blockingStub5.available(request);
      System.out.println("Available Books: " + response.getBooksList());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
    }
  }

  public void returnBook(String clientName, String bookTitle, String bookAuthor) {
    LibraryReq request = LibraryReq.newBuilder()
            .setName(clientName)
            .setBook(Book.newBuilder().setTitle(bookTitle).setAuthor(bookAuthor).build())
            .build();
    LibraryRes response;

    try {
      response = blockingStub5.returnBook(request);
      System.out.println(response.getIsSuccess() ? "Book returned successfully" : "Return failed: " + response.getError());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
    }
  }

  //ENCRYPTION

  public void encryptOrDecryptText(String text) {
    System.out.println("Choose an option:");
    System.out.println("1. Encrypt");
    System.out.println("2. Decrypt");

    int encryptDecryptChoice = getUserChoice();

    switch (encryptDecryptChoice) {
      case 1:
        encryptText(text);
        break;
      case 2:
        decryptText(text);
        break;
      default:
        System.out.println("Invalid choice. Please choose 1 for Encrypt or 2 for Decrypt.");
        break;
    }
  }

  public void encryptText(String text) {
    EncryptRequest request = EncryptRequest.newBuilder().setInput(text).build();
    EncryptResponse response;

    try {
      response = blockingStub6.encrypt(request);
      System.out.println(response.getIsSuccess() ? "Encryption successful: " + response.getSolution() : "Encryption failed: " + response.getError());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
    }
  }

  // DECRYPT
  public void decryptText(String text) {
    DecryptRequest request = DecryptRequest.newBuilder().setInput(text).build();
    DecryptResponse response;

    try {
      response = blockingStub6.decrypt(request);
      System.out.println(response.getIsSuccess() ? "Decryption successful: " + response.getSolution() : "Decryption failed: " + response.getError());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
    }
  }



  // TRIVIA

  public void playTrivia() {
    try {
      boolean playAgain = true;

      while (playAgain) {
        // Get trivia category from the user
        String category = getUserInput("Enter the trivia category (General Knowledge, Science, History, Geography)");

        // Check if the category is valid
        if (!isValidTriviaCategory(category)) {
          System.out.println("Invalid trivia category. Please choose a valid category.");
          continue;
        }

        Trivia.TriviaRequest triviaRequest = Trivia.TriviaRequest.newBuilder().setCategory(category).build();

        // Get trivia question from the server
        Trivia.TriviaResponse triviaResponse = blockingStub7.getTriviaQuestion(triviaRequest);

        System.out.println("Trivia Question: " + triviaResponse.getQuestion());

        // Display relevant options for the trivia question
        for (int i = 0; i < triviaResponse.getOptionsList().size(); i++) {
          System.out.println((i + 1) + ". " + triviaResponse.getOptionsList().get(i));
        }

        // Get user's choice for the trivia answer
        int userChoice = getUserChoice();
        String userAnswer = triviaResponse.getOptionsList().get(userChoice - 1);

        // Send trivia answer to the server
        Trivia.TriviaAnswerRequest answerRequest = Trivia.TriviaAnswerRequest.newBuilder().setAnswer(userAnswer).build();
        Trivia.TriviaAnswerResponse answerResponse = blockingStub7.submitTriviaAnswer(answerRequest);

        // Display the result and explanation
        System.out.println(answerResponse.getExplanation());

        // Ask the user if they want to play again
        int playAgainChoice = Integer.parseInt(getUserInput("Do you want to play again? (1. Yes, 2. No)"));


        playAgain = (playAgainChoice == 1);
      }

      // Ask the user if they want to go back to the main menu
      int continueChoice = Integer.parseInt(getUserInput("Do you want to go back to the top menu? (1. Yes, 2. No)"));
      if (continueChoice == 1) {
        // Show available services to the user
        showAvailableServices();

        // Get user's choice of service
        int choice = getUserChoice();

        // Execute the selected service
        executeUserChoice(choice);
      }
    } catch (Exception e) {
      // Handle any exceptions
      System.err.println("An error occurred while playing trivia: " + e.getMessage());
      e.printStackTrace();
    }
  }

// Check if the trivia category is valid
  private boolean isValidTriviaCategory(String category) {
    return Arrays.asList("General Knowledge", "Science", "History", "Geography").contains(category);
  }

  public void showAvailableServices() {
    System.out.println("Available Services:");
    System.out.println("1. Echo Service");
    System.out.println("2. Joke Service");
    System.out.println("3. Library Service");
    System.out.println("4. Encryption/Decryption Service");
    System.out.println("5. Play a Trivia");
    System.out.println("6. Exit");
  }

  public void getNodeServices() {
    GetServicesReq request = GetServicesReq.newBuilder().build();
    ServicesListRes response;
    try {
      response = blockingStub4.getServices(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void getServices() {
    GetServicesReq request = GetServicesReq.newBuilder().build();
    ServicesListRes response;
    try {
      response = blockingStub3.getServices(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServer(String name) {
    FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
    SingleServerRes response;
    try {
      response = blockingStub3.findServer(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServers(String name) {
    FindServersReq request = FindServersReq.newBuilder().setServiceName(name).build();
    ServerListRes response;
    try {
      response = blockingStub3.findServers(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public int getUserChoice() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Choose a service (1-6): ");
    while (!scanner.hasNextInt()) {
      System.out.println("Invalid input. Please enter a number between 1 and 6.");
      scanner.next(); // consume invalid input
    }
    return scanner.nextInt();
  }

  public String getUserInput(String prompt) {
    Scanner scanner = new Scanner(System.in);
    System.out.print(prompt + ": ");
    return scanner.nextLine();
  }

  public void executeUserChoice(int choice) {
    boolean exitService = false; // To control whether to exit the current service
    while (!exitService) {
      try {
        switch (choice) {
          case 1:
            String echoMessage = getUserInput("Enter a message for the Echo service");
            askServerToParrot(echoMessage);
            break;
          case 2:
            int numJokes = Integer.parseInt(getUserInput("Enter the number of jokes you want"));
            askForJokes(numJokes);
            break;
          case 3:
            boolean exitLibrary = false; // To control whether to exit the library menu
            while (!exitLibrary) {
              int libraryChoice = Integer.parseInt(getUserInput("Library Options:\n1. Check Available Books\n2. Return a Book\n3. Checkout a Book\n4. Exit Library\n"));
              if (libraryChoice == 4) {
                exitLibrary = true; // Exit the library menu
              } else {
                handleLibraryOption(libraryChoice);
              }
            }
            break;
          case 4:
            String textToProcess = getUserInput("Enter the text to process");
            encryptOrDecryptText(textToProcess);
            break;
          case 5:
            playTrivia();
            break;
          case 6:
            exitService = true; // Exit the application
            break;
          default:
            break;
        }

        if (!exitService) {
          // After completing a service, ask if the user wants to go back to the top menu
          int continueChoice = Integer.parseInt(getUserInput("Do you want to go back to the top menu? (1. Yes, 2. No)"));
          if (continueChoice != 1) {
            exitService = true; // Exit the loop and the current service
          } else {
            // Show available services to the user
            showAvailableServices();

            // Get user's choice of service
            choice = getUserChoice();
          }
        }
      } catch (NumberFormatException e) {
        System.err.println("Invalid input. Please enter a valid number.");
      } catch (Exception e) {
        System.err.println("An unexpected error occurred: " + e.getMessage());
        exitService = true;
      }
    }
  }

  private void handleLibraryOption(int libraryChoice) {
    try {
    switch (libraryChoice) {
      case 1:
        available();
        break;
      case 2:
        String returnClientName = getUserInput("Enter your name");
        String returnBookTitle = getUserInput("Enter the title of the book");
        String returnBookAuthor = getUserInput("Enter the author of the book");
        returnBook(returnClientName, returnBookTitle, returnBookAuthor);
        break;
      case 3:
        // Add prompts to get details for checking out a book
        String checkoutClientName = getUserInput("Enter your name");
        String checkoutBookTitle = getUserInput("Enter the title of the book");
        String checkoutBookAuthor = getUserInput("Enter the author of the book");
        checkoutBook(checkoutClientName, checkoutBookTitle, checkoutBookAuthor);
        break;
      default:
        System.out.println("Invalid choice. Please choose a number between 1 and 3.");
      }
    }
    catch (Exception e) {
      System.err.println("An error occurred while processing the library option: " + e.getMessage());
    }
  }




  public static void main(String[] args) throws Exception {
    if (args.length != 6) {
      System.out
              .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)>");
      System.exit(1);
    }
    int port = 9099;
    int regPort = 9003;
    String host = args[0];
    String regHost = args[2];
    String message = args[4];
    try {
      port = Integer.parseInt(args[1]);
      regPort = Integer.parseInt(args[3]);
    } catch (NumberFormatException nfe) {
      System.out.println("[Port] must be an integer");
      System.exit(2);
    }

    // Create a communication channel to the server (Node), known as a Channel. Channels
    // are thread-safe
    // and reusable. It is common to create channels at the beginning of your
    // application and reuse
    // them until the application shuts down.
    String target = host + ":" + port;
    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS
            // to avoid
            // needing certificates.
            .usePlaintext().build();

    String regTarget = regHost + ":" + regPort;
    ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();
    try {

      // ##############################################################################
      // ## Assume we know the port here from the service node it is basically set through Gradle
      // here.
      // In your version you should first contact the registry to check which services
      // are available and what the port
      // etc is.

      /**
       * Your client should start off with
       * 1. contacting the Registry to check for the available services
       * 2. List the services in the terminal and the client can
       *    choose one (preferably through numbering)
       * 3. Based on what the client chooses
       *    the terminal should ask for input, eg. a new sentence, a sorting array or
       *    whatever the request needs
       * 4. The request should be sent to one of the
       *    available services (client should call the registry again and ask for a
       *    Server providing the chosen service) should send the request to this service and
       *    return the response in a good way to the client
       *
       * You should make sure your client does not crash in case the service node
       * crashes or went offline.
       */

      // create client
      Client client = new Client(channel, regChannel);

      // Show available services to the user
      client.showAvailableServices();

      // Get user's choice of service
      int userChoice = client.getUserChoice();

      // Execute the selected service
      client.executeUserChoice(userChoice);


    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent
      // leaking these
      // resources the channel should be shut down when it will no longer be used. If
      // it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
      regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
