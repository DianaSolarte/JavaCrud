package com.client.crud.confi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API CLIENTES BIT",
                description = "Our app provides a concise listing of Clients",
                version = "1.0.0",
                contact = @Contact (
                        name = "Diana Marcela Solarte Moreno",
                        url = "https://www.linkedin.com/in/diana-marcela-solarte-moreno-691492141/",
                        email = "dianasolartemm@gmail.com"
                ),
                license = @License(
                name = "Standard Software Use License for SolartenaDev",
                url = "https://www.linkedin.com/in/diana-marcela-solarte-moreno-691492141/"
                )
        ),
                servers = {
                        @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                        ),
                        @Server (
                        description = "PROD SERVER",
                        url = "http://solartenadev:8080"
                        )}

)

public class SawaggerConfig {}


