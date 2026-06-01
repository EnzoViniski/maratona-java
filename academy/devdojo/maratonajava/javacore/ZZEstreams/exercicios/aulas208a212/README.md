# Exercicios - Aulas 208 a 212

Resolva os exercicios nesta ordem. As aulas `208`, `209` e `210` entram como
revisao, e as aulas novas `211` e `212` aparecem com mais peso.

Todos os arquivos Java compilam com retornos provisorios. A sua tarefa e trocar
os retornos vazios ou zerados pelas implementacoes dos `TODOs`, sem alterar os
arquivos originais das aulas.

## 1. Facil - primeiros streams criados na mao

Arquivo: `Aulas208A212Exercicio01Facil.java`

Objetivo: treinar as formas basicas de criar streams vistas na aula `211`,
misturando com buscas da aula `208`.

Treine:

- `IntStream.rangeClosed(...)`
- `Stream.of(...)`
- `Arrays.stream(...)`
- `average()`
- `allMatch(...)`
- `findFirst()`
- ordenacao com `Comparator`

## 2. Medio - arquivo, sequencia e reducao

Arquivo: `Aulas208A212Exercicio02Medio.java`

Objetivo: praticar `Files.lines` e `Stream.iterate`, combinando com `reduce`,
`mapToDouble` e busca em listas de `LightNovel`.

Treine:

- `Files.lines(Paths.get(...))` com try-with-resources
- `flatMap(Arrays::stream)` em palavras de arquivo
- `Stream.iterate(...)`
- `Arrays.stream(...)`
- `reduce(...)`
- `mapToDouble(...)`
- `sum()`
- `findFirst()`

## 3. Desafio final - campanha de leitura

Arquivo: `Aulas208A212DesafioFinal.java`

Objetivo: resolver um cenario maior com lotes de vendas, metas geradas,
codigos aleatorios, leitura de arquivo e resumo final.

Treine:

- `IntStream.rangeClosed(...)` para dias da campanha
- `Stream.iterate(...)` para Fibonacci
- `Stream.generate(...)` com `ThreadLocalRandom`
- `Files.lines(...)` para contar linhas do arquivo
- `flatMap(...)` em listas aninhadas
- `allMatch(...)`
- `max(...)`
- `mapToDouble(...)`
- `sum()`
- `Arrays.stream(...)`
- `reduce(...)`
- composicao de metodos pequenos em um resumo final

## Regras de treino

- Nao altere os arquivos das aulas originais.
- Substitua os retornos provisorios, mas mantenha os nomes dos metodos.
- Evite `for` nos metodos marcados para resolver com stream.
- Quando ler arquivo com `Files.lines`, use try-with-resources.
- Quando o metodo retornar `Optional`, `OptionalDouble` ou lista, nao use `null`.
- Comece pelo facil, passe para o medio e deixe o desafio final por ultimo.
- Rode o `main` de cada arquivo depois de resolver os TODOs.
