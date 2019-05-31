/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaso;

/**
 *
 * @author USUARIO
 */
public class Nodo {
    public int servicios;
    public String nombre;
    public Nodo siguiente;
    public Nodo raiz;
    public Nodo fondo;
	public int getServicios() {
		return servicios;
	}
	public void setServicios(int servicios) {
		this.servicios = servicios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	public Nodo getFondo() {
		return fondo;
	}
	public void setFondo(Nodo fondo) {
		this.fondo = fondo;
	}
    
    
}
