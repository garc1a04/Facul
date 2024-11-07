package Listas.Interface;

public interface Lista<T> {
	
	public void add(T valor);
	
	public void add(int index, T valor);
	
	public boolean remove(T valor);
	
	public T remove(int index);
	
	public int indexOf(T valor);
	
	public int size();
	
	public void clear();
	
	public T get(int index);
	
	public boolean contais(T Elemento);
	
	public String toString();
}
