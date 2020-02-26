# Arquitectura de Software - XYZ Enterprise

<img class="center" src="https://i.imgur.com/EdExvlG.png" alt="XYZ Enterprise">

A continuación, se muestra la arquitectura de software de la aplicación, tanto de gestión interna como de operación del negocio de la empresa de muebles XYZ.

## Contenido

- Descripción del problema.
- Descripción del producto.
- Visión general de la arquitectura.
- Requerimientos principales y atributos de calidad.
- Prácticas fundamentales para el proceso de desarrollo.

## Descripción del problema

La empresa XYZ dedicada a la fabricación y venta de muebles para oficina, decidió sistematizar sus procesos tanto de gestión interna como de operación del negocio. Dado que la empresa es pequeña todos sus registros los manejan usando hojas de cálculo, sin embargo, esto les está causando pérdida información, dificultad para hacer reportes y muchos reclamos de sus usuarios; adicionalmente, la empresa tendrá en los próximos meses una expansión para lo cual crearán una nueva sede para poder ampliar cobertura.

La empresa requiere un sistema que permita gestionar Usuarios, Sedes, Inventario, Cotizaciones, Ventas y Órdenes de Trabajo. También, desean tener unos reportes de cada unos de los módulos en formato de texto y gráficos.

Desean un sistema con tres tipos de usuarios: gerente, vendedores y jefe de taller. El gerente puede gestionar la información relacionada con el sistema y crear los usuarios vendedores y jefe de taller y gestionar las sedes. Los usuarios vendedores pueden gestionar cotizaciones y venta de muebles de oficina. El usuario jefe de taller gestiona las órdenes de trabajo.

Como primer paso hacia la sistematización se establecieron algunas necesidades:

**Gestión de usuarios**

- La empresa desea poder registrar (adicionar o crear) los usuarios que podrán acceder al sistema según el rol que desempeñen en la empresa.
- La empresa desea poder modificar los datos de los usuarios del sistema.
- La empresa desea poder conocer en cualquier momento los usuarios que tiene en el sistema, el rol que desempeñan y su estado (activo/inactivo).

**Gestión de sedes**

- La empresa requiere poder registrar sedes de la empresa.
- La empresa requiere poder modificar los datos de una sede.
- La empresa desea poder conocer en cualquier momento las sedes que tiene en el sistema.

Además, la empresa también necesita gestionar:

- Inventarios.
- Cotizaciones.
- Ventas de muebles de oficina.
- Órdenes de trabajo de muebles de oficina.
- Reportes.

## Descripción del producto

**1. ¿Qué hace el producto?:** El producto de software se encarga de gestionar los usuarios, productos y ventas de una empresa de fabricación y venta de muebles.

**2. Objetivos del producto y valor de negocio:** El objetivo del producto es automatizar los procesos tanto de gestión interna, como de operación del negocio. El valor de negocio se analizará y obtendrá cuando los usuarios finales interactúen de manera intensiva con la aplicación.

**3. Problemas que el producto soluciona:** Mantener la integridad de la información teniendo un control sobre esta a la hora de generar reportes, ya que la empresa está en crecimiento y todos sus registros estaban escritos en hojas de cálculo, generando problemas de redundancia, inconsistencia, incompatibilidad, dificultad para realizar reportes y quejas de los usuarios (clientes). Ahora, dicha información será procesada de forma eficiente, a la vez que será fácilmente accesible y visible para los usuarios correspondientes.

**4. Tipos de empresas y usuarios (objetivo):** Nuestra aplicación está dirigida a empresas pequeñas que se encuentran en crecimiento y requieran automatizar todos sus procesos (gestión interna y operación del negocio). Los usuarios finales de la aplicación serán aquellos que requieran interactuar constantemente con información (datos): gerentes y/o administradores, vendedores y jefes de taller y/o área.

**5. Enlaces a documentación del producto:** Para mayor información del producto, ir al siguiente enlace: [Manual de Usuario - XYZ Enterprise.](https://drive.google.com/open?id=1R18Prf5Y_XkBQXPzHLhz-_Lc02uY59WQr7DAnmS-Kuo "Manual de Usuario - XYZ Enterprise")

## Visión general de la arquitectura

**1. Descripción general de la arquitectura:** La arquitectura del producto está compuesta de la siguiente forma:

**1.1. Metodología ágil utilizada para el desarrollo:** SCRUM. Brevemente, en esta metodología se aplican de manera regular un conjunto de buenas prácticas para trabajar colaborativamente, en equipo y obtener el mejor resultado posible de proyectos, caracterizado por:

- Adoptar una estrategia de desarrollo incremental, en lugar de la planificación y ejecución completa del producto.
- Basar la calidad del resultado más en el conocimiento tácito de las personas en equipos auto organizados, que en la calidad de los procesos empleados.
- Solapamiento de las diferentes fases del desarrollo, en lugar de realizar una tras otra en un ciclo secuencial o en cascada.

**1.2. Tipos de diagramas utilizados (simples):** Modelo Entidad-Relación, Modelo  Relacional, Diagrama por Capas, Diagrama de Despliegue.

**2. Modelo de capas:** A continuación, el modelo de capas de la aplicación:

<img class="center" src="https://i.imgur.com/sLeJN90.jpg" alt="Modelo de Capas">

**3. Diseño para el desarrollo:** Para el desarrollo de la aplicación, se usó lo siguiente:

**3.1. Equipos:** Las referencias de los equipos utilizados se pueden encontrar en el siguiente enlace: [Referencias de Equipos y Herramientas.](https://drive.google.com/open?id=1xj12OqPSKkY85cId0bB1voD91hzQaUz5-vfTx4VRfvs "Referencias de Equipos y Herramientas")

**3.2. Herramientas:** Las herramientas usadas para el desarrollo fueron:

- **Java 8:** Con su correspondiente JDK, JRE y JVM.
- **NetBeans IDE 8.2:** Con las librerías Swing, JasperReport y JDateChooser.
- **PostgreSQL:** Versiones 9.5.16, 10.6 y 11.2.
- **Git:** Software de control de versiones.
- **GitHub:** Plataforma de desarrollo colaborativo para alojar proyectos utilizando el sistema de control de versiones Git.

**4. Modelo de datos:** A continuación, el modelo de datos de la aplicación:

**4.1. Modelo Entidad-Relación:**

<img class="center" src="https://i.imgur.com/H9kzI4o.jpg" alt="Modelo Entidad-Relación">

**4.2. Modelo Relacional:**

<img class="center" src="https://i.imgur.com/E4BYUvi.jpg" alt="Modelo Relacional">

**5. Diagrama de despliegue:** A continuación, el diagrama de despliegue de la aplicación:

<img class="center" src="https://i.imgur.com/i9DS2c5.jpg" alt="Diagrama de Despliegue (Deploy)">


## Requerimientos principales y atributos de calidad

**Cobertura de la versión actual:** La información sobre las funcionalidades y el Product Backlog se pueden encontrar en los siguientes enlaces:

- [Product Backlog.](https://drive.google.com/open?id=1jz4BqhgNG4M71N3Dv1-ORQ_gT-0sy-IeovQXem3XLbE "Product Backlog")
- [Historias de Usuario (descripción, restricciones, criterios de aceptación, etc).](https://drive.google.com/open?id=13UtD0uMAYDGbvC1vBsUJF_PlW9BLkyux-Ep4MtaqNw0 "Historias de Usuario (descripción, restricciones, criterios de aceptación, etc)")


## Prácticas fundamentales para el proceso de desarrollo

**Principales prácticas usadas:**

**1. Metodología base:** La metodología base utilizada fue SCRUM, la cual es definida brevemente en la *Visión general de la arquitectura*, apartado 1.1.

**2. Prácticas:** Las prácticas ágiles utilizadas fueron:

- Historias de Usuario.
- Product Backlog.
- Sprint Backlog.
- Reuniones (si bien estas no eran diarias, se hacían mínimo 2 veces por semana).
- Incrementos (pequeñas entregas funcionales).
- Retrospectiva.
- Refactoring.
- Sprint Planning.

## Referencias

- Imgur (Página web para alojar imágenes en línea). Recuperado de https://imgur.com
- López, J. M. (2017, Agosto 8). *Tu propia Wikipedia: espacios online donde crear un wiki propio*. Recuperado de https://blogthinkbig.com/tu-propia-wikipedia-espacios-online-donde-crear-un-wiki-propio
- Programación por capas. (s. f.). En *Wikipedia*. Recuperado el 23 de abril de 2019 de https://es.wikipedia.org/wiki/Programaci%C3%B3n_por_capas
- Scrum (desarrollo de software). (s. f.). En *Wikipedia*. Recuperado el 23 de abril de 2019 de https://es.wikipedia.org/wiki/Scrum
- Torchpad (Herramienta para la creación de wikis). Recuperado de https://torchpad.com