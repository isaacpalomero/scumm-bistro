Feature: Añadir ingredientes a un plato

  Scenario: Como restaurador quiero añadir una lista de ingredientes en un plato
    Given Un plato creado con id "1312412498"
      And Una lista de ingredientes existentes
    When Envio un mensaje de añadir ingredientes
    Then Los ingredientes se han añadido al plato
