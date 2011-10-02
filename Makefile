run:  generate_article
    #clean compile exec generate_graphics copy_images
without_compile: generate_article generate_graphics copy_images

compile:
	javac -cp src -d build src/**/*.java

clean:
	rm -rf build/*

exec:
	java -cp build collectionbenchmark.Main 

generate_graphics:
	cd src/outfiles && make

generate_article:
	cd artigo && make

copy_images:
	cp src/outfiles/list_clock_graph.png artigo/images
	cp src/outfiles/set_clock_graph.png artigo/images
	cp src/outfiles/map_clock_graph.png artigo/images
	cp src/outfiles/list_cpu_graph.png artigo/images
	cp src/outfiles/set_cpu_graph.png artigo/images
	cp src/outfiles/map_cpu_graph.png artigo/images

move_images:
	mv src/outfiles/list_clock_graph.png artigo/images
	mv src/outfiles/set_clock_graph.png artigo/images
	mv src/outfiles/map_clock_graph.png artigo/images
	mv src/outfiles/list_cpu_graph.png artigo/images
	mv src/outfiles/set_cpu_graph.png artigo/images
	mv src/outfiles/map_cpu_graph.png artigo/images
