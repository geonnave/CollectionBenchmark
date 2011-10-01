install: rm_pdf copy_styles make_bibliography make_pdf clean
	evince artigo.pdf &

make_pdf:
	pdflatex -shell-escape artigo
	pdflatex -shell-escape artigo

make_bibliography:
	pdflatex -shell-escape artigo
	bibtex artigo
	pdflatex -shell-escape artigo

rm_pdf:
	rm -f artigo.pdf

copy_styles:
	mkdir -p ~/texmf/tex/latex/
	cp -r stys/*.sty ~/texmf/tex/latex/
	cp -r bsts/*.bst .

clean:
	rm -f *.aux
	rm -f *.bbl
	rm -f *.bak
	rm -f *.log
	rm -f *.blg
	rm -f *.toc
	rm -f *.lot
	rm -f *.lof
	rm -f *.dvi
	rm -f *.idx
	rm -f *.ilg
	rm -f *.ind
	rm -f **/*~
	rm -f *~
	rm -f artigo.ps
	rm -f artigo.dvi
	rm -f *.nav
	rm -f *.out
	rm -f *.snm
	rm -f artigo.pyg
	rm -f artigo.vrb
	rm -r *.bst

