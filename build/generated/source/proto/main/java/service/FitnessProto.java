// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/fitness.proto

package service;

public final class FitnessProto {
  private FitnessProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_AddRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_AddRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_AddResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_AddResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_GetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_GetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_GetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_GetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_services_Exercise_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_services_Exercise_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026services/fitness.proto\022\010services\"2\n\nAd" +
      "dRequest\022$\n\010exercise\030\001 \001(\0132\022.services.Ex" +
      "ercise\"/\n\013AddResponse\022\021\n\tisSuccess\030\001 \001(\010" +
      "\022\r\n\005error\030\002 \001(\t\":\n\nGetRequest\022,\n\014exercis" +
      "eType\030\001 \001(\0162\026.services.ExerciseType\"U\n\013G" +
      "etResponse\022\021\n\tisSuccess\030\001 \001(\010\022\r\n\005error\030\002" +
      " \001(\t\022$\n\010exercise\030\003 \001(\0132\022.services.Exerci" +
      "se\"M\n\010Exercise\022\023\n\013description\030\001 \001(\t\022,\n\014e" +
      "xerciseType\030\002 \001(\0162\026.services.ExerciseTyp" +
      "e*5\n\014ExerciseType\022\n\n\006CARDIO\020\000\022\014\n\010STRENGT" +
      "H\020\001\022\013\n\007BALANCE\020\0022\205\001\n\007Fitness\022<\n\013addExerc" +
      "ise\022\024.services.AddRequest\032\025.services.Add" +
      "Response\"\000\022<\n\013getExercise\022\024.services.Get" +
      "Request\032\025.services.GetResponse\"\000B\031\n\007serv" +
      "iceB\014FitnessProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_services_AddRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_services_AddRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_AddRequest_descriptor,
        new java.lang.String[] { "Exercise", });
    internal_static_services_AddResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_services_AddResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_AddResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Error", });
    internal_static_services_GetRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_services_GetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_GetRequest_descriptor,
        new java.lang.String[] { "ExerciseType", });
    internal_static_services_GetResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_services_GetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_GetResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Error", "Exercise", });
    internal_static_services_Exercise_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_services_Exercise_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_services_Exercise_descriptor,
        new java.lang.String[] { "Description", "ExerciseType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}