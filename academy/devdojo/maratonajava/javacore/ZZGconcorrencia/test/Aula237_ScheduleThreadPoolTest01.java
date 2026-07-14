package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Aula237_ScheduleThreadPoolTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) +" beep");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.schedule(r, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 4, TimeUnit.SECONDS); // vai contar a partir de quando volta de dormir
//        ScheduledFuture<?> scheduleWithFixedRate = executor.scheduleAtFixedRate(r, 1, 4, TimeUnit.SECONDS); // conta mesmo quando esta dormindo, quando acordar se ja tiver passadp p tempo ele faz
        executor.schedule(() -> {
            System.out.println("Cancelando scheduleWithFixedDelay");
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);

    }
    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
