nasm -f elf -d ELF_TYPE asm_io.asm
nasm -f elf matriz.asm
gcc -o matriz driver.c matriz.o asm_io.o -m32
echo "Compilou, executando..."

./matriz < in
