PROTOTYPE – DECK CARDS SHUFFLE

The idea is to create a deck of cards and have the provision to shuffle them. The deck contains all 52 cards (suit, rank, label, image path) and store them in memory.
	Allowing shuffle which will randomize the card order. Thereby display the shuffled deck back to the UI

##The project can be located in the folder ../Exercise 3/Java/VS Code/deck

1.	Development environment setup
			* Java jdk-21.0.10
			* Maven 3.9.14
			* Spring Boot framework for REST API and UI
			* Thymeleaf (for HTML rendering)
			* VS Code with Java extension pack
			* Git for version control
			* Docker

2. The structure of the solution - To start with, we need model which will be responsible for storage and retreival of data(deck cards details). The service class which contains 
																	the processes and defines how the computation rules and business logic is executed. And the controller class which contains the entry 
																		point of how the user request is handled at first place.
		These are defined in a simple layout as:
			src/main/java/com/example/deck
			 --model
					-Card.java
					-Suit.java
					-Rank.java
					-Deck.java
			 --service
					-DeckService.java
			 --web
					-DeckController.java
			-DeckApplication.java

			src/main/resources
			 --static/cards/*.png    (52 card images)
       --templates/deck.html   (UI layout)

3. A UI to be built that calls the apis in the controller classes
		GET  /        -- calling this shows current order of the cards in the deck
		POST /shuffle -- hitting this triggers the shuffle logic and re-render the latest order of the cards in the deck

    A simple HTML (Deck.html) file is created that contains a form with a submit button. we will utilise Thymeleaf to build UI.
     The submit buttom click calls the /shuffle endpoint, the controller shuffles the deck and then Thymeleaf re-renders the page with the new order.
		 
4. At this stage, the UI is just basic- containing simple html form with a button. The next thing to be worked on is utilise Thymeleaf fully.  
		Further, ..resources/static/cards folder has been created, and 52 cards images in .png format needs to be stored in it, and update the 
		code to map those images so that when rendering it pulls images from /resources.
		
		Another approach I considered for building UI for this scenario is React. React would have been great if we needed an interactive and modern UI. But I chose Thymeleaf
		over React here because	I think it is ideal for this shuffle card scenario as it lets us embed Java data directly into HTML. It lets us build a UI using
		plain HTML. It works seamlessly with Spring Boot with no extra setup, no JSON parsing,	no JavaScript frameworks, no client‑side state management and 
		no build pipeline. Just drop .html files into /templates and we are done. It keeps everything in Java, where	controller returns a model and 
		Thymeleaf consumes it directly. It is quite easy to deploy and maintain.

5. Delivery pipeline
		Build the project:
			-mvn clean verify
		Package:
			-mvn package  (this generates .jar for the project in the target)
			




### I have create a second prototype using Oracle APEX just as an alternative.