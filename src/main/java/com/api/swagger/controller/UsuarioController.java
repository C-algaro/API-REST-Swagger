package com.api.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.swagger.model.Usuario;
import com.api.swagger.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "tag", description = "The user API with documentation annotations")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @Operation(summary = "Get All Users")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "found the Users", content = { 
        @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))}),
      @ApiResponse(responseCode = "400", description = "Bad request", content = @Content), 
      @ApiResponse(responseCode = "404", description = "Did not find any Users", content = @Content) })
    @GetMapping()
    public List<Usuario> getUsers(){
    return repository.findAll();
    }

    @Operation(summary = "Get a User by its username")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "found the User", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content), 
      @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username")String username){
        return repository.findByUsername(username);
    }

    @Operation(summary = "Delete a User by its id")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "deleted the User", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content), 
      @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deletebyId(id);
    }

    @Operation(summary = "Create a User")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "created the User", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid value supplied", content = @Content), 
      @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @Operation(summary = "Update a User")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "updated the User", content = @Content),
      @ApiResponse(responseCode = "400", description = "Invalid value supplied", content = @Content), 
      @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @PutMapping()
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}
