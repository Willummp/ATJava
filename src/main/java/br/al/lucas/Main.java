package br.al.lucas;

import br.al.lucas.controllers.SongsController;
import static spark.Spark.*;

public class Main {
    //ROTAS POSSIVEIS NO REST API
    private static final int port = 8080;
    private static final SongsController songsController
            = new SongsController();
    public static void main(String[] args) {

        port(port);
        get("/", (req, res) -> "Server On!");

        path("/songs", () -> {
            get("", songsController::getAll);
            get("/:id", songsController::read);
            post("", songsController::insert);
            put("/:id", songsController::update);
            patch("/:id", songsController::upgrade);
            delete("/:id", songsController::delete);
        });




    }
}