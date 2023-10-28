package com.br.claudemir.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

@Component
public class H2DatabaseInitializer {

    @Value("${spring.datasource.url}")
    private String h2DatabaseUrl;

  
    @PostConstruct
    private void initializeDatabaseDirectory() {
    
        // Use regex para extrair o caminho do URL do banco de dados H2
        Pattern pattern = Pattern.compile("jdbc:h2:file:(.+?);");
        Matcher matcher = pattern.matcher(h2DatabaseUrl);

        if (matcher.find()) {
            String databasePath = matcher.group(1);
            // Verifique se o diretório existe e, se não existir, crie-o
            File directory = new File(databasePath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Diretório do banco de dados criado com sucesso: " + databasePath);
                } else {
                    System.err.println("Falha ao criar o diretório do banco de dados: " + databasePath);
                }
            }
        } else {
            // O URL não corresponde ao padrão esperado, trate isso apropriadamente
        }
    }
}
