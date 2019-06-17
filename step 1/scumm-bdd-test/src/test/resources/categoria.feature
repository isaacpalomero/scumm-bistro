# new feature
# Tags: optional
    
Feature: Como restaurador quiero poder gestionar las categorias de los platos
    
Scenario: Creacion de una categoria
    Given Una categoria de nombre "Ensaladas"
    When Cuando doy de alta la categoria
    Then Aparece la categoria en el listado

Scenario: Modificacion de una categoria
    Given Una categoria de id "5d038cfa902b100001f7c9b1"
    When Modifico una categoria
    Then Aparece la categoria modificada en el listado

Scenario: Eliminacion de una categoria
    Given Una categoria de id "5d038cfa902b100001f7c9b1"
    When Borro una categoria
    Then Desaparece la categoria del listado
