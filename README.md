# poker-tdd

Adrian Cheoreanu - 100868406

https://github.com/AdiCheo/poker-tdd

- for each feature/requirement you have developed, the names of the corresponding test methods

- instructions on how to run your code


# Description
This assignment is worth 10% of your final mark.

In this first iteration, we are considering an extremely simplistic version of Poker, with no betting or any other subtlety. 

Each round consists in 2 to 4 players each submitting their hand (which was finalized through means that are not relevant here). Each valid poker hand consists of 5 cards. 

The goal of this assignment is first and foremost to gain practice at doing TDD using JUnit and Git/Hub. 

(For correction purposes you MUST make your repository accessible to the TA.)

So you are to develop a Java/Eclipse application that, each round, a) allows 2 to 4 poker hands to be input to it and b) outputs the ranking of these four hands. More precisely, each round, your app should:

- determine how many players are participating in this round (which defines the valid player ids for this round)

- input each player's hand, in the form of a player id followed by 5 cards separated by spaces, each card being identified according to the format RankSuit. So the ace of spades will be AceSpades, and the two of Heart will be TwoHearts. 

- output these hands (player id and cards) AND a rank (1 being the winner) in sorted decreasing order.

There are three crucial aspects to this assignment: 

1) tests are to be written in JUnit and execute as a single test suite

2) following the TDD bowling example, EACH software modification must be preceded by the submission of one or more tests. 

3) you must worry about the robustness of your application. (You may be asked to fill out a traceability file that will establish where in your JUnit tests you handle, if at all, specific test cases.)

Additionally, you should know that the second iteration of this assignment will require an API.

Details about how to submit the assignment will be made available at a later date. 

The ranking of poker hands can be found at: 

http://www.pokerlistings.com/poker-hand-ranking 



Please note: 

- suits do NOT matter: if two players each have a royal flush, then there are two winners. 

- the ace is the highest card of its suit.

- high cards do matter to decide between equivalent hands. For example, if you have a flush with an ace as the highest card and your opponent has a flush with a king as the high card, you win. 

Howard will develop and run test cases. Minimally he will try the following:

1: Test for Duplicate cards and suites
2: Test for Minimum and maximum number of players (2 to 4)
3: Test to ensure there are 5 cards dealt to each player
4: Hands are ranked in order !
5: Test for duplicate hands e.g. Royal Flush and ensure they are listed at the top of the ranking order
6: Test for invalid cards e.g. fourteenClubs, threeShovels, thDiamonds etc.
7: Test for valid player ids
8: Ensure the order of entry is correct - e.g. player id and then the cards
