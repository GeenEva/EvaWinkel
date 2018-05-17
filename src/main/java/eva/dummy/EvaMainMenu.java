package eva.dummy;

import org.bson.Document;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



public class EvaMainMenu {
	
	public static void main(String[] args) {

	MongoClient mongoClient = new MongoClient("localhost" , 27017 );
	
	MongoDatabase mongoDb = mongoClient.getDatabase("tryoutdb");
	MongoCollection<Document> dbCollection = mongoDb.getCollection("users");
			
	MongoCursor <Document> cursor = dbCollection.find().iterator();
	
	while(cursor.hasNext()) {
		int i = 1;
		System.out.println(cursor.next());
	}
	}
}
