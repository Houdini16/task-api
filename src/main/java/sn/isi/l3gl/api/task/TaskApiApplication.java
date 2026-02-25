package sn.isi.l3gl.api.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"sn.isi.l3gl.api.task", "sn.isi.l3gl.core.task"})
@EntityScan(basePackages = "sn.isi.l3gl.core.task")
@EnableJpaRepositories(basePackages = "sn.isi.l3gl.core.task")
public class TaskApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }
}
