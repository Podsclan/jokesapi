package br.com.brendowpodsclan.jokesapi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoJokes {

    public Jokes read(int id) {
        Database db = new Database();
        Connection con = db.getConnection();

        String sql = "SELECT * FROM JOKE INNER JOIN AUTHOR ON JOKE.JOKE_AUTHORID = AUTHOR.AUTHOR_ID WHERE JOKE.JOKE_ID = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, id);  //protection against sql injection
            ResultSet rs = query.executeQuery();
            Jokes aux = new Jokes();
            while (rs.next()) {
                return (getJokeFromResultSet(rs));
            }
            rs.close();
            query.close();
            return aux;
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }

    public List<Jokes> readAll() {

        Database db = new Database();
        Connection con = db.getConnection();

        String sql = "SELECT * FROM JOKE INNER JOIN AUTHOR ON JOKE.JOKE_AUTHORID = AUTHOR.AUTHOR_ID";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            List<Jokes> list = new ArrayList<Jokes>();
            while (rs.next()) {
                list.add(getJokeFromResultSet(rs));
            }
            rs.close();
            query.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Error on readAll, DaoAuthor: " + e);
        }
        return null;
    }

    public List<Author> readAllAuthors() {

        Database db = new Database();
        Connection con = db.getConnection();

        String sql = "SELECT * FROM AUTHOR";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            List<Author> list = new ArrayList<Author>();
            while (rs.next()) {
                list.add((getAuthorFromResultSet(rs)));
            }
            rs.close();
            query.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Error on readAll, DaoAuthor: " + e);
        }
        return null;
    }


    public Jokes getJokeFromResultSet(ResultSet rs) {

        Jokes aux = new Jokes();
        Author author = new Author();
        try {
            aux.setId(rs.getInt("JOKE_ID"));
            aux.setType(rs.getString("JOKE_TYPE"));
            aux.setJoke(rs.getString("JOKE_JOKE"));
            author.setName(rs.getString("AUTHOR_NAME"));
            author.setId(rs.getInt("AUTHOR_ID"));
            aux.setAuthor(author);
            return aux;
        } catch (SQLException e) {
            System.out.println("Error on getJokeFromResultSet, DaoAuthor: " + e);
        }
        return null;
    }

    public Author getAuthorFromResultSet(ResultSet rs) {

        Author aux = new Author();
        try {
            aux.setId(rs.getInt("AUTHOR_ID"));
            aux.setName(rs.getString("AUTHOR_NAME"));
            return aux;
        } catch (SQLException e) {
            System.out.println("Error on getAuthorFromResultSet, DaoAuthor: " + e);
        }
        return null;
    }

    public boolean createJoke(Jokes aux) {
        Database db = new Database();
        Connection con = db.getConnection();
        String sql = "INSERT INTO JOKE (JOKE_TYPE, JOKE_JOKE, JOKE_AUTHORID) VALUES (?, ?, ?)";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, aux.getType());
            query.setString(2, aux.getJoke());
            query.setInt(3, aux.getAuthor().getId());
            query.execute();
            query.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error on create Joke, DaoAuthor: " + e);
        }
        return false;
    }

    public boolean createAuthor(Author aux) {
        Database db = new Database();
        Connection con = db.getConnection();
        String sql = "INSERT INTO AUTHOR (AUTHOR_NAME) VALUES (?)";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, aux.getName());
            query.execute();
            query.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error on create Author, DaoAuthor: " + e);
        }
        return false;
    }

    public boolean updateJoke(Jokes aux) {
        Database db = new Database();
        Connection con = db.getConnection();

        String sql = "UPDATE JOKE SET JOKE_TYPE = ?, JOKE_JOKE = ?, JOKE_AUTHORID = ?  WHERE JOKE_ID = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, aux.getType());  //protection against sql injection
            query.setString(2, aux.getJoke());  //protection against sql injection
            query.setInt(3, aux.getAuthor().getId());
            query.setInt(4, aux.getId());    //protection against sql injection
            query.execute();
            query.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error on update Joke, DaoAuthor: " + e);
        }
        return false;
    }

    public boolean updateAuthor(Author aux) {
        Database db = new Database();
        Connection con = db.getConnection();

        String sql = "UPDATE AUTHOR SET AUTHOR_NAME = ? WHERE AUTHOR_ID = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, aux.getName());  //protection against sql injection
            query.setInt(2, aux.getId());
            query.execute();
            query.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error on update Author, DaoAuthor: " + e);
        }
        return false;
    }


    public boolean deleteAuthor(int id) {
        Database db = new Database();
        Connection con = db.getConnection();
        String sql = "DELETE from AUTHOR where AUTHOR_ID = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, id);
            query.execute();
            query.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error on delete Author, DaoAuthor: " + e);
        }
        return false;
    }

    public boolean deleteJoke(int id) {
        Database db = new Database();
        Connection con = db.getConnection();
        String sql = "DELETE from JOKE where JOKE_ID = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, id);
            query.execute();
            query.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error on delete Joke, DaoAuthor: " + e);
        }
        return false;
    }

}
