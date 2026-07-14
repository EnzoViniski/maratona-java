# Exercicios - Aulas 220 a 230

Resolva os exercicios nesta ordem. As aulas `220`, `222` e `223` (criar threads,
nome/prioridade/sleep e join) entram como revisao, e as aulas novas `224` a
`230` (race condition, synchronized, deadlock, wait/notifyAll, AtomicInteger e
ReentrantLock) aparecem com mais peso.

Arquivos de referencia das aulas no projeto:

- `ZZFthreads/test`: aulas 220, 222, 223, 224, 225, 226, 227 e 228
- `ZZFthreads/domain` e `ZZFthreads/service`: `Account`, `Members` e `EmailDeliveryService`
- `ZZGconcorrencia/test`: aulas 229 e 230

Observacao: a aula `221` nao tem arquivo no projeto, entao os exercicios cobrem
o que tem codigo de fato.

Todos os arquivos Java compilam com corpos vazios e retornos provisorios. A sua
tarefa e trocar esses corpos pelas implementacoes dos `TODOs`, sem alterar os
arquivos originais das aulas.

## 1. Facil - placar de ingressos: race condition x synchronized x AtomicInteger

Arquivo: `Aulas220A230Exercicio01Facil.java`

Objetivo: ver a race condition acontecer de verdade num contador compartilhado
(aulas 224/229) e corrigir de dois jeitos diferentes: metodo `synchronized`
(aula 225) e `AtomicInteger` (aula 229). A criacao das threads revisa as duas
formas da aula 220 e o `join` da aula 223.

Treine:

- Sobrescrever `run()` (nao `start()`) ao estender `Thread`
- Implementar `Runnable` e envolver em `new Thread(runnable, "nome")`
- `synchronized` na assinatura do metodo
- `AtomicInteger.incrementAndGet()` e `AtomicInteger.get()`
- `thread.start()` + `thread.join()` em `try/catch (InterruptedException)`
- Comparar o placar: sem protecao (vem menor), synchronized e atomic (exatos)

## 2. Medio - guilda: saque protegido, colecao thread-safe e ReentrantLock

Arquivo: `Aulas220A230Exercicio02Medio.java`

Objetivo: reproduzir o check-then-act protegido com bloco `synchronized` no
objeto compartilhado (aulas 224/225), deixar uma classe de colecao thread-safe
com metodos `synchronized` (aula 226) e proteger uma secao critica com
`ReentrantLock` + `try/finally` (aula 230).

Treine:

- `synchronized (objeto) { ... }` em volta do check-then-act do saque
- Prints fora x dentro do bloco, no estilo da aula 225
- `synchronized` na assinatura de metodos de colecao (add/remove/size)
- Method reference como `Runnable` (`quadro::removerPrimeira`)
- `lock.lock()` antes do `try`, `lock.unlock()` no `finally`
- `lock.getQueueLength()` para ver a fila de threads
- Nome e prioridade de thread (revisao da aula 222), `Thread.sleep` em try/catch

## 3. Desafio final - taverna: produtor/consumidor com wait/notifyAll

Arquivo: `Aulas220A230DesafioFinal.java`

Objetivo: montar o fluxo completo da aula 228 num dominio novo (balcao de
pedidos + cozinheiros no lugar de `Members` + `EmailDeliveryService`), com o
main produzindo pedidos, dois consumidores em `wait()`/`notifyAll()`, contagem
de pratos com `AtomicInteger` (aula 229), `join` para o relatorio sair certo
(aula 223) e limpeza final com dois locks na mesma ordem para evitar o deadlock
da aula 227.

Treine:

- Bloco `synchronized` no objeto fila, dos dois lados (produtor e consumidor)
- `wait()` SEMPRE dentro de `while` (nunca `if`)
- `notifyAll()` ao adicionar item E ao fechar o balcao
- Flag `aberto` + condicao de parada `while (isAberto() || pendentes > 0)`
- `continue` quando o consumidor recebe `null`
- `AtomicInteger` compartilhado entre threads para estatistica
- `join` no main antes do relatorio final
- Dois locks adquiridos na MESMA ordem por todas as threads (anti-deadlock)

Ordem sugerida dos TODOs: resolva primeiro o `BalcaoDePedidos` (TODOs 01 a 04),
depois o `RUN-COZINHEIRO`, depois os TODOs do main (06 e 07) e por ultimo a
limpeza (05 e 08). Se rodar com o balcao pela metade, o while do cozinheiro
pode virar loop infinito.

## Regras de treino

- Nao altere os arquivos das aulas originais.
- Substitua os corpos provisorios, mas mantenha os nomes e assinaturas dos metodos
  (adicionar `synchronized` na assinatura faz parte do exercicio).
- Para iniciar uma thread, use `.start()`. Chamar `.run()` direto roda na thread atual.
- `Thread.sleep(...)` e `thread.join()` sempre em `try/catch (InterruptedException)`.
- `lock.unlock()` sempre no `finally`, senao uma excecao deixa o lock preso.
- `wait()` e `notifyAll()` so funcionam dentro de um bloco `synchronized` no MESMO
  objeto, senao lancam `IllegalMonitorStateException`.
- Comece pelo facil, passe para o medio e deixe o desafio final por ultimo.
- Rode o `main` de cada arquivo depois de resolver os TODOs. Rode mais de uma vez:
  bug de concorrencia nem sempre aparece na primeira execucao.

## Se o programa nao terminar nunca

- Confira se o `fechar()` do balcao chama `notifyAll()` dentro do `synchronized`.
  Sem isso, cozinheiro em `wait()` dorme para sempre. O `close()` do seu
  `Members` (aula 228) tem exatamente esse problema: ele imprime a mensagem mas
  nao notifica ninguem.
- Confira se o `wait()` esta dentro do `while` que testa a fila vazia.
- No experimento de deadlock do TODO 05, travar e o comportamento esperado:
  encerre o processo e volte os locks para a mesma ordem.
