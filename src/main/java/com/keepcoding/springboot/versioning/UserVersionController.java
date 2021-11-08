package com.keepcoding.springboot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserVersionController {

    //URI(Ej: Amazon)
    @GetMapping("/v1/userVersioning")
    public UserVersionV1 getUserVersion1() {
        return new UserVersionV1("nombre");
    }

    @GetMapping("/v2/userVersioning")
    public UserVersion2 getUserVersion2() {
        return new UserVersion2(new NameStructure("nombre", "apellido"));
    }

    //PARAMS (Ej: Twitter)
    //URI: /userVersioning/params?version=1
    @GetMapping(value = "/userVersioning/params", params = "version=1")
    public UserVersionV1 getUserVersion1Params() {

        return new UserVersionV1("nombre");
    }
    //URI: /userVersioning/params?version=2
    @GetMapping(value = "/userVersioning/params", params= "version=2")
    public UserVersion2 getUserVersion2Params() {

        return new UserVersion2(new NameStructure("nombre", "apellido"));
    }

    //HEADERS (Ej: Microsoft)
    //URI: /userVersioning/header
    // Se añade un header 'X-API-VERSION' en Postman y se coloca en value = 1
    @GetMapping(value = "/userVersioning/header", headers = "X-API-VERSION=1")
    public UserVersionV1 getUserVersion1Header() {

        return new UserVersionV1("nombre");
    }
    //URI: /userVersioning/header
    // Se añade un header 'X-API-VERSION' en Postman y se coloca en value = 2
    @GetMapping(value = "/userVersioning/header", headers= "X-API-VERSION=2")
    public UserVersion2 getUserVersion2Header() {

        return new UserVersion2(new NameStructure("nombre", "apellido"));
    }

    //MEDIA TYPE (Ej: Github)
    //URI: /userVersioning/produces
    // Se añade otro header 'accept' en Postman y se coloca en value = application/vnd.company.app-v1+json
    @GetMapping(value = "/userVersioning/produces", produces = "application/vnd.company.app-v1+json")
    public UserVersionV1 getUserVersion1Produces() {

        return new UserVersionV1("nombre");
    }
    //URI: /userVersioning/produces
    // Se añade otro header 'accept' en Postman y se coloca en value = application/vnd.company.app-v2+json
    @GetMapping(value = "/userVersioning/produces", produces = "application/vnd.company.app-v2+json")
    public UserVersion2 getUserVersion2Produces() {

        return new UserVersion2(new NameStructure("nombre", "apellido"));
    }

}
