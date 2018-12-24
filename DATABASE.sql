CREATE DATABASE LIBRARYJOKE_JOKES;
USE LIBRARYJOKE_JOKES;

CREATE TABLE AUTHOR(

AUTHOR_ID INTEGER AUTO_INCREMENT,
AUTHOR_NAME VARCHAR(40),
PRIMARY KEY(AUTHOR_ID)
);

CREATE TABLE JOKE(

JOKE_ID      INTEGER AUTO_INCREMENT,
JOKE_TYPE   VARCHAR(40),
JOKE_JOKE_JOKE   VARCHAR(1000),
JOKE_AUTHORID INTEGER, 
PRIMARY KEY(JOKE_ID),
FOREIGN KEY (JOKE_AUTHORID) REFERENCES AUTHOR(AUTHOR_ID)
);

INSERT INTO AUTHOR (AUTHOR_NAME) VALUES ("www.pianoeletronico.com.br");
INSERT INTO AUTHOR (AUTHOR_NAME) VALUES ("www.mensagenscomamor.com");
INSERT INTO AUTHOR (AUTHOR_NAME) VALUES ("www.aldeiarpg.com");


INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Nerd", "Quantos programadores são necessários para trocar uma lâmpada? R: Não é possível ser feito. É um problema de hardware.", 2);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Nerd", "O que a mulher do Einstein falou pra ele quando ela o viu pelado pela primeira vez??
R: Nossa! Que físico!", 2);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Nerd", "Se há algo que o tetris me ensinou sobre a vida é que os erros acumulam e os triunfos desaparecem.", 2);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Nerd", "Programador encontrado morto na banheira cinco dias após ter sido dado como desaparecido. Junto a ele foi encontrado um shampoo com as seguintes instruções:

Lavar, enxaguar, repetir.", 2);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Nerd", "A esposa pede ao marido, um programador, para ir à mercearia e diz:
- Compre duas salsichas e, se eles tiverem ovos, compre 10.
O programador vai até a loja e pergunta:
- Vocês têm ovos?
- Sim.
- Então eu quero 10 salsichas.", 3);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Nerd", "Um engenheiro, um médico e um programador estavam tomando umas e outras num bar quando surgiu uma dúvida sobre qual seria a mais velha profissão do mundo. Imediatamente o médico descartou a prostituição, que era a mais óbvia, dizendo:
- A profissão mais velha é a medicina. Afinal, se vocês pegarem a Bíblia, verão que Deus fez a mulher de uma costela de Adão, praticando uma cirurgia.
O engenheiro aproveitou o gancho e disse:
- Se vocês pegarem a Bíblia verão que antes de ter feito a mulher, Deus fez o Mundo, o que é a mais perfeita manifestação de engenharia de que se tem notícia.
O programador não agüentou e retrucou:
- Acho que vocês estão enganados. É a programação. Justamente na Bíblia, que vocês citaram, a primeira frase do primeiro livro, o Gênesis, diz assim: 'No começo, era o caos...'.", 3);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Game", "Qual o game que só tem 1, 3, 5, 6, 7 e 9?
Age of Impares", 1);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Game", "Qual o estado que solta hadouken?
O Ryu de Janeiro", 1);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Game", "Qual o jogo preferido do Hitler?
Meinkraft", 1);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Game", "Mataram o Ash, qual o nome do filme?
Mewtwo matou um cara", 1);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Game", "Qual o pokémon que dá dicas de saúde?
O Drowzee Varella", 1);
INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES ("Game", "Qual o café preferido do gamer?
NEScafé", 1);

