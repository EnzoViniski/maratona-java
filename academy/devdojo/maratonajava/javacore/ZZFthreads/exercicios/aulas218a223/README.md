# Exercicios - Aulas 218 a 223

Resolva os exercicios nesta ordem. A aula `218` entra como revisao de streams
paralelas, e as aulas novas `220`, `222` e `223` (threads) aparecem com mais
peso.

Observacao: no projeto nao existem arquivos para as aulas `219` e `221` (sao
aulas teoricas ou foram puladas), entao os exercicios cobrem so o que tem
codigo de fato: `218`, `220`, `222` e `223`.

Todos os arquivos Java compilam com retornos provisorios. A sua tarefa e trocar
os retornos vazios ou zerados pelas implementacoes dos `TODOs`, sem alterar os
arquivos originais das aulas.

## 1. Facil - primeira thread, primeiro Runnable

Arquivo: `Aulas218A223Exercicio01Facil.java`

Objetivo: criar threads das duas formas vistas na aula `220` (estendendo
`Thread` e implementando `Runnable`), e revisar o lado paralelo da aula `218`.

Treine:

- Sobrescrever `run()` (nao `start()`) ao estender `Thread`
- Implementar `Runnable` e envolver em `new Thread(runnable)`
- Chamar `.start()` corretamente
- `Thread.currentThread()`
- `LongStream.rangeClosed(...).sum()`
- `LongStream.rangeClosed(...).parallel().sum()`
- `Stream.iterate(...).limit(...).parallel().reduce(...)`

## 2. Medio - nome, prioridade, sleep e benchmark

Arquivo: `Aulas218A223Exercicio02Medio.java`

Objetivo: praticar nome de thread e prioridade da aula `222`, com `Thread.sleep`
+ `InterruptedException`, e fechar com um benchmark sequencial vs paralelo da
aula `218`.

Treine:

- `new Thread(runnable, "nome")`
- `Thread.currentThread().getName()`
- `thread.setPriority(Thread.MIN_PRIORITY / NORM_PRIORITY / MAX_PRIORITY)`
- `Thread.sleep(ms)` em `try/catch (InterruptedException)`
- Funcao utilitaria de cronometragem com `System.currentTimeMillis()`
- `LongStream.rangeClosed(...).sum()` vs `.parallel().sum()`

## 3. Desafio final - fluxo sequencial e paralelo com join

Arquivo: `Aulas218A223DesafioFinal.java`

Objetivo: combinar criacao nomeada de threads (`222`), `join()` para coordenar
ordem (`223`), `sleep` simulando trabalho, e fechar com uma soma paralela da
aula `218` num relatorio final.

Treine:

- Criar `Runnable` com nome, passos e pausa
- `new Thread(runnable, nome)` + `setPriority`
- `thread.start()` + `thread.join()` em `try/catch (InterruptedException)`
- Encapsular start+join num utilitario `iniciarEEsperar(Thread t)`
- Fluxo sequencial: cada `join` bloqueia ate a thread terminar
- Fluxo paralelo: start em todas primeiro, depois join em todas
- `LongStream.rangeClosed(1, n).parallel().sum()`
- `Runtime.getRuntime().availableProcessors()`
- Composicao de metodos pequenos em um relatorio textual final

## Regras de treino

- Nao altere os arquivos das aulas originais.
- Substitua os retornos provisorios, mas mantenha os nomes dos metodos.
- Ao estender `Thread`, sobrescreva `run()`, nunca `start()`.
- Para iniciar uma thread, use `.start()`. Chamar `.run()` direto roda na thread atual.
- Sempre que usar `Thread.sleep(...)` ou `thread.join()`, envolva em `try/catch (InterruptedException)`.
- Quando o metodo retornar `Thread`, ele ja vem com um `return new Thread(() -> {})` provisorio - troque pela implementacao.
- Comece pelo facil, passe para o medio e deixe o desafio final por ultimo.
- Rode o `main` de cada arquivo depois de resolver os TODOs e observe a saida intercalada das threads.
