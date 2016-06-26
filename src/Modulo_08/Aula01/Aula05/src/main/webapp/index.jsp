<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Hello World!</h1>

            <form action="" method="GET">
                <div class="form-group">
                    <label for="txtNome">
                        Nome
                    </label>
                    <input style="width: 70%;" class="form-control" id="txtNome" name="pessoa.nome" type="text">
                </div>
                <div class="form-group">
                    <label for="numIdade">
                        Idade
                    </label>
                    <input style="width: 20%;" class="form-control" id="numIdade" name="pessoa.idade" type="number">
                </div>
                <div class="form-group">
                    <label>
                        Sexo
                    </label>
                    <input type="radio" name="pessoa.sexo" value="maculino"> Masculino
                    <input type="radio" name="pessoa.sexo" value="feminino"> Feminino
                    <input type="radio" name="pessoa.sexo" value="outros"> Outro
                </div>
                <button class="btn btn-success">
                    Enviar
                </button>
            </form>
        </div>        
    </body>
</html>
