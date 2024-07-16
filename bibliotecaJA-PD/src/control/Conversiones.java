/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import excepciones.PersistenciaException;
import objetosServicios.*;
import java.util.List; 
import javax.swing.DefaultComboBoxModel; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import objetosNegocio.Libro;
import objetosNegocio.Publicacion;
import objetosNegocio.Prestamo;
import objetosNegocio.PublicacionED;
import objetosNegocio.Usuario;
/**
 ** Esta clase contiene métodos que generan objetos del tipo DefaultTableModel 
 *  y DefaultComboBoxModel para crear instancias de Jtable y JComboBox.
 * @author jvale
 */
public class Conversiones 
{
    // Arreglos con los nombres de las columnas de las tablas
    String nombresColumnasTablasLibros[]={"Isbn","Titulo","Editorial","Clasificacion","Autor","Edicion"};
    String nombresColumnasTablaLibrosAutor[] = {"Isbn","Autor","Titulo","Editorial","Clasificación","Edicion"};
    String nombresColumnasTablaLibrosClasificacion[]={"Isbn","Clasificacion","Titulo","Editorial","Autor","Edicion"};
    String nombresColumnasTablaLibrosEditorial[]={"Isbn","Editorial","Titulo","Clasificacion","Autor","Edicion"};
    String nombresColumnasTablasUsuarios[] = {"Numero credencial","Nombre", "Direccion", "Telefono", "Multa"};
    String nombresColumnasTablasinventarioLibros[] = {"Publicacion", "Existencia", "Disponibilidad"};
    String nombresColumnasTablasprestamoLibros[] = {"Usuario", "Publicacion", "fechaPrestamo","tiempoPrestamo"};
    String nombreColumnasTablasLibrosPrestados[]={"PublicacionesED","Existencia","Disponibilidad"};
    String nombresColumnasTablasLibrosDiponibles[]={"PublicacionesED","Disponibilidad"};
    String nombresColumnasTablasPrestamosUsuarios[]={"Usuario","Publicacion","tiempo","fecha de prestamo"};
    String nombresColumnasTablasPrestamosLibrosLibro[]={"Publicacion","Usuarios","tiempo","fecha de prestamo"};
    String nombresColumnasTablasPrestamosPeriodo[]={"Publicacion","Usuario","Tiempo","Fecha de prestamo"};
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de libros.
    * @param listaLibros Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los libros
    */
    public DefaultTableModel librosTableModel(List<Libro>listaLibros)
    {
        Object tabla[][];
        if(listaLibros!=null)
        {
            tabla=new Object[listaLibros.size()][6];
            for(int i=0;i<listaLibros.size();i++)
            {
                //obtiene un libro de la lista libros
                Libro libro=listaLibros.get(i);
                //Almacena los atributos en la fila del arreglo
                tabla[i][0]=libro.getIsbn();
                tabla[i][1]=libro.getTitulo();
                tabla[i][2]=libro.getEditorial();
                tabla[i][3]=libro.getClasificacion();
                tabla[i][4]=libro.getAutor();
                tabla[i][5]=libro.getEdicion();
            }
            return new DefaultTableModel(tabla,nombresColumnasTablasLibros);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de libros.
    * @param listaLibros Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los libros
    */
    public DefaultTableModel librosTableModelAutor(List<Libro> listaLibros)
    {
        Object tabla[][];
        if (listaLibros != null) 
        {
            tabla = new Object[listaLibros.size()][6];
            for (int i = 0; i < listaLibros.size(); i++) 
            {
                // Obten un libro de la listaLibros
                Libro libro = listaLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0]=libro.getIsbn();
                tabla[i][1] = libro.getAutor(); 
                tabla[i][2]=libro.getTitulo();
                tabla[i][3]=libro.getEditorial();
                tabla[i][4]=libro.getClasificacion();
                tabla[i][5]=libro.getEdicion();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablaLibrosAutor);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de libros.
    * @param listaLibros Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los libros
    */
    public DefaultTableModel librosTableModelClasificacion(List<Libro> listaLibros)
    {
        Object tabla[][];
        if (listaLibros != null) 
        {
            tabla = new Object[listaLibros.size()][6];
            for (int i = 0; i < listaLibros.size(); i++) 
            {
                // Obten un libro de la listaLibros
                Libro libro = listaLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0]=libro.getIsbn();
                tabla[i][1] = libro.getClasificacion();
                tabla[i][2]=libro.getTitulo();
                tabla[i][3]=libro.getEditorial();
                tabla[i][4]=libro.getAutor();
                tabla[i][5]=libro.getEdicion();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablaLibrosClasificacion);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de libros.
    * @param listaLibros Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los libros
    */
    public DefaultTableModel librosTableModelEditorial(List<Libro> listaLibros)
    {
        Object tabla[][];
        if (listaLibros != null) 
        {
            tabla = new Object[listaLibros.size()][6];
            for (int i = 0; i < listaLibros.size(); i++) 
            {
                // Obten una canción de la lista de canciones
                Libro libro = listaLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0]=libro.getIsbn();
                tabla[i][1] = libro.getEditorial(); 
                tabla[i][2]=libro.getTitulo();
                tabla[i][3]=libro.getClasificacion();
                tabla[i][4]=libro.getAutor();
                tabla[i][5]=libro.getEdicion();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablaLibrosEditorial);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de usuarios.
    * @param listaUsuarios Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los usuarios.
    */
    public DefaultTableModel usuariosTableModel(List<Usuario> listaUsuarios)
    {
        Object tabla[][];
        if (listaUsuarios != null) 
        {
            tabla = new Object[listaUsuarios.size()][5];
            for (int i = 0; i < listaUsuarios.size(); i++) 
            {
                // Obten un usuario de la listaUsuarios
                Usuario usuario = listaUsuarios.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = usuario.getNumCredencial();
                tabla[i][1] = usuario.getNombre();
                tabla[i][2] = usuario.getDireccion();
                tabla[i][3] = usuario.getTelefono();
                tabla[i][4] = usuario.getMulta();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasUsuarios);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista del inventario de libros.
    * @param listaInventarioLibros Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos del inventario.
    */
    public DefaultTableModel inventarioLibrosTableModel(List<PublicacionED>listaInventarioLibros) 
    {
        Object tabla[][];
        if (listaInventarioLibros != null) 
        {
            tabla = new Object[listaInventarioLibros.size()][3];
            for (int i = 0; i < listaInventarioLibros.size(); i++) 
            {
                // Obten un una publicacion de la listaInventarioLibros
                PublicacionED publicacionED=listaInventarioLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = publicacionED.getPublicacion();
                tabla[i][1] = listaInventarioLibros.get(i).getExistencia();
                tabla[i][2] = listaInventarioLibros.get(i).getDisponibilidad();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasinventarioLibros);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de prestamos de libros.
    * @param listaPrestamosLibros Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los prestamos de libros.
    */
    public DefaultTableModel prestamoLibrosTableModel(List<Prestamo> listaPrestamosLibros) 
    {
        Object tabla[][];
        if (listaPrestamosLibros != null) 
        {
            tabla = new Object[listaPrestamosLibros.size()][4];
            for (int i = 0; i < listaPrestamosLibros.size(); i++) 
            {
                // Obten un prestamo de listaPrestamoLibros
                Prestamo prestamo = listaPrestamosLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = prestamo.getUsuario();
                tabla[i][1] = prestamo.getPublicacion();
                tabla[i][2] = prestamo.getFechaPrestamo();
                tabla[i][3] = prestamo.getTiempoPrestamo();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasprestamoLibros);
        }
        return null;
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de prestamos de libros.
    * @param listaPrestamosLibrosUsuarios Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los prestamos de libros.
    */
    public DefaultTableModel prestamoLibrosUsuariosTableModel(List<Prestamo>listaPrestamosLibrosUsuarios)
    {
        Object tabla[][];
        if(listaPrestamosLibrosUsuarios!=null)
        {
            tabla=new Object[listaPrestamosLibrosUsuarios.size()][4];
            for (int i = 0; i < listaPrestamosLibrosUsuarios.size(); i++) 
            {
                // Obten un prestamo de listaPrestamoLibros
                Prestamo prestamo = listaPrestamosLibrosUsuarios.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = prestamo.getUsuario();
                tabla[i][1] = prestamo.getPublicacion();
                tabla[i][2] = prestamo.getFechaPrestamo();
                tabla[i][3] = prestamo.getTiempoPrestamo();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasPrestamosUsuarios);
        }
        return null; 
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de prestamos de libros.
    * @param listaPrestamosLibrosLibro Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los prestamos de libros.
    */
    public DefaultTableModel prestamoLibrosLibrosTableModel(List<Prestamo>listaPrestamosLibrosLibro)
    {
        Object tabla[][];
        if(listaPrestamosLibrosLibro!=null)
        {
            tabla=new Object[listaPrestamosLibrosLibro.size()][4];
            for (int i = 0; i < listaPrestamosLibrosLibro.size(); i++) 
            {
                // Obten un prestamo de listaPrestamoLibros
                Prestamo prestamo = listaPrestamosLibrosLibro.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = prestamo.getPublicacion();
                tabla[i][1] = prestamo.getUsuario();
                tabla[i][2] = prestamo.getFechaPrestamo();
                tabla[i][3] = prestamo.getTiempoPrestamo();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasPrestamosLibrosLibro);
        }
        return null; 
    }
    /**
    * Genera un objeto de tipo DefaultTableModel a partir de una lista de prestamos de libros.
    * @param listaPrestamosLibrosPeriodo Lista de libros a convertir
    * @return Objeto de tipo DefaultTableModel con los atributos de los prestamos de libros.
    */
    public DefaultTableModel prestamoLibrosPeriodoTableModel(List<Prestamo>listaPrestamosLibrosPeriodo)
    {
        Object tabla[][];
        if(listaPrestamosLibrosPeriodo!=null)
        {
            tabla=new Object[listaPrestamosLibrosPeriodo.size()][4];
            for (int i = 0; i < listaPrestamosLibrosPeriodo.size(); i++) 
            {
                // Obten un prestamo de listaPrestamoLibros
                Prestamo prestamo = listaPrestamosLibrosPeriodo.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = listaPrestamosLibrosPeriodo.get(i).getPublicacion();
                tabla[i][1] = listaPrestamosLibrosPeriodo.get(i).getUsuario();
                tabla[i][2] = prestamo.getTiempoPrestamo();
                tabla[i][3] = prestamo.getFechaPrestamo();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasPrestamosPeriodo);
        }
        return null; 
    }
    /**
    *Convierte una lista de libros a un objeto de tipo DefaultComboBoxModel
    * @param listaLibros lista libros
    * @return los atributos de los libros.
    */
    public DefaultComboBoxModel librosComboBoxModel(List<Libro> listaLibros)
    {
        DefaultComboBoxModel<Libro> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (listaLibros != null) 
        {
            // Para cada elemento de la Lista
            for (int i = 0; i < listaLibros.size(); i++)
            {
                // Agregalo a la instancia de la clase DefaultComboBoxModel
                defaultComboBoxModel.addElement(listaLibros.get(i));
            }
            return defaultComboBoxModel; 
        }
        return null;
    }
    /**
    *Convierte una lista de usuarios a un objeto de tipo DefaultComboBoxModel
    * @param listaUsuarios
    * @return los atributos de los usuarios
    */
    public DefaultComboBoxModel usuariosComboBoxModel(List<Usuario> listaUsuarios) 
    {
        DefaultComboBoxModel<Usuario> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (listaUsuarios != null) 
        {
            // Para cada elemento de la Lista
            for (int i = 0; i < listaUsuarios.size(); i++)
            {
                // Agregalo a la instancia de la clase DefaultComboBoxModel
                String numCredencial=listaUsuarios.get(i).getNumCredencial();
                String nombre=listaUsuarios.get(i).getNombre();
                String telefono=listaUsuarios.get(i).getTelefono();
                String direccion=listaUsuarios.get(i).getDireccion();
                float multa=listaUsuarios.get(i).getMulta();
                defaultComboBoxModel.addElement(new Usuario(numCredencial,nombre,direccion,telefono,multa));
            }
            return defaultComboBoxModel; 
        }
        return null;
    }
    /**
     * Crea la tabla que se mostrará para los libros prestados
     * @param listaInventarioLibros
     * @return return un modelo de tabla.
     */
    public DefaultTableModel librosPrestados(List<PublicacionED>listaInventarioLibros) 
    {
        Object tabla[][];
        if (listaInventarioLibros != null) 
        {
            tabla = new Object[listaInventarioLibros.size()][3];
            for (int i = 0; i < listaInventarioLibros.size(); i++) 
            {
                // Obten un una publicacion de la listaInventarioLibros
                PublicacionED publicacionED=listaInventarioLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = publicacionED.getPublicacion();
                tabla[i][1] = listaInventarioLibros.get(i).getExistencia();
                tabla[i][2] = listaInventarioLibros.get(i).getDisponibilidad();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasinventarioLibros);
        }
        return null;
    }
    /**
     * Crea una tabla que mostrara los libros disponibles
     * @param listaInventarioLibros
     * @return un modelo de tabla.
     */
    public DefaultTableModel librosDisponibles(List<PublicacionED>listaInventarioLibros) 
    {
        Object tabla[][];
        if (listaInventarioLibros != null) 
        {
            tabla = new Object[listaInventarioLibros.size()][2];
            for (int i = 0; i < listaInventarioLibros.size(); i++) 
            {
                // Obten un una publicacion de la listaInventarioLibros
                PublicacionED publicacionED=listaInventarioLibros.get(i);
                // Almacena sus atributos en la fila del arreglo
                tabla[i][0] = publicacionED.getPublicacion();
                tabla[i][1] = publicacionED.getDisponibilidad();
            }
            return new DefaultTableModel(tabla,nombresColumnasTablasLibrosDiponibles);
        }
        return null;
    }
}
