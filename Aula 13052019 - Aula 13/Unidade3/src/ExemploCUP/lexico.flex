package ExemploCUP;
import java_cup.runtime.*;
%%
%cup
%public
%class Lexer
%line
%column
%{
  private Symbol symbol(int type) { return new Symbol(type, yyline, yycolumn); }
  private Symbol symbol(int type, Object value) { return new Symbol(type, yyline, yycolumn, value);  }
%}
DIGITO = [0-9]
LETRA = [a-zA-Z_]
LITERAL =  \"[^\"]*\"
INTEIRO = {DIGITO}+
VARIAVEL = {LETRA}+
IGNORE = [\n|\s|\t\r]
%%

<YYINITIAL> {
    "programa"      {return new Symbol(Sym.PROGRAMA); }
    "inicio"        {return new Symbol(Sym.INICIO); }
    "fim"           {return new Symbol(Sym.FIM); }
    "int"           {return new Symbol(Sym.TIPO_INTEIRO); }
    "caracter"      {return new Symbol(Sym.TIPO_CHAR); }    
    ";"             {return new Symbol(Sym.PTVG); }        
    "<-"            {return new Symbol(Sym.SIMBOLO_ATRIB); }   
    {LITERAL}       {return new Symbol(Sym.CHAR); }
    {INTEIRO}       {return new Symbol(Sym.INTEIRO); }  
    {VARIAVEL}      {return new Symbol(Sym.VARIAVEL); }
    {IGNORE}        {}   
}
<<EOF>> { return new Symbol( Sym.EOF ); }
[^] { throw new Error("caracter inválido: "+yytext()+" na linha "+(yyline+1)+", coluna "+(yycolumn+1) ); }
