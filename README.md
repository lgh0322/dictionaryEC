# dictionaryEC
#pragma mode( separator(.,;) integer(h32) )


LOCAL ro:={{{110},{118}},{{118,105},{118,116}},{{97,100,106},{97,100,118},{97,114,116},{110,117,109},{105,110,116}},{{112,114,101,112},{112,114,111,110},{99,111,110,106}}};
LOCAL rs:={105,106,108,73,91,40,114,116};
LOCAL p:=10,ga;




ran(a,b,c)
BEGIN
LOCAL k,n,q:=0;
FOR k FROM a TO b DO
TEXTOUT_P(CHAR(ga(k)),q,p,7,RANDINT(0,#FFFFFFh));
IF ga(k)>255 THEN
q:=q+22;
ELSE
IF POS(rs,ga(k))≠0 THEN
q:=q+8;
ELSE
IF ga(k)<91 OR ga(k)==109 OR ga(k)==119 THEN
q:=q+18;
ELSE
q:=q+14;
END;


END;


END;
IF q>280 THEN
p:=p+30;
q:=0;
END;
END;
p:=p+30;
END;



BONE5(a)
BEGIN
ga:=a;
p:=0;
RECT_P(0);
LOCAL l:=SIZE(a),k,m:={},j;
LOCAL n:={},r,l2,z;
LOCAL mn:={},w,u,v,s;
FOR k FROM 1 TO l DO
IF a(k)==91 THEN
m(j:=j+1):=k;
END;

IF a(k)==46 THEN
z:=1;
IF k-1≥1 THEN
IF a(k-1)==46 THEN
z:=0;
END
END;
IF k+1≤l THEN
IF a(k+1)==46 THEN
z:=0;
END;
END;
IF z==1 THEN
n(r:=r+1):=k;
END;
END;
END;

IF r≠0 THEN
IF n(1)≤4 THEN
v:=a({1,n(1)-1});
u:=SIZE(ro(n(1)));
FOR j FROM 1 TO u DO
IF EQ(ro(n(1),j),v)==1 THEN
mn(w:=w+1):=1;
BREAK;
END;
END;
END;
IF r≥2 THEN
FOR k FROM 2 TO r DO
j:=4;
REPEAT
u:=SIZE(ro(j));
v:=a({n(k)-j,n(k)-1});
FOR s FROM 1 TO u DO
IF EQ(v,ro(j,s))==1 THEN
mn(w:=w+1):=n(k)-j;
BREAK(2);
END;
END;
j:=j-1; 
UNTIL j==0;

END;
END;

END;




IF w≠0 THEN
m:=CONCAT(m,mn);
m:=SORT(m);
END;

l2:=SIZE(m);
IF SIZE(m)==0 THEN
ran(1,l,#FFh);
RETURN 0;
END;

IF m(1)==1 THEN
FOR k FROM 1 TO l2-1 DO
ran(m(k),m(k+1)-1,#Fh);
END;
ran(m(k),l,#FFFFFFh);
ELSE
ran(1,m(1)-1,#FFh);
FOR k FROM 1 TO l2-1 DO
ran(m(k),m(k+1)-1,#FFh);
END;
ran(m(k),l,#FFh);
END;
END;





N22()
BEGIN
DIMGROB_P(G1,200,32);
LOCAL A,L9,P,Z:=0;
L9:={14,15,16,17,18,20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,37,38,39,40,42,43};
LOCAL word:="";
WHILE 1 DO
A:=GETKEY;
IF A==30 THEN
BREAK;
END;
IF A≠−1 THEN
P:=POS(L9,A);
IF P≠0 THEN
word:=word+CHAR(96+P);
IF Z==0 THEN
Z:=1;
RECT_P(0);
END;

RECT_P(G1,0);
TEXTOUT_P(word,G1,100,0,7,RANDINT(0,#FFFFFFh));
BLIT_P(G0,0,100,G1);
ELSE

IF A==19 THEN
IF DIM(word)≠0 THEN
word:=SUPPRESS(word,DIM(word));
RECT_P(G1,0);
TEXTOUT_P(word,G1,100,0,7,RANDINT(0,#FFFFFFh));
BLIT_P(G0,0,100,G1);
END;
END;
IF A==4 THEN
RETURN "0";
END;



END;
END;
END;
RETURN word;
END;





LOCAL Sea(Ci)
BEGIN
IF Ci=="z" THEN
RETURN −1;
END;

LOCAL Di:=ASC(Ci);
LOCAL L:=SIZE(Di);
LOCAL GG;
LOCAL K;
LOCAL J,Z,JJ;
LOCAL imin,imax;


IF Di(1)==97 AND L==1 THEN
RETURN 0;
END;
imin:=0;



K:=2600051;
REPEAT 
K:=K-1;
GG:=AFilesB("Di.fu",2*K,2);
UNTIL GG(1)==0 AND GG(2)==0;

Z:=1;
FOR J FROM 1 TO L DO
GG:=AFilesB("Di.fu",2*(K+J));
IF GG(1)≠Di(J) THEN
Z:=0;
BREAK;
END;
END;

IF Z THEN
RETURN K;
END;
imax:=K;


REPEAT

K:=FLOOR((imin+imax)/2);
REPEAT 
K:=K-1;
GG:=AFilesB("Di.fu",2*K,2);
UNTIL GG(1)==0 AND GG(2)==0;

Z:=0;
FOR J FROM 1 TO L DO
GG:=AFilesB("Di.fu",2*(K+J));
CASE
IF GG(1)<Di(J) THEN
Z:=1;
BREAK;
END;
IF GG(1)>Di(J) THEN
Z:=2;
BREAK;
END;
DEFAULT
END;
END;
CASE
IF Z==1 THEN
IF imin≠K THEN
imin:=K;
ELSE
JJ:=1;
END;
END;
IF Z==2 THEN
IF imax≠K THEN
imax:=K;
ELSE
JJ:=1;
END;
END;
IF Z==0 THEN
GG:=AFilesB("Di.fu",2*(K+J));
IF GG(1)==9 THEN
RETURN K;
ELSE
imax:=K;
END;
END;
DEFAULT
END;



IF JJ THEN
K:=imax;
REPEAT 
K:=K-1;
GG:=AFilesB("Di.fu",2*K,2);
UNTIL GG(1)==0 AND GG(2)==0;

Z:=0;
FOR J FROM 1 TO L DO
GG:=AFilesB("Di.fu",2*(K+J));
CASE
IF GG(1)<Di(J) THEN
Z:=1;
BREAK;
END;
IF GG(1)>Di(J) THEN
Z:=2;
BREAK;
END;
DEFAULT
END;
END;
CASE
IF Z==1 THEN
imin:=K;
END;
IF Z==2 THEN
imax:=K;
END;
IF Z==0 THEN
GG:=AFilesB("Di.fu",2*(K+J));
IF GG(1)==9 THEN
RETURN K;
ELSE
imax:=K;
END;
END;
DEFAULT
END;
ELSE
K:=imax;
END;


UNTIL K==imin;
RETURN −1;
END;


VIEW "查单词",START()
BEGIN
RECT_P(0);
LOCAL C:="",K;
LOCAL GG,DD:="",HH:="";
LOCAL II;

WHILE 1 DO
DD:="";HH:="";
C:=N22;
CASE
IF C=="0" THEN
RETURN 0;
END;
IF C=="" THEN
CONTINUE;
END;
END;

K:=Sea(LOWER(C));
IF K==−1 THEN
RECT_P(0);
ELSE
K:=K+1;
GG:=AFilesB("Di.fu",2*K,2);
REPEAT
DD:=DD+CHAR(GG(1)+256*GG(2)); 
K:=K+1;
GG:=AFilesB("Di.fu",2*K,2);
UNTIL GG(1)==9 AND GG(2)==0;
GG:=AFilesB("Di.fu",2*(K+1),520);
K:=1;
HH:={};
I:=0;
REPEAT
HH(I:=I+1):=GG(K)+256*GG(K+1);
K:=K+2;
UNTIL GG(K)==0 AND GG(K+1)==0;
BONE5(HH);
END;
END;
END;


Symb()
BEGIN
START();
END;

Plot()
BEGIN
START();
END;

Num()
BEGIN
START();
END;

SymbSetup()
BEGIN
START();
END;

PlotSetup()
BEGIN
START();
END;

NumSetup()
BEGIN
START();
END;

Info()
BEGIN
START();
END;


RESET()
BEGIN
START();
END;
