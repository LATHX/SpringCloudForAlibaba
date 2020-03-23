package com.lathx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaNacosOrder8083 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosOrder8083.class, args);
    }
}
