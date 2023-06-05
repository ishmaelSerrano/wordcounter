package com.synechron.ishmael.wordcounter.service;

import java.io.InputStream;
import java.util.Properties;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.translate.TranslateClient;
import software.amazon.awssdk.services.translate.model.TranslateTextRequest;
import software.amazon.awssdk.services.translate.model.TranslateTextResponse;

import java.io.FileInputStream;
import java.io.IOException;



public class Translator {

  private final TranslateClient translateClient;

  public Translator() {
    translateClient = createTranslateClient();
  }

  private TranslateClient createTranslateClient() {
    Properties properties = loadProperties();

    String accessKey = properties.getProperty("aws.accessKeyId");
    String secretKey = properties.getProperty("aws.secretKey");
    String region = properties.getProperty("aws.region");

    AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(
        AwsBasicCredentials.create(accessKey, secretKey)
    );

    return TranslateClient.builder()
        .region(Region.of(region))
        .credentialsProvider(credentialsProvider)
        .build();
  }

  private Properties loadProperties() {
    Properties properties = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("aws.properties")) {
      if (inputStream != null) {
        properties.load(inputStream);
      } else {
        throw new RuntimeException("Failed to load AWS properties file");
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to load AWS properties file", e);
    }
    return properties;
  }

  public String translate(String word) {
    TranslateTextRequest request = TranslateTextRequest.builder()
        .text(word)
        .sourceLanguageCode("auto")
        .targetLanguageCode("en")
        .build();

    TranslateTextResponse response = translateClient.translateText(request);

    return response.translatedText();
  }
}
