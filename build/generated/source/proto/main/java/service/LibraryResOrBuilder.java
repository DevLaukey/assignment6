// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/library.proto

package service;

public interface LibraryResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.LibraryRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * was the checkout or return successful?
   * </pre>
   *
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  boolean getIsSuccess();

  /**
   * <pre>
   * isSuccess is false, inform the client of what went wrong
   * </pre>
   *
   * <code>string error = 2;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <pre>
   * isSuccess is false, inform the client of what went wrong
   * </pre>
   *
   * <code>string error = 2;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();
}