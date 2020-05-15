%include "asm_io.inc"

segment .data

segment .bss

vet1    resb 5

segment .text
        global  asm_main


fibo:
    enter 0,0
    mov     ebx,[ebp + 8]
    cmp     ebx, 1
    je      um
    cmp     ebx, 0
    je      zero
    dec     ebx
    push    ebx
    call    fibo
    pop		ecx
    mov     ebx, [ebp + 8]
    sub     ebx, 2
    push    ebx
    call    fibo
    pop		ecx
    jmp     fim_fibo

	um:
	    inc     eax
	    jmp     fim_fibo

	zero:

	fim_fibo:

    leave
    ret

asm_main:

    call read_int
    push    eax
    mov eax,0
    call    fibo
    pop		ecx
    call    print_int
    call	print_nl

    leave
    ret
