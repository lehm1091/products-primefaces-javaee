package datos;

import domainOrcl.*;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumnos20
 */
@Local
public interface SupplierDAO {

    public List<Supplier> select() throws SQLException;

    public int insert(Supplier s) throws SQLException;

    public int update(Supplier s) throws SQLException;

    public int delete(Supplier s) throws SQLException;

    public Supplier getSupplier(int id) throws SQLException;

}
