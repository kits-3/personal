package project.management.repository;

import java.util.List;

import project.management.mapper.RowMapper;

public interface GenericRepository<T> {
   List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
   int update (String sql, Object... parameters);
   int insert (String sql, Object... parameters);
}
