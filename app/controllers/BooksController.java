package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Book;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;

public class BooksController extends Controller {


    // for all books

    public Result index(){
        List<Book> books = Book.find.all();
        return ok(Json.toJson(books));
    }

    // to create book

    public Result create(Http.Request request){
        JsonNode jsonNode = request.body().asJson();
        Book book = new Book();
        book.setTitle(jsonNode.get("title").asText());
        book.setPrice(jsonNode.get("price").asInt());
        book.setAuthor(jsonNode.get("author").asText());
        book.insert();

        return ok(Json.toJson(book));
    }

    public Result edit(Http.Request request,Integer id){

        JsonNode jsonNode = request.body().asJson();

        Book book = Book.find.byId(id);

        book.setTitle(jsonNode.get("title").asText());
        book.setPrice(jsonNode.get("price").asInt());
        book.setAuthor(jsonNode.get("author").asText());
        book.update();

        return ok(Json.toJson(book));
    }


    public Result show(Integer id){
        Book book = Book.find.byId(id);
        return ok(Json.toJson(book));
    }

    public Result destroy(Integer id){

        Book book = Book.find.byId(id);
        if(book == null){
            return notFound();
        }
        book.delete();
        return ok(Json.toJson(book));
    }

}
