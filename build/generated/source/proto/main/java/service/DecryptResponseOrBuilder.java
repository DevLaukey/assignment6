// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/encryption.proto

package service;

public interface DecryptResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.DecryptResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  boolean getIsSuccess();

  /**
   * <pre>
   * The decrypted string 
   * </pre>
   *
   * <code>string solution = 2;</code>
   * @return The solution.
   */
  java.lang.String getSolution();
  /**
   * <pre>
   * The decrypted string 
   * </pre>
   *
   * <code>string solution = 2;</code>
   * @return The bytes for solution.
   */
  com.google.protobuf.ByteString
      getSolutionBytes();

  /**
   * <pre>
   * Error message, a String of your choice to show what went wrong
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <pre>
   * Error message, a String of your choice to show what went wrong
   * </pre>
   *
   * <code>string error = 3;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}
