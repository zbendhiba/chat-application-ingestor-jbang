package dev.zineb.embedding;


public final class HuggingFaceModelCustom {

	private String accessToken;
	private String modelId;
	private boolean waitForModel;
	private int timeout;

	HuggingFaceModelCustom(String accessToken, String modelId, boolean waitForModel, int timeout) {
		this.accessToken = accessToken;
		this.modelId = modelId;
		this.waitForModel = waitForModel;
		this.timeout = timeout;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getModelId() {
		return modelId;
	}

	public int getTimeout() {
		return timeout;
	}

	public boolean isWaitForModel() {
		return waitForModel;
	}

	public String summary() {
		return "accessToken is " + accessToken + ", model is " + modelId + ", timeout in seconds is " + timeout + ", wait for model is :" +waitForModel;
	}
}