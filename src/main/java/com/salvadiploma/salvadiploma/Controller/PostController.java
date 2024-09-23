package com.salvadiploma.salvadiploma.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salvadiploma.salvadiploma.model.User;
import com.salvadiploma.salvadiploma.model.Post;
import com.salvadiploma.salvadiploma.model.RegisterRequest;
import com.salvadiploma.salvadiploma.repository.LoginRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PostController {
    @Autowired
    private LoginRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody RegisterRequest request) {
        String name = request.getName();
        String description = request.getDescription();
        String title = request.getTitle();
        String link = request.getLink();
        String objective = request.getObjective();


        User user = userRepository.findByName(name);
        User admUser = userRepository.findByName("gabriel");

        String image = user.getImage( );

        Object post = new Post(title, description, objective, link, name, image);

        admUser.addPost(post);
        user.addPost(post);

        userRepository.save(user);
        userRepository.save(admUser);
        return ResponseEntity.ok("Esta é a lista total:" + admUser.getPosts());
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/returnPosts")
    public ResponseEntity<List<Object>> returnPosts( ) {
        User admName = userRepository.findByName("gabriel");


        return ResponseEntity.ok(admName.getPosts());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/returnUserPosts")
    public ResponseEntity<List<Object>> returnUserPosts(@RequestBody RegisterRequest request) {
        String name = request.getName();
        User postsFromUser = userRepository.findByName(name);

        return ResponseEntity.ok(postsFromUser.getPosts());
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/deletePost")
    public ResponseEntity<Object> deletePost(@RequestBody RegisterRequest request) {
        String name = request.getName();
        String description = request.getDescription();
    
        User user = userRepository.findByName(name);
        User adm = userRepository.findByName("gabriel");
    
        // Encontrar o post a ser removido pela descrição
        Post postToRemove = null;
        for (Object post : user.getPosts()) {
            if (((Post) post).getDescription().equals(description)) {
                postToRemove = (Post) post;
                break;
            }
        }
    
        if (postToRemove != null) {
            // Remover o post do administrador primeiro
            adm.getPosts().remove(postToRemove);
            user.getPosts().remove(postToRemove);
    
            userRepository.save(adm);
            userRepository.save(user);
            System.out.println("Post removido: " + postToRemove);
            return ResponseEntity.ok(postToRemove);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        }
    }
    
    
    @CrossOrigin(origins = "*")
    @PostMapping("/editPost")
    public ResponseEntity<Object> editPost(@RequestBody RegisterRequest request) {
        String name = request.getName();
        Number indexToArray = request.getIndexToArray();
        String description = request.getDescription();
        String objective = request.getObjective();
        String link = request.getLink();
        String title = request.getTitle();
    
        User user = userRepository.findByName(name);
        User AdmName = userRepository.findByName("gabriel");
    
        if (user == null || user.getPosts().size() <= indexToArray.intValue()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
    
        Post postObject = (Post) user.getPosts().get(indexToArray.intValue());
    
        // Atualiza o post no array do usuário
        postObject.setTitle(title);
        postObject.setDescription(description);
        postObject.setLink(link);
        postObject.setObjective(objective);
        userRepository.save(user);
    
        // Atualiza o post no array do administrador
        for (Object post : AdmName.getPosts()) {
            if (post.equals(postObject)) {
                Post updatedPost = (Post) post;
                updatedPost.setTitle(title);
                updatedPost.setDescription(description);
                updatedPost.setLink(link);
                updatedPost.setObjective(objective);
                userRepository.save(AdmName);
                break;
            }
        }
    
        return ResponseEntity.ok("Post updated successfully");
    }
    




}
