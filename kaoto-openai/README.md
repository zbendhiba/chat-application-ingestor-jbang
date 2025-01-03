# chat-application-ingestor-jbang
Jbang version of the Camel chat application ingestor


## Install camel Jbang, camel version 4.8

## Update the application.properties 
Set your OPENAI API_Key

## Run a  Qdrant instance
    podman run -d -p 6334:6334 -p 6333:6333 qdrant/qdrant:v1.11.5-unprivileged

## Create a collection
In this example we are using a OpenAI text-embedding-3-small model. It's a 1536-dimensional dense vector space, so we adjust the size accordingly.

Run
 curl -X PUT http://localhost:6333/collections/test-collection \
    -H "Content-Type: application/json" \
    -d '{
        "vectors": {
        "size": 1536,
        "distance": "Cosine"
        }
    }'


Run this 
 camel run --dep=dev.langchain4j:langchain4j-open-ai:0.36.2,dev.langchain4j:langchain4j-embeddings:0.36.2 *