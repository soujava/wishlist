package sh.platform.template;

import com.mongodb.MongoClient;
import jakarta.nosql.document.DocumentCollectionManager;
import org.eclipse.jnosql.diana.mongodb.document.MongoDBDocumentCollectionManagerFactory;
import org.eclipse.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;
import sh.platform.config.Config;
import sh.platform.config.MongoDB;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class MongoConfig {

    @Produces
    public DocumentCollectionManager getManager() {
        Config config = new Config();
        final MongoDB mongo = config.getCredential("mongodb", MongoDB::new);
        final MongoClient mongoClient = mongo.get();
        MongoDBDocumentConfiguration configuration = new MongoDBDocumentConfiguration();
        MongoDBDocumentCollectionManagerFactory factory = configuration.get(mongoClient);
        return factory.get(mongo.getDatabase());
    }
}