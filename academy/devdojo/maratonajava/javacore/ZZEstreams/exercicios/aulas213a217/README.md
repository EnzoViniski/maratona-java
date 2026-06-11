# Exercicios - Aulas 213 a 217

Resolva os exercicios nesta ordem. As aulas `213`, `214` e `216` entram como
revisao, e as aulas novas `215` e `217` aparecem com mais peso.

Todos os arquivos Java compilam com retornos provisorios. A sua tarefa e trocar
os retornos vazios ou zerados pelas implementacoes dos `TODOs`, sem alterar os
arquivos originais das aulas.

## 1. Facil - colecionando com Collectors

Arquivo: `Aulas213A217Exercicio01Facil.java`

Objetivo: treinar a versao Collector dos terminais da aula `213` e o
`groupingBy` basico da aula `214`, com um primeiro contato com o classificador
derivado da aula `215`.

Treine:

- `Collectors.counting()`
- `Collectors.summingDouble(...)`
- `Collectors.joining(...)`
- `Collectors.maxBy(...)`
- `Collectors.summarizingDouble(...)`
- `Collectors.groupingBy(LightNovel::getCategory)`
- `Collectors.groupingBy` com classificador derivado para `Promotion`

## 2. Medio - groupingBy + downstream + mapping

Arquivo: `Aulas213A217Exercicio02Medio.java`

Objetivo: praticar `groupingBy` aninhado da aula `215`, downstream collectors
da aula `216` e `mapping` + `toCollection` da aula `217`.

Treine:

- `groupingBy` aninhado (Categoria -> Promocao -> Lista)
- `groupingBy(..., Collectors.counting())`
- `groupingBy(..., Collectors.collectingAndThen(Collectors.maxBy(...), Optional::get))`
- `Collectors.toMap` com `BinaryOperator.maxBy(...)`
- `groupingBy(..., Collectors.summarizingDouble(...))`
- `groupingBy(..., Collectors.mapping(..., Collectors.toSet()))`
- `groupingBy(..., Collectors.mapping(..., Collectors.toCollection(LinkedHashSet::new)))`

## 3. Desafio final - relatorio do catalogo

Arquivo: `Aulas213A217DesafioFinal.java`

Objetivo: combinar todos os coletores das aulas em um cenario de relatorio
completo do catalogo, com agrupamentos de varios niveis e composicao final.

Treine:

- `Collectors.counting()`
- `groupingBy(..., mapping(..., joining(...)))`
- `groupingBy(..., summingDouble(...))`
- `groupingBy(..., averagingDouble(...))`
- `groupingBy` aninhado por classificador derivado (foco da aula 215)
- `groupingBy(..., mapping(..., toSet()))` (foco da aula 217)
- `groupingBy(..., collectingAndThen(maxBy(...), Optional::get))` (foco da aula 216)
- `groupingBy` aninhado terminando em `summarizingDouble(...)` (mistura 215 + 217)
- composicao de metodos pequenos em um relatorio textual final

## Regras de treino

- Nao altere os arquivos das aulas originais.
- Substitua os retornos provisorios, mas mantenha os nomes dos metodos.
- Evite `for`/`switch` manuais nos metodos marcados para resolver com stream.
- Quando o metodo retornar `Optional`, `Map` ou `Set`, nao use `null`.
- Comece pelo facil, passe para o medio e deixe o desafio final por ultimo.
- Rode o `main` de cada arquivo depois de resolver os TODOs.
