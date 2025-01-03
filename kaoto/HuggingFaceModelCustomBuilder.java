package dev.zineb.embedding;

import static java.time.Duration.ofSeconds;
import dev.langchain4j.model.huggingface.HuggingFaceEmbeddingModel;

public final class HuggingFaceModelCustomBuilder {

	private String accessToken;
    private String modelId;
    private boolean waitForModel;
    private int timeout;

	public HuggingFaceModelCustomBuilder accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

	public HuggingFaceModelCustomBuilder modelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public HuggingFaceModelCustomBuilder timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public HuggingFaceModelCustomBuilder waitForModel(boolean waitForModel) {
        this.waitForModel = waitForModel;
        return this;
    }   

    public HuggingFaceEmbeddingModel build() {
        return HuggingFaceEmbeddingModel.builder()
                .accessToken(accessToken)
                .modelId(modelId)
                .waitForModel(waitForModel)
                .timeout(ofSeconds(timeout))
                .build();
    }

}

