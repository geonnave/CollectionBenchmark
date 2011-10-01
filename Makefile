run: clean compile exec

compile:
	javac -cp src -d build src/**/*.java

clean:
	rm -rf build/*

exec:
	java -cp build collectionbenchmark.Main 

generate_graphics:
	
