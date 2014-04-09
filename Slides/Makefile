TARGET=presentation.pdf

all: $(TARGET)

showpdf: $(TARGET)
	evince $(TARGET)

$(TARGET): $(TARGET:%.pdf=%.tex)
	pdflatex $< -o $@