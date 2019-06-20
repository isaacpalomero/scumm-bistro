
Feature: Como restaurador quiero poder modificar las categorias de los platos

  Background: Creacion de una categoria
    Given Una categoria de nombre "Ensaladas"
    When Cuando doy de alta la categoria

  Scenario: Modificacion de una categoria
    Given Un nombre nuevo de categoria "Tortilla de alcachofas"
    When Modifico una categoria
    Then Aparece la categoria modificada en el listado
