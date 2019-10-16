nasm -f elf -d ELF_TYPE asm_io.asm
nasm -f elf divisores.asm
gcc -o divisores driver.c divisores.o asm_io.o -m32
echo "Compilou, executando..."

./divisores
