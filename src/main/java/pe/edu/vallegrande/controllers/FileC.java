/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pe.edu.vallegrande.dao.FileImpl;
import pe.edu.vallegrande.model.File;

/**
 *
 * @author josue
 */
@Named(value = "fileC")
@SessionScoped
public class FileC implements Serializable {

    File file;
    FileImpl daoFile;
    List<File> listFile;

    public FileC() {
        file = new File();
        daoFile = new FileImpl();
        listFile = new ArrayList();
    }

    @PostConstruct
    public void inicio() {
        try {
            listar();
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
    }

    public void guardar() {
        try {
            daoFile.registrar(file);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al guardarC " + e.getMessage());
        }
    }

    public void limpiar() {
        file = new File();
    }

    public void listar() {
        try {
            listFile = daoFile.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileImpl getDaoFile() {
        return daoFile;
    }

    public void setDaoFile(FileImpl daoFile) {
        this.daoFile = daoFile;
    }

    public List<File> getListFile() {
        return listFile;
    }

    public void setListFile(List<File> listFile) {
        this.listFile = listFile;
    }

}
