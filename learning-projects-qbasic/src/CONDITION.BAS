CLS
LOCATE 6, 30
PRINT "Faite votre choix"
10    INPUT "voulez vous entrez (1) ou sortir (2)", i%
30    IF i% = 1 THEN GOTO 80
85    IF i% = 2 THEN GOTO 90 ELSE GOTO 110
80    CLS
PRINT "Bienvenue"
83    END
90    CLS
PRINT "au revoir"
100    END
110  PRINT "choix incorrect"
GOTO 10
END

