// Importamos Express (framework para crear servidores web)
const express = require('express');

// Creamos la aplicación
const app = express();

// Definimos el puerto
const PORT = 3000;

// Middleware para que el servidor entienda JSON
app.use(express.json());

/*
  Simulación de base de datos
*/
let usuarios = [];

/*
RUTA: REGISTRO
*/
app.post('/registro', (req, res) => {
    const { usuario, contraseña } = req.body;

    if (!usuario || !contraseña) {
        return res.status(400).json({ mensaje: "Faltan datos" });
    }

    const existe = usuarios.find(u => u.usuario === usuario);

    if (existe) {
        return res.status(400).json({ mensaje: "El usuario ya existe" });
    }

    usuarios.push({ usuario, contraseña });

    res.status(201).json({ mensaje: "Usuario registrado correctamente" });
});

/*
RUTA: LOGIN
*/
app.post('/login', (req, res) => {
    const { usuario, contraseña } = req.body;

    if (!usuario || !contraseña) {
        return res.status(400).json({ mensaje: "Faltan datos" });
    }

    const user = usuarios.find(
        u => u.usuario === usuario && u.contraseña === contraseña
    );

    if (user) {
        return res.json({ mensaje: "Autenticación satisfactoria" });
    }

    res.status(401).json({ mensaje: "Credenciales incorrectas" });
});

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
