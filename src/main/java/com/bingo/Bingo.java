package com.bingo;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class Bingo {

    public static void main(String[] args) {
        SpringApplication.run(Bingo.class, args);
    }
}
