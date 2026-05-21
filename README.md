# Sistema de Gestion de Casos Clinicos

Mini implementacion en Java 17 y Spring Boot para registrar resultados de examenes clinicos y generar una alerta cuando el valor queda fuera del rango permitido.

El proyecto aplica Clean Architecture con estilo hexagonal: el dominio contiene las reglas clinicas, la aplicacion coordina el caso de uso, los puertos definen contratos y los adaptadores conectan REST y persistencia en memoria.

## Endpoint principal

```http
POST /clinical-exams
```

Body de ejemplo:

```json
{
  "patientId": "P001",
  "patientName": "Maria Gomez",
  "examType": "Glucosa",
  "examValue": 150,
  "minNormalValue": 70,
  "maxNormalValue": 110
}
```

Respuesta esperada:

```json
{
  "patientId": "P001",
  "patientName": "Maria Gomez",
  "examType": "Glucosa",
  "examValue": 150,
  "alertGenerated": true,
  "alertMessage": "Resultado fuera del rango permitido"
}
```

## Estructura

- `domain/model`: entidades y reglas del negocio clinico.
- `application/ports/in`: contratos de casos de uso.
- `application/ports/out`: contratos hacia infraestructura.
- `application/usecase`: implementacion del caso de uso.
- `adapters/in/rest`: controlador y DTOs REST.
- `adapters/out/persistence`: repositorio en memoria.
- `config`: armado de dependencias de Spring.
- `docs`: documento arquitectonico, ADRs y diagramas editables.

## Ejecutar localmente

```bash
mvn spring-boot:run
```

Probar el endpoint:

```bash
curl -X POST http://localhost:8080/clinical-exams \
  -H "Content-Type: application/json" \
  -d "{\"patientId\":\"P001\",\"patientName\":\"Maria Gomez\",\"examType\":\"Glucosa\",\"examValue\":150,\"minNormalValue\":70,\"maxNormalValue\":110}"
```

## Pruebas

```bash
mvn test
```

Las pruebas cubren:

- alerta cuando el resultado esta fuera de rango,
- respuesta sin alerta cuando el resultado esta dentro de rango,
- validacion de `patientId` obligatorio,
- validacion de rango normal invalido.

## Docker

Construir imagen:

```bash
docker build -t casos-clinicos .
```

Ejecutar contenedor:

```bash
docker run --rm -p 8080:8080 casos-clinicos
```

## Documentacion

- Documento arquitectonico: `docs/documento-arquitectonico.md`
- ADRs: `docs/adr/`
- Diagramas editables PlantUML: `docs/diagrams/`
