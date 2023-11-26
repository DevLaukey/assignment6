package example.grpcclient;

import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.Serializable;

import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import service.*;

import java.util.stream.Collectors;


/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class Client2 {
    private final RegistryGrpc.RegistryBlockingStub blockingStub3;
    private RegistryGrpc.RegistryBlockingStub blockingStub4;
    private LibraryGrpc.LibraryBlockingStub blockingStub5;
    private EncryptionGrpc.EncryptionBlockingStub blockingStub6;

    private Channel serviceChannel;



    /** Construct client for accessing server using the existing channel. */
    public Client2(Channel channel, Channel regChannel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
        // responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to
        // reuse Channels.

        blockingStub3 = RegistryGrpc.newBlockingStub(regChannel);
        blockingStub4 = RegistryGrpc.newBlockingStub(channel);
        blockingStub5 = LibraryGrpc.newBlockingStub(channel);
        blockingStub6 = EncryptionGrpc.newBlockingStub(channel);


        // Initialize the service channel

        this.serviceChannel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();

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



    public static void showAvailableServices(List<String> services) {

        System.out.println("Available Services:");

        int count = 1;
        for (String service : services) {
            if (service.startsWith("services.Encryption") || service.startsWith("services.Library")) {
                System.out.println(count + ". " + service);
                count++;
            }
        }
        System.out.println("0. Exit");
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

    public ServicesListRes getServices() {
        GetServicesReq request = GetServicesReq.newBuilder().build();
        ServicesListRes response;
        try {
            response = blockingStub3.getServices(request);
            System.out.println(response.toString());
            return response;
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return null;
        }
    }

    public ServerInfo findServer(String name) {
        FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
        SingleServerRes response;

        try {
            response = blockingStub3.findServer(request);
            System.out.println(response.toString());

            // Extract server details from the response
            String serverIp = response.getConnection().getUri();
            int serverPort = response.getConnection().getPort();

            // Create a new channel for the discovered server
            Channel serviceChannel = createChannel(serverIp, serverPort);

            // Update the blocking stubs to use the new channel
            updateBlockingStubs(serviceChannel);

            // Return the server details
            return new ServerInfo(serverIp, serverPort);
        } catch (Exception e) {
            System.err.println("RPC failed: " + e);
            return null;
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
        System.out.print("Choose a service (0-5): ");
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


    public void executeUserChoice(int choice, List<String> services) throws InterruptedException {
        switch (choice) {
            case 0:
                System.out.println("Exiting the client.");
                break;
            default:
                if (choice > 0 && choice <= services.size()) {
                    String selectedService = services.get(choice - 1);

                    // Step 1: Find the server providing the selected service
                    ServerInfo serverInfo = findServer(selectedService);

                    if (serverInfo != null) {
                        System.out.println("Found server for " + selectedService + ": " + serverInfo.getIp() + ":" + serverInfo.getPort());

                        // Step 2: Execute the service-specific logic
                        handleService(selectedService);

                        // Close the channel when done
                        ((ManagedChannel) serviceChannel).shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                    } else {
                        System.out.println("Failed to find server for " + selectedService);
                    }
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
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


    private Channel createChannel(String ip, int port) {
        return ManagedChannelBuilder.forAddress(ip, port).usePlaintext().build();
    }


    private void updateBlockingStubs(Channel channel) {
        blockingStub4 = RegistryGrpc.newBlockingStub(channel);
        blockingStub5 = LibraryGrpc.newBlockingStub(channel);
        blockingStub6 = EncryptionGrpc.newBlockingStub(channel);
    }

    private void handleService(String selectedService) {
        switch (selectedService) {
            case "services.Library/checkout":
            case "services.Library/available":
            case "services.Library/returnBook":
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
            case "services.Encryption/encrypt":
            case "services.Encryption/decrypt":
                String textToProcess = getUserInput("Enter the text to process");
                encryptOrDecryptText(textToProcess);
                break;
            default:
                System.out.println("Unhandled service: " + selectedService);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 6) {
            System.out.println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)>");
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
             * Your client should start off with 1. contacting the Registry to check for the available services 2. List the services in the terminal and the client can choose one (preferably through numbering) 3. Based on what the client chooses the terminal should ask for input, eg. a new sentence, a sorting array or whatever the request needs 4. The request should be sent to one of the available services (client should call the registry again and ask for a Server providing the chosen service) should send the request to this service and return the response in a good way to the client You should make sure your client does not crash in case the service node crashes or went offline.
             */

            // create client
            Client2 client = new Client2(channel, regChannel);

            // Fetch available services from the registry
            ServicesListRes availableServices = client.getServices();

            // Show available services to the user
            List<String> serviceList = availableServices.getServicesList();

            // Filter services for Library and Encryption
            List<String> filteredServices = serviceList.stream()
                    .filter(service -> service.startsWith("services.Encryption") || service.startsWith("services.Library"))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


            // Show the filtered services to the user
            showAvailableServices(filteredServices);

            // Get user's choice of service
            int userChoice = client.getUserChoice();

            // Execute the selected service
            client.executeUserChoice(userChoice, filteredServices);

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


 class ServerInfo implements Serializable {
    private final String ip;
    private final int port;

    public ServerInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
