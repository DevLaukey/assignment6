package example.grpcclient;

import io.grpc.stub.StreamObserver;
import service.*;

public class EncryptionImpl extends EncryptionGrpc.EncryptionImplBase {

    private static final int SHIFT = 3; // Caesar cipher shift

    @Override
    public void encrypt(EncryptRequest req, StreamObserver<EncryptResponse> responseObserver) {
        String input = req.getInput();
        String encrypted = caesarCipherEncrypt(input, SHIFT);
        sendEncryptResponse(responseObserver, true, encrypted, null);
    }

    public void decrypt(DecryptRequest req, StreamObserver<DecryptResponse> responseObserver) {
        String input = req.getInput();
        String decrypted = caesarCipherDecrypt(input, SHIFT);
        sendDecryptResponse(responseObserver, true, decrypted, null);
    }

    private String caesarCipherEncrypt(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String caesarCipherDecrypt(String input, int shift) {
        // Decryption is the same as encryption with a negative shift
        return caesarCipherEncrypt(input, 26 - shift);
    }

    private void sendEncryptResponse(
            StreamObserver<EncryptResponse> responseObserver,
            boolean isSuccess,
            String solution,
            String errorMessage) {
        EncryptResponse response = EncryptResponse.newBuilder()
                .setIsSuccess(isSuccess)
                .setSolution(solution)
                .setError(errorMessage != null ? errorMessage : "")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void sendDecryptResponse(
            StreamObserver<DecryptResponse> responseObserver,
            boolean isSuccess,
            String solution,
            String errorMessage) {
        DecryptResponse response = DecryptResponse.newBuilder()
                .setIsSuccess(isSuccess)
                .setSolution(solution)
                .setError(errorMessage != null ? errorMessage : "")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
