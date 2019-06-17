
  Feature: Como restaurador quiero dar de alta los platos de la carta

    Scenario: Creacion de un plato nuevo en la carta
      Given Un plato de nombre "Tortilla de patatas"
      Given Una categoria de id "5d038cfa902b100001f7c9b1"
      When Doy de alta el plato
      Then El plato esta en la carta
