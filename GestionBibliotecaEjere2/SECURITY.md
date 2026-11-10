# SECURITY.md

## 1. Protección de datos sensibles

Para proteger el proyecto y evitar subir archivos innecesarios o que puedan contener información privada, he creado un archivo `.gitignore`.

En este archivo he indicado que Git debe ignorar:

- **Archivos temporales:** como los archivos `.log` y `.tmp`, que no son necesarios para el funcionamiento del programa.
- **Archivos compilados:** como los `.class` y `.jar`, ya que se pueden generar al compilar el proyecto.
- **Carpetas de configuración:** como `.idea` y `nbproject/private`, porque contienen configuraciones propias del equipo.
- **Archivos privados:** como `.env`, claves y certificados, que podrían contener información sensible.
- **Carpetas generadas:** como `target`, que contiene archivos creados automáticamente por Maven.

De esta forma, evitamos subir información privada y mantenemos el repositorio más limpio y organizado.

## 2. Accesibilidad al repositorio

Para facilitar el trabajo en equipo, GitHub permite añadir colaboradores a un repositorio y asignarles diferentes permisos.

Los principales permisos que se pueden utilizar son:

- **Read (lectura):** permite consultar el código y los archivos del proyecto, pero no modificarlos.
- **Write (escritura):** permite modificar el contenido del repositorio y subir cambios.
- **Admin (administrador):** permite gestionar todos los aspectos del repositorio, incluyendo colaboradores y configuración.

Para un trabajo en equipo, considero que el permiso Write es el más adecuado para los compañeros que tengan que modificar el código. El permiso Read sería suficiente para las personas que solo necesiten consultar el proyecto. El permiso Admin debería reservarse para el responsable del repositorio.

## 3. Buenas prácticas de seguridad

Para mantener el repositorio seguro, es recomendable seguir estas prácticas:

- **Proteger las ramas principales:** evitar que cualquier persona pueda modificar directamente la rama principal (`main`).
- **Revisar los cambios:** utilizar Pull Requests para revisar las modificaciones antes de incorporarlas al proyecto.
- **Realizar copias de seguridad:** guardar copias del proyecto periódicamente para evitar perder el trabajo.
- **Controlar los permisos:** dar a cada colaborador únicamente los permisos que necesita.

## 4. Recuperación ante pérdida de datos o errores

Si se produce un error importante o se pierde información, podemos recuperar versiones anteriores del proyecto utilizando el historial de Git.

Git permite consultar los cambios realizados y volver a una versión anterior si es necesario. Además, GitHub mantiene una copia remota del repositorio, por lo que podemos volver a descargar el proyecto si perdemos los archivos de nuestro ordenador.

También es recomendable realizar copias de seguridad adicionales para tener una protección extra.