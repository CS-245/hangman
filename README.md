# hangman
CS 245 Swing Project v1.0 - Hangman Game

For this game a random word will be selected from the following list (abstract, cemetery, nurse,
pharmacy, climbing). A typical graphic for a game of “hangman” is displayed with a number of
lines beneath it corresponding to the number of characters from the selected word. The user
may then click on one of the buttons to guess a letter which may be in the selected word which
they are guessing. Each time the user guesses a letter if that letter is found within the selected
word then the letter is drawn to the screen above its appropriate space marked by the lines
below the “hangman” graphic, and the button for the letter which was guessed should be
disabled. If a letter is guessed and it is not found within the selected word, then you should alert
the user, draw a portion of the man being “hanged”, disable the button which was guessed, and
allow the user to try again. You should keep a running tab of the user’s score and display it on
screen; the user begins with 100 pts possible if they correctly guess the word without any
mistakes. For every incorrect letter which is guessed, 10 pts should be taken away from what is
left of their total possible points. For every correct letter which is guessed, their score is left
unchanged. The user’s score should never be lower than 0, or exceed the mentioned points
possible. After six incorrect guesses or once the user has correctly guessed the word or if the
user clicks “Skip” to skip the game, display an end page where the user’s score is displayed in
similar fashion to the high scores screen including an “End” button (instead of back) to take the
user back to the function buttons screen (If the user decided to skip the game, then their score
should be 0). The game should allow for repeat play through with all elements reset as if playing
for the first time.
