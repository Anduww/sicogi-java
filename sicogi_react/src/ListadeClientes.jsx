import React from "react";

function ListaClientes({ clientes }) {
  return (
    <div>
      <h3>Lista de Clientes</h3>

      {clientes.length === 0 ? (
        <p>No hay clientes registrados</p>
      ) : (
        <ul>
          {clientes.map((cliente, index) => (
            <li key={index}>
              {cliente.nombre} - {cliente.correo}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default ListaClientes;