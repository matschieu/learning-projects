10 REM dessin de 5 sphres
20 CLS
30 GOTO 200
40 IF vert GOTO 100
50 CIRCLE (x, y), r, c, , , .07
60 FOR i = 1 TO 5
70 CIRCLE (x, y), r, c, , , i * .2
80 NEXT i
90 IF vert THEN RETURN
100 CIRCLE (x, y), r, c, , , 1.3
110 CIRCLE (x, y), r, c, , , 1.9
120 CIRCLE (x, y), r, c, , , 3.6
130 CIRCLE (x, y), r, c, , , 9.8
140 IF vert GOTO 50
150 RETURN
200 SCREEN 9: COLOR 2: KEYOFF: vert = 0
210 x = 160: y = 100: c = 1: r = 50: GOSUB 40
220 x = 30: y = 30: c = 2: r = 30: GOSUB 40
230 x = 30: y = 169: GOSUB 40
240 x = 289: y = 30: GOSUB 40
250 x = 289: y = 169: GOSUB 40
260 LINE (30, 30)-(289, 169), 1
270 LINE (30, 169)-(289, 30), 1
280 LINE (30, 169)-(289, 30), 1
290 z$ = inkey$ : if z$="" then 290
300 END










