DROP DATABASE BGranja;
CREATE DATABASE BGranja;
USE BGranja;


CREATE TABLE TCooperativas  (
Id        			INT   AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
Descripcion         VARCHAR(70) NOT NULL,
Numero_Miembros     INT NOT NULL,
Puntuacion	   	 	DOUBLE NOT NULL
PRIMARY KEY (Id),
); 

CREATE TABLE TUsuarios  (
Id        			INT   AUTO_INCREMENT,
Login     			VARCHAR(15) NOT NULL,
Pass      			VARCHAR(64)  NOT NULL,
Nombre     			VARCHAR(35) NOT NULL,
Apellidos     		VARCHAR(35) NOT NULL,
Telefono     		VARCHAR(35) NOT NULL,
Fecha     			DATE NOT NULL,
Correo     			VARCHAR(70) NOT NULL
Id_Granja     	   	INT NOT NULL,
Id_Cooperativa	    INT NOT NULL,
Puntuacion	   	 	DOUBLE NOT NULL
PRIMARY KEY (Id),
FOREIGN KEY (Id_Granja) REFERENCES TUsuarios(Id),
FOREIGN KEY (Id_Cooperativa) REFERENCES TUsuarios(Id)
);  

CREATE TABLE TVecinos  (
Id        			INT   AUTO_INCREMENT,
Id_Usuario1     	INT NOT NULL,
Id_Usuario2	    	INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Usuario1) REFERENCES TUsuarios(Id),
FOREIGN KEY (Id_Usuario2) REFERENCES TUsuarios(Id)
);  


CREATE TABLE TGranjas  (
Id        			INT   AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
PRIMARY KEY (Id)
);


CREATE TABLE TTiposInfracestructuras  (
Id        			INT   AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
Descripcion         VARCHAR(70) NOT NULL,
Mantenimiento       DOUBLE NOT NULL,
PRIMARY KEY (Id)
);


CREATE TABLE TInfraestructuras  (
Id        			INT   AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
Id_Granja     		INT NOT NULL,
Id_Tipo	    		INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Granja) REFERENCES TGranjas(Id),
FOREIGN KEY (Id_Tipo) REFERENCES TTiposInfracestructuras(Id)
);

CREATE TABLE TTiposAcciones  (
Id        			INT   AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
Descripcion         VARCHAR(70) NOT NULL,
Id_Tipo	    		INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Tipo) REFERENCES TTiposInfracestructuras(Id)
);

CREATE TABLE TAccionesUsuarios  (
Id        			INT   AUTO_INCREMENT,
Id_Usuario	    	INT NOT NULL,
Id_Tipo	    		INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Usuario) REFERENCES TUsuarios(Id),
FOREIGN KEY (Id_Tipo) REFERENCES TTiposInfracestructuras(Id)
);

CREATE TABLE TRecursos  (
Id        			INT   AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
Descripcion         VARCHAR(70) NOT NULL,
Tipo           		VARCHAR(70) NOT NULL,
Precio_Maximo       DOUBLE NOT NULL,
Precio_Minimo       DOUBLE NOT NULL,
PRIMARY KEY (Id)
);

CREATE TABLE TAccionesRecursos  (
Id        			INT   AUTO_INCREMENT,
Id_Recurso	    	INT NOT NULL,
Id_Tipo	    		INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Recurso) REFERENCES TRecursos(Id),
FOREIGN KEY (Id_Tipo) REFERENCES TTiposInfracestructuras(Id)
);

CREATE TABLE TEspacios  (
Id        			INT  AUTO_INCREMENT,
Id_Recurso	    	INT NOT NULL,
Id_Infraestructura	INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Recurso) REFERENCES TRecursos(Id),
FOREIGN KEY (Id_Infraestructura) REFERENCES TInfracestructuras(Id)
);

CREATE TABLE TAnimales  (
Id        			INT  AUTO_INCREMENT,
Nombre           	VARCHAR(70) NOT NULL,
Fecha_Nacimiento	DATE NOT NULL,
Id_Recurso	    	INT NOT NULL,
Id_Espacio			INT NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (Id_Recurso) REFERENCES TRecursos(Id),
FOREIGN KEY (Id_Infraestructura) REFERENCES TEspacios(Id)
);

