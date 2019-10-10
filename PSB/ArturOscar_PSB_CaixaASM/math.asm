

;
; file: math.asm
; This program demonstrates how the integer multiplication and division
; instructions work.
;
; To create executable:
; nasm -f coff math.asm
; gcc -o math math.o driver.c asm_io.o

%include "asm_io.inc"

segment .data
;
; Output strings
;

square_msg      db    "Square of input is ", 0
cube_msg        db    "Cube of input is ", 0
cube25_msg      db    "Cube of input times 25 is ", 0
quot_msg        db    "Quotient of cube/100 is ", 0
rem_msg         db    "Remainder of cube/100 is ", 0
neg_msg         db    "The negation of the remainder is ", 0
prompt          db    "Entrada: ", 0
notas_msg           db    "NOTAS:", 0
saida_msg           db    "Saida:", 0
cem_msg         db    " nota(s) de R$ 100.00", 0
cinq_msg        db    " nota(s) de R$ 50.00", 0
vint_msg        db    " nota(s) de R$ 20.00", 0
dez_msg         db    " nota(s) de R$ 10.00", 0
cinco_msg       db    " nota(s) de R$ 5.00", 0
dois_msg        db    " nota(s) de R$ 2.00", 0
um_msg          db    " nota(s) de R$ 1.00", 0
segment .bss
input   resd 1


segment .text
        global  asm_main
asm_main:
        enter   0,0               ; setup routine
        pusha

        mov     eax, prompt
        call    print_string ; printando Entrada>
        call    read_int ; chamada de funcao read_int
        mov     [input], eax ; lendo entrada
        call    print_nl ; pulando linha apos entrada.
        mov     eax, saida_msg ; movendo para eax, saida_msg "Saida: "
        call    print_string
        call    print_nl
        call    print_nl

        mov     eax, notas_msg
        call    print_string
        call    print_nl ; fim do print de 'NOTAS'

        mov     edx, 0
        mov     eax, [input]
        mov     ebx, 100

        idiv    ebx ; sera que funcionou?
        call    print_int ;
        mov     eax, cem_msg
        call    print_string
        call    print_nl ; endl do print notas de 100

        mov     eax, edx
        mov     edx, 0
        mov     ebx, 50
        idiv    ebx

        call    print_int
        mov     eax, cinq_msg
        call    print_string
        call    print_nl ; fim da impressao das notas de 50

        mov     eax, edx
        mov     edx, 0
        mov     ebx, 20
        idiv    ebx

        call    print_int
        mov     eax, vint_msg
        call    print_string
        call    print_nl ; fim da impressao das notas de 20

        mov     eax, edx
        mov     edx, 0 ; tem que setar 0 toda vez em edx se nao da ruim
        mov     ebx, 10
        idiv    ebx

        call    print_int
        mov     eax, dez_msg
        call    print_string
        call    print_nl ; fim da impressao das notas de 10

        mov     eax, edx
        mov     edx, 0
        mov     ebx, 5
        idiv    ebx

        call    print_int
        mov     eax, cinco_msg
        call    print_string
        call    print_nl ; fim da impressao das notas de 5

        mov     eax, edx
        mov     edx, 0
        mov     ebx, 2
        idiv    ebx

        call    print_int
        mov     eax, dois_msg
        call    print_string
        call    print_nl

        mov     eax, edx
        mov     edx, 0
        mov     ebx, 1
        idiv    ebx

        call    print_int
        mov     eax, um_msg
        call    print_string
        call    print_nl

        popa
        mov     eax, 0            ; return back to C
        leave
        ret
