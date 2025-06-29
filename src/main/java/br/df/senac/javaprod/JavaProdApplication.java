package br.df.senac.javaprod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "br.df.senac.javaprod.entity")
@EnableJpaRepositories(basePackages = "br.df.senac.javaprod.repository")
@ComponentScan(basePackages = "br.df.senac.javaprod")
@EnableTransactionManagement
public class JavaProdApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaProdApplication.class, args);
	}

}
