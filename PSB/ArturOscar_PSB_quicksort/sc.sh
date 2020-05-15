nasm -f elf -d ELF_TYPE asm_io.asm
nasm -f elf quicksort.asm
gcc -o quicksort driver.c quicksort.o asm_io.o -m32
echo "Compilou, executando..."

./quicksort
