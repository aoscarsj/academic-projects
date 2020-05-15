%include "asm_io.inc"

segment .data
valor_n db      "Digite o valor de n: ", 0
valor_vet db    "Digite os valores do vetor: ", 0
valor_mat db    "Digite os valores da Matriz: ", 0
valor_result db "Resultado: ", 0
virg db   " ", 0
dbg  db   "debug", 0

segment .bss
n       resd 1
i       resd 1
j       resd 1
vetor   resd 1
matriz  resd 1
result  resd 1
m    resd 1 ; m = n*n
cont    resd 1
segment .text
      global asm_main

asm_main:
      enter   0,0
      pusha
      pushf
      mov     eax, valor_n
    ;  call    print_string ; printando

      call    read_int
      mov     [n], eax ; lendo N

      mov     eax, valor_vet
  ;    call    print_string ; printando digite o vetor...

      mov     ecx, 1 ; ecx eh o 'i', o contador.
      mov     [vetor], esp
      ;vetor = a pos anterior do primeiro elemento.
      ;para encontra-lo deve somar vetor + 4 depois.

ler_vetor:
      call    read_int
      push    eax
      cmp     ecx, [n]
      je      cfg_matriz ; se ecx == n => que já leu todo mundo
      inc     ecx
      jmp     ler_vetor

cfg_matriz:
      mov     eax, valor_mat
  ;    call    print_string
      mov     [matriz], esp ; salvando a pos anterior do inicio da matriz
      mov     eax, [n]
      imul    eax ; eax *= eax <==> n * n;
      mov     [m], eax ; m = n*n
      mov     ecx, 1
ler_matriz:
      call    read_int
      push    eax
      cmp     ecx, [m]
      je      resultado
      inc     ecx
      jmp     ler_matriz

resultado:
  ;; corrigindo [vetor] e [matriz] para que apontem para seus primeiros elementos
      mov   eax, [vetor]
      sub   eax, 4
      mov   [vetor], eax
      mov   eax, [matriz]
      sub   eax, 4
      mov   [matriz], eax

      mov   eax, 0
      mov   [result], eax

    ;  mov     eax, valor_result
    ;  call    print_string
      mov   eax, 0
      mov   [i], eax
      mov   [j], eax
      ;bh = i, bl = j
for_i:
      mov   eax, 0
      mov   [j], eax
      mov   [cont], eax
      mov   eax, [i]
      cmp   eax, [n]
      je    fim
      mov   ecx, 0 ; eax eh 'aux'


for_j:
      mov   eax, [j]
      cmp   eax, [n]

      je    cout ; i++


      mov   eax, [n]
      mov   edx, [j]


      imul  edx ; eax = n * j;

      mov   edx, [i]
      add   eax, edx

      mov   edx, 4
      imul  edx

      ;call  print_int
      ;call  print_nl
      ; eax = (N * j + i)* 4
      mov   edx, eax ; edx eh a posicao da matriz
      mov   eax, 0
      add   eax, [vetor] ; eax recebe a pos da mem de vetor
      mov   ebx, [matriz]
      sub   eax, [cont] ;vetor[i]
      mov   eax, [eax]

      ;call  print_int
      ;call  print_nl

      sub   ebx, edx ; matriz[j][i] ; ebx tem o valor certo

      mov   edx, [cont]
      add   edx, 4
      mov   [cont], edx
      mov   ebx, [ebx]
      imul  ebx
      add   ecx, eax ; ecx = aux
      mov   eax, ecx
      ;call  print_int
    ;  call  print_nl
      ;aux +=
      mov   eax, [j]
      inc   eax
      mov   [j], eax

      jmp   for_j
cout:
    ;  mov   eax, dbg
    ;  call  print_string
    ;  call  print_nl
      mov   eax, [i]
      inc   eax
      mov   [i], eax
      mov   eax, ecx
      ;mov   eax, [eax]

      call  print_int
      mov   eax, virg
      call  print_string
      jmp   for_i
fim:
    call  print_nl
      ;; end program
    ;  popf
  ;    popa
      leave
      ret

;;vetor[ i ][ j ] = vetor + i*n*4 + j*4

;mov eax,[ i ]
;mov ebx,[ n ]
;imul eax, ebx
;mov ebx, [array] ;; (isso n é o conteúdo da primeira posição, é o endereço da primeira posição)
;lea eax,[ebx+eax*4]
;mov ebx, [ j ]
;lea eax,[eax+ebx*4]
;mov eax,[eax]
;Pronto, colocamos array[i][j] em eax
