@ /0
	JP	MAIN

FUN_0	JP	/000
	LD	K_2
	*	VAR_0
	MM	TMP_0
	LD	TMP_0
	MM	VAR_1
	LD	VAR_1
	MM	VAR_1
	MM	EXT_0
	RS	FUN_0

MAIN	LD	K_8
	MM	VAR_2
WHL_0	LD	VAR_2
	-	K_32
	MM	TEMP_1
	LD	K_0
	-	TEMP_1
	JN	END_0
	LD	VAR_2
	MM	VAR_0
	SC	FUN_0
	LD	EXT_0
	MM	VAR_2
	JP	WHL_0
END_0	#	MAIN

@ /200
VAR_0	K	=0
VAR_1	K	=0
K_2	K	=2
TMP_0	K	=0
EXT_0	K	=0
VAR_2	K	=0
K_8	K	=8
K_32	K	=32
K_0	K	=0
TEMP_1	K	=0
