
Feature: Como restaurador quiero poder actualizar los platos de la carta

    Background: Creacion de una categoria para los platos de la carta
      Given Una categoria de nombre "Ensaladas"
      And Doy de alta la categoria
      And Un plato de nombre "Tortilla de patatas"
      And Un nuevo plato
      And Una categoria de nombre "Tortillas de patatas"
      And Doy de alta la categoria

    Scenario: Actualización de un plato existente en la carta
      Given Un nuevo nombre de plato "Tortilla de patatas y chorizo"
      When Actualizo el plato
      Then El plato sale actualizado en la carta
