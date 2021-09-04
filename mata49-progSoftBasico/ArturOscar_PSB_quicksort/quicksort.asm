%include "asm_io.inc"

segment .data
msg_1     db     "Digite o tamanho do vetor: ",     0
msg_2     db     "Digite os valores do vetor: ",    0
msg_3     db     "---------------------------",     0
msg_4     db     "Resultado: ",                     0
space     db      " ",                              0
dbg       db      "debug", 0

segment .bss
size      resd 1
i         resd 1
j         resd 1
vetor     resd 1
meio      resd 1
left      resd 1
right     resd 1
x         resd 1
y         resd 1
r2        resd 1
l2        resd 1

segment   .text
     global asm_main

asm_main:

     enter 0,0
     pusha
     pushf

     mov       eax, msg_1
     call      print_string
     call      read_int
     mov       [size], eax

     mov       eax,     msg_2
     call      print_string
     mov       ecx,     [size] ; ecx eh o contador.
     mov       [vetor], esp

read_array:
     call      read_int
     dec       ecx
     push      eax

     cmp       ecx, 0
     je        ant_quick
     jne       read_array
; leitura OK. Lembrar de desempilhar tudo. pop eax

ant_quick:
     call cfg_quick
     jmp  print_vetor
cfg_quick:
     ;configurando cabeca do vetor
     mov       eax,      [vetor]
     sub       eax,      4
     mov       [vetor],  eax ; para printar tem que mov eax, [eax]

     ;configurando valor inicial para o quicksort
     mov       eax,      0
     mov       [left],   eax
     mov       [l2],     eax ; copia de left
     mov       eax,      [size]
     dec       eax
     mov       [right],  eax
     mov       [r2],     eax ; copia de right

;iniciando o quick.
quick_sort:
     mov       eax,      [right]
     mov       [j],      eax       ; j = right
     mov       eax,      [left]
     mov       [i],      eax       ; i = left

     mov       ebx,      4
     imul      eax,      ebx
     mov       ebx,      eax
     mov       eax,      [vetor]
     sub       eax,      ebx
     mov       eax,      [eax]    ; a[left] ; ta funcionando!!
     mov       [x],      eax      ; x = a[left];

; while(i <= j){}

if_i_mi_j:
     mov       eax,      [i]
     cmp       eax,      [j]
     jc        while_i_mi_j ; se for menor
     jz        while_i_mi_j ; se for igual
     jmp       nao_while    ; se for maior

while_i_mi_j:

while_1:
     mov       eax,      [i]
     mov       ebx,      4
     imul      eax,      ebx
     mov       ebx,      eax
     mov       eax,      [vetor]
     sub       eax,      ebx
     mov       eax,      [eax] ; eax = a[i]

     cmp       eax,      [x]
     jnc       while_2 ; se nao for menor
     mov       ecx,      [i]
     cmp       ecx,      [right]
     jnc       while_2
     inc       ecx
     mov       [i],      ecx  ; i++
     jmp       while_1

while_2:
     mov       eax,      [j]
     mov       ebx,      4
     imul      eax,      ebx
     mov       ebx,      eax
     mov       eax,      [vetor]
     sub       eax,      ebx
     mov       eax,      [eax] ; eax = a[j]

     cmp       eax,      [x]
     jc        if_while
     jz        if_while ; se menor ou igual, sai
     mov       edx,      [j]
     cmp       edx,      [left]
     jc        if_while
     jz        if_while
     dec       edx
     mov       [j],      edx ; j--
     jmp       while_2

if_while:
     mov       ebx,      [i]
     cmp       ebx,      [j]
     jc        if_true ; se menor
     jz        if_true ; se igual
     mov       eax,      [i]
     call      print_int
     mov       eax,      [space]
     call      print_string
     mov       eax, [j]
     call      print_int
     call      print_nl
     jmp       if_false  ; se maior
if_true:
     mov       eax,      [i]
     mov       ebx,      4
     imul      eax,      ebx

     mov       ebx,      eax
     mov       eax,      [vetor]
     sub       eax,      ebx
     mov       edx,      eax

     mov       edx,      eax ; edx = vetor[i]

     mov       eax,      [eax] ; eax = a[i]
     mov       [y],      eax ; y = vetor[i]


     mov       eax,      [j]
     mov       ebx,      4
     imul      eax,      ebx
     mov       ebx,      eax
     mov       eax,      [vetor]
     sub       eax,      ebx
     mov       ecx,      eax ; ecx = end de a[j]

     ;mov       eax,      [eax] ; eax = a[j]
     ;mov       [edx],    eax
     mov       eax,      edx
     mov       ebx,      ecx
     mov       ecx,      [ecx]
     mov       [eax],    ecx ; vetor[i] = vetor[j]

     mov       eax,      ebx
     mov       ebx,      [y]
     mov       [eax],    ebx ; vetor[j] = y


     mov       ecx,      [i]
     inc       ecx
     mov       [i],      ecx ; i++
     mov       ecx,      [j]
     dec       ecx
     mov       [j],      ecx ; j--

if_false:
;     jmp       while_i_mi_j ;
;fim do while_i_mi_j

nao_while:

;if (j > left)
if_1:
     mov       eax,      [j]
     cmp       eax,      [left]
     jc        if_2
     jz        if_2

     mov       eax,      [j]
     mov       [right],  eax
     mov       eax,      [l2]
     mov       [left],   eax ; garantindo que left tem o valor certo
     call      quick_sort
if_2:
     mov       eax,      [i]
     cmp       eax,      [right]
     jc        cont_if_2
     jz        cont_if_2
     jmp       pula_if_2

cont_if_2: ; eax eh menor ou igual right
     mov       eax,      [r2]
     mov       [right],  eax ; garantindo que right ta certo
     mov       eax,      [i]
     mov       [left],   eax
     call      quick_sort
pula_if_2:
     mov  edx,      0
     ret

print_vetor:
     pop  eax
     mov  ecx, [size]
     cmp  ecx, 0
     je   end_program
     call print_int
     dec  ecx
     mov  [size], ecx
     jmp  print_vetor


end_program:
     mov       eax, 0
     popf
     popa
     leave
     ret
