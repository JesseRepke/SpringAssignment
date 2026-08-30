package edu.wctc.sales;

import edu.wctc.sales.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SalesApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SalesProcessor processor =
                context.getBean(SalesProcessor.class);

        processor.generateReport();

        context.close();
    }
}