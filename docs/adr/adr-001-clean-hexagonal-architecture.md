# ADR 001 - Usar Clean Architecture con estilo hexagonal

## Estado

Aceptada.

## Contexto

El sistema debe mostrar una mini implementacion funcional, organizada y facil de explicar. El flujo elegido registra resultados de examenes clinicos y genera alertas cuando el resultado esta fuera de rango.

## Decision

Usar Clean Architecture aplicada con estilo hexagonal, separando dominio, aplicacion, puertos y adaptadores.

## Consecuencias

- La logica clinica queda desacoplada de Spring Boot.
- La solucion es mas facil de probar y mantener.
- Aparecen mas clases e interfaces, pero la separacion de responsabilidades queda mas clara.
