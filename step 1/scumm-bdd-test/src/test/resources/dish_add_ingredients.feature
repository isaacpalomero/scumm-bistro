Feature: Añadir ingredientes a un plato

  Background: Creacion de una categoria para los platos de la carta
    Given Una categoria de nombre "Ensaladas"
    When Cuando doy de alta la categoria

  Scenario: Como restaurador quiero añadir una lista de ingredientes en un plato
    Given Un plato creado
      And Una lista de ingredientes existentes
    When Envio un mensaje de añadir ingredientes
    Then Los ingredientes se han añadido al plato
