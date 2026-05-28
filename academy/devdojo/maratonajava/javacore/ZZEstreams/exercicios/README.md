# Exercicios - Optional e Streams

Resolva os exercicios na ordem. Eles revisam as aulas `Aula201_OptionalTest01`
e `Aula202_OptionalTest02`, mas o foco principal esta nas aulas novas
`Aula203_StreamTest01`, `Aula204_StreamTest02` e `Aula205_StreamTest03`.

Todos os arquivos compilam com retornos provisorios. A sua tarefa e substituir
os `TODOs` pelas implementacoes corretas, sem alterar as aulas originais.

## 1. Facil - primeira pipeline com stream

Arquivo: `StreamOptionalExercicio01Facil.java`

Objetivo: transformar a ideia da aula 203, feita com `sort`, `for`, `if` e
`break`, em uma pipeline parecida com a aula 204.

Treine:

- `Optional.empty()`
- `Optional.of(...)`
- `orElse(...)`
- `ifPresent(...)`
- `stream()`
- `sorted(...)`
- `filter(...)`
- `limit(...)`
- `map(...)`
- `collect(...)`

## 2. Medio - repositorio com Optional e consultas com stream

Arquivo: `StreamOptionalExercicio02Medio.java`

Objetivo: misturar o `MangaRepository` das aulas de revisao com consultas em
`List<LightNovel>` usando streams.

Treine:

- `ifPresent(...)`
- `orElseThrow(...)`
- `orElseGet(...)`
- `distinct()`
- `count()`
- `Comparator.comparing(...)`
- `thenComparing(...)`
- pipelines com filtro por parametro

## 3. Desafio final - catalogo de campanha

Arquivo: `StreamOptionalDesafioFinal.java`

Objetivo: criar buscas reaproveitaveis com `Predicate`, retornar `Optional` sem
usar `null`, e montar consultas de campanha com streams.

Treine:

- metodo generico de busca com `Predicate`
- `Optional<ItemCatalogo>`
- `orElseThrow(...)`
- `stream()`
- `sorted(...)`
- `filter(...)`
- `distinct()`
- `limit(...)`
- `map(...)`
- `collect(...)`
- `count()`

## Regras de treino

- Nao use `get()` em `Optional`.
- Nao retorne `null` em metodos que retornam `Optional`.
- Nao altere os arquivos das aulas originais.
- Primeiro resolva sem olhar as aulas; depois compare com os exemplos.
- Rode o `main` de cada exercicio depois de implementar.
