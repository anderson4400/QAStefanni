Feature: Pt - Teste de funcionalidade do histórico de log Cadastro


  Scenario Outline: Registre-se com os campos obrigatórios

    Given quero acessar o portal url "https://cadastro-de-usuarios.s3.us-east-1.amazonaws.com/index.html"
    When Valide o registro dos campos vazios de <name> e <email> de <password>
    Then para validar que não permite cadastro com campos vazios
    Examples:
      | name | email | password |
      |""|"calkin440040@gmail.com"|"And440040"|
      |"calkin medina"|""         |"And440040"|
      |"calkin medina"|"calkin44oo4o@gmail.com"|""|
      |""             | ""                     |""|
      |"calkin"       | "calkin440040@gmail.com"|"And440040"|
      |"calkin medina" |"dasdasdasdasd"          |"And440040"|
      |"calkin medina" |"calkin440040@gmail.com" |"444"      |
      |"calkin medina"|"calkin440040@gmail.com"|"And440040"|
      |"calkin mendez"|"calkinmendez@gmail.com"|"And440040"|










