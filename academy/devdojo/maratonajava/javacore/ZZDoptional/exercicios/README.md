# Exercicios - Optional

Resolva os exercicios na ordem. A ideia e treinar o mesmo conteudo das aulas
`Aula201_OptionalTest01` e `Aula202_OptionalTest02`, sem consultar gabarito.

## 1. Busca de nomes

Arquivo: `OptionalExercicio01.java`

Treine:

- `Optional.empty()`
- `Optional.of(...)`
- `orElse(...)`
- `ifPresent(...)`

Objetivo: implementar uma busca simples em uma lista de nomes e imprimir uma
mensagem padrao quando o nome nao existir.

## 2. Repositorio de mangas

Arquivo: `OptionalExercicio02.java`

Treine:

- `Optional<Manga>`
- `orElseThrow(...)`
- `orElseGet(...)`
- `ifPresent(...)`

Objetivo: usar o `MangaRepository` existente para buscar, alterar e criar
valores de fallback sem usar `null`.

## 3. Busca generica com Predicate

Arquivo: `OptionalExercicio03.java`

Treine:

- `Predicate<T>`
- metodo privado de busca
- `Optional.ofNullable(...)`

Objetivo: criar um mini repositorio parecido com `MangaRepository`, mas usando
uma lista de produtos.

## 4. Corrigindo codigo com null

Arquivo: `OptionalExercicio04.java`

Treine:

- substituir retorno `null` por `Optional`
- `isPresent` apenas quando fizer sentido
- `ifPresentOrElse(...)`

Objetivo: refatorar uma busca antiga que retorna `null`.

## Regras de treino

- Nao use `get()` em `Optional`.
- Nao retorne `null` dentro dos metodos que retornam `Optional`.
- Tente resolver primeiro com os metodos vistos nas aulas.
- Depois de resolver, rode o `main` do exercicio.
