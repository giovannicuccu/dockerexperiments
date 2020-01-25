package it.giovannicuccu.dockerexperiments.dao;

import it.giovannicuccu.dockerexperiments.model.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DocumentoDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Documento documento) {
        jdbcTemplate.update("insert into documenti (id,description) values (?,?)", new Object[]{documento.getId(), documento.getDescrizione()});
    }

    public List<Documento> loadAll() {
        return jdbcTemplate.query("select id,description from documenti", ((resultSet, i) -> {
            Documento documento= new Documento();
            documento.setId(resultSet.getLong(1));
            documento.setDescrizione(resultSet.getString(2));
            return documento;
        }));
    }

}
