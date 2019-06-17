
Feature: Como restaurador quiero poder eliminar las categorias de los platos

  Background: Creacion de una categoria
    Given Una categoria de nombre "Ensaladas"
    When Cuando doy de alta la categoria

  Scenario: Eliminacion de una categoria
    When Borro una categoria
    Then Desaparece la categoria del listado
