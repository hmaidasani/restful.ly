To start mongo, open terminal and run:
<code>
mongod
</code>

Once that runs, open another terminal tab and run:
<code>
mongo
</code>

Open another terminal tab, and pwd to the the java source files. Compile and run the java files using:
<code>
javac -cp mongo-2.10.1.jar Restfully.java
java -cp .:mongo-2.10.1.jar Restfully
</code>