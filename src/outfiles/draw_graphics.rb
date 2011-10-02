

def generate
	IO.popen("gnuplot", "w+") do |pipe|
		pipe.puts "reset"
		pipe.puts "set boxwidth 0.75 absolute"
		pipe.puts "set style fill solid 1.00 border -1"
		pipe.puts "set style data histogram"
		pipe.puts "set style histogram cluster gap 1"
		pipe.puts "set yrange [0:80]"
		pipe.puts "set ylabel 'time in milliseconds'"
		pipe.puts "set terminal png"
		pipe.puts "set title 'Insert, Search and Remove clock times of List Interface'"
		pipe.puts "plot './list_clock.dat' using 2 t 'ArrayList', ''  using 3 t 'Vector', '' using 4:xtic(1) t 'LinkedList' "
		pipe.puts "set output 'list_clock_graph.png'"
		pipe.puts "replot"
		pipe.puts "set title 'Insert, Search and Remove clock times of Set Interface'"
		pipe.puts "plot './set_clock.dat' using 2 t 'hashSet', ''  using 3 t 'linkedHashSet', '' using 4:xtic(1) t 'treeSet' "
		pipe.puts "set output 'set_clock_graph.png'"
		pipe.puts "replot"
		pipe.puts "set title 'Insert, Search and Remove clock times of Map Interface'"
		pipe.puts "plot './map_clock.dat' using 2 t 'hashMap', ''  using 3 t 'linkedHashMap', '' using 4:xtic(1) t 'treeMap' "
		pipe.puts "set output 'map_clock_graph.png'"
		pipe.puts "replot"
		pipe.puts "#and then, the cpu times:"
		pipe.puts "set title 'Insert, Search and Remove cpu times of List Interface'"
		pipe.puts "plot './list_cpu.dat' using 2 t 'ArrayList', ''  using 3 t 'Vector', '' using 4:xtic(1) t 'LinkedList' "
		pipe.puts "set output 'list_cpu_graph.png'"
		pipe.puts "replot"
		pipe.puts "set title 'Insert, Search and Remove cpu times of Set Interface'"
		pipe.puts "plot './set_cpu.dat' using 2 t 'hashSet', ''  using 3 t 'linkedHashSet', '' using 4:xtic(1) t 'treeSet' "
		pipe.puts "set output 'set_cpu_graph.png'"
		pipe.puts "replot"
		pipe.puts "set title 'Insert, Search and Remove cpu times of Map Interface'"
		pipe.puts "plot './map_cpu.dat' using 2 t 'hashMap', ''  using 3 t 'linkedHashMap', '' using 4:xtic(1) t 'treeMap' "
		pipe.puts "set output 'map_cpu_graph.png'"
		pipe.puts "replot"
		pipe.close_write
		output = pipe.read
	end
end



generate