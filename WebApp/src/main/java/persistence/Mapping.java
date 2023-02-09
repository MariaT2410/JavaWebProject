package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;


@FunctionalInterface
public interface Mapping<T> 
{
	T map(ResultSet resultSet) throws SQLException;
}
