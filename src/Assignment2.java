import javax.swing.*;

public class Assignment2 {

    public static int chosen(){ /*Computer picks a random number between 1 and 3 with using Math.random method.
                                I want to assign that like, if it picks 1 it means:rock, if it picks 2 it means:paper and if it picks 3 it means:scissor. */
        int ai= 1 + (int) (Math.random() * 3);
        return ai;
    }

    public static String low(String me){ //Here, we want to match the words we get from the user and the words we define to the computer, even if there is a differences about their size of the letters.

        return me.toLowerCase();
    }

    public static void winner(int you, int com){  //We use if-else, for ending game and determine the who is winner.Also if it was a 5-0 game, we can get a little teasing with each other.

        if(you<com){

            if (com==5 && you==0) {
                JOptionPane.showMessageDialog(null, "OMG! You couldn't even win a round.You are the worst player I have ever seen.");
            }
            else {
                JOptionPane.showMessageDialog(null, "I won. Did I mention about you are a loser?");
            }

        }

        else {

            if(you==5 && com==0){
                JOptionPane.showMessageDialog(null,"Did you cheat?");
            }
            else {
                JOptionPane.showMessageDialog(null,"Beginner Luck.");
            }

        }
    }


    public static void main(String[] args) {

        int com = 0; //We assign an integer variable so that the rounds the computer will win can be added to the scoreboard.
        int you = 0; //We assign an integer variable so that the rounds won by us can be added to the scoreboard.
        int round=0; //We assign an integer variable to count the rounds.

        //We display the our first window as an information about the game, with using JOptionPane.
        JOptionPane.showMessageDialog(null,"The first player who reaches 5 points first wins." ,"Let's Start!",JOptionPane.PLAIN_MESSAGE);

        while (you!=5 && com!=5) { //We use this loop-continuation-condition to end the game when a player reaches 5 points.

            int ai = chosen(); /*Computer picks a random number between 1 and 3 with using the integer method that we have defined above*/

            //We take an input from user for his/her move.
            String me = JOptionPane.showInputDialog(null,"Rock, paper or scissor?: ","Round: "+(round+1),JOptionPane.PLAIN_MESSAGE);

            //We match the letters using the method that we described above.
            me=low(me);



            switch (me) { //We use a switch-case, for use the input which we got from the user.

                case "rock": // We enter all the possibilities in case the user type a rock.

                    if (ai == 1) {

                        JOptionPane.showMessageDialog(null, "My answer was Rock. It's a TIE!! ");
                        round++;
                    }
                    else if (ai == 2) {

                        JOptionPane.showMessageDialog(null, "My answer was Paper. I won LOSER!!");
                        com++;
                        round++;
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "My answer was Scissor. You won, lucky.");
                        you++;
                        round++;
                    }
                    //We display the scoreboard with using JOptionPane.
                    JOptionPane.showMessageDialog(null, "Human: " + you + "\nComputer: " + com, "Scoreboard",JOptionPane.PLAIN_MESSAGE);
                    break;

                case "paper": // We enter all the possibilities in case the user type a paper.

                    if (ai == 1) {

                        JOptionPane.showMessageDialog(null, "My answer was Rock. You won, lucky. ");
                        you++;
                        round++;
                    }
                    else if (ai == 2) {

                        JOptionPane.showMessageDialog(null, "My answer was Paper. It's a TIE!!");
                        round++;
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "My answer was Scissor. I won, LOSER!!");
                        com++;
                        round++;
                    }
                    //We display the scoreboard with using JOptionPane.
                    JOptionPane.showMessageDialog(null, "Human: " + you + "\nComputer: " + com,"Scoreboard",JOptionPane.PLAIN_MESSAGE);
                    break;

                case "scissor": // We enter all the possibilities in case the user type a scissor.

                    if (ai == 1) {

                        JOptionPane.showMessageDialog(null, "My answer was Rock. I won, LOSER!!");
                        com++;
                        round++;
                    }
                    else if (ai == 2) {

                        JOptionPane.showMessageDialog(null, "My answer was Paper. You won, lucky.");
                        you++;
                        round++;
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "My answer was Scissor. It's a TIE.");
                        round++;
                    }
                    //We display the scoreboard with using JOptionPane.
                    JOptionPane.showMessageDialog(null, "Human: " + you + "\nComputer: " + com,"Scoreboard",JOptionPane.PLAIN_MESSAGE);
                    continue; //We use continue, for give more chances to user who has typed something else from rock, paper, scissor.


                default: //We use default, in case of the user input something else from rock,paper and scissor.
                    JOptionPane.showMessageDialog(null, "Do you even know how to play?!");
                    break;
            }

        }

        //We use another method to announce the winner.
        winner(you,com);
    }
}
