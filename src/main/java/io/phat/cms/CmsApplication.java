package io.phat.cms;

import io.phat.cms.core.config.DefaultCmsSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Controller
	@RequestMapping("")
	public class InitController {

		@Autowired
		private DefaultCmsSetup cmsSetup;

		@GetMapping
		public ResponseEntity<Void> index() {
			cmsSetup.init();
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
