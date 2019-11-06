%include "asm_io.inc"
; Sofri para fazer esse. Professor, demorei de submeter pois como conversei com o sr, mudei de pc e as novas versoes do ubuntu nao contem mais por padrao o gcc-4.8-multilib.
segment .data
prompt db   "Digite o numero: ", 0
outmsg db   "Resultado de ", 0
outmsg2 db  "!: ", 0
debug db "debug, valor de eax: ", 0

segment .bss
input resd 1
cont  resd 1
segment .text
      global asm_main

fat:
      enter   0, 0
      cmp     ecx, 1
      je      ult_fat
      push    ecx
      dec     ecx
      call    fat
      mov     edx, [esp]
      imul    edx
      pop     ecx

ult_fat:
      leave
      ret

asm_main:
      enter   0,0
      pusha
      mov     eax, prompt
      call    print_string

      call    read_int
      mov     [input], eax ; que tal subistituir por reg?
          ; leitura feita
      mov     ecx, eax ; ecx eh o contador.
      mov     eax, 1
      call fat

      mov     ebx, eax
      mov     eax, outmsg
      call    print_string ; 'Resultado de: '
      mov     eax, [input]
      call    print_int   ;  print 'N'
      mov     eax, outmsg2
      call    print_string ; print '!: '
      mov     eax, ebx
      call    print_int ; print valor.
      call    print_nl ; \n
      popa
      mov eax, 0
      leave
      ret
