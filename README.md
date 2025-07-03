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

* **Backend:**
    * Java 21
    * Spring Boot 3.5.0
    * Spring Data JPA (con Hibernate)
    * Spring Data MongoDB
    * Spring Data Redis
    * PostgreSQL
    * Maven
* **Frontend:**
    * Vaadin Flow 24.7.6
* **Bases de Datos:**
    * PostgreSQL
    * MongoDB
---
