
echo "Starting project for Windows ..." ;
gradlew build && cd app/build/libs && java -jar app.jar
