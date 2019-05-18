package com.wcff.ciocolit.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcff.ciocolit.domain.User;
import com.wcff.ciocolit.domain.builder.UserBuilder;
import com.wcff.ciocolit.dto.UserDto;
import com.wcff.ciocolit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;

@RestController
@CrossOrigin
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/{id}")
    public User getUserById(@PathVariable Long id) {
        User user = UserBuilder.createUserBuilder().name("Ioana").username("ioana$efa").password("password").build();
        userRepository.save(user);
        return userRepository.findById(id).get();
    }

    @GetMapping("/springVersion")
    public String springVersion() {
        return SpringVersion.getVersion();
    }

    @GetMapping("/user/{userDto}")
    public UserDto validateUser(@PathVariable String userDto) {

        Gson gson = new GsonBuilder().create();
        UserDto dto = gson.fromJson(userDto, UserDto.class);
        User user = userRepository.findByUsername(dto.getUsername());
        if (user != null) {
            if (user.getPassword().equals(dto.getPassword())) {
                return dto;
            }
        }
        return null;
    }

    @GetMapping("/testPetze")
    public String testPetze() {
        String fromServer = null;
        try (Socket socket = new Socket("192.168.137.162", 9000)) {

            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //File imgPath = new File("C:\\Users\\moldo\\OneDrive\\Desktop\\cameraman.png");

            ////

            File myFile = new File("C:\\Users\\moldo\\OneDrive\\Desktop\\cameraman.png");
            byte [] mybytearray  = new byte [(int)myFile.length()];
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);

            //System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
            outputStream.write(mybytearray,0,mybytearray.length);
            outputStream.flush();
            //System.out.println("Done.");

            ////

            fromServer = input.readLine();
            return fromServer;
        } catch (IOException e) {
            return null;
        }
    }
}
