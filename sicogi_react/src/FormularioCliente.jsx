import React, { useState } from "react";

function FormularioCliente({ agregarCliente }) {
  const [nombre, setNombre] = useState("");
  const [correo, setCorreo] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    // Creamos objeto cliente
    const nuevoCliente = {
      nombre,
      correo,
    };

    agregarCliente(nuevoCliente);

    // Limpiar campos
    setNombre("");
    setCorreo("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Registrar Cliente</h3>

      <input
        type="text"
        placeholder="Nombre"
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
      />

      <input
        type="email"
        placeholder="Correo"
        value={correo}
        onChange={(e) => setCorreo(e.target.value)}
      />

      <button type="submit">Guardar</button>
    </form>
  );
}

export default FormularioCliente;