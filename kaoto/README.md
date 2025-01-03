# chat-application-ingestor-jbang
Jbang version of the Camel chat application ingestor


## Install camel Jbang, camel version 4.8

## Update the application.properties 
Set your HuggingFace API_Key

## Run a  Qdrant instance
    podman run -d -p 6334:6334 -p 6333:6333 qdrant/qdrant:v1.11.5-unprivileged

## Create a collection
In this example we are using a HugginFace All MiniLM L6 v2 model (cf. https://huggingface.co/sentence-transformers/all-MiniLM-L6-v2). It's a 384-dimensional dense vector space, so we adjust the size accordingly.

Run
 curl -X PUT http://localhost:6333/collections/test-collection \
    -H "Content-Type: application/json" \
    -d '{
        "vectors": {
        "size": 384,
        "distance": "Cosine"
        }
    }'


Run this 
 camel run --dep=dev.langchain4j:langchain4j-hugging-face:0.36.2,dev.langchain4j:langchain4j-embeddings:0.36.2 *