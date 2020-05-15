nasm -f elf -d ELF_TYPE asm_io.asm
nasm -f elf bits.asm
gcc -o bits driver.c bits.o asm_io.o -m32
echo "Compilou, executando..."

./bits
