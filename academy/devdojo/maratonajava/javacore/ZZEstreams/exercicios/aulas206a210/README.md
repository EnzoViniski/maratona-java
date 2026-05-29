# Exercicios - Aulas 206 a 210

Resolva os exercicios nesta ordem. As aulas `206` e `207` entram como revisao,
e as aulas novas `208`, `209` e `210` aparecem com mais peso.

Todos os arquivos Java compilam com retornos provisorios. A sua tarefa e trocar
os `TODOs` pelas implementacoes corretas, sem alterar os arquivos originais das
aulas.

## 1. Facil - estantes de light novels

Arquivo: `Aulas206A210Exercicio01Facil.java`

Objetivo: revisar `flatMap` com lista de listas e comecar a usar operacoes de
busca com `Optional`.

Treine:

- `flatMap` para abrir `List<List<LightNovel>>`
- `sorted(Comparator.comparing(...))`
- `map(...)`
- `collect(...)`
- `anyMatch(...)`
- `findFirst()`

## 2. Medio - buscas, soma e reducao

Arquivo: `Aulas206A210Exercicio02Medio.java`

Objetivo: misturar palavras de frases com calculos em streams de light novels.

Treine:

- `map(texto -> texto.split(" "))`
- `flatMap(Arrays::stream)`
- `distinct()`
- `filter(...)`
- `mapToDouble(...)`
- `sum()`
- `max(Comparator.comparing(...))`
- `reduce(...)`

## 3. Desafio final - vendas em lotes

Arquivo: `Aulas206A210DesafioFinal.java`

Objetivo: resolver um cenario maior usando lotes de vendas, tags, titulos,
quantidades e faturamento.

Treine:

- `flatMap` em listas aninhadas
- `flatMap(Arrays::stream)` em palavras de titulos
- `allMatch(...)`
- `anyMatch(...)`
- `max(...)`
- `mapToDouble(...)`
- `sum()`
- `reduce(...)`
- composicao de metodos pequenos em um resumo final

## Regras de treino

- Nao altere os arquivos das aulas originais.
- Evite `for` nos metodos marcados para resolver com stream.
- Nao copie o codigo das aulas linha por linha: adapte para os dados novos.
- Resolva primeiro o exercicio facil, depois o medio e por ultimo o desafio.
- Rode o `main` de cada arquivo depois de resolver os TODOs.
- Quando o metodo retornar `Optional`, nao use `null`.
- Quando precisar somar `double`, pratique `mapToDouble`.
- Quando precisar abrir listas dentro de listas, pense em `flatMap`.
