# gRPC Client Example

This project demonstrates a gRPC client that interacts with various services, including an Echo service, Joke service, Library service, Encryption/Decryption service, and Trivia service. The client communicates with these services using Protocol Buffers and gRPC.

## Requirements Fulfilled

- Implemented a gRPC client-server architecture.
- Utilized Protocol Buffers for message serialization.
- Implemented a service registry for service discovery.

## How to Run

### Running the Registry Server

```bash
gradle runRegistryServer -PgrpcPort=your_grpc_port

###