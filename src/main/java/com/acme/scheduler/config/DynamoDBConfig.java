package com.acme.scheduler.config;

import com.acme.scheduler.core.dataProviders.repository.ScheduleRepository;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = ScheduleRepository.class)
public class DynamoDBConfig {

    @Value("${aws.dynamodb.endpoint:http://localhost:8000}")
    private String awsEndpoint;
    @Value("${aws.accesskey:accesskey}")
    private String awsAccessKey;
    @Value("${aws.secretkey:secretkey}")
    private String awsSecretKey;
    @Value("${aws.region:us-east-1}")
    private String awsRegion;

    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

    public EndpointConfiguration endpointConfiguration() {
        return new EndpointConfiguration(awsEndpoint, awsRegion);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.
                standard()
                .withCredentials(amazonAWSCredentialsProvider())
                .withEndpointConfiguration(endpointConfiguration())
                .build();
    }

}
