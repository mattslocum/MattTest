	.file	"stdlib.c"
	.section	.rodata
.LC0:
	.string	"0\n"
	.zero	17
	.text
.globl writeint
	.type	writeint, @function
writeint:
	pushl	%ebp
	movl	%esp, %ebp
	pushl	%edi
	subl	$68, %esp
	movw	.LC0, %ax
	movw	%ax, -56(%ebp)
	movb	.LC0+2, %al
	movb	%al, -54(%ebp)
	leal	-53(%ebp), %edi
	cld
	movl	$17, %ecx
	movb	$0, %al
	rep
	stosb
	leal	-36(%ebp), %eax
	movl	%eax, -16(%ebp)
	leal	-56(%ebp), %eax
	movl	%eax, -12(%ebp)
	cmpl	$0, 8(%ebp)
	jns	.L2
	movl	-12(%ebp), %eax
	movb	$45, (%eax)
	leal	-12(%ebp), %eax
	incl	(%eax)
	negl	8(%ebp)
.L2:
	cmpl	$0, 8(%ebp)
	jle	.L4
	jmp	.L6
.L7:
	movl	8(%ebp), %edx
	movl	$10, -72(%ebp)
	movl	%edx, %eax
	cltd
	idivl	-72(%ebp)
	movl	%edx, %eax
	leal	48(%eax), %edx
	movl	-16(%ebp), %eax
	movb	%dl, (%eax)
	leal	-16(%ebp), %eax
	incl	(%eax)
	movl	8(%ebp), %ecx
	movl	$1717986919, -72(%ebp)
	movl	-72(%ebp), %eax
	imull	%ecx
	sarl	$2, %edx
	movl	%ecx, %eax
	sarl	$31, %eax
	movl	%edx, %ecx
	subl	%eax, %ecx
	movl	%ecx, %eax
	movl	%eax, 8(%ebp)
.L6:
	cmpl	$0, 8(%ebp)
	jg	.L7
	leal	-16(%ebp), %eax
	decl	(%eax)
	jmp	.L9
.L10:
	movl	-16(%ebp), %eax
	movb	(%eax), %dl
	movl	-12(%ebp), %eax
	movb	%dl, (%eax)
	leal	-12(%ebp), %eax
	incl	(%eax)
	leal	-16(%ebp), %eax
	decl	(%eax)
.L9:
	leal	-36(%ebp), %eax
	cmpl	-16(%ebp), %eax
	jb	.L10
	movl	-16(%ebp), %eax
	movb	(%eax), %dl
	movl	-12(%ebp), %eax
	movb	%dl, (%eax)
	leal	-12(%ebp), %eax
	incl	(%eax)
	movl	-12(%ebp), %eax
	movb	$10, (%eax)
	leal	-12(%ebp), %eax
	incl	(%eax)
	movl	-12(%ebp), %eax
	movb	$0, (%eax)
	leal	-12(%ebp), %eax
	incl	(%eax)
	jmp	.L12
.L4:
	leal	-56(%ebp), %eax
	addl	$2, %eax
	movl	%eax, -12(%ebp)
.L12:
	movl	-12(%ebp), %edx
	leal	-56(%ebp), %eax
	movl	%edx, %ecx
	subl	%eax, %ecx
	movl	%ecx, %eax
	decl	%eax
	subl	$4, %esp
	pushl	%eax
	leal	-56(%ebp), %eax
	pushl	%eax
	pushl	$1
	call	write
	addl	$16, %esp
	movl	-4(%ebp), %edi
	leave
	ret
	.size	writeint, .-writeint
.globl readint
	.type	readint, @function
readint:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$40, %esp
	subl	$8, %esp
	leal	-24(%ebp), %eax
	pushl	%eax
	pushl	$0
	call	read
	addl	$16, %esp
	movl	%eax, -4(%ebp)
	movl	-4(%ebp), %eax
	leave
	ret
	.size	readint, .-readint
	.ident	"GCC: (GNU) 4.0.2 20051125 (Red Hat 4.0.2-8)"
	.section	.note.GNU-stack,"",@progbits
