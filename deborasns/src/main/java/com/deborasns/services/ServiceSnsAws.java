package com.deborasns.services;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

public class ServiceSnsAws {
    private static String arnTopic = System.getenv("AWS_SNS_ARN_TOPIC");
    
    public static void sendMessage(String message){

        
        AwsCredentialsProvider credentials = new AwsCredentialsProvider(){
            @Override
            public AwsCredentials resolveCredentials(){
                return new AwsCredentials(){
                    @Override
                    public String accessKeyId(){
                        return System.getenv("AWS_ACCESS_KEY");
                    }
                    @Override
                    public String secretAccessKey(){
                        return System.getenv("AWS_SECRET_ACCESS_KEY");
                    }
                };
            }
        };
        
        SnsClient snsClient = SnsClient.builder()
        .region(Region.US_EAST_1)
        .credentialsProvider(credentials)
        .build();
        
        PublishRequest request = PublishRequest.builder()
        .messageStructure("Envio de SNS")
        .message(message)
        .topicArn(arnTopic)
        .build();
        
        PublishResponse response = snsClient.publish(request);
        
        System.out.println("Mensagem enviada, status: " + response.sdkHttpResponse().statusCode());
        
        snsClient.close();
        
    }
}