TARGET=rapport_CPS_BC_SV.pdf

all: $(TARGET)

showpdf: all
	evince $(TARGET)

$(TARGET): $(TARGET:%.pdf=%.tex)
	pdflatex $< -o $@