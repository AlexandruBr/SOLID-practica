Se ha modificado el metodo getSize() de la clase Directory para que mostrará el tamaño total de los ficheros y directorios que contiene.

Principios arreglados:

-Principio de Responsabilidad Única:
--Dentro de la clase file había dos métodos: convertMP3ToWav y convertWavToMP3, estos métodos no estaban para nada relacionados con la responsabilidad de la clase, así que hice una clase aparte y los separé.

-Principio de Segregación de interfaces:

--Había una sola interfaz actuando prácticamente como dios, está tenía todos los métodos de las clases, provocando que las clases tuvieran métodos innecesarios y que nunca usarán, ya que al implementar la interfaz estaban obligados a poner todos los métodos. Esto lo arreglé usando una interfaz padre con métodos generales para las clases y creando interfaces hijos, de manera que las clases al heredar del padre y de implementar las del hijo usaban los métodos justos y necesarios, usando todos los métodos disponibles.

-Principio de Inversion de dependencias
--Las interfaces y clases abstractas estaban al mismo nivel que las clases, las he separado por carpetas.
--El constructor de la clase Directory estaba instanciando una variable, no se como evitar hacerlo sin que me pete todo el programa, pero con esa instancia no se podrían hacer tests unitarios.
--Además, aunque no se si contarlo como mal, se declara una variable de List tipo FileSystemBase, pero como hace referencia a una interfaz y no a una clase no se si contarlo como malo.

También me gustaría agregar que he puesto dos casts en la clase FileManager, no quería usarlos pero no me quedaba otra opción, he estado probando maneras de arreglarlo pero no lo conseguí.
