# ADR 002 - Usar repositorio en memoria para la mini implementacion

## Estado

Aceptada.

## Contexto

El trabajo requiere una evidencia funcional pequena. Una base de datos real aumentaria la configuracion y desviaria el foco de la arquitectura y del caso de uso principal.

## Decision

Implementar `ClinicalExamRepository` con un adaptador en memoria.

## Consecuencias

- La aplicacion puede probarse sin infraestructura externa.
- El caso de uso queda desacoplado del mecanismo de persistencia.
- Los datos no sobreviven al reinicio de la aplicacion, lo cual es aceptable para la evidencia academica.
