# Documento Arquitectonico - Sistema de Gestion de Casos Clinicos

## 1. Contexto del sistema

La clinica necesita registrar resultados de examenes y detectar valores fuera del rango permitido de forma rapida. El flujo seleccionado es puntual: registrar un resultado de examen clinico, evaluar el rango normal y responder si se genero una alerta.

Usuarios principales:

- Personal medico: consulta resultados y atiende alertas.
- Enfermeria: apoya el registro y seguimiento.
- Analistas clinicos: registran resultados de examenes.
- Personal administrativo: consulta informacion operativa basica.

Alcance incluido:

- registro de resultado de examen clinico,
- validacion de datos obligatorios basicos,
- validacion de rango permitido,
- generacion de alerta si el valor esta fuera de rango,
- endpoint REST funcional,
- persistencia temporal en memoria.

Alcance no incluido:

- autenticacion completa,
- historia clinica completa,
- agenda medica,
- facturacion,
- integracion con laboratorios externos,
- base de datos productiva.

## 2. Drivers arquitectonicos

Drivers funcionales:

- Registrar resultados de examenes clinicos mediante una API REST.
- Validar si el valor del examen esta dentro del rango permitido.
- Generar una alerta cuando el resultado esta fuera del rango normal.

Drivers no funcionales:

- Mantenibilidad: el sistema debe permitir agregar nuevos tipos de examenes o reglas sin mezclar responsabilidades.
- Disponibilidad: el servicio debe responder cuando el personal clinico necesite registrar o consultar el resultado del flujo.
- Seguridad: la informacion clinica es sensible y debe tratarse con controles claros en futuras extensiones.

## 3. Atributos de calidad

Mantenibilidad:

- Impacto: facilita modificar reglas de validacion y agregar nuevos examenes.
- Trade-off: aumenta el numero de paquetes, interfaces y clases.
- Riesgo: si las capas se mezclan, los cambios futuros seran costosos.

Disponibilidad:

- Impacto: el registro de resultados debe estar disponible para evitar retrasos en el analisis clinico.
- Trade-off: en produccion requeriria monitoreo, despliegue controlado y recuperacion ante fallos.
- Riesgo: una caida del servicio retrasa la deteccion de resultados criticos.

Seguridad:

- Impacto: protege datos sensibles del paciente.
- Trade-off: controles de acceso, auditoria y validaciones aumentan la complejidad.
- Riesgo: exposicion o manejo inadecuado de informacion clinica.

## 4. Estilo arquitectonico seleccionado

Se usa Clean Architecture aplicada con estilo hexagonal. La solucion separa el dominio, la aplicacion y los adaptadores de infraestructura para que la regla clinica principal no dependa de Spring Boot ni del mecanismo de almacenamiento.

Esta decision es adecuada porque el alcance es pequeno y academico, pero permite demostrar separacion de responsabilidades, puertos, adaptadores, reglas de negocio y pruebas unitarias. Microservicios, SOA o Event-Driven agregarian complejidad innecesaria para este flujo.

## 5. Componentes y responsabilidades

- API REST: recibe solicitudes HTTP para registrar resultados.
- Controlador: transforma el request en modelo de dominio y devuelve la respuesta.
- Caso de uso: coordina validaciones, guardado y generacion de alerta.
- Dominio: representa el examen clinico y la alerta clinica.
- Puerto de salida: define el contrato de persistencia.
- Repositorio en memoria: guarda temporalmente los examenes registrados.
- Configuracion: arma las dependencias entre puertos, caso de uso y adaptadores.

## 6. Patrones utilizados

Repository:

El caso de uso depende del contrato `ClinicalExamRepository`, no de una base de datos concreta. Esto desacopla la logica de negocio del almacenamiento.

Adapter:

El controlador REST y el repositorio en memoria actuan como adaptadores. Conectan el nucleo de la aplicacion con HTTP y persistencia temporal sin contaminar el dominio.

Dependency Injection:

Spring configura las dependencias en `ClinicalExamConfig`, permitiendo reemplazar implementaciones sin cambiar el caso de uso.

## 7. ADRs y diagramas

Las decisiones arquitectonicas estan documentadas en `docs/adr/`.

Los diagramas editables estan en `docs/diagrams/`:

- `componentes.puml`
- `secuencia.puml`
- `despliegue.puml`
- `paquetes.puml`
- `archimate.puml`
