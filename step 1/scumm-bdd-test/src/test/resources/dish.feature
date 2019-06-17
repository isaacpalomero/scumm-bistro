
  Feature: Como restaurador quiero dar de alta los platos de la carta

    Background: Creacion de una categoria para los platos de la carta
      Given Una categoria de nombre "Ensaladas"
      When Cuando doy de alta la categoria

    Scenario: Creacion de un plato nuevo en la carta
      Given Un plato de nombre "Tortilla de patatas"
      When Doy de alta el plato
      Then El plato esta en la carta
