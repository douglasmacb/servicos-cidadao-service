# Serviços ao cidadão

Esse serviço cuida de toda a parte do cidadão.

Para já iniciarmos com algumas informações em nossa base, devemos inserir antes de utilizar o sistema.
```sql
USE servicodb;
INSERT INTO categoria VALUES (1, 'Animais');
INSERT INTO categoria VALUES (2, 'Finanças');
INSERT INTO categoria VALUES (3, 'Rua e bairro');
INSERT INTO categoria VALUES (4, 'COVID-19');
INSERT INTO categoria VALUES (5, 'Lixo e limpeza');
INSERT INTO categoria VALUES (6, 'Trânsito e Transporte');
INSERT INTO categoria VALUES (7, 'Cidadania e assistência social');
INSERT INTO categoria VALUES (8, 'Meio Ambiente');
 
INSERT INTO servico VALUES (1, 'Tapa-buraco', 3);
INSERT INTO servico VALUES (2, 'Dívida Ativa - Solicitar triagem de agendamento', 2);
INSERT INTO servico VALUES (3, 'Imunidades e Isenções', 2);
INSERT INTO servico VALUES (4, 'Indicadores Econômicos Municipais', 2);
INSERT INTO servico VALUES (5, 'Notas do milhão', 2);
 
INSERT INTO STATUS VALUES (1, 'Recebido');
INSERT INTO STATUS VALUES (2, 'Em análise');
INSERT INTO STATUS VALUES (3, 'Concluído');

INSERT INTO contato VALUES (1, 'Cemig', '116');
INSERT INTO contato VALUES (2, 'Copasa', '115');
INSERT INTO contato VALUES (3, 'Corpo de bombeiros', '193');
INSERT INTO contato VALUES (4, 'Defesa civil', '199');
INSERT INTO contato VALUES (5, 'Detran - mg', '155');
INSERT INTO contato VALUES (6, 'Disque denúncia', '181');
INSERT INTO contato VALUES (7, 'Governo de minas gerais(ligminas)', '155');
INSERT INTO contato VALUES (8, 'Inss', '135');
INSERT INTO contato VALUES (9, 'Ouvidoria geral do estado', '162');
INSERT INTO contato VALUES (10, 'Pessoas desaparecidas', '0800-2828-197');
INSERT INTO contato VALUES (11, 'Polícia civil', '197');
INSERT INTO contato VALUES (12, 'Polícia federal', '194');
INSERT INTO contato VALUES (13, 'Polícia militar', '190');
INSERT INTO contato VALUES (14, 'Polícia rodoviária federal', '191');
INSERT INTO contato VALUES (15, 'Prefeitura  de belo horizonte(ligações de outros municípios)', '(31) 3429-0405');
INSERT INTO contato VALUES (16, 'Ministério do trabalho e emprego', '158');
INSERT INTO contato VALUES (17, 'Tribunal regional eleitoral', '148');
INSERT INTO contato VALUES (18, 'Receita federal', '146');
INSERT INTO contato VALUES (19, 'Samu', '192');
```

## Dependências

Para o desenvolvimento desse projeto foi utilizado uma dependencia chamada Lombok que nos ajuda na redução de código boilerplate.

https://projectlombok.org/
>Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
>Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.