package ru.netology.hwspringbootdao.repository;

import org.springframework.stereotype.Repository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String productScriptQuery;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.productScriptQuery = read();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getProductNames(String name) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        return jdbcTemplate.queryForList(productScriptQuery, params, String.class);
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("product_script.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}