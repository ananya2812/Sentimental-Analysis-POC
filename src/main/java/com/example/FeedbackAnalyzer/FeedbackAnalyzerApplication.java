package com.example.FeedbackAnalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedbackAnalyzerApplication {

	public static void main(String[] args) {
		//String text = "Those who find ugly meanings in beautiful things are corrupt without being charming.";
		String text = "Wish you a very happy Happy Birthday";
		
		StanfordAPI sentimentAnalyzer = new StanfordAPI();
		sentimentAnalyzer.initialize();
		SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);

		System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
		System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
		System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");
		System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");
		System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");
		System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");
		System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");
		SpringApplication.run(FeedbackAnalyzerApplication.class, args);
	}

}
