Feature: Añadir ingredientes a un plato

  Scenario: Como restaurador quiero añadir una lista de ingredientes en un plato
    Given Un plato creado con id "5d076c0c2ab79c00012be104"
      And Una lista de ingredientes existentes
    When Envio un mensaje de añadir ingredientes
    Then Los ingredientes se han añadido al plato
