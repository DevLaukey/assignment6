// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/fitness.proto

package service;

public interface GetResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:services.GetResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  boolean getIsSuccess();

  /**
   * <code>string error = 2;</code>
   * @return The error.
   */
  java.lang.String getError();
  /**
   * <code>string error = 2;</code>
   * @return The bytes for error.
   */
  com.google.protobuf.ByteString
      getErrorBytes();

  /**
   * <code>.services.Exercise exercise = 3;</code>
   * @return Whether the exercise field is set.
   */
  boolean hasExercise();
  /**
   * <code>.services.Exercise exercise = 3;</code>
   * @return The exercise.
   */
  service.Exercise getExercise();
  /**
   * <code>.services.Exercise exercise = 3;</code>
   */
  service.ExerciseOrBuilder getExerciseOrBuilder();
}
