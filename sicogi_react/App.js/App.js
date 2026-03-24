import React, { useState } from "react";
import Navbar from "./components/Navbar";
import FormularioCliente from "./components/FormularioCliente";
import ListaClientes from "./components/ListaClientes";

function App() {
  // Estado donde guardamos clientes
  const [clientes, setClientes] = useState([]);

  // Función para agregar cliente
  const agregarCliente = (cliente) => {
    setClientes([...clientes, cliente]);
  };

  return (
    <div>
      <Navbar />
      <h1>SICOGI - Gestión de Clientes</h1>

      <FormularioCliente agregarCliente={agregarCliente} />
      <ListaClientes clientes={clientes} />
    </div>
  );
}

export default App;