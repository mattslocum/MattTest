	.file	"junk.c"
# GNU C version 4.0.2 20051125 (Red Hat 4.0.2-8) (i386-redhat-linux)
#	compiled by GNU C version 4.0.2 20051125 (Red Hat 4.0.2-8).
# GGC heuristics: --param ggc-min-expand=98 --param ggc-min-heapsize=127389
# options passed:  -auxbase -fverbose-asm
# options enabled:  -falign-loops -fargument-alias -fbranch-count-reg
# -fcommon -feliminate-unused-debug-types -ffunction-cse -fgcse-lm -fident
# -finline-functions-called-once -fivopts -fkeep-static-consts
# -fleading-underscore -floop-optimize2 -fmath-errno -fpcc-struct-return
# -fpeephole -fsched-interblock -fsched-spec -fsched-stalled-insns-dep
# -fsplit-ivs-in-unroller -ftrapping-math -ftree-loop-im
# -ftree-loop-ivcanon -ftree-loop-optimize -fverbose-asm
# -fzero-initialized-in-bss -m80387 -mhard-float -mno-soft-float -mieee-fp
# -mfp-ret-in-387 -mno-red-zone -mtls-direct-seg-refs -mtune=i386
# -march=i386

	.text
.globl test
	.type	test, @function
test:
	pushl	%ebp	#
	movl	%esp, %ebp	#,
	subl	$16, %esp	#,
	movl	$0, -8(%ebp)	#, x
	movl	$4, -4(%ebp)	#, y
	cmpl	$0, -8(%ebp)	#, x
	sete	%al	#, tmp58
	movzbl	%al, %eax	# tmp58, tmp59
	movl	%eax, -12(%ebp)	# tmp59, i
	leave
	ret
	.size	test, .-test
	.ident	"GCC: (GNU) 4.0.2 20051125 (Red Hat 4.0.2-8)"
	.section	.note.GNU-stack,"",@progbits
