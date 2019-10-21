nasm -f elf -d ELF_TYPE asm_io.asm
nasm -f elf fatorial.asm
gcc -o bits driver.c fatorial.o asm_io.o -m32
echo "Compilou, executando..."

./fatorial
