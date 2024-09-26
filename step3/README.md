# chat-application-ingestor-jbang
Jbang version of the Camel chat application ingestor


Install camel Jbang, camel version 4.8

Update the application.properties, set your HuggingFace API_Key

Run this 
 camel run --dep=dev.langchain4j:langchain4j-hugging-face:0.34.0,dev.langchain4j:langchain4j-embeddings:0.34.0 *