import com.mongodb.casbah.Imports._


object Resfully extends App{

	// Connect to default - localhost, 27017
	val mongoClient =  MongoClient()

	val db = mongoClient("RestfullyTestDB")

	val coll = db("RestfullyTestCOL")

	val a = MongoDBObject("Hitesh" -> "Maidasani")
	val b = MongoDBObject("Michael" -> "hWee")
	val c = MongoDBObject("Pari" -> "Lingampally")

	coll.insert(a)
	coll.insert(b)
	coll.insert(c)

	val allDocs = coll.find()
	println(allDocs)
	for(doc <- allDocs) println(doc)

}


