package com.stucoursered.javacourseprojectback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class TableTestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/films")
    public List<String> getFilmNames() {
        String sqlQuery = "SELECT name FROM studio";

        List<String> filmNames = jdbcTemplate.query(sqlQuery, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("name");
            }
        });

        return filmNames;
    }
}