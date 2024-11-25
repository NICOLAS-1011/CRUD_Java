function filtrarProductos() {
  // Obtener el valor del campo de búsqueda
  const filtro = document.getElementById('search-field').value.toLowerCase();
  
  // Obtener la lista de productos
    const productos = document.querySelectorAll('#tablaProductos .mdl-card');

  // Iterar sobre los productos y mostrar/ocultar según el filtro
  productos.forEach(producto => {
    
    const nombre = producto.querySelector('h4').textContent.toLowerCase();
    
    if (nombre.includes(filtro)) {
      producto.style.display = ''; // Mostrar
    } else {
      producto.style.display = 'none'; // Ocultar
    }
  });
}
