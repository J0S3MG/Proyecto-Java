# 👨‍👩‍👧‍👦 Gestión de Personas y Tareas (Vaadin Flow & Spring Boot) 📝

Este proyecto es una aplicación web full-stack diseñada para la gestión integral de **Personas** y las **Tareas** que tienen asignadas. Desarrollada con el framework **Vaadin Flow** para la interfaz de usuario y **Spring Boot** para el backend, combina la flexibilidad de bases de datos relacionales y NoSQL para una persistencia robusta y segura.

## ✨ Características Principales

* **Gestión Completa de Personas (CRUD):**
    * Interfaz para **Crear, Leer, Actualizar y Eliminar** registros de personas.
    * Campos de persona incluyen nombre, apellido, edad y DNI.
    * Manejo seguro de datos sensibles: `email` y `password` de las personas se almacenan en **MongoDB**, desacoplados de la entidad principal relacional.
* **Gestión de Tareas:**
    * Asigna tareas a personas específicas.
    * Registra la descripción, fechas de inicio y finalización, y el estado de completado de cada tarea.
* **Arquitectura de Persistencia Híbrida:**
    * **PostgreSQL (JPA/Hibernate):** Base de datos relacional principal para almacenar la información de `Persona` y `Tarea`, garantizando la integridad referencial y las propiedades ACID.
    * **MongoDB:** Base de datos NoSQL utilizada estratégicamente para almacenar datos más flexibles y/o sensibles como `email` y `password` de los usuarios, aprovechando su modelo de documento.
    * **Redis:** Para el cacheo de los datos como `email` y `password` para mejoran la experiencia de usuario y aligerar la carga de la base de datos ya que se hacen menos consultas a la misma.
* **Interfaz de Usuario Dinámica (Vaadin Flow):**
    * Aplicación interactiva y responsiva construida con componentes de Vaadin, proporcionando una experiencia de usuario fluida y moderna.
    * **Filtrado Dinámico:** Funcionalidad de búsqueda en tiempo real para filtrar listas de personas y tareas por diversos criterios.
    * **Diálogos de Confirmación:** Modales para operaciones críticas (ej. eliminación), mejorando la seguridad y la usabilidad.
    * **Navegación Intuitiva:** Transición sencilla entre las vistas de gestión de Personas y Tareas.
* **Base Robusta de Spring Boot:**
    * Configuración simplificada, inyección de dependencias y facilidad de despliegue gracias al ecosistema de Spring Boot.

## 🚀 Tecnologías Utilizadas

| Tecnología              | Descripción                                                                                                                           |
| :---------------------- | :------------------------------------------------------------------------------------------------------------------------------------ |
| **Java 21**             | Versión de soporte extendido (LTS) del lenguaje, aprovechando características modernas como Virtual Threads para mayor escalabilidad. |
| **Spring Boot 3.5.0**   | Framework principal para agilizar el desarrollo de aplicaciones robustas, configurables y listas para producción.                     |
| **Spring Data JPA**     | Abstracción que simplifica el acceso a datos relacionales utilizando Hibernate como motor de persistencia de objetos.                 |
| **Spring Data MongoDB** | Módulo encargado de la integración fluida con MongoDB para el manejo de persistencia NoSQL orientada a documentos.                    |
| **Spring Data Redis**   | Implementación para el manejo de caché y estructuras de datos en memoria para optimizar la velocidad del sistema.                     |
| **Vaadin Flow 24.7.6**  | Framework de frontend que permite construir interfaces web modernas y dinámicas programando completamente en Java.                    |
| **PostgreSQL**          | Sistema de gestión de bases de datos relacionales de código abierto, robusto y altamente escalable.                                   |
| **MongoDB**             | Base de datos NoSQL de alto rendimiento utilizada para el almacenamiento flexible de datos no estructurados.                          |
| **Maven**               | Herramienta de gestión de dependencias y automatización del ciclo de vida de construcción del proyecto.                               | 
---
