package br.al.lucas.controllers;

import br.al.lucas.models.Song;
import br.al.lucas.repositories.SongsRepository;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class SongsController {
    SongsRepository songsRepository = new SongsRepository();
    Gson gson = new Gson();

    public String getAll(Request req, Response res) {
        int limit = 5;
        int offset = 0;

        String queryLimit = req.queryParams("limit");
        if (queryLimit != null) {
            try {
                limit = Integer.parseInt(queryLimit);
                if (limit > 30)
                    limit = 30;
            } catch (NumberFormatException exception) {
            }
        }

        String queryOffset = req.queryParams("offset");
        if (queryOffset != null)
            offset = Integer.parseInt(queryOffset);

        var songs = songsRepository.list(limit, offset);
        return response(songs, res);
    }

    public String read(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);
        Song song = songsRepository.read(id);
        if (song != null) {
            return response(song, res);
        } else {
            res.status(204);
            return "No Content";
        }
    }

    public String insert(Request req, Response res) {
        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Song.class);
        Song song = songsRepository.insert(body);
        return response(song, res);
    }

    public String update(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);
        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Song.class);
        Song song = songsRepository.update(id, body);
        if (song != null) {
            return response(song, res);
        } else {
            res.status(204);
            return "No Content";
        }
    }

    public String upgrade(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);
        var bodyStr = req.body();
        var body = gson.fromJson(bodyStr, Song.class);
        Song song = songsRepository.upgrade(id, body);
        if (song != null) {
            return response(song, res);
        } else {
            res.status(204);
            return "No Content";
        }
    }

    public String delete(Request req, Response res) {
        var idStr = req.params("id");
        var id = Long.parseLong(idStr);
        Song song = songsRepository.delete(id);
        if (song != null) {
            return response(song, res);
        } else {
            res.status(204);
            return "No Content";
        }
    }
    private String response(Object object, Response res) {
        String bodyJson = gson.toJson(object);
        res.type("application/json");
        return bodyJson;
    }
}



