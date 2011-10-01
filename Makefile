run: clean compile exec generate_graphics

compile:
	javac -cp src -d build src/**/*.java

clean:
	rm -rf build/*

exec:
	java -cp build collectionbenchmark.Main 

generate_graphics:
	gedit sets_gnuplots &
	gnuplot
