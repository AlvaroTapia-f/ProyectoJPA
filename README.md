En el repositorio se encuentran los archivos de una aplicacición en JAVA implementando JPA + HIBERNATE

Pasos para ejecutar el programa:
1- Descargar el proyecto.
2- Abrir la carpeta del proyecto con un IDE como Intellij IDEA.
3- Utilizar la base de datos h2 para realizar la persistencia.
4- Configurar el archivo persistence.xml en caso de querer utilizar otra base de datos, por defecto la base de datos se llama "persistencedb". Si desea cambiar la base de datos debe configurar esta linea:

    <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/persistencedb"/>

Y colocar el nombre nombre de su base de datos en lugar de "persistencedb".

5- La base de datos tiene por defecto una contraseña que es "1234", si su base de datos tiene otra clave, o no tiene, debe modificar la siguiente linea:

    <property name="javax.persistence.jdbc.password" value="1234"/>

Y debe colocar la nueva contraseña en lugar de "1234" o en caso de no tener clave debe dejarlo vacío.

Esas son las configuraciones que tiene que tener en cuenta para ejecutar el proyecto.

Hablando del proyecto en sí, el mismo tiene algunas relaciones bidireccionales que a pesar de que son consideradas malas practicas, decidí incluirlas para tenerlas en cuenta porque es un recurso que en alguna ocasión se puede llegar a necesitar, no obstante la mayoría de las relaciones son unidireccionales.
