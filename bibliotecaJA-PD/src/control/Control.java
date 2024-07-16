/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import excepciones.PersistenciaException;
import interfaces.IPersistencia;
import interfazUsuario.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosServicios.*;
import objetosNegocio.*;
import persistencia.PersistenciaListas;
/**
 * Esta clase implementa los casos de uso de la aplicacion Biblioteca.
 * @author jvale
 */
public class Control 
{
    // Acceso a los objetos del negocio 
    IPersistencia persistencia;
    Conversiones conversiones;
    /**
    * Constructor.
    */
    public Control() 
    {
        // Crea un objeto del tipo persistencia
        persistencia = new PersistenciaListas();
        conversiones = new Conversiones();
    }
    /**
     * Agrega un libro al catalogoLibros
     * @param frame ventana sobre la que se despliega el cuadro de dialogo para capturar los datos del libro
     * @return regresa true si se pudo agregar el libro y false si no.
     */
    public boolean agregarLibro(JFrame frame)
    {
        Libro libro, bLibro;
        StringBuffer respuesta = new StringBuffer("");
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        // Captura el isbn del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:","Agregar libro",JOptionPane.QUESTION_MESSAGE);
         // Si el usuario presiono el boton Cancelar
        if(isbn == null) return false;
        // Crea un objeto Libro con solo el isbn
        libro = new Libro (isbn);
        
        // Agrega el nuevo libro al catalogo de libros
        try 
        {
            // Obten el libro del catalogoLibros
            bLibro = persistencia.obten(libro);
            // Obtiene la lista de libros
        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al leer del catalogo de libros despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el libro existe, despliega sus datos
        if(bLibro != null) 
        {
            dlgLibro = new DlgLibro(frame, "El libro ya está en el catalogo", true, bLibro,ConstantesGUI.DESPLEGAR, respuesta);
            return false;
        }
        // Si el libro no existe captura los datos del libro
        dlgLibro = new DlgLibro(frame, "Captura Datos libro", true, libro, ConstantesGUI.AGREGAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR))
        {
             return false;
        }
        try 
        {
            persistencia.agregar(libro);
            listaLibros = persistencia.consultarLibros();
        }
        catch(PersistenciaException e) 
        {
            // Si ocurrio un error al escribir al catalogoLibros despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Actualiza un libro del catalogo de libros
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para editar los datos del libro
     * @return regresa true si se pudo actualizar y false si no.
     */
    public boolean actualizarLibro(JFrame frame)
    {
        Libro libro;
        StringBuffer respuesta = new StringBuffer(""); 
        DlgLibro dlgLibro; 
        List<Libro> listaLibros;  
        // Captura el isbn del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN del libro:", "Actualizar libro", JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
        if(isbn == null) return false;
        // Crea un objeto libro solo con el isbn
        libro = new Libro(isbn);
        try 
        {
            // Obten el libro del catalogoLibros
            libro = persistencia.obten(libro);
        } 
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al leer del catalogo de libros, despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el libro no existe manda un mensaje de error
        if(libro == null) 
        {
            JOptionPane.showMessageDialog(frame,
            "El libro no existe", "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try 
        {
            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el libro existe edita los datos del libro
        dlgLibro = new DlgLibro(frame, "Edita Datos Libro", true, libro, ConstantesGUI.ACTUALIZAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) return false;
        // Actualiza el libro del catalogo de libros
        try 
        {
            persistencia.actualizar(libro);
        }
        catch(PersistenciaException e) 
        {
            // Si ocurrio un error al escribir al catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
    * Elimina un libro del catalogo de libros
    * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
    * desplegar los datos del libro
    * @return Regresa true si se pudo eliminar el libro, false en caso
    * contrario
    */
    public boolean eliminarLibro(JFrame frame)
    {
        Libro libro;
        StringBuffer respuesta = new StringBuffer();
        DlgLibro dlgLibro;
        List<Libro> listaLibros;
        // Captura el isbn del libro
        String isbn = JOptionPane.showInputDialog(frame, "ISBN de el libro:", "Eliminar libro", JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
        if(isbn == null) return false;
        // Crea un objeto libro solo con el isbn.
        libro = new Libro(isbn);
        try 
        {
            // Obten el libro del catalogoLibros
            libro = persistencia.obten(libro);
        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al leer del catalogo de canciones
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        // Si el libro no existe en el catalogo de libros
        if(libro == null) 
        {
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "El libro no existe", "Error!!.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try 
        {
            // Obtiene la lista de libros
            listaLibros = persistencia.consultarLibros();
        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si existe el libro, despliega los datos del libro
        dlgLibro = new DlgLibro(frame, "Libro a borrar", true, libro, ConstantesGUI.ELIMINAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) return false;
        try 
        {
            // Elimina el libro del catalogo de libros
            persistencia.eliminar(libro);
        }
        catch(PersistenciaException e) 
        {
            // Si ocurrio un error al borrar del catalogo de libros,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    } 
    /**
     * Agrega un usuario al catalogo de usuarios
     * @param frame ventana sobre la que se despliega el cuadro de dialogo para capturar los datos del libro
     * @return regresa true si se pudo agregar el usuario y false si no.
     */
    public boolean agregarUsuario(JFrame frame)  
    {
        Usuario usuario, bUsuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
 
        // Captura el numero de credencial del usuario
        String numeroCredencial = JOptionPane.showInputDialog(frame, "Numero de Credencial del usuario:", "Agregar usuario",
        JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
        if(numeroCredencial == null) return false;
        // Crea un objeto Usuario solo con el numero de credencial
        usuario = new Usuario(numeroCredencial);
        
        try 
        {
            // Obten el usuario del catalogoUsuarios
            bUsuario = persistencia.obten(usuario);

        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al leer del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el usuario existe, despliega sus datos
        if(bUsuario != null) 
        {
            dlgUsuario = new DlgUsuario(frame, "El usuario ya está", true, bUsuario,ConstantesGUI.DESPLEGAR, respuesta);

            return false;
        }
        // Si el usuario no existe agrega los datos de nuevo usuario
        dlgUsuario = new DlgUsuario(frame, "Captura Datos Usuario", true, usuario, ConstantesGUI.AGREGAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) return false;
        
       
        // Agrega el nuevo usuario al catalogo de usuarios.
        try 
        {
            persistencia.agregar(usuario);
            listaUsuarios=persistencia.consultarUsuarios();
        }
        catch(PersistenciaException e) 
        {
            // Si ocurrio un error al escribir al catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Actualiza un usuario del catalogo de usuarios
     * @param frame Ventana sobre la que se despliega el cuadro de dialogo para editar los datos del usuario
     * @return regresa true si se pudo actualizar y false si no.
     */
    public boolean actualizarUsuario(JFrame frame) 
    {
        Usuario usuario;
        StringBuffer respuesta = new StringBuffer("");
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
         // Captura el numero de credencial del usuario
        String numeroCredencial = JOptionPane.showInputDialog(frame, "Numero de Credencial del Usuario:", "Actualizar Usuario", JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
        if(numeroCredencial == null) return false;
        // Crea un objeto Usuario solo con el numero de credecial
        usuario = new Usuario(numeroCredencial);
        try
        {
            // Obten el usuario del catalogo de usuarios
            usuario = persistencia.obten(usuario);
        } 
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al leer del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si el usuario no existe, despliega un mensaje de error
        if(usuario == null) 
        {
            JOptionPane.showMessageDialog(frame, "EL usuario no existe", "Error!!.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try 
        {
            // Obtiene la lista de usuarios
            listaUsuarios = persistencia.consultarUsuarios();
        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si el usuario existe, edita los datos del usuario
        dlgUsuario = new DlgUsuario(frame, "Edita Datos Libro", true, usuario, ConstantesGUI.ACTUALIZAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) return false;
        // Actualiza el usuario del catalogo de usuarios
        try 
        {
            persistencia.actualizar(usuario);
        }
        catch(PersistenciaException e) 
        {
            // Si ocurrio un error al escribir al catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
    * Elimina un usuario del catalogo de usuarios
    * @param frame Ventana sobre la que se despliega el cuadro de dialogo para
    * desplegar los datos del usuario
    * @return Regresa true si se pudo eliminar el usuario false en caso
    * contrario
    */
    public boolean eliminarUsuario(JFrame frame) 
    {
        Usuario usuario;
        StringBuffer respuesta = new StringBuffer();
        DlgUsuario dlgUsuario;
        List<Usuario> listaUsuarios;
        // Captura el numero de credencial del usuario
        String numeroCredencial = JOptionPane.showInputDialog(frame, "numeroCredencial del usuario:", "Eliminar usuario", JOptionPane.QUESTION_MESSAGE);
        // Si el usuario presiono el boton Cancelar
        if(numeroCredencial == null) return false;
        // Crea un objeto usuario solo con el numero de credencial
        usuario = new Usuario(numeroCredencial);
        try 
        {
            // Obten el usuario del catalogo de usuarios
            usuario = persistencia.obten(usuario);
        }
        catch (PersistenciaException e)
        {
            // Si ocurrio un error al leer del catalogo de usuarios
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false; 
        }
        // Si el usuario no existe en el catalogo de usuarios,
        if(usuario == null) 
        {
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, "El usuario no existe", "Error!!.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try
        {
            // Obtiene la lista de usuarios
            listaUsuarios = persistencia.consultarUsuarios();
        }
        catch (PersistenciaException e) 
        {
            // Si ocurrio un error al obtener la lista de la base de datos,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Si existe el usuario, despliega los datos del usuario
        dlgUsuario = new DlgUsuario(frame, "Usuario a borrar", true, usuario, ConstantesGUI.ELIMINAR, respuesta);
        // Si el usuario presiono el boton Cancelar
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) return false;
        try 
        {
            // Elimina el usuario del catalogo de usuarios
            persistencia.eliminar(usuario);
        }
        catch(PersistenciaException e) 
        {
            // Si ocurrio un error al borrar del catalogo de usuarios,
            // despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Inventaria un libro en el catalogo de inventario.
     * @param frame para mostrar el cuadro de dialogo para capturar los datos de la publicación
     * @return regresa true si se pudo inventariar y false si no.
     */
    
    public boolean inventariarLibro(JFrame frame)
    {
        PublicacionED bLibro;
        Libro libro;
        StringBuffer respuesta=new StringBuffer("");
        DlgInventario dlgInventario;
        List<Libro>listaLibros;
        DefaultComboBoxModel<Libro>publicacionesComboBoxModel;
        listaLibros=persistencia.consultarLibros();
        publicacionesComboBoxModel=conversiones.librosComboBoxModel(listaLibros);
        libro=(Libro)publicacionesComboBoxModel.getSelectedItem();
        bLibro=new PublicacionED(libro);
        
        dlgInventario=new DlgInventario(frame,"Captura datos inventario",true,bLibro,publicacionesComboBoxModel,ConstantesGUI.AGREGAR,respuesta);
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR))return false;
        try
        {
            persistencia.inventariar((Libro)bLibro.getPublicacion(),bLibro.getExistencia());
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Desinventaría un libro del inventario de libros
     * @param frame despliega un cuadro de dialogo para capturar los datos del libro a desinventariar.
     * @return regresa true si se pudo desinventariar, false si no.
     */
    public boolean desinventariarLibros(JFrame frame)
    {
        PublicacionED bLibro;
        Libro libro;
        StringBuffer respuesta=new StringBuffer("");
        DlgInventario dlgInventario;
        List<Libro>listaLibros;
        DefaultComboBoxModel<Libro>publicacionComboBoxModel;
        listaLibros=persistencia.consultarLibros();
        publicacionComboBoxModel=conversiones.librosComboBoxModel(listaLibros);
        libro=(Libro)publicacionComboBoxModel.getSelectedItem();
        bLibro=new PublicacionED(libro);
        
        dlgInventario=new DlgInventario(frame,"Desinventariar libro",true,bLibro,publicacionComboBoxModel,ConstantesGUI.AGREGAR,respuesta);
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR))return false;
        try
        {
            persistencia.desinventariar((Libro)bLibro.getPublicacion(),bLibro.getDisponibilidad());
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Presta un libro del inventario, a un usuario.
     * @param frame despliega el cuadro de dialogo para capturar los datos del prestamo.
     * @return regresa verdadero si se pudo prestar y falso si no.
     */
    public boolean prestarLibro(JFrame frame) {
        Prestamo prestamo;
        StringBuffer respuesta=new StringBuffer("");
        DlgPrestamos dlgPrestamos;
        List<Libro>listaLibros=null;
        List<Usuario>listaUsuarios=null;
        DefaultComboBoxModel<Libro>librosComboBoxModel;
        DefaultComboBoxModel<Libro>usuariosComboBoxModel;
        
        prestamo=new Prestamo();
        try
        {
            listaLibros=persistencia.consultarLibros();
            listaUsuarios=persistencia.consultarUsuarios();
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        librosComboBoxModel=conversiones.librosComboBoxModel(listaLibros);
        usuariosComboBoxModel=conversiones.usuariosComboBoxModel(listaUsuarios);
        dlgPrestamos=new DlgPrestamos(frame,"Captura datos prestamos",true,prestamo,librosComboBoxModel,usuariosComboBoxModel,ConstantesGUI.AGREGAR,respuesta);
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR))return false;
        try
        {
            persistencia.prestarLibro(prestamo);
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Devuelve un libro al inventario de libros.
     * @param frame despliega el cuadro de dialogo para capturar los datos de la devolución
     * @return regresa true si pudo regresar y false si no.
     */
    public boolean devolverLibro(JFrame frame) 
    {
        
        PublicacionED bLibro;
        Libro libro; 
        Usuario usuario;
        StringBuffer respuesta = new StringBuffer(""); 
        DlgPrestamos dlgPrestamo;
        Prestamo prestamo;
        List<Libro> listaLibros ; 
        DefaultComboBoxModel<Libro> publicacionComboBoxModel;
        List<Usuario> listaUsuarios;
        DefaultComboBoxModel<Usuario> usuarioComboBoxModel;
        // Captura el isbn del libro 
        listaLibros=persistencia.consultarLibros();
        listaUsuarios=persistencia.consultarUsuarios();
        publicacionComboBoxModel = conversiones.librosComboBoxModel(listaLibros);
        usuarioComboBoxModel = conversiones.usuariosComboBoxModel(listaUsuarios); 
        // Si el libro existe, despliega sus datos 
        libro=(Libro) publicacionComboBoxModel.getSelectedItem();
        usuario=(Usuario)usuarioComboBoxModel.getSelectedItem();
        bLibro=new PublicacionED(libro);
        prestamo=new Prestamo(usuario,bLibro.getPublicacion());
        // Si el libro no existe captura los datos del nuevo Libro 
        dlgPrestamo = new DlgPrestamos(frame,"Devolver libro", true,prestamo,publicacionComboBoxModel,usuarioComboBoxModel, ConstantesGUI.AGREGAR, respuesta); 
        // Si el usuario presiono el boton Cancelar 
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) return false; 
        try { 
        persistencia.devolverLibro(prestamo); 
        } 
        catch(Exception e) { 
        // Si ocurrio un error al escribir al catalogo de libros, 
        // despliega mensaje de error 
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!.", 
        JOptionPane.ERROR_MESSAGE); 
        return false; 
        } 
        return true; 
    }
    public boolean acercaDE(JFrame frame)
    {
        AcercaDe acercaDe;
        acercaDe=new AcercaDe(frame, true);
        return true;
    }
    /**
    * Regresa un objeto Tabla con todos los libros
    * @param frame Ventana sobre la que se despliega el mensaje de error
    * @return Objeto Tabla con todas los libros, null si hay un error
    */
    public Tabla getTablaLibros(JFrame frame) 
    {
        List<Libro> listaLibros;
        try 
        {
            //Obtiene la lista de libros
           listaLibros = persistencia.consultarLibros();
        }
        catch (PersistenciaException e) 
        {
            //Si ocurrio un error al obtener la lista de la base de datos,
             //despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return null;
        }
        //Regresa el objeto Tabla con todas los libros.
        return new Tabla("Lista de Libros",
        conversiones.librosTableModel(listaLibros)); 
    }
    /**
     * Regresa una tabla con la lista de todos los usuarios.
     * @param frame ventana sobre la que se despliega el mensaje de error
     * @return objeto de tabla con todos los usuarios, null si hay error.
     */
    public Tabla getTablaUsuarios(JFrame frame) 
    {
        List<Usuario> listaUsuarios;
        try 
        {
           //Obtiene la lista de usuarios
           listaUsuarios = persistencia.consultarUsuarios();
        }
        catch (PersistenciaException e) 
        {
            //Si ocurrio un error al obtener la lista de la base de datos,
             //despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
            JOptionPane.ERROR_MESSAGE);
            return null;
        }
        //Regresa el objeto Tabla con todos los usuarios
        return new Tabla("Lista de Usuarios",
        conversiones.usuariosTableModel(listaUsuarios)); 
    }
    /**
     * Regresa un objeto de tabla con los libros inventariados
     * @param frame muestra el mensaje de error
     * @return un objeto de tabla mostrando todos los libros inventariados
     */
    public Tabla getTablaInventariaLibros(JFrame frame)
    {
        List<PublicacionED>publicacionesED;
        try
        {
            publicacionesED=persistencia.consultarInventarioLibros();
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Tabla("Inventario",conversiones.inventarioLibrosTableModel(publicacionesED));
    }
    /**
     * Regresa una tabla con la lista de los libros de un mismo autor.
     * @param frame ventana sobre la que se despliega el mensaje de error
     * @return objeto de tabla con todos los libros de un mismo autor, null si hay error.
     */
    public Tabla getTablaLibrosAutor(JFrame frame) throws PersistenciaException 
    {
        List<Libro> listaLibros = null;
        String autor = JOptionPane.showInputDialog(frame, "Autor: ", "Consulta libros por autor", JOptionPane.QUESTION_MESSAGE);
        if(autor==null)return null;
        try
        {
            // Obtiene la lista de libros
            if(persistencia.consultarLibrosAutor(autor)!=null)
            {
                listaLibros=persistencia.consultarLibrosAutor(autor);
            }
        }
        catch (PersistenciaException e) {
        // Si ocurrio un error al obtener la lista de la base de datos,
        // despliega mensaje de error
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
        JOptionPane.ERROR_MESSAGE);
        return null;
        }
        // Regresa el objeto Tabla con todos los libros del mismo autor
        return new Tabla("Lista de Libros del autor",conversiones.librosTableModelAutor(listaLibros));
        
    }
    /**
     * Regresa una tabla con la lista de todos los libros de una misma clasificación.
     * @param frame ventana sobre la que se despliega el mensaje de error
     * @return objeto de tabla con los libros de la misma clasificación, null si hay error.
     */
    public Tabla getTablaLibrosClasificacion(JFrame frame) 
    {
        List<Libro> listaLibros = null;
        String clasificacion = JOptionPane.showInputDialog(frame, "Clasificacion: ", "Consulta libros por clasificacion", JOptionPane.QUESTION_MESSAGE);
        if(clasificacion==null){return new Tabla("No se indico la clasificacion",conversiones.librosTableModelClasificacion(listaLibros));}
        try
        {
            // Obtiene la lista de libros
            if(persistencia.consultarLibrosClasificacion(clasificacion)!=null)
            {
                listaLibros=persistencia.consultarLibrosClasificacion(clasificacion);
            }
        }
        catch (PersistenciaException e) {
        // Si ocurrio un error al obtener la lista de la base de datos,
        // despliega mensaje de error
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
        JOptionPane.ERROR_MESSAGE);
        return null;
        }
        // Regresa el objeto Tabla con todos los libros del mismo autor
        return new Tabla("Lista de libros de esa clasificacion",conversiones.librosTableModelClasificacion(listaLibros));
    }
    /**
     * Regresa una tabla con la lista de libros de la misma editorial..
     * @param frame ventana sobre la que se despliega el mensaje de error
     * @return objeto de tabla con todos los libros de la misma editorial, null si hay error.
     */
    public Tabla getTablaLibrosEditorial(JFrame frame) 
    {
        List<Libro> listaLibros = null;
        String editorial = JOptionPane.showInputDialog(frame, "Editorial: ", "Consulta libros por editorial", JOptionPane.QUESTION_MESSAGE);
        if(editorial==null){return new Tabla("No se indico la editorial",conversiones.librosTableModelAutor(listaLibros));}
        try
        {
            // Obtiene la lista de libros
            if(persistencia.consultarLibrosEditorial(editorial)!=null)
            {
                listaLibros=persistencia.consultarLibrosEditorial(editorial);
            }
        }
        catch (PersistenciaException e) {
        // Si ocurrio un error al obtener la lista de la base de datos,
        // despliega mensaje de error
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
        JOptionPane.ERROR_MESSAGE);
        return null;
        }
        // Regresa el objeto Tabla con todos los libros del mismo autor
        return new Tabla("Lista de libros de la editorial",conversiones.librosTableModelEditorial(listaLibros));
    }
    /**
     * Regresa una lista de todos los prestamos
     * @param frame ventana que envía el mensaje de error.
     * @return una lista de todos los prestamos.
     */
    public Tabla getTablaPrestamos(JFrame frame)
    {
        List<Prestamo>prestamos=null;
        try
        {
            if(persistencia.consultarPrestamosLibros()!=null)
            {
                prestamos=persistencia.consultarPrestamosLibros();
            }
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Tabla("Lista de prestamos",conversiones.prestamoLibrosTableModel(prestamos));
    }
    /**
     * Regresa una tabla de los libros que actualmente están prestados
     * @param frame ventana que se usa para notificar un error si es que lo hay.
     * @return una tabla con los libros prestados.
     */
    public Tabla getTablaLibrosPrestados(JFrame frame)
    {
        List<PublicacionED>publicacionED=null;
        try
        {
            if(persistencia.consultarLibrosPrestados()!=null)
            {
                publicacionED=persistencia.consultarLibrosPrestados();
            }
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Tabla("Lista de libros prestados",conversiones.librosPrestados(publicacionED));
    }
    /**
     * Regresa una tabla con los libros que tienen una disponibilidad mayor a 0
     * @param frame ventana para notificar error.
     * @return una tabla con los libros disponibles para prestamo.
     */
    public Tabla getTablaLibrosDisponibles(JFrame frame)
    {
        List<PublicacionED>publicacionED=null;
        try
        {
            if(persistencia.consultarLibrosDisponibles()!=null)
            {
                publicacionED=persistencia.consultarLibrosDisponibles();
            }
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Tabla("Lista de libros disponibles",conversiones.librosDisponibles(publicacionED));
    }
    /**
     * Regresa una tabla de los prestamos que tiene cada usuarios.
     * @param frame ventana para notificar error
     * @return una tabla de los prestamos de un usuario.
     */
    public Tabla getTablaPrestamosUsuarios(JFrame frame)
    {
        List<Prestamo> listaPrestamosUsuarios = null;
        String numeroCredencial = JOptionPane.showInputDialog(frame, "Numero de credencial ", "Consulta prestamos por usuario", JOptionPane.QUESTION_MESSAGE);
        Usuario usuario=new Usuario(numeroCredencial);
        try
        {
            // Obtiene la lista de libros
            if(persistencia.consultarPrestamosLibros(usuario)!=null)
            {
                listaPrestamosUsuarios=persistencia.consultarPrestamosLibros(usuario);
            }
        }
        catch (PersistenciaException e) {
        // Si ocurrio un error al obtener la lista de la base de datos,
        // despliega mensaje de error
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
        JOptionPane.ERROR_MESSAGE);
        return null;
        }
        // Regresa el objeto Tabla con todos los libros del mismo autor
        return new Tabla("Lista de Libros del autor",conversiones.prestamoLibrosUsuariosTableModel(listaPrestamosUsuarios));
    }
    /**
     * Muestra una tabla de los prestamos de un mismo libro 
     * @param frame ventana para notificar error.
     * @return una tabla de los prestamos de un libro.
     */
    public Tabla getTablaPrestamosLibrosLibro(JFrame frame)
    {
        List<Prestamo>listaPrestamosLibrosLibro=null;
        String isbn = JOptionPane.showInputDialog(frame, "ISBN ", "Consulta prestamos por libro", JOptionPane.QUESTION_MESSAGE);
        Libro libro=new Libro(isbn);
        try
        {
            // Obtiene la lista de libros
            if(persistencia.consultarPrestamos(libro)!=null)
            {
                listaPrestamosLibrosLibro=persistencia.consultarPrestamos(libro);
            }
        }
        catch (PersistenciaException e) {
        // Si ocurrio un error al obtener la lista de la base de datos,
        // despliega mensaje de error
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
        JOptionPane.ERROR_MESSAGE);
        return null;
        }
        // Regresa el objeto Tabla con todos los libros del mismo autor
        return new Tabla("Lista de Libros del autor",conversiones.prestamoLibrosLibrosTableModel(listaPrestamosLibrosLibro));   
    }
    /**
     * Una tabla que muestra los prestamos de libros dentro de un periodo
     * @param frame ventana que notifica error.
     * @return una tabla que muestra los prestamos de libros dentro de un periodo.
     */
    public Tabla getTablaPrestamosLibrosPeriodo(JFrame frame)
    {
        Periodo periodo;
        StringBuffer respuesta=new StringBuffer("");
        DlgPeriodo dlgPeriodo;
        List<Prestamo> listaPrestamosLibrosPeriodo;
        periodo=new Periodo();
        dlgPeriodo=new DlgPeriodo(frame,"Captura de datos del periodo",true,periodo,ConstantesGUI.AGREGAR,respuesta);
        try
        {
            listaPrestamosLibrosPeriodo=persistencia.consultarPrestamosLibros(periodo);
        }
        catch(PersistenciaException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return new Tabla("Lista de prestamos dentro del periodo",conversiones.prestamoLibrosPeriodoTableModel(listaPrestamosLibrosPeriodo));
    }
}
