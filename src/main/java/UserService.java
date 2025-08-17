package com.ms;

import com.ms.User;
import com.ms.UserResponse;
import com.ms.UserServiceApiGrpc;

import io.grpc.stub.StreamObserver;

public class UserService extends UserServiceApiGrpc.UserServiceApiImplBase {

    @Override
    public void createUser(User request, StreamObserver<UserResponse> responseObserver) {
        // Here you would typically save the user to a database
        System.out.println("Received user: " + request.getFirstName() + " " + request.getLastName());

        // Create a response
        UserResponse response = UserResponse.newBuilder()
                .setMessage("User created successfully")
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(User request, StreamObserver<User> responseObserver) {
        // Here you would typically retrieve the user from a database
        System.out.println("Fetching user: " + request.getFirstName() + " " + request.getLastName());
        // Example: send back the same user as response
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

}
