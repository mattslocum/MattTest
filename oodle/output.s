.comm  x, 4, 4
.global main
main:
# x := (readint )
	popl	x
	pushl	x
	call	writeint
	popl	%eax
	pushl	x
	pushl	$0
# (x ) > (0 )
	popl	%ebx
	popl	%eax
	cmpl	%ebx, %eax
	setg	%al
	movzbl	%al, %eax
	pushl	%eax
	popl	%eax
	cmpl	$0, %eax
	jne	_doif14
	jmp	_else14
_doif14:
	pushl	$1
	call	writeint
	popl	%eax
	jmp	_endif14
_else14:
	pushl	x
	pushl	$0
# (x ) = (0 )
	popl	%ebx
	popl	%eax
	cmpl	%ebx, %eax
	sete	%al
	movzbl	%al, %eax
	pushl	%eax
	popl	%eax
	cmpl	$0, %eax
	jne	_doif17
	jmp	_else17
_doif17:
	pushl	$0
	call	writeint
	popl	%eax
	jmp	_endif17
_else17:
	pushl	$-1
	call	writeint
	popl	%eax
_endif17:
	pushl	$9
	call	writeint
	popl	%eax
_endif14:
	pushl	$9
	call	writeint
	popl	%eax
	pushl	$0
	call	exit
