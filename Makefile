run: clean compile exec graphics move_images article
    #clean compile exec generate_graphics copy_images

article:
	cd artigo && make

without_compile: generate_article generate_graphics copy_images

compile:
	javac -cp src -d build src/**/*.java

clean:
	rm -rf build/*

exec:
	java -cp build collectionbenchmark.Main 100000 10

graphics:
	cd src/outfiles && make

move_images:
	mv src/outfiles/list_clock_graph.png artigo/images
	mv src/outfiles/set_clock_graph.png artigo/images
	mv src/outfiles/map_clock_graph.png artigo/images
	mv src/outfiles/list_cpu_graph.png artigo/images
	mv src/outfiles/set_cpu_graph.png artigo/images
	mv src/outfiles/map_cpu_graph.png artigo/images
