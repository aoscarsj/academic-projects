%include "asm_io.inc"

segment .data
Message         db      "Digite o primeiro numero: ", 0
Msg2            db      "Digite o segundo numero: ", 0
Msg3            db      "MultiplosComuns(", 0
Msg4            db      ", ", 0
Msg5            db      "): ", 0
segment .bss
Val1           resd    1               ; find primes up to this Val1
Val2           resd    1
Menor          resd    1
Count          resd   1
N              resd   1

segment .text
        global  asm_main
asm_main:
        enter   0,0               ; setup routine
        pusha
        mov     eax,  Message
        call    print_string

        call    read_int             ; scanf("%u", & Val1 );
        mov     [Val1], eax
        ;
        mov eax, Msg2
        call print_string

        call    read_int
        mov     [Val2], eax
;
;    primeiro passo: descobrir o Menor entre eles. OK
;
        mov     ax, [Val1]
        mov     [Menor], ax ; Menor = ax
        cmp     [Val2], ax
        jnc     next
        mov     ax, [Val2]
        mov     [Menor], ax


next: ; Caso Val1 >= Val2
        mov     edx, 0
        mov     eax, [Menor]
        mov     ebx, 2
        idiv    ebx
        add     eax, 1
        mov     [N], eax ; N = menor / 2 +1
        ;Funciona!
        call print_nl
        mov     eax, Msg3
        call    print_string
        mov     eax, [Val1]
        call    print_int
        mov     eax, Msg4
        call    print_string
        mov     eax, [Val2]
        call    print_int
        mov     eax, Msg5
        call    print_string


        mov     eax, 1 ; Count = 2
        call    print_int
        add     eax, 1
        mov     [Count], eax

while_limit:                         ; while ( Guess <= Limit )
        mov     eax,[Count]
        cmp     eax, [Menor]
        jnbe    end_while_limit



        mov     edx, 0
        mov     eax, [Val1]
        mov     ebx, [Count]
        idiv    ebx
        cmp     edx, 0
        jz      testSegValor

continuar:
        mov     eax, [Count]
        add     eax, 1
        mov     [Count], eax ; count ++

        jmp     while_limit

testSegValor:
        mov     edx, 0
        mov     eax, [Val2]
        mov     ebx, [Count]
        idiv    ebx
        cmp     edx, 0
        jz      saoDivisiveis
        jmp     continuar

saoDivisiveis:
        mov     eax, Msg4
        call    print_string
        mov     eax, [Count]
        call    print_int

        jmp     continuar

end_while_limit:
        call    print_nl
        call    print_nl
        popa
        mov     eax, 0            ; return back to C
        leave
        ret
