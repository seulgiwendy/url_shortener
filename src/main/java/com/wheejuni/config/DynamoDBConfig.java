package com.wheejuni.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.wheejuni.spring.repositories")

public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String DynamoDBEndpoint;

	@Value("${amazon.aws.accesskey}")
	private String AwsAccesskey;

	@Value("${amazon.aws.secretkey}")
	private String AwsSecretKey;

	@SuppressWarnings("deprecation")
	@Bean
	public AmazonDynamoDB dynamoDb() {
		AmazonDynamoDB dynamoDb = new AmazonDynamoDBClient(amazonAWSCredentials());
		if (!StringUtils.isEmpty(DynamoDBEndpoint)) {
			dynamoDb.setEndpoint(DynamoDBEndpoint);
		}

		return dynamoDb;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(AwsAccesskey, AwsSecretKey);
	}

}
