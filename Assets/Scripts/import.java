import
java.sql.*;
public class jdbc_teste {
public static void main(String args[])
{

String
url = “jdbc:postgresql://localhost:5432/minhabase”;
System.out.println(“

Esta
é a URL: “ + url);
try
{

Class.forName( “org.postgresql.Driver”
);
}
catch ( java.lang.ClassNotFoundException
e )
{

System.err.print( “ClassNotFoundException: ” );

System.err.println( e.getMessage () );
}
System.out.println(“Driver
do PostgreSQL selecionado. “);

try
{

Connection db = DriverManager.getConnection(url,”postgres”,””);

db = DriverManager.getConnection( url,
“postgres”, “” );
}
catch ( SQLException
ex )
{

System.err.println( “SQLException: ” + ex.getMessage()
);
}
System.out.println(“Conexão
aberta. “);

try
{

Statement sq_stmt = db.createStatement();

String sql_str = “SELECT * FROM cadastro”;

ResultSet rs = sq_stmt.executeQuery(sql_str);

while (rs.next())

{

int id = rs.getInt(“id”);

String name = rs.getString(“nome”);
String email = rs.getString(“email”);

System.out.println(“ID: “ + id);

System.out.println(“Nome: “ + nome);

System.out.println(“Email: “ + email + “ ”);

}
}
catch ( SQLException
ex )
{

System.err.println( “SQLException: ” + ex.getMessage()
);
}
System.out.println(“Consulta
efetuada. “);

sq_stmt.close();
rs.close();
db.close();
System.out.println(“Conexão
fechada. “);
}
}