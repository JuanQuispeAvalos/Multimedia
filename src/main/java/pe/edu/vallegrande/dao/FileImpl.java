/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.dao;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.util.List;
import pe.edu.vallegrande.model.File;

/**
 *
 * @author josue
 */
public class FileImpl extends Conexion implements ICRUD<File> {

    @Override
    public void registrar(File modelo) throws Exception {
        try {
            String sql = "insert into Upload (img) values (?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            // Convert the input string to bytes according to the UTF-8 character encoding
            byte[] varBinary = sql.getBytes(StandardCharsets.UTF_8);

            // Set the XmlField parameter in the prepared statement.
            ps.setBytes(1, varBinary);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Registrar " + e);
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(File modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(File modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<File> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
