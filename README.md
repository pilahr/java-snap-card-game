# Java Snap Card Game ❤️♣️♠️♦️

<img width="1231" alt="45704937-B417-4661-808F-2849F209841E" src="https://github.com/pilahr/java-snap-card-game/assets/125895065/f3214628-3408-4db6-b8ad-590a79b38994">
<img width="1120" alt="B7C9ACAA-A818-485C-BA1B-7BF38829EEA2" src="https://github.com/pilahr/java-snap-card-game/assets/125895065/867d4ccb-3a47-44dc-911b-8f627920feaf">


Snap card game created in Java.

# Feature
Snap Card game is for two players. Players enter their names.
Each of the players takes turn to deal a card from a deck.
Keep an eyes on the symbols of the cards.
If the symbol of a card you drew matches with the previous one from another player.
It's a Snap!! 
The player who types 'snap' first win the game.

# Functionality in the game
The game contains 5 classes and 1 Enum
- Main : contains main logic of the game, where the game runs
- Card : initalises the component of the card with the method to print out the pattern of the card
- CardSuit (Enum) : contains the unicode for the suits of the cards
- CardGame: has a functionality of the cards, such as a method fo get the deck of the card, to deal card from the top card, to sort decking by number order, to sort the deck of cards into card suits and to shuffle the deck of cards
- Player: enable Snap Game to take two players, so the users can taking turns to play
- Snap: uses the method from the CardGame class to enable user to play the game
