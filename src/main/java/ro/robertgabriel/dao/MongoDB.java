package ro.robertgabriel.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    private DB dbConnection;

    public DB getDbConnection() {

        if (dbConnection != null){
            return dbConnection;
        }
        String host = getHost();
        String db = getDb();
        String user = getUser();
        String password = getPassword();
        int port = getPort();

        try {
            MongoCredential credential = MongoCredential.createCredential(user,
                    db,
                    password.toCharArray());

            List<MongoCredential> listMongoCredentials = new ArrayList<MongoCredential>();

            listMongoCredentials.add(credential);

            MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), listMongoCredentials);

            dbConnection = mongoClient.getDB(db);
            return dbConnection;

        } catch (UnknownHostException e) {
            throw new RuntimeException("Failed to access Mongo server", e);
        }

    }

    private String getHost(){

        String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");

        if(host == null){
            throw new RuntimeException("The MongoDB host is not set");
        }
        return host;
    }

    private int getPort(){

        String stringPort = System.getenv("OPENSHIFT_MONGODB_DB_PORT");

        if(stringPort == null){
            throw new RuntimeException("The MongoDB port is not set");
        }

        return Integer.decode(stringPort);
    }

    private String getDb() {
        String db = System.getenv("OPENSHIFT_APP_NAME");

        if(db == null){
            throw new RuntimeException("The MongoDB database is not set");
        }

        return db;
    }
    private String getUser() {
        String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");

        if(user == null){
            throw new RuntimeException("The MongoDB user is not set");
        }

        return user;
    }
    private String getPassword() {
        String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");

        if(password == null){
            throw new RuntimeException("The MongoDB password is not set");
        }

        return password;
    }
}
