// camel-k: dependency=camel:file  dependency=camel:langchain4j-tokenizer  dependency=camel:langchain4j-embeddings dependency=camel:direct
//DEPS dev.langchain4j:langchain4j-open-ai:0.34.0
//DEPS dev.langchain4j:langchain4j-embeddings:0.34.0
//DEPS dev.langchain4j:langchain4j-embeddings-all-minilm-l6-v2:0.34.0

import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.tokenizer.LangChain4jTokenizerDefinition;
import org.apache.camel.spi.DataType;
import org.apache.camel.component.langchain4j.embeddings.LangChain4jEmbeddingsComponent;
import org.apache.camel.component.langchain4j.embeddings.LangChain4jEmbeddings;


public class DocumentIngestor extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        LangChain4jEmbeddingsComponent component
                = this.getContext().getComponent(LangChain4jEmbeddings.SCHEME, LangChain4jEmbeddingsComponent.class);

        component.getConfiguration().setEmbeddingModel(new AllMiniLmL6V2EmbeddingModel());

        from("file:catalog?noop=true")
                .tokenize(tokenizer()
                        .byParagraph()
                        .maxTokens(1024)
                        .maxOverlap(10)
                        .using(LangChain4jTokenizerDefinition.TokenizerType.OPEN_AI)
                        .end())
                .split().body()
                .to("direct:embed");

        from("direct:embed")
                .log("body :: ${body}")
                .to("langchain4j-embeddings:test")  // Use Langchain4j to generate embeddings
                .to("direct:transform");
                /*.transform(new DataType("qdrant:embeddings"))   // Transform the data type to a format suitable for Qdrant using a predefined transformer
                .setHeader(Qdrant.Headers.ACTION, constant(QdrantAction.UPSERT))  // Set the header to perform an UPSERT operation in Qdrant
                .to("qdrant:my-collection");  // Send the data to Qdrant*/


    }

}
