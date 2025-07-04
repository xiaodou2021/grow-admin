package com.ig.game_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptScan;

@SpringBootApplication
@EntityScan
@EruptScan
public class GameAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameAdminApplication.class, args);
	}

}
