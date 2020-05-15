%include "asm_io.inc"

segment .data
Message         db      "Entrada: ", 0
Msg2            db      "Saída: ", 0
debug           db      "Valor lido/OK\n", 0
segment .bss
Val1           resd    1               ; find primes up to this Val1
Val2           resd    1


segment .text
        global  asm_main
asm_main:
        enter   0,0               ; setup routine
        pusha
        mov     eax,  Message
        call    print_string

        call    read_int             ; scanf("%u", & Val1 );
        mov     ecx, eax ; valor1 lido  [Val1], eax
        ;
        call    read_int
        mov     edx, eax ; valor2 lido [Val2], eax
        jmp inicio

if_val_1_and_2_0: ; if(val1 = val2 = 0)
        jmp end_while_limit
if_val1_0:
        cmp edx, 0
        jz  if_val_1_and_2_0 ; eh zero
        jmp valor2 ;pula para valor 2 pq val1 eh zero

if_val2_0: ; edx eh zero
        cmp ecx, 0 ; ecx eh zero?
        jz if_val_1_and_2_0 ; eh zero
        jmp valor1

valor1:
        clc
        cmp eax, 0
        jnz print1
inicio:
        mov eax, 0
continue1:
        cmp ecx, 0
        jz if_val1_0
        shr ecx, 1
        jnc ignoraZero1
        add eax, 1
        jmp continue1

ignoraZero2:
        cmp edx, 0
        jz  valor1
        shr edx, 1
        jc  valor1
        jmp ignoraZero2

ignoraZero1:
        cmp ecx, 0
        jz  valor2
        shr ecx, 1
        jc  valor2
        jmp ignoraZero1

valor2:
        clc
        cmp eax, 0
        jnz print2
posPrint2:
        mov eax, 0
continue2:
        cmp edx, 0
        jz if_val2_0
        shr edx, 1
        jnc ignoraZero2
        add eax, 1
        jmp continue2

print1:
        call print_int
        jmp posPrint2
print2:
        call print_int
        jmp inicio

end_while_limit:
        call    print_nl
        call    print_nl
        popa
        mov     eax, 0            ; return back to C
        leave
        ret
