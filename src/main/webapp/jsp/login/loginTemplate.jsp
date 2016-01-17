<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<html>
    <head>

        <title>
            <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
            </title>
            <!-- Bootstrap -->
            <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
            <!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
            <link href="css/bootstrap-theme.min.css" rel="stylesheet">
            <link href="css/theme.css" rel="stylesheet">
            <link href="css/bootstrap-select.css" rel="stylesheet" type="text/css" >
            <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
            <link href="css/custom.css" rel="stylesheet">
            <link rel='shortcut icon' href='favicon.ico'>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <script src="js/bootstrap.min.js"></script>
            <!-- <script type="text/javascript" src="js/bootstrap-select.js"></script>
            <script type="text/javascript" src="js/angular.min.js"></script> -->
            <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
            <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js"></script>
            <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.1.js"></script>

        </head>
        <body>

            <div class="col-md-1"></div>
            <div class="col-md-10 background">
                <header id="heading">
                    <div class="logo_header">
                        <a href="http://www.noletia.es/" title="Ir a Noletia"> <img
                                alt="Noletia" src="img/logo-noletia.png">
                        </a>
                    </div>

                </header>

            <tiles:insertAttribute name="body"></tiles:insertAttribute>
            <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </div>
        <div class="col-md-1"></div>

    </body>
</html>