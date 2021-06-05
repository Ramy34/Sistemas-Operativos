/*Ing. Patricia Del Valle Morales*/


class Cola_LSE {
   //ATRIBUTOS
   
   private Nodo H; 		   // H: referencia al primer elemento de la lista
   private Nodo T;         //T: referencia al último elemento de la lista
  
   //MÉTODOS PUBLICOS
   //_________________
	
   public boolean ListaVacia() {
      return H == null){
   }
  
    // Añadir un elemento al final de la lista

   public void InsertarAlFinal(int num){
      Nodo q = new Nodo(num, null);
   
      if (T == null)
         H=T=q;
      else{
         T.SetSiguiente(q);
         T=q;
      }
   }

	//Borra un nodo de la lista
	
   public Nodo Borrar() {
      Nodo aux =H;
      if (H==null)
         System.out.println("\nLista vacia....");
      else if (H == T)
         H=T=null;
      else 
         H = H.GetSiguiente();
      return aux;
   }
		
		
	//Despliega todos los nodo de la lista
   public void Listar()
   {
      System.out.println("\n");
      // Recorrer la lista
      Nodo q = H; // referencia al primer elemento
      while (q != null){
         System.out.print(q.GetDato() + " ");
         q = q.GetSiguiente() ;
      }
      System.out.println("\n");
   }
}