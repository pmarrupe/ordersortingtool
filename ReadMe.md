This is a simple Java springboot application that takes in a source file with list of orders which then sorts them lexicographical and writes to a destination file.

--> Steps to run this application:

1. Clone the project
2. Run: "mvn clean package" (This should run all the tests and build a jar under /target)
3. Cd /target and run the following command to start the application:  
"java -jar order-sorting.jar --srcFile.name=SRCFILE_ABSOLUTEPATH --destFile.name=DESTFILE_ABSOLUTEPATH

Note: The file format is assumed as follows: (the first one is the ordername and time is in epoch which is read as long)
order   time
pizza    1345677
bread1   1448731

4. Hit the following link to see the output which is a sorted order list:

"http://localhost:8080/api/sort" Or You can hit "http://localhost:8080/swagger-ui.html" to see a proper user interface.

5. Run "mvn test" to run all the test cases.

--> Design assumptions and decisions:

1. It is assumed that order is an entity and has two properties:
 - orderName
 - Timestamp in epoch

2. Taking into consideration the future scope of this task, I wrote a spring based restful api to take in a src file and write to a destination file.

3. As we might want to write the sorted order list to a particular database in future, the list has been converted to an actual entity and returned to the user.

4. There is a scope to add spring jpa + hibernate to write the entity as it is to the database.

5. Swagger has been preferred as a web interface to upload a file for sorting and storing purposes.

