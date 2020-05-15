%include "asm_io.inc"

segment .data
msg_0     db     "Digite o numero de discos: ", 0
msg_1     db     "Mova o disco 1 da base ",     0
msg_2     db     " para a base "          ,     0
msg_3     db     "Para resolver a torre de Hanoi faça os seguintes movimentos:", 0
msg_4     db     "Mova o disco "
msg_5     db     " da base "
origem    db     "A",                           0
destino   db     "C",                           0
auxiliar  db     "B",                           0
dbg       db      "debug",                      0
fim       db      "The end ;)",                 0
segment .bss
n         resd                                  1
m         resd                                  1

segment   .text
     global asm_main
     ;    NOTAS: Professor, fiz o que consegui fazer, mas acho que não compreendi completamente
     ;como utilizar a pilha e por isso, tentei resolver o problema da falha de segmentação mas não consegui.
     ; Parti para a Implementação do Hanoi mas também travei lá, espero que o sr considere alguma coisa.
     ; Muito obrigado pelo semestre professor, boas férias!
     ;
asm_main:

     enter     0,0
     pusha
     pushf
     mov       eax,      msg_0
     call      print_string
     call      read_int
     mov       [n],      eax
     ;Li N (qtd de discos)

     mov       eax,      msg_3 ; print de 'maquiagem'.
     call      print_nl
     call      print_string
     call      print_nl
     call      print_nl
     ; tudo certo ate aqui

     mov       ebx,      origem
     mov       ecx,      destino
     mov       edx,      auxiliar
     ;Certo
     ; uso ebx como origem, ecx como destino e edx como auxiliar
     call      hanoi
     jmp       end ; qnd terminar pular para o fim do programa

hanoi:

      enter     0,0
      pusha
      pushf
      mov       eax, [n]
      cmp       eax, 1 ; if(n == 1)
      jne       if_false ; se > 1 pula para if_false
      mov       eax,      msg_1 ; 'mova o disco 1 da base '
      call      print_string
      mov       eax,      ebx ; 'A'
      call      print_string
      mov       eax,      msg_2 ; 'para a base '
      call      print_string
      mov       eax,      ecx ; 'C'
      call      print_string
      call      print_nl
      popf
      popa
      leave
      ret

if_false: ; estou tentando fazer hanoi(n-1, origem, auxiliar, destino);

      mov      eax,      [n]
      dec      eax
      mov      [n],      eax
      mov       ebx,      origem
      mov       ecx,      auxiliar ; inverto com edx (swap (ecx, edx))
      mov       edx,      destino
      call      hanoi

     ; print
     ; estou fazendo o print
     ;printf("\nMova o disco %d da base %c para a base %c",n,origem,destino);
      mov       eax,      msg_4 ; 'mova o disco '
      call      print_string
      mov       eax,      [n]
      call      print_int
      mov       eax,      msg_5 ; ' da base '
      call      print_string
      mov       eax,      ebx
      call      print_string
      mov       eax,      msg_2 ; ' para a base '
      call      print_string
      mov       eax,      ecx
      call      print_int
      call      print_nl

; estou tentando fazer hanoi(n-1, auxiliar, destino, origem);
      mov       eax,      [n]
      dec       eax
      mov       [n],      eax
      mov       ebx,      auxiliar
      mov       ecx,      destino
      mov       edx,      origem
      call      hanoi
      ret

end:
     mov       eax,      fim
     call      print_string
     call      print_nl
     mov       eax,      0
     popf
     popa
     leave
     ret
