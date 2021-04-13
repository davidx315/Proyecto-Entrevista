/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Productos {
    private int id;
    private float  valorProducto;
    private String codigoPedido,nombreProducto,descripcionProducto;

    public Productos(int id,String codigoPedido, String nombreProducto, String descripcionProducto, float valorProducto) {
        this.id = id;      
        this.codigoPedido = codigoPedido;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.valorProducto = valorProducto;
    }

    public int getId() {
        return id;
    }

    public float getValorProducto() {
        return valorProducto;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValorProducto(float valorProducto) {
        this.valorProducto = valorProducto;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }


    
}
