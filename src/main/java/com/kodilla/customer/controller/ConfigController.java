package com.kodilla.customer.controller;

import com.kodilla.customer.dto.DbConfigDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class ConfigController {

    @Autowired
    DataSource dataSource;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeDbCredentials(@RequestBody DbConfigDto dbConfigDto) throws SQLException {
        var connection = dataSource.createConnectionBuilder()
                .user(dbConfigDto.getUsername())
                .password(dbConfigDto.getPassword())
                .build();

        connection.beginRequest();
    }
}
