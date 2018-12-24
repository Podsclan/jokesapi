package br.com.brendowpodsclan.jokesapi.controller;

import br.com.brendowpodsclan.jokesapi.model.Author;
import br.com.brendowpodsclan.jokesapi.model.DaoJokes;
import br.com.brendowpodsclan.jokesapi.model.Jokes;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/jokesAPI")
public class JokesController {

    //SHOW ALL DATA

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Jokes getJokes(){                                //method which return one joke
        DaoJokes db = new DaoJokes();
        Random random = new Random();
        int x = random.nextInt(12)+1;
        return db.read(x);
    }

    //SHOWING ALL JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/all", method = RequestMethod.GET)
    public List<Jokes> getAllJokes(){                       //method which return all jokes on database
        DaoJokes db = new DaoJokes();
        return db.readAll();
    }

    @RequestMapping(value = "/authors/all", method = RequestMethod.GET)
    public List<Author> getAllAuthor(){                       //method which return all jokes on database
        DaoJokes db = new DaoJokes();
        return db.readAllAuthors();
    }

    //UPDATING JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/update", method = RequestMethod.PUT, produces = "application/json")
    public boolean update (@RequestBody Jokes aux) {        //method which update some joke's information on database
        DaoJokes db = new DaoJokes();
        if (aux.getId() != 0) {
            if (db.read(aux.getId()) != null) {
                return db.updateJoke(aux);
            }
        }
        return false;
    }

    @RequestMapping(value = "/authors/update", method = RequestMethod.PUT, produces = "application/json")
    public boolean update (@RequestBody Author aux) {        //method which update some joke's information on database
        DaoJokes db = new DaoJokes();
        if (aux.getId() != 0) {
            if (db.read(aux.getId()) != null) {
                return db.updateAuthor(aux);
            }
        }
        return false;
    }

    //CREATING NEW JOKES OR AUTHORS

    @RequestMapping(value ="/jokes/create", method = RequestMethod.POST, produces = "application/json")
    public boolean createJoke(@RequestBody Jokes aux) {
        DaoJokes db = new DaoJokes();
        return db.createJoke(aux);
    }

    @RequestMapping(value ="/authors/create", method = RequestMethod.POST, produces = "application/json")
    public boolean createAuthor(@RequestBody Author aux) {
        DaoJokes db = new DaoJokes();
        return db.createAuthor(aux);
    }

    //DELETING JOKE OR AUTHOR

    @RequestMapping(value ="/jokes/delete", method = RequestMethod.DELETE)
    public boolean deleteJoke(@RequestParam("id") int id) {
        DaoJokes db = new DaoJokes();
        return db.deleteJoke(id);
    }

    @RequestMapping(value ="/authors/delete", method = RequestMethod.DELETE)
    public boolean deleteAuthor(@RequestParam("id") int id) {
        DaoJokes db = new DaoJokes();
        return db.deleteAuthor(id);
    }

}
