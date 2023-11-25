package example.grpcclient;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import service.*;

import java.util.HashMap;
import java.util.Map;

public  class LibraryImpl extends LibraryGrpc.LibraryImplBase {

    private final Map<Book, Integer> availableBooks = new HashMap<>();
    private final Map<String, Book> checkedOutBooks = new HashMap<>();

    // Initialize the library with some books
    public LibraryImpl() {
        // Assume some initial set of books
        Book book1 = Book.newBuilder().setTitle("Book 1").setAuthor("Author 1").build();
        Book book2 = Book.newBuilder().setTitle("Book 2").setAuthor("Author 2").build();

        availableBooks.put(book1, 2);  // 2 copies of Book 1
        availableBooks.put(book2, 1);  // 1 copy of Book 2
    }

    @Override
    public void checkout(LibraryReq req, StreamObserver<LibraryRes> responseObserver) {
        Book requestedBook = req.getBook();
        String clientName = req.getName();

        if (!availableBooks.containsKey(requestedBook) || availableBooks.get(requestedBook) == 0) {
            // Book not available
            sendResponse(responseObserver, false, "Book not available for checkout");
        } else if (checkedOutBooks.containsKey(clientName)) {
            // Client already has a book checked out
            sendResponse(responseObserver, false, "You already have a book checked out");
        } else {
            // Perform checkout
            availableBooks.put(requestedBook, availableBooks.get(requestedBook) - 1);
            checkedOutBooks.put(clientName, requestedBook);
            sendResponse(responseObserver, true, "Checkout successful");
        }
    }

    @Override
    public void returnBook(LibraryReq req, StreamObserver<LibraryRes> responseObserver) {
        String clientName = req.getName();
        Book returnedBook = req.getBook();

        if (!checkedOutBooks.containsKey(clientName) || !checkedOutBooks.get(clientName).equals(returnedBook)) {
            // Client didn't check out this book
            sendResponse(responseObserver, false, "You didn't check out this book");
        } else {
            // Perform return
            availableBooks.put(returnedBook, availableBooks.getOrDefault(returnedBook, 0) + 1);
            checkedOutBooks.remove(clientName);
            sendResponse(responseObserver, true, "Return successful");
        }
    }

    public void available(Empty request, StreamObserver<AvailableRes> responseObserver) {
        AvailableRes.Builder availableResBuilder = AvailableRes.newBuilder();

        for (Map.Entry<Book, Integer> entry : availableBooks.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                availableResBuilder.addBooks(entry.getKey());
            }
        }

        responseObserver.onNext(availableResBuilder.build());
        responseObserver.onCompleted();
    }




    private void sendResponse(StreamObserver<LibraryRes> responseObserver, boolean isSuccess, String errorMessage) {
        LibraryRes response = LibraryRes.newBuilder().setIsSuccess(isSuccess).setError(errorMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
