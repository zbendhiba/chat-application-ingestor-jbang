package dev.zineb.embedding;

import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import static java.time.Duration.ofSeconds;
import static dev.langchain4j.model.openai.OpenAiEmbeddingModelName.TEXT_EMBEDDING_3_SMALL;


public final class OpenAiEmbeddingCustomModelBuilder {
    private String apiKey;
    private String modelName;
    private long timeout;
    private int maxRetries;
    private int dimensions;
    private boolean logRequests;
    private boolean logResponses;

    public OpenAiEmbeddingCustomModelBuilder apiKey(String apiKey){
        this.apiKey = apiKey;
        return this;
    }

    public OpenAiEmbeddingCustomModelBuilder modelName(String modelName){
        this.modelName = modelName;
        return this;
    }

    public OpenAiEmbeddingCustomModelBuilder timeout(long timeout){
        this.timeout = timeout;
        return this;
    }

    public OpenAiEmbeddingCustomModelBuilder maxRetries(int maxRetries){
        this.maxRetries = maxRetries;
        return this;
    }

    public OpenAiEmbeddingCustomModelBuilder dimensions(int dimensions){
        this.dimensions = dimensions;
        return this;
    }

    public OpenAiEmbeddingCustomModelBuilder logRequests(boolean logRequests){
        this.logRequests = logRequests;
        return this;
    }

    public OpenAiEmbeddingCustomModelBuilder logResponses(boolean logResponses){
        this.logResponses = logResponses;
        return this;
    }

    public OpenAiEmbeddingModel build() {
       return OpenAiEmbeddingModel.builder()
                     .apiKey(apiKey)
                     .modelName(modelName)
                    .timeout(ofSeconds(timeout))
                    .maxRetries(maxRetries)
                    .dimensions(dimensions)
                    .logRequests(logRequests)
                    .logRequests(logResponses)
                    .build();
                   
    }
}

