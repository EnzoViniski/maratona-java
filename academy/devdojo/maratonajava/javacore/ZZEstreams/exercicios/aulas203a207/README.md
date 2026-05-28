# Exercicios - Aulas 203 a 207

Resolva os exercicios nesta ordem. Eles revisam as aulas `203`, `204` e `205`
e dao mais peso para as aulas novas `206` e `207`.

Todos os arquivos Java compilam com retornos provisorios. A sua tarefa e trocar
os `TODOs` pelas implementacoes corretas, sem alterar os arquivos originais das
aulas.

## 1. Facil - prateleiras de light novels

Arquivo: `Aulas203A207Exercicio01Facil.java`

Objetivo: pegar a ideia das aulas 203 e 204, mas agora com uma lista de listas,
como na aula 206.

Treine:

- `stream()`
- `flatMap(Collection::stream)`
- `sorted(Comparator.comparing(...))`
- `filter(...)`
- `limit(...)`
- `map(...)`
- `collect(...)`
- `distinct()`
- `count()`

## 2. Medio - palavras de titulos e frases

Arquivo: `Aulas203A207Exercicio02Medio.java`

Objetivo: praticar a aula 207, transformando frases e titulos em palavras
soltas usando `split`, `map` e `flatMap`.

Treine:

- `map(texto -> texto.split(" "))`
- `flatMap(Arrays::stream)`
- `distinct()`
- `sorted()`
- `filter(...)`
- `limit(...)`
- `count()`
- composicao de pipelines com dados de `LightNovel`

## 3. Desafio final - campanha do catalogo

Arquivo: `Aulas203A207DesafioFinal.java`

Objetivo: misturar tudo: catalogo, listas aninhadas de tags, palavras de
titulos, ordenacao, filtros, limite, contagem e montagem de resumo.

Treine:

- `flatMap(Collection::stream)` para tags
- `flatMap(Arrays::stream)` para palavras de titulos
- `sorted(...)`
- `filter(...)`
- `distinct()`
- `limit(...)`
- `map(...)`
- `collect(...)`
- `count()`

## Regras de treino

- Nao altere os arquivos das aulas originais.
- Nao copie a solucao das aulas linha por linha: adapte para os dados novos.
- Evite `for` nos metodos marcados para resolver com stream.
- Rode o `main` de cada arquivo depois de resolver.
- Se um metodo pede palavras, pense se voce precisa de `split`, `Arrays.stream`
  e `flatMap`.
- Se um metodo recebe uma lista de listas, pense se voce precisa de
  `Collection::stream` e `flatMap`.
