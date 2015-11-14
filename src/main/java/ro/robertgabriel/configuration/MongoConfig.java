package ro.robertgabriel.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    public static final String OPENSHIFT_MONGODB_DB_HOST = "OPENSHIFT_MONGODB_DB_HOST";
    public static final String OPENSHIFT_MONGODB_DB_PORT = "OPENSHIFT_MONGODB_DB_PORT";
    public static final String OPENSHIFT_APP_NAME = "OPENSHIFT_APP_NAME";
    public static final String OPENSHIFT_MONGODB_DB_USERNAME = "OPENSHIFT_MONGODB_DB_USERNAME";
    public static final String OPENSHIFT_MONGODB_DB_PASSWORD = "OPENSHIFT_MONGODB_DB_PASSWORD";

    @Override
    protected String getDatabaseName() {
        return getDb();
    }

    @Override
    public Mongo mongo() throws Exception {

        String host = getHost();
        String db = getDb();
        String user = getUser();
        String password = getPassword();
        int port = getPort();

        MongoCredential credential = MongoCredential.createCredential(user,
                db,
                password.toCharArray());

        List<MongoCredential> listMongoCredentials = new ArrayList<MongoCredential>();

        listMongoCredentials.add(credential);

        return new MongoClient(new ServerAddress(host, port), listMongoCredentials);
    }

    private String getHost(){

        String host = System.getenv(OPENSHIFT_MONGODB_DB_HOST);

        if(host == null){
            throw new RuntimeException("The MongoDB host is not set");
        }
        return host;
    }

    private int getPort(){

        String stringPort = System.getenv(OPENSHIFT_MONGODB_DB_PORT);

        if(stringPort == null){
            throw new RuntimeException("The MongoDB port is not set");
        }

        return Integer.decode(stringPort);
    }

    private String getDb() {
        String db = System.getenv(OPENSHIFT_APP_NAME);

        if(db == null){
            throw new RuntimeException("The MongoDB database is not set");
        }

        return db;
    }
    private String getUser() {
        String user = System.getenv(OPENSHIFT_MONGODB_DB_USERNAME);

        if(user == null){
            throw new RuntimeException("The MongoDB user is not set");
        }

        return user;
    }
    private String getPassword() {
        String password = System.getenv(OPENSHIFT_MONGODB_DB_PASSWORD);

        if(password == null){
            throw new RuntimeException("The MongoDB password is not set");
        }

        return password;
    }
}
